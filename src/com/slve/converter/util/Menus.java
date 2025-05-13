package com.slve.converter.util;

public class Menus {

  public void principal() {
    String menu = """
        \n--------------------------------------------------
                  Bienvenida(o) a la Aplicación Java
        \na. Conversor de Monedas
        \ns. Salir
        --------------------------------------------------
        """;
    System.out.print(menu);
  }

  public void secundario() {
    String opciones = """
        \n               Conversor de Monedas
        \n1. USD - Dolar Americano
        2. MXN - Peso Mexicano
        3. BRL - Real Brasileño
        4. ARS - Peso Argentino
        5. PEN - Sol Peruano
        6. COP - Peso Colombiano
        7. CRC - Colón Costarricense
        8. GTQ - Peso Guatemalteco
        9. CLP - Peso Chileno
        
        --------------------------------------------------
        """;
    System.out.print(opciones);
    System.out.println("Seleccione las opciones (1 a 9)");
  }

  // Metodo para obtener el Codigo ISO4217 de las divisas
  public static String obtenerIso(int opcionMoneda) {
    return switch (opcionMoneda) {
      case 49 -> "USD";
      case 50 -> "MXN";
      case 51 -> "BRL";
      case 52 -> "ARS";
      case 53 -> "PEN";
      case 54 -> "COP";
      case 55 -> "CRC";
      case 56 -> "GTQ";
      case 57 -> "CLP";
      default -> throw new IllegalStateException("Unexpected value: " + opcionMoneda);
    };
  }
}
