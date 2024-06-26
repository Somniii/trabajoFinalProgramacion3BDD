/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seahub.trabajofinaltorneo.igu.principal;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import seahub.trabajofinaltorneo.logica.Controladora;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import seahub.trabajofinaltorneo.logica.Torneo;

/**
 *
 * @author nicoz
 */
public class UnirseTorneo extends javax.swing.JFrame {

    /**
     * Creates new form UnirseTorneo
     */
    private Participante par;
    public UnirseTorneo() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setVisible(true);
        this.setTitle("Unirse a Torneos Existentes");
        mostrarTabla();
    }
    public UnirseTorneo(Participante par) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 500);
        this.setTitle("Unirse a torneos Existentes");
        setVisible(true);
        this.par = par;
         mostrarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTorneo = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaTorneo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaTorneo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTorneoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTorneo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 410, 340));

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaTorneoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTorneoMouseClicked
        Controladora control = new Controladora();
        int select = TablaTorneo.getSelectedRow();
        int contador = 0;
        boolean yaUnido = false;
        Torneo tor = null;
        boolean disponible = false;
        ArrayList<Torneo> torneoArr = control.traerTodoTorneo();
        for (Torneo torAux : torneoArr) {


            if (torAux.getInscripcionVigente() == true) {
                disponible = true; // Verificar disponibilidad por torneo
            } else {
                disponible = false;
            }
            if (contador == select) {
                tor = torAux;
                break;
            }            
            System.out.println("Torneo:"+torAux.getNombre());
            System.out.println("Disponinle =" + disponible);            
            contador++;
        }

        ArrayList<ParticipanteTorneo> parTorArr = control.traerTodoParticipanteTorneo();
        for (ParticipanteTorneo parTorAux : parTorArr) {
            if (parTorAux.getIdParticipante().equals(par) == true) {
                if (parTorAux.getIdTorneo().equals(tor) == true) {
                    yaUnido = true;
                }
            }
        }
        ArrayList<Torneo> torneoArr2 = control.traerTodoTorneo();

        System.out.println("Disponinle FINAL=" + disponible);
        if (yaUnido == true) {
            JOptionPane.showMessageDialog(null, "YA ESTAS UNIDO A :" + tor.getNombre());
            UnirseTorneo unirseT = new UnirseTorneo(par);
            unirseT.setVisible(true);
            this.setVisible(false);
        }
        if (disponible == false) {
            JOptionPane.showMessageDialog(null, "EL TORNEO " + tor.getNombre() + " CERRO INSCRIPCION");
            UnirseTorneo unirseT = new UnirseTorneo(par);
            unirseT.setVisible(true);
            this.setVisible(false);
            
        } 

        if(yaUnido == false && disponible == true ){
            JOptionPane.showMessageDialog(null, "TE UNISTE A :" + tor.getNombre());
            ParticipanteTorneo parTor = new ParticipanteTorneo(tor, par);
            try {
                control.crearParticipanteTorneo(parTor);
            } catch (Exception ex) {
                Logger.getLogger(UnirseTorneo.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage()); // Mostrar mensaje más informativo
            }
            UnirseTorneo unirseT = new UnirseTorneo(par);
            unirseT.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_TablaTorneoMouseClicked

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        HomeParticipante homePar = new HomeParticipante(par);
        homePar.setVisible(true);
        homePar.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void mostrarTabla(){
        Torneo torneo = new Torneo();
        torneo.ListaTorneoParticipante(TablaTorneo ,par);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UnirseTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnirseTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnirseTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnirseTorneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnirseTorneo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTorneo;
    private javax.swing.JButton btnAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
