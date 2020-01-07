package v3;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    String method;
    String path;
    String version;
    public Map<String,String> parameters = new HashMap<>();
    public Map<String,String> headers = new HashMap<>();

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", parameters=" + parameters +
                ", headers=" + headers +
                '}';
    }

    public static Request parse(InputStream is) throws IOException {
       Request request = new Request();
       Scanner scanner = new Scanner(is,"UTF-8");

       parseRequestLine(scanner,request);
       parseRequestHeaders(scanner,request);

       return request;
    }

    private static void parseRequestHeaders(Scanner scanner, Request request) {
        String line;
        while (!(line = scanner.nextLine()).isEmpty()){
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            request.headers.put(key,value);
        }
    }

    private static void parseRequestLine(Scanner scanner, Request request) throws IOException {
        String[] group = scanner.nextLine().split(" ");
        request.method = group[0];
        parseUrl(group[1],request);
        request.version = group[2];
    }

    private static void parseUrl(String s, Request request) throws IOException {
        String[] group = s.split("\\?");
        request.path = URLDecoder.decode(group[0],"UTF-8");
        if(group.length == 2){
            String[] segment = group[1].split("&");
            for(String kvString : segment){
                String[] kv = kvString.split("=");
                String key = URLDecoder.decode(kv[0],"UTF-8");
                String value = "";
                if(kv.length == 2){
                    value = URLDecoder.decode(kv[1],"UTF-8");
                }
                request.parameters.put(key,value);
            }
        }
    }
}
