// Abhinav Bassi
// 31327046
// CS 356 101
// Project 2

// Code uses basic classes as described in sockets programming from JavaWorld
// Code uses Bellman Ford algorithm as described on Stack Overflow

import java.io.*;
import java.net.*;

class Router0 {
    
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("192.168.1.128", 21212);
        InputStream inputstream = socket.getInputStream();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        String line;
        final Object[][] distancetable = new String[4][];
        distancetable[0] = new String[] {"0", "0"};
        distancetable[1] = new String[] {"1", "1"};
        distancetable[2] = new String[] {"2", "3"};
        distancetable[3] = new String[] {"3", "7"};
        System.out.println("DESTINATION\tCOST");
        for (final Object[] row : distancetable) {
            System.out.format("%1s%16s\n", row);
        }
        System.out.println();
        System.out.println("UPDATED TABLE");
        System.out.println();
        while ((line = bufferedreader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedreader.close();
        socket.close();
    }
}
