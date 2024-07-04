/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seahub.trabajofinaltorneo.igu.principal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Controladora;
import seahub.trabajofinaltorneo.logica.Torneo;

/**
 *
 * @author tinov
 */
public class CrearTorneosP extends javax.swing.JFrame {

    /**
     * Creates new form CrearTorneosP
     */
    private Administrador adm;
    public CrearTorneosP() {
        initComponents();
    }
    public CrearTorneosP(Administrador adm){
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 500);
        this.setTitle("");
        setVisible(true);
        this.adm = adm;
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
        btnCreacion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtCrearTorneo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 41, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreacion.setText("Crear");
        btnCreacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreacionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        txtCrearTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCrearTorneoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCrearTorneo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 260, -1));

        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Nombre del torneo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreacionActionPerformed
        String nombreTor = txtCrearTorneo.getText();
        if(nombreTor.isEmpty()==true){
           JOptionPane.showMessageDialog(null, "NOMBRE VACIO DE TORNEO");
        }else{
            Torneo tor = new Torneo(nombreTor,adm);
            Controladora control = new Controladora();
            try {
                control.crearTorneo(tor);
                VistaTorneoInscripcion vistaTor = new VistaTorneoInscripcion(tor,adm);
                vistaTor.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(CrearTorneosP.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_btnCreacionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       AdministradorHome administradorHome= new AdministradorHome(adm);
       administradorHome.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCrearTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCrearTorneoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCrearTorneoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CrearTorneosP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearTorneosP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearTorneosP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearTorneosP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearTorneosP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreacion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCrearTorneo;
    // End of variables declaration//GEN-END:variables
}
