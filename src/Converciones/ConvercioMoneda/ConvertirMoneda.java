package Converciones.ConvercioMoneda;
import ProsesoDeLaApp.MensajeFinal;
import ProsesoDeLaApp.Proceso;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertirMoneda {
    public void obtenerDatos(){
        Object [] listaMoneda={"De Pesos(MX) a Dolar","De Pesos (DOP) a Dólar","De Pesos (DOP) a Euro","De pesos (DOP) a pesos (MX)","De Dolar a Pesos(DOP)"};
        Object opcionesMoneda =  JOptionPane.showInputDialog(null,"Seleccione una opcion para convertir", "menu", JOptionPane.QUESTION_MESSAGE, null, listaMoneda, listaMoneda[0]);
        String monedaSelecionada =  (String) opcionesMoneda;

        if (opcionesMoneda == null){
            MensajeFinal mensajeFinal = new MensajeFinal();
            mensajeFinal.mensajeFinal();
            System.exit(0);
        }

        try {
            String Monto = JOptionPane.showInputDialog("Ingrese la cantidad de dinero que seas convertir \n Opcion escogida: " + opcionesMoneda);

            ConvertirMoneda operacion = new ConvertirMoneda();
            operacion.Covercion(monedaSelecionada, Monto);

        }
        catch (NumberFormatException | NullPointerException exception ){
            JOptionPane.showMessageDialog(null, "Valor no valido", "error", JOptionPane.ERROR_MESSAGE);
            Proceso interatarDeNuevo = new Proceso();
            interatarDeNuevo.iniciar();
        }


    }

    public void Covercion(String tipoCovercion, String CantidaDinero){

        String datos_api[];
        datos_api = new String[4];

        String converir = "", covertidor="";
        switch (tipoCovercion) {
            case "De Pesos(MX) a Dolar":
                converir="MXN";
                covertidor="USD";
                break;

            case "De Pesos (DOP) a Dólar":
                converir="DOP";
                covertidor="USD";
                break;

            case "De Pesos (DOP) a Euro":
                converir="DOP";
                covertidor="EUR";
                break;

            case "De pesos (DOP) a pesos (MX)":
                converir="DOP";
                covertidor="MXN";
                break;

            case "De Dolar a Pesos(DOP)":
                converir="USD";
                covertidor="DOP";
                break;

            case "De Dolar a Euro":
                converir="USD";
                covertidor="EUR";
                break;

            case "De Pesos(MX) a Pesos(DOP)":
                converir="MXN";
                covertidor="DOP";
                break;

            case "De Euro a Pesos(DOP)" :
                converir="EUR";
                covertidor="DOP";
                break;

            case "Otros valores":
                ConvertirMoneda operacion= new ConvertirMoneda();


            default:
                break;
            //"De Pesos(MX) a Pesos(COP)",
        }


        LocalDate actualDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String fecha_formateada = actualDate.format(formatter);

        datos_api[0] = fecha_formateada;
        datos_api[1] = CantidaDinero;
        datos_api[2] = converir;
        datos_api[3] = covertidor;

        API repuesta = new API();
        double valor_convertido = repuesta.get(datos_api[0],datos_api[1],datos_api[2],datos_api[3]);

        double valoFormateado = 0;
         valoFormateado=Math.round((valor_convertido*100.0)/100.0);

         JOptionPane.showMessageDialog(null, "el valor de la conversion " + tipoCovercion + "es : $" + valoFormateado);

         MensajeFinal mensajeFinal = new MensajeFinal();


    }
}
