package program1.Client;
import java.io.*;
import java.net.*;

public class myClient {
    public static void main (String[] args) throws Exception {

        //once again assuming that an int and port number is passed in as the first arg
        int portNum = Integer.parseInt(args[0]);

        //this is the socket that will connect to the server
        Socket s = new Socket("localhost", portNum);
        System.out.println("Client connecting");

        //object from the client socket to read data from the server
        InputStream input = s.getInputStream();

        //buffered reader to read in lines of text
        //the input stream reader is to read the data in input
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        //br is then read into the string data which will then print into client_file.txt
        String data = br.readLine();

        System.out.println(data);
    }
}
