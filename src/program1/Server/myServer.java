package program1.Server;
import java.io.*;
import java.net.*;

class myServer {
    public static void main (String args[]) throws Exception{
        String clientSentence;
        String capitalizedSentence;
        //creates the server side welcome socket that will accept the communication from the client socket
        ServerSocket welcomeSocket = new ServerSocket (25000);
        while (true){
            //this is the actual 3-way handshake
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
