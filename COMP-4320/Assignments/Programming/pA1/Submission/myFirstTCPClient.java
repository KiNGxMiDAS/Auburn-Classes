import java.net.*;  // for Socket
import java.io.*;   // for IOException and Input/OutputStream
import java.util.Scanner;  // for creating Scanner Objects

/*=====================================================================*
 * FILE NAME:    myFirstTCPClient.java                                 *
 * AUTHOR:       Midas Oden                                            *  
 * VERSION:      02/07/2022                                            *
 * COMPILE:      javac myFirstTCPClient.java
 * EXECUTE:      java myFirstTCPClient
 *
 * DESCRIPTION:  This program ...
 *
 *
 * =====================================================================*/

public class myFirstTCPClient {

  public static void main(String[] args) throws IOException {

    if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Server> [<Port>]");

    // Server name or IP address
    String server = args[0];
    
    // ternary operator
    // int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
    
    int servPort = Integer.parseInt(args[1]);

    // Display message on how to terminate program
    System.out.print("\n*** Press Ctrl+C to terminate program ***");

    String userInput = "";
    
    while (true) {
      System.out.println("\n\n-------------------------------------------------------------");
      System.out.print("Enter a message to send over to the server: ");
      
      // Scanner object to scan sentence to send to server
      Scanner scanObj = new Scanner(System.in);
      userInput = scanObj.nextLine();
      
      // Convert input String to bytes using the default character encoding
      byte[] byteBuffer = userInput.getBytes();

      // Create socket that is connected to server on specified port
      Socket socket= new Socket(server, servPort);

      // Create stream for sending/receiving bytes of data
      InputStream in = socket.getInputStream();
      OutputStream out = socket.getOutputStream();

      // NOW CONNECTED !!
      System.out.println("Sending over to server....");

      // Start timer (ms)
      long startTimer = System.currentTimeMillis();
      out.write(byteBuffer);  // Send the encoded string to the server

      // Receive the same string back from the server
      int totalBytesRcvd = 0;  // Total bytes received so far
      int bytesRcvd;           // Bytes received in last read
      while (totalBytesRcvd < byteBuffer.length) {
        if ((bytesRcvd = in.read(byteBuffer, totalBytesRcvd,  
                        byteBuffer.length - totalBytesRcvd)) == -1)
		throw new SocketException("Connection close prematurely");
	totalBytesRcvd += bytesRcvd;
      }

      // End timer (ms)
      long endTimer = System.currentTimeMillis();

      // Compute round trip time
      long roundTripTime = endTimer - startTimer;

      System.out.println("....client has received a message");

      System.out.println("Message Received: " + new String(byteBuffer));

      System.out.println("\nThe response took " + Long.toString(roundTripTime) + " millisecond(s)");
      System.out.println("-------------------------------------------------------------");

      socket.close();  // Close the socket and its streams
    
    }
  }
}
