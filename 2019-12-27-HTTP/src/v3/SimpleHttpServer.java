package v3;

import v3.Task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(20);
        ServerSocket serverSocket = new ServerSocket(1229);
        while (true){
            Socket socket = serverSocket.accept();
            pool.execute(new Task(socket));
        }
    }
}
