package com.slve.converter.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.slve.converter.model.Datos;
import com.slve.converter.model.DatosDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {
  final String API_KEY = "d1b329305202d24f4260c84f"; // Definir el valor de la API KEY

  /* Metodo para conexion con el servicio de ExchangeRate-API recibiendo
     el valor de los codigo de monedas */
  public void conexionHttp(String baseCode, String targetCode, double currencyAmount) {

    // Construir la URI para la conexión con la API
    URI urlExchange = URI.create("https://v6.exchangerate-api.com/v6/"+ API_KEY + "/pair/" + baseCode + "/" + targetCode);

    // Clase HttpClient para construir la conexion y consulta a la API
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(urlExchange)
        .build();
    try {
      HttpResponse<String> response = client
          .send(request, HttpResponse.BodyHandlers.ofString());

      String json = response.body().replace("}", ",") + "\"currency_amount\":" + currencyAmount + "}";
      //System.out.println(json);

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      DatosDto datosJson = gson.fromJson(json, DatosDto.class);

      Datos datos = new Datos(datosJson);

      datos.conversionDivisa();

    } catch (Exception e) {
      throw new RuntimeException("Se encontro un error con la conexion." + e.getMessage());
    }

  }
}
