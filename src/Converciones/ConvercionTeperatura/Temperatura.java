package Converciones.ConvercionTeperatura;


import javax.swing.*;
import ProsesoDeLaApp.MensajeFinal;
import ProsesoDeLaApp.Proceso;

public class Temperatura {

    public void ObtenerTemperatura() {
        Object[] opciones_temperatura = {"Grado Celsius a Kelvin ", "Grado Kelvin a Celsius", "Grado Celsius a Grado Fahrenheit", "Grado Fahrenheit a Grado Celsius", "Grado Fahrenheit a Grado Kelvin"};
        Object opciones_elegir_temperatura = JOptionPane.showInputDialog(null, "Seleccione un opción de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, null, opciones_temperatura, opciones_temperatura[0]);
        String opcionTemperatura_elegida = (String) opciones_elegir_temperatura;

        if (opciones_elegir_temperatura == null) {
            MensajeFinal MensajeFinal = new MensajeFinal();
            MensajeFinal.mensajeFinal();
            // por si escoge no seguir se sale del programa
            System.exit(0);
        }


        try {
            //ingresar valor
            String opcion_cantidad_grados = JOptionPane.showInputDialog("Ingrese los grados que desea convertir \n Opción escogida : " + opcionTemperatura_elegida);
            double opcion_elegida_cantidadGrados = Double.parseDouble(opcion_cantidad_grados);

            //operción conversión
            Temperatura operacion = new Temperatura();
            operacion.resultadoConversion(opcionTemperatura_elegida, opcion_elegida_cantidadGrados);
        }// por si se  ingresa un valor  no permitido
        catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Valor no valido", "Error", JOptionPane.ERROR_MESSAGE);
            Proceso intentar_de_nuevo = new Proceso();
            intentar_de_nuevo.iniciar();

        }



    }

    public void resultadoConversion (String tipoConvercion, double cantidadGrados) {


        double resultadoConversion = 0;

        switch (tipoConvercion) {

            case "Grado Celsius a Kelvin ":

                resultadoConversion = cantidadGrados + 273;
                break;

            case "Grado Celsius a Grado Fahrenheit":

                resultadoConversion = (1.8 * cantidadGrados) + 32;
                break;

            case "Grado Fahrenheit a Grado Celsius":

                resultadoConversion = (cantidadGrados - 32) / 1.8;
                break;

            case "Grado Kelvin a Celsius":
                resultadoConversion = cantidadGrados - 273;
                break;

            case "Grado Fahrenheit a Grado Kelvin":
                int valordolar_cop = 3905;
                resultadoConversion = ((cantidadGrados - 32) / 1.8) + 273;
                break;


            default:
                break;


        }


        //mostrar conversión
        JOptionPane.showMessageDialog(null, "El valor de la conversión  " + tipoConvercion + " es : " + resultadoConversion);

        //mensaje final
        MensajeFinal mensajeFinal = new MensajeFinal();
        mensajeFinal.mensajeFinal();


    }
}