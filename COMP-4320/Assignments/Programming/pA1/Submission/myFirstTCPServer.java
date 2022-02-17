import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream

/*=======================================================================*
 **** FILE NAME:    myFirstTCPServer.java                                 *
 ***** AUTHOR:       Midas Oden                                            *  
 ****** VERSION:      02/07/2022                                            *
 ******* COMPILE:      javac myFirstTCPServer.java
 ******** EXECUTE:      java myFirstTCPServer
 *********
 ********** DESCRIPTION:  This program ...
 ***********
 ************
 *************=====================================================================*/

public class myFirstTCPServer {

  private static final int BUFSIZE = 32;   // Size of receive buffer

  public static void main(String[] args) throws IOException {

    if (args.length != 1)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int servPort = Integer.parseInt(args[0]);

    System.out.println("\nStarting server...");

    // Create a server socket to accept client connection requests
    ServerSocket servSock = new ServerSocket(servPort);

    int recvMsgSize;   // Size of received message
    byte[] byteBuffer = new byte[BUFSIZE];  // Receive buffer

    for (;;) { // Run forever, accepting and servicing connections
      Socket clntSock = servSock.accept();     // Get client connection

      System.out.println("\nHandling client at " +
        clntSock.getInetAddress().getHostAddress() + " on port " +
             clntSock.getPort());

      InputStream in = clntSock.getInputStream();
      OutputStream out = clntSock.getOutputStream();

      // Receive until client closes connection, indicated by -1 return
      while ((recvMsgSize = in.read(byteBuffer)) != -1) {
	StringBuilder strB = new StringBuilder(new String(byteBuffer));
        String capitaliseString = strB.toString().toUpperCase();
	
	System.out.println("Server Received: " + capitaliseString);
	byteBuffer = capitaliseString.getBytes();
	System.out.println(">>> " + capitaliseString 
			+ "\n---------------------------------------------------------");
        out.write(byteBuffer, 0, recvMsgSize);
      }

      byteBuffer = new byte[BUFSIZE];
      clntSock.close();  // Close the socket.  We are done with this client!
    }
    /* NOT REACHED */
  }
}
