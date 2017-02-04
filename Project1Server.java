// Abhinav Bassi
// 31327046
// CS 356 101
// Project 1

// Code uses basic classes as described in "Sockets programming in Java: A tutorial" from JavaWorld

import java.io.*;
import java.net.*;

class Server {

    public static void main(String[] args) throws IOException {
        
        ServerSocket serversocket = new ServerSocket(21212);
        Socket socket = serversocket.accept();
        System.out.println("CONNECTION WITH CLIENT ESTABLISHED");
        BufferedReader clientinput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        OutputStream clientoutput = socket.getOutputStream();
        PrintStream printstream = new PrintStream(clientoutput);
        String clientmessage;
        int routernumber = 1;
        int linkcost = 1; 
        clientmessage = clientinput.readLine();
        printstream.println(clientmessage);
        printstream.println("Router " + routernumber + ": Initial least known link cost is " + linkcost);
        printstream.close();
        serversocket.close();
        socket.close();
    }
}
