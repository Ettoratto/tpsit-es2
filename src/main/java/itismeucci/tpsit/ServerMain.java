package itismeucci.tpsit;

public class ServerMain {
    public static void main(String[] args) {

        ServerClass server = new ServerClass(6789);

        server.connect(); 
        for(;;)
        server.communicate();
    }


}