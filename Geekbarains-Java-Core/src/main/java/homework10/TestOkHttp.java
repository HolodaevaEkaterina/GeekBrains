package homework10;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TestOkHttp {

  public static void main(String[] args) {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
      .url("https://www.google.ru/")
      .build();

    try {
      Response execute = client.newCall(request).execute();
      System.out.println(execute.body() != null ? execute.body().contentType() : null);
      System.out.println(execute.code());
      System.out.println(execute.headers());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
