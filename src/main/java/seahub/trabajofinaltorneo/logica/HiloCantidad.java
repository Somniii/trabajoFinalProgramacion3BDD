/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author tinov
 */
public class HiloCantidad implements Runnable {
    private volatile boolean running = true;
    private Controladora control;
    private JTextField txtCantidad;

    public HiloCantidad(Controladora control, JTextField txtCantidad) {
        this.control = control;
        this.txtCantidad = txtCantidad;
    }

    public HiloCantidad(Controladora control) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void run() {
        while (running) {
            if (!txtCantidad.isVisible()) {
                break;
            } else {
                txtCantidad.setText(control.traerTodoParticipante().size() + "");
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloCantidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stopRunning() {
        running = false;
    }
}