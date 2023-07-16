package Converciones.ConvercioMoneda;


import javax.swing.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class API {

    public double get(String dia, String Cantidad, String Converir, String Conversor){
        double valorFinal = 0;

        try{
            System.out.println("esperando ejecucion");
            URL url = new URL("https://api.apilayer.com/exchangerates_data/convert?to="+Conversor+"&from="+Converir+"&amount="+Cantidad+"&apikey=wSIdZtZe37dtPx7doriTCt7sLqjjLo4X");
            System.out.println(url);

            HttpURLConnection api = (HttpURLConnection) url.openConnection();
            api.setRequestMethod("GET");
            api.setRequestProperty("apikey", "wSIdZtZe37dtPx7doriTCt7sLqjjLo4X");

            if(api.getResponseCode() == 200){
                List datos_String = new ArrayList();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()){
                    datos_String.add(scanner.nextLine());
                }
                scanner.close();

                String valor = (String)datos_String.get(12);
                valor = valor.replaceAll("\"result\": ", "");
                valorFinal = Double.parseDouble(valor);
                System.out.println("el valor final es: " + valorFinal);
            }else {
                System.out.println("error de Repuesta de: " + api.getResponseCode());
            }

            api.disconnect();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error al convertir la moneda", "error", JOptionPane.ERROR_MESSAGE);
        }

        return valorFinal;
    }

}
