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

            //print writer to send data to the client
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            //prints a phrase to client
            pw.println("Hello Client!");
            System.out.println("Msg sent");
            //flushes the print writer to be safe
            pw.flush();
    }
}
