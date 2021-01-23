package Ex2.server;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.util.Date;

public class Server {
    final static int port = 7878;
    final static int taille = 1024;
    final static byte buffer[] = new byte[taille];
    public static void main(String argv[]) throws Exception
    {
        DatagramSocket socket = new DatagramSocket(port);
        while(true)
        {
            DatagramPacket datarecv = new DatagramPacket(buffer,taille);
            socket.receive(datarecv);
            System.out.println(new String(datarecv.getData()).trim());
            String message = "Bonjour Mr le Ex2.client"+"\n"+"Date :"+new Date()+"\n";
            int length = message.length();
            byte buffer_send[] = message.getBytes();
            DatagramPacket dataSent = new DatagramPacket(buffer_send,length,datarecv.getAddress(),datarecv.getPort());
            socket.send(dataSent);
            String dd;
            do {
                datarecv.setData(new byte[taille],0,taille);
                socket.receive(datarecv);
                dd = new String(datarecv.getData()).trim().toUpperCase();
                System.out.println(dd);

            }while (!dd.equals("BYE"));


        }
    }
}

