// Abhinav Bassi
// 31327046
// CS 356 101
// Project 3

// Code uses basic classes as described in sockets programming from JavaWorld
// Code uses Bellman Ford algorithm as described on Stack Overflow

import java.io.*;
import java.net.*;

class Router0 {
    
    public static void main(String[] args) throws IOException {
        
        final Object[][] distancetable = new String[4][];
        distancetable[0] = new String[] {"0", "0"};
        distancetable[1] = new String[] {"1", "1"};
        distancetable[2] = new String[] {"2", "3"};
        distancetable[3] = new String[] {"3", "7"};
        System.out.println("DESTINATION\tCOST");
        for (final Object[] row : distancetable) {
            System.out.format("%1s%16s\n", row);
        }
        Socket socket1 = new Socket("192.168.1.128", 21211);
        InputStream inputstream1 = socket1.getInputStream();
        BufferedReader bufferedreader1 = new BufferedReader(new InputStreamReader(inputstream1));
        String line1;
        System.out.println();
        System.out.println("UPDATED TABLE FROM ROUTER 1");
        System.out.println();
        while ((line1 = bufferedreader1.readLine()) != null) {
            System.out.println(line1);
        }
        bufferedreader1.close();
        socket1.close();
        Socket socket2 = new Socket("192.168.1.132", 21212);
        InputStream inputstream2 = socket2.getInputStream();
        BufferedReader bufferedreader2 = new BufferedReader(new InputStreamReader(inputstream2));
        String line2;
        System.out.println();
        System.out.println("UPDATED TABLE FROM ROUTER 2");
        System.out.println();
        while ((line2 = bufferedreader2.readLine()) != null) {
            System.out.println(line2);
        }
        bufferedreader2.close();
        socket2.close();
        Socket socket3 = new Socket("192.168.1.118", 21213);
        InputStream inputstream3 = socket3.getInputStream();
        BufferedReader bufferedreader3 = new BufferedReader(new InputStreamReader(inputstream3));
        String line3;
        System.out.println();
        System.out.println("UPDATED TABLE FROM ROUTER 3");
        System.out.println();
        while ((line3 = bufferedreader3.readLine()) != null) {
            System.out.println(line3);
        }
        bufferedreader3.close();
        socket3.close();
    }
}
