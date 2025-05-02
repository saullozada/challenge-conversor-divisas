package com.slve.converter.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {

  /* Metodo para conexion con el servicio de ExchangeRate-API recibiendo
     el valor de los codigo de monedas */
  public void clienteHttp(String baseCode, String targetCode) {

    // Construccion de URL con APIKEY y los codigos de monedas seleccionados
    var URL_EXCHANGE = "https://v6.exchangerate-api.com/v6/d1b329305202d24f4260c84f/pair/";
    String urlBase = URL_EXCHANGE + baseCode + "/" + targetCode;

    // Clase HttpClient para construir la conexion y consulta a la API
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(urlBase))
        .build();
    try {
      HttpResponse<String> response = client
          .send(request, HttpResponse.BodyHandlers.ofString());

      String json = response.body();

      System.out.println(json);

    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}
