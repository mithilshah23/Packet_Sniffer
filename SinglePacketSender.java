import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.net.InetAddress;

public class SinglePacketSender {
    Socket socket;
    private String sourceIP;
    private String destinationIP;
    private String sourcePort;
    private String destinationPort;
    private String typeOfProtocol;

    public SinglePacketSender() throws IOException {
        socket = new Socket("localhost", 7777);
        System.out.println("Connected!");
        InetAddress IP = InetAddress.getLocalHost();
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        sourceIP = IP.getHostAddress();
        destinationIP = "192.168.29.173";
        sourcePort = String.valueOf(socket.getPort());
        destinationPort = String.valueOf(socket.getLocalPort());
        typeOfProtocol = "TCP/IP";
        List<PacketInformation> Packet = new ArrayList<>();
        Packet.add(new PacketInformation(sourceIP)); // source IP address
        Packet.add(new PacketInformation(destinationIP)); // destination IP address
        Packet.add(new PacketInformation(sourcePort)); // source port
        Packet.add(new PacketInformation(destinationPort)); // destination port
        Packet.add(new PacketInformation(typeOfProtocol)); // type of protocol

        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(Packet);

        // System.out.println("Closing socket and terminating program.");
        socket.close();

    }
}
