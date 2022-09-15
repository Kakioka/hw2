package program1.Client;
import java.io.*;
import java.net.*;

public class myClient {
    public static void main (String[] args){

        //user input
        String sentence;
        //computer modified user input
        String modiifiedSentence;
        //reader in order to take input from user
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        //this creates the socket by which the tcp connection will be initiated
        //hostname must be replaced before connecting
        //port MUST be the same on this and server side
        Socket clientSocket = new Socket ("hostname", 25000);
        //outToSerer is the output that will be sent to the server
        //inFromStream is the input that will be received from the server via the process
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromStream =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //makes sentence equal to the input from the user
        sentence = inFromUser.readLine();
        //
        outToServer.writeBytes(sentence + '\n');


        System.out.println("Hello World!");
        System.out.println("Once More");
    }
}
