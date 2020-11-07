package homework10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

  public static void main(String[] args) {
    try( ServerSocket serverSocket = new ServerSocket(8080)) {
      System.out.println("Server started");
      Socket socket = serverSocket.accept();
      System.out.println("New client connected");

      DataInputStream stream =
        new DataInputStream(
          new BufferedInputStream(socket.getInputStream()));

      String content = "";
      while(!content.equals("stop")) {
        content = stream.readUTF();
        System.out.println(content);
      }

      System.out.println("Client disconnected");
      stream.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
