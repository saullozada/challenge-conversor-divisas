package com.slve.converter;

import com.slve.converter.service.Conexion;
import com.slve.converter.util.Menus;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {
    Scanner lectura = new Scanner(System.in);
    Menus menu = new Menus();
    Conexion cliente = new Conexion();

    // Modificar la configuración de región a México
    Locale local = new Locale("es", "MX");
    lectura.useLocale(local);

    // Variables de entrada de teclado
    char opcionMenu = ' ';
    int opcionMoneda = 0;

    // * Inicio - Do While para el menu de la aplicación
    do {
      menu.principal();
      System.out.print("Seleccione la opción deseada (a, s): ");

      // ** Inicio - Logica de validacion de la opcMenu
      try {
        opcionMenu = lectura.next().charAt(0);

        switch (opcionMenu) {
          case 'a':
            menu.secundario();
            try {
              System.out.print("Moneda Origen: ");
              opcionMoneda = (int) lectura.next().charAt(0);
              String baseCode = menu.obtenerIso(opcionMoneda);

              System.out.print("Moneda Destino: ");
              opcionMoneda = lectura.next().charAt(0);
              String targetCode = menu.obtenerIso(opcionMoneda);

              System.out.print("Cantidad de " + baseCode + " a convertir: $");
              double currencyAmount = lectura.nextDouble();

              cliente.conexionHttp(baseCode, targetCode, currencyAmount);

            } catch (Exception e) {
              System.out.println("\n¡ El valor es incorrecto, \n se cancela la conversion !");
              lectura.next();
            }
            break;
          case 'b':
            break;
          case 's':
            System.out.println("\nSaliendo de la aplicación...");
            break;
          default:
            System.out.println("\n¡ Opciön incorrecta, seleccione una opción válida !");
        }
      } catch (InputMismatchException e) {
        lectura.nextLine();
      }
      // ** Fin - Logica de validacion de la opcionMenu elegida

    } while (opcionMenu != 's');
    lectura.close();
    // * Fin - Do While para el menu de la aplicación
  }
}