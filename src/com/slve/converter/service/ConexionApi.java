package com.slve.converter.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.slve.converter.model.DatosDto;
import com.slve.converter.model.Datos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {

  /* Metodo para conexion con el servicio de ExchangeRate-API recibiendo
     el valor de los codigo de monedas */
  public void clienteHttp(String baseCode, String targetCode, double currencyAmount) {

    // Construccion de URL con APIKEY y los codigos ISO de las monedas
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

      String json = response.body().replace("}", ",") + "currency_amount:" + currencyAmount + "}";
      //System.out.println(json);

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      DatosDto datosJson = gson.fromJson(json, DatosDto.class);
      Datos datos = new Datos(datosJson);

      //System.out.println(datos);
      datos.conversionDivisa();

    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}
