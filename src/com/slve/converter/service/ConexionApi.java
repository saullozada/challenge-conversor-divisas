package com.slve.converter.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {

  // Función de conexion al servicio de ExchangeRate-API
  public void clienteHttp() {

    /* Construir la URL para ExchangeRate-API con el Api Key asignado y los datos
    * de los codigos de las monedas
    * */
    var URL_EXCHANGE = "https://v6.exchangerate-api.com/v6/d1b329305202d24f4260c84f/pair/";
    String urlBase = URL_EXCHANGE + "MXN" + "/" + "USD";

    // Clase HttpClient para construir la conexion y consulta a la API
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(urlBase))
        .build();
    try {
      HttpResponse<String> response = client
          .send(request, HttpResponse.BodyHandlers.ofString());

      System.out.println(response.body());

    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}
