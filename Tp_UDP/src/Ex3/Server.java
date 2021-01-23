package Ex3;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
public class Server {
    final static int port = 7878;
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];
    public static void main(String argv[]) throws Exception
    {
        DatagramSocket socket = new DatagramSocket(port);
        while(true)
        {




            DatagramPacket datarecv = new
                    DatagramPacket(buffer,taille);
            socket.receive(datarecv);
            ByteArrayInputStream byteStream = new
                    ByteArrayInputStream(datarecv.getData());
            ObjectInputStream objectStream = new
                    ObjectInputStream(byteStream);
            Personne object = (Personne) objectStream.readObject();
            System.out.println(object.getNom());



        }
    }
}
