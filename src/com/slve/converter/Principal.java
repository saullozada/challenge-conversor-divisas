package com.slve.converter;

import com.slve.converter.service.ConexionApi;

import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {

    // * Inicio - While para el menu de opciones del Convertidor
    while (true) {
      Scanner lectura = new Scanner(System.in);

      String menuPrincipal = """
          \n--------------------------------------------------
          
                     Bienvenida(o) a la Aplicación
          
          1. Convertidor Uno
          2. Convertidor Dos
          9. Salir de la Aplicación
          
          --------------------------------------------------
          """;
      System.out.println(menuPrincipal);

      // Inicio - Logica de validacion de la opcion elegida
      try {

        System.out.println("Elija una opción: ");
        var opcion = Integer.valueOf(lectura.next());

        // Condicion para romper el While del menu de opciones
        if (opcion == 9) {
          System.out.println("Saliendo de la aplicación, gracias por utilizarla...");
          break;
        }

        // Asignar a las variables el codigo ISO de las monedas de acuerdo al metodo
        String baseCode = base(opcion);
        String targetCode = target(opcion);

        System.out.println("Monedas elegidas: " + baseCode + " " +targetCode);

        // Crear la conexion al servicio API
        ConexionApi conexion = new ConexionApi();
        conexion.clienteHttp(baseCode, targetCode);

      } catch (RuntimeException e) {
        System.out.println(e.getMessage());
        ;
      }
      // Fin - Logica de validacion de la opcion elegida
    }
    // * Fin - Blucle para el menu de opciones del Convertidor
  }

  // Metodo para obtener el codigo ISO de la moneda base
  public static String base(int opcion) {
    return switch (opcion) {
      case 1 -> "USD";
      case 2 -> "MXN";
      default -> throw new IllegalStateException("Unexpected value: " + opcion);
    };
  }

  // Metodo para obtener el codigo ISO de la moneda target
  public static String target(int opcion) {
    return switch (opcion) {
      case 1 -> "MXN";
      case 2 -> "USD";
      default -> throw new IllegalStateException("Unexpected value: " + opcion);
    };
  }
}
