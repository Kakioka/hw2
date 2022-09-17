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

package program1.Client;
import java.io.*;
import java.net.*;

public class myClient {
    public static void main (String[] args) throws Exception {

        //once again assuming that an int and port number is passed in as the first arg
        int portNum = Integer.parseInt(args[0]);
        //file writer for the client log
        FileWriter logWrite = new FileWriter("program1/Client/client_log.txt");
        //file writer to write what was received from the server into the client file
        FileWriter fw = new FileWriter("program1/Client/client_file.txt");
        //file writer to write to overall status file
        FileWriter statusWrite = new FileWriter("program1/status.txt");

        //this is the socket that will connect to the server
        Socket socket = new Socket("localhost", portNum);
        logWrite.write("Client attempted connection. \n");

        //object from the client socket to read data from the server
        InputStream input = socket.getInputStream();
        logWrite.write("Connection was successful. \n");
        statusWrite.write("Connected on client side. \n");

        //buffered reader to read in lines of text
        //the input stream reader is to read the data in input
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        //br is then read into the string data which will then print into client_file.txt
        String data = br.readLine();
        logWrite.write("Server data read. \n");
        statusWrite.write("Data received from server. \n");
        //closes statusWrite as it is no longer needed
        statusWrite.close();
        //closes the logWrite as we no longer need it
        logWrite.close();

        //writes the data received to client_file.txt
        fw.write(data);
        //closes fw as it is no longer needed
        fw.close();

    }
}
