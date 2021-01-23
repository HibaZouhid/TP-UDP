package Ex3;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Client
{ final static int port = 7878;
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];
    public static void main(String argv[]) throws Exception
    {
        InetAddress serveur = InetAddress.getByName("localhost");


        Personne p1 = new Personne("salim","morchid",new Date()) ;
        ByteArrayOutputStream outbyteStream = new
                ByteArrayOutputStream();
        ObjectOutputStream outobjectStream = new
                ObjectOutputStream(outbyteStream);
        outobjectStream.writeObject(p1);
        byte[] byteArray = outbyteStream.toByteArray();
        DatagramPacket pSent = new
                DatagramPacket(byteArray,byteArray.length,serveur,port);


        DatagramSocket socket = new DatagramSocket();
        socket.send(pSent);
        DatagramPacket dataRecieved = new DatagramPacket(buffer,taille);
        socket.receive(dataRecieved);
        System.out.println("Data recieved : " + new String(dataRecieved.getData()).trim());
        System.out.println("From : " + dataRecieved.getAddress() + ":" +
                dataRecieved.getPort());
        socket.close();
    } }
