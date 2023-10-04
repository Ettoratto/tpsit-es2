package itismeucci.tpsit;

import java.io.*;
import java.net.*;

public class ServerClass {

    int port;
    ServerSocket server;
    Socket client;
    BufferedReader in;
    PrintWriter out;

    public ServerClass(int port) {

        this.port = port;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void connect() {

        try {

            client = server.accept();
            server.close();

            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

            System.out.println("Client connesso: " + client.getInetAddress() + ":" + port);

        } catch (IOException e) {

        }
    }
    
    public void communicate() {

        try {

            String str;
            while (!(str = in.readLine()).equalsIgnoreCase("BYE")) {

                System.out.println("Client: " + str);
                out.println(str.toUpperCase());
            }
            
            closeConnection();
            connect();

        } catch (Exception e) {

            System.out.println("Something went wrong!11");
        }
    }

    public void closeConnection() {

        System.out.println("Closing connection...");
        try {
            in.close();
            out.close();
            client.close();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
       
}
