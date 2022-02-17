import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException

public class myFirstUDPServer {

  private static final int ECHOMAX = 255;  // Maximum size of echo datagram

  public static void main(String[] args) throws IOException {

    if (args.length != 1)  // Test for correct argument list
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int servPort = Integer.parseInt(args[0]);

    System.out.println("\nStarting server...");

    DatagramSocket socket = new DatagramSocket(servPort);
    DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
    
    for (;;) {  // Run forever, receiving and echoing datagrams
      socket.receive(packet);     // Receive packet from client
      System.out.println("\nHandling client at " +
		      packet.getAddress().getHostAddress() + " on port " + packet.getPort());

      String cString = new String(packet.getData(), packet.getOffset(), packet.getLength());

      System.out.println("Server Received: " + cString.toUpperCase() + "\n>>> " + cString.toUpperCase());
      System.out.println("---------------------------------------------------------");

      socket.send(packet);       // Send the same packet back to client

      packet.setData(new byte[ECHOMAX]);
      packet.setLength(ECHOMAX); // Reset length to avoid shrinking buffer
    }
    /* NOT REACHED */
  }
}
