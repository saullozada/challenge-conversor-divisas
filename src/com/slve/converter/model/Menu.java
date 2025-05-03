package com.slve.converter.model;

import com.slve.converter.service.ConexionApi;

import java.util.Scanner;

public class Menu {
  public void principal() {
    String menu = """
        \n--------------------------------------------------
                  Bienvenida(o) a la Aplicación Java
        \n1. Conversor de Monedas
        2. Historico de Conversiones
        \n0. Salir
        --------------------------------------------------
        """;
    System.out.print(menu);
  }

  public void lista() {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    String divisas = """
        \n               Conversor de Monedas
        \n1. Dolar Americano [USD]
        2. Peso Mexicano [MXN]
        3. Real Brasileño [BRL]
        4. Peso Argentino [ARS]
        5. Sol Peruano [PEN]
        6. Peso Colombiano [COP]
        7. Colón Costarricense [CRC]
        8. Peso Guatemalteco [GTQ]
        9. Peso Chileno [CLP]
        --------------------------------------------------
        \nIngrese los Datos de Conversion
        """;
    System.out.print(divisas);

    System.out.print("Moneda Origen: ");
    opcion = scanner.nextInt();
    String baseCode = obtenerIso(opcion);

    System.out.print("Moneda Destino: ");
    opcion = scanner.nextInt();
    String targetCode = obtenerIso(opcion);

    System.out.print("Ingresar la cantidad de " + baseCode + " a convertir en " + targetCode + ": $ ");
    double currencyAmount = scanner.nextDouble();


    // Crear la conexion al servicio API
    var conexion = new ConexionApi();
    conexion.clienteHttp(baseCode, targetCode, currencyAmount);

  }

  // Metodo para obtener el Codigo ISO4217 de las divisas
  static String obtenerIso(int opcion) {
    return switch (opcion) {
      case 1 -> "USD";
      case 2 -> "MXN";
      case 3 -> "BRL";
      case 4 -> "ARS";
      case 5 -> "PEN";
      case 6 -> "COP";
      case 7 -> "CRC";
      case 8 -> "GTQ";
      case 9 -> "CLP";
      default -> throw new IllegalStateException("Unexpected value: " + opcion);
    };
  }
}
