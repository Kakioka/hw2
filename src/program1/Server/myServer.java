/**
 * NAME     :KULIAKAIWIKUAMOO (KAIWI) AKIOKA
 * 
 * HOMEWORK     : 1
 * 
 * CLASS        : ICS 451
 *
 * INSTRUCTOR       : RAVI NARAYAN
 *
 * DATE         : 9/16/2022
 *
 * FILE         : myServer.java
 *
 * DESCRIPTION      : This file contains the server side of homework 1.
 *
 */


package program1.Server;
import java.io.*;
import java.net.*;
import java.util.*;

class myServer {
    public static void main (String[] args) throws Exception{

            //sets a variable equal to the first arg passed in as that should be a port number
            int portNum = Integer.parseInt(args[0]);

            //file writer for the ser_log
            FileWriter logWrite = new FileWriter("program1/Server/server_log.txt");
            //file writer to write to the overall status.txt file
            FileWriter statusWrite = new FileWriter("program1/status.txt");
            //file obj declaration for scanning
            File msg = new File("program1/Server/server_file.txt");

            //sets up a server socket at the port number
            ServerSocket serverSocket = new ServerSocket(portNum);
            logWrite.write("Server Socket set up. \n");
            //accepts the connection from the client
            Socket socket = serverSocket.accept();
            logWrite.write("Client connected. \n");
            statusWrite.write("Connected on server side \n");

            //print writer to send data to the client
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            //scanner to read from server_file.txt
            Scanner scan = new Scanner(msg);
            //reads the file as long as there is a next line
            while (scan.hasNextLine()){
                //writes that data into a string called data to be sent
                String tmpData = scan.nextLine();
                //writes whatever was read into the log for documentation
                logWrite.write(tmpData);
                //prints lines to client 1 line at a time
                pw.println(tmpData);
            }

            logWrite.write("Message sent to client. \n");
            statusWrite.write("Message sent to client. \n");
            //closes statusWrite as it is no longer needed
            statusWrite.close();
            //flushes the print writer to be safe
            pw.flush();
            
            logWrite.write("pw flushed. \n");
            //closes logWrite as it is no longer neeeded
            logWrite.close();
    }
}
