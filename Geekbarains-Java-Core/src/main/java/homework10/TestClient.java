package homework10;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {

  public static void main(String[] args) {
    try(Socket socket = new Socket("", 8080)) {
      System.out.println("Client started");

      DataOutputStream stream = new DataOutputStream(
        new BufferedOutputStream(socket.getOutputStream()));

      Scanner in = new Scanner(System.in);

      String str = "";
      while(!str.equals("stop")) {
        System.out.print("Input a string: ");
        str = in.nextLine();
        stream.writeUTF(str);
        stream.flush();
      }

      in.close();
      stream.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
