/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTextField;

/**
 *
 * @author romer
 */
public class Utiles {
    public static boolean validarFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH);
        sdf.setLenient(false);

        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha: " + e.getMessage());
            return false;
        }
    }
    
    public static Date setDateFormat(JTextField texto) throws ParseException{
        return new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).parse(texto.getText());
    }
    
    public static String obtenerFechaHoraActualFormateada() {
        // Obtén la fecha y hora actual
        Date fechaHoraActual = new Date();

        // Crea un formateador de fecha con el formato deseado y el idioma especificado
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH);

        // Formatea la fecha y hora actual
        return formateador.format(fechaHoraActual);
    }
}
