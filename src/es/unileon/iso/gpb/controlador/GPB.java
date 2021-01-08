/*
 * Clase main de GPB
 */
package es.unileon.iso.gpb.controlador;

import es.unileon.iso.gpb.vista.*;

/**
 *
 * @author Angel
 */
public class GPB {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        LogIn inicio = new LogIn();
        inicio.pack();
        inicio.setVisible(true);
        
    }
}
