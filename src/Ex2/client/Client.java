package Ex2.client;
import java.net.*;
import java.util.Scanner;

public class Client {
    final static int port = 7878;
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];

    public static void main(String argv[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        InetAddress serveur = InetAddress.getByName("localhost");
        String message = "Bonjour Mr le serveur";
        int length = message.length();
        byte buffer_send[] = message.getBytes();
        DatagramPacket dataSent = new DatagramPacket(buffer_send, length, serveur, port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(dataSent);

        DatagramPacket dataRecieved = new DatagramPacket(buffer, taille);
        socket.receive(dataRecieved);
        System.out.println("Data recieved : " + new String(dataRecieved.getData()).trim());

        System.out.println("From : " + dataRecieved.getAddress() + ":" +
                dataRecieved.getPort());
        String buff;
        do {

            System.out.println("donner un text ");
            buff = scanner.nextLine();
            int length1 = buff.length();
            byte buffer[] = buff.getBytes();
            dataSent.setData(buffer, 0, length1);
            socket.send(dataSent);

        }


        socket.close();
    }
}
