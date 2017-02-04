// Abhinav Bassi
// 31327046
// CS 356 101
// Project 1

// Code uses basic classes as described in "Sockets programming in Java: A tutorial" from JavaWorld

import java.io.*;
import java.net.*;

class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("10.200.168.125", 26312);
        InputStream inputstream = socket.getInputStream();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        DataOutputStream serveroutput = new DataOutputStream(socket.getOutputStream());
        String line;
        String message;
        int routernumber = 0;
        int linkcost = 0;
        System.out.println("Router " + routernumber + ": Initial least known link cost is " + linkcost);
        message = "Router " + routernumber + ": Initial least known link cost is " + linkcost;
        serveroutput.writeBytes(message + '\n');
        System.out.println("\nMESSAGES FROM SERVER");
        while ((line = bufferedreader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedreader.close();
        socket.close();
    }
}