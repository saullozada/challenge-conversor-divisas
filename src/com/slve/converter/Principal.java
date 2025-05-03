package com.slve.converter;

import com.slve.converter.model.Menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {
    Scanner lectura = new Scanner(System.in);
    int opcion = 0;

    // * Inicio - Do While para el menu de la aplicación
    do {

      Menu menu = new Menu();
      menu.principal();

      System.out.print("Elige una opción: ");

      // Inicio - Logica de validacion de la opcion
      try {
        opcion = Integer.valueOf(lectura.nextInt());
        switch (opcion) {
          case 1:
            menu.lista();
            break;
          case 2:
            System.out.println("\nHistorico de Conversiones");
            break;
          case 0:
            System.out.println("\nSaliendo de la aplicación...");
            break;
          default:
            System.out.println("\nInténtalo de nuevo, elige una opción del menú.");
        }
      } catch (InputMismatchException ex) {
        System.out.println("\nSe require un valor numerico, inténtalo de nuevo,");
        lectura.nextLine();
      } // Fin - Logica de validacion de la opcion elegida

    } while (opcion != 0); // * Fin - Do While para el menu de la aplicación

    lectura.close();
  }
}
