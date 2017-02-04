// Abhinav Bassi
// 31327046
// CS 356 101
// Project 3

// Code uses basic classes as described in sockets programming from JavaWorld
// Code uses Bellman Ford algorithm as described on Stack Overflow

import java.io.*;
import java.net.*;

class Router1 {
    
    class Link {
        
        int source;
        int destination;
        int cost;
        Link () {
            source = 0;
            destination = 0;
            cost = 0;
        }
    }
    
    int routers;
    int interfaces;
    Link links[];

    Router1 (int routernumber, int interfacenumber) {
        
        routers = routernumber;
        interfaces = interfacenumber;
        links = new Link[interfacenumber];
        for (int i = 0; i < interfacenumber; ++i) {
            links[i] = new Link();
        }
    }
    
    void bellmanford (Router1 graph, int source) throws Exception {
        
        int routernumber = graph.routers;
        int interfacenumber = graph.interfaces;
        int distancetable[] = new int[routernumber];
        for (int i = 0; i < routernumber; ++i) {
            distancetable[i] = Integer.MAX_VALUE;
        }
        distancetable[source] = 0;
        for (int i = 1; i < routernumber; ++i) {
            for (int j = 0; j < interfacenumber; ++j) {
                int x = graph.links[j].source;
                int y = graph.links[j].destination;
                int cost = graph.links[j].cost;
                if (distancetable[x] != Integer.MAX_VALUE && distancetable[x]+cost < distancetable[y]) {
                    distancetable[y] = distancetable[x]+cost;
                }
            }
        }
        printtable(distancetable, routers);
    }
        
    void printtable (int distancetable[], int routers) throws IOException {
        
        ServerSocket serversocket = new ServerSocket(21211);
        Socket socket = serversocket.accept();
        System.out.println("CONNECTION WITH ROUTER 0 ESTABLISHED");
        OutputStream clientoutput = socket.getOutputStream();
        PrintStream printstream = new PrintStream(clientoutput);
        printstream.println("DESTINATION\tCOST");
        for (int i = 0; i < routers; ++i) {
            printstream.println((i + "\t\t" + distancetable[i]));
        }
        printstream.close();
        serversocket.close();
        socket.close();
    }
    
    public static void main(String[] args) throws IOException, Exception {
        
        int routernumber = 4;
        int interfacenumber = 4;
        Router1 distancetable = new Router1(routernumber, interfacenumber);
        distancetable.links[0].source = 0;
        distancetable.links[0].destination = 1;
        distancetable.links[0].cost = 1;
        distancetable.links[1].source = 0;
        distancetable.links[1].destination = 2;
        distancetable.links[1].cost = 3;
        distancetable.links[2].source = 1;
        distancetable.links[2].destination = 2;
        distancetable.links[2].cost = 1;
        distancetable.links[3].source = 0;
        distancetable.links[3].destination = 3;
        distancetable.links[3].cost = 7;
        distancetable.bellmanford(distancetable, 0);
    }      
}
