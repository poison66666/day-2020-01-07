package v2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHttpServlet {
    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(20);//创建线程池
        //服务器端的socket接口，Socket是建立网络连接时使用的，完成所需要的会话
        ServerSocket serverSocket = new ServerSocket(1229);
        while (true) {
            //取出连接请求
            Socket socket = serverSocket.accept();
            //创建线程任务
            pool.execute(new Task(socket));
        }
    }
}
