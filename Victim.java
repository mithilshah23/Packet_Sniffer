import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class Victim {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        long start = System.currentTimeMillis();
        long end = start + 3000 * 1000;
        HashMap<String, Integer> count = new HashMap<>();
        ServerSocket ss = new ServerSocket(7777);
        while (System.currentTimeMillis() < end) {

            System.out.println("Waiting for Packet to be sent.");
            Socket socket = ss.accept();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            @SuppressWarnings(value = "unchecked")
            List<PacketInformation> Packet = (List<PacketInformation>) objectInputStream.readObject();
            String sourceIP = Packet.get(0).getText();
            if (count.containsKey(sourceIP)) {
                count.put(sourceIP, count.get(sourceIP) + 1);
            } else {
                count.put(sourceIP, 1);
            }
            int countFromIP = count.get(sourceIP);
            System.out.println("Connection from " + socket + ". Packet number is " + countFromIP);
            new PortScanning(Packet, socket);
            if (countFromIP > 1000) {
                System.out.println("-------------------An attack is happening!!--------------------------");
            }
            socket.close();
        }
        ss.close();
        System.out.println("Closing sockets.");

    }
}
