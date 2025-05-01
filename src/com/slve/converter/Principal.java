package com.slve.converter;

import com.slve.converter.service.ConexionApi;

import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {
    // Crear la conexion al servicio API
    ConexionApi conexionApi = new ConexionApi();

    // * Inicio - Blucle para el menu de opciones del Convertidor
    while (true) {
      Scanner lectura = new Scanner(System.in);

      String menuConvertidor = """
          Imprimir el menú de opciones
          
          1. Dolar Americano (USD) >> Pesos Mexicano (MXN)
          9. Salir de la Aplicación
          """;
      System.out.println(menuConvertidor);

      System.out.println("Elija una opción: ");

      // Inicio - Logica de validacion de la opcion elegida
      try {
        var opcion = Integer.valueOf(lectura.next());
        System.out.println(opcion);

        // Condición para romper del bucle del menu de opciones
        if (opcion == 9) {
          break;
        }

        // Validar la conexion con el clienteHttp
        conexionApi.clienteHttp();

      } catch (RuntimeException e) {
        System.out.println(e.getMessage());
        ;
      }
      // Fin - Logica de validacion de la opcion elegida
    }
    // * Fin - Blucle para el menu de opciones del Convertidor
  }
}
