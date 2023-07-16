package ProsesoDeLaApp;

import javax.swing.*;

public class MensajeFinal {
    public void mensajeFinal(){
        Object mensajeOpcion = JOptionPane.showConfirmDialog(null, "Desea continuar", "Elija una Opcion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        int mensaje = (Integer) mensajeOpcion;

        if (mensaje == 0){
            Proceso elecion = new Proceso();
            elecion.iniciar();
        }

        if (mensaje == 1){
            JOptionPane.showMessageDialog(null, "progrma finalisado", "Gracias", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
