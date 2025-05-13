package com.slve.converter.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Datos {

  // Variables requeridas para el convertidor de divisas
  String fechaActualizacion;
  String divisaBase;
  String divisaTarget;
  double tasaCambio;
  double montoDivisa;

  public Datos(DatosDto datosJson) {
    this.fechaActualizacion = datosJson.time_last_update_utc();
    this.divisaBase = datosJson.base_code();
    this.divisaTarget = datosJson.target_code();
    this.tasaCambio = datosJson.conversion_rate();
    this.montoDivisa  = datosJson.currency_amount();
  }

  public void conversionDivisa() {
    // Utilizo NumberFormat, porque tengo un problema de configuracion en mi laptop
    NumberFormat numeroF = NumberFormat.getCurrencyInstance(Locale.US);

    double montoConversion = montoDivisa * tasaCambio;

    String montoRedondeo = numeroF.format(montoDivisa);
    String totalMontoConversion = numeroF.format(montoConversion);

    System.out.println("\n--------------------------------------------------");
    System.out.println("\nDatos de la Conversion");
    System.out.println("Tipo de Cambio: " + tasaCambio);
    System.out.println("La cantidad de: " + montoRedondeo + " " + divisaBase);
    System.out.println("Corresponden a: " + totalMontoConversion + " " + divisaTarget);
  }

  @Override
  public String toString() {
    return "fecha=" + fechaActualizacion +
        ", monedaBase=" + divisaBase +
        ", monedaTarget=" + divisaTarget +
        ", tasaCambio=" + tasaCambio;
  }
}
