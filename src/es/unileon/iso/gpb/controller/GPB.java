/*
 * Clase main de GPB
 */
package es.unileon.iso.gpb.controller;

import es.unileon.iso.gpb.vista.*;
import es.unileon.iso.gpb.modelo.connection.*;
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
        new LogIn().setVisible(true);
    }
}
