package program1.Server;
import java.io.*;
import java.net.*;

class myServer {
    public static void main (String[] args) throws Exception{

            //sets a variable equal to the first arg passed in as that should be a port number
            int portNum = Integer.parseInt(args[0]);

            //sets up a server socket at the port number
            ServerSocket ss = new ServerSocket(portNum);
            //accepts the connection from the client
            Socket s = ss.accept();
            //prints that the client connected
            System.out.println("client connected");
    }
}
