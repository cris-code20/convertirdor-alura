package ProsesoDeLaApp;

import Converciones.ConvercioMoneda.ConvertirMoneda;
import Converciones.ConvercionTeperatura.Temperatura;

import javax.swing.*;

public class Proceso {

    public void iniciar(){
        Object [] opciones = {"Conversor de Moneda", "Conversor de Temperatura"};
        Object opcionSelecion = JOptionPane.showInputDialog(null, "Selecione un tipo de convercion", "Menu", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        String opcionSeleciona = (String)opcionSelecion;

        if (opcionSeleciona != null){

             switch (opcionSeleciona){
                 case "Conversor de Moneda":
                     ConvertirMoneda obtenerMoneda = new ConvertirMoneda();
                     obtenerMoneda.obtenerDatos();
                     break;

                 case "Conversor de temperatura":
                     Temperatura temperatura = new Temperatura();
                     temperatura.ObtenerTemperatura();
                     break;

                 default:
                     break;

             }
        }

    }

}
