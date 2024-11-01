/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seahub.trabajofinaltorneo.igu.principal;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import seahub.trabajofinaltorneo.logica.Controladora;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import seahub.trabajofinaltorneo.logica.Torneo;

/**
 *
 * @author tinov
 */
public class MetricasParticipante extends javax.swing.JFrame {

    /**
     * Creates new form MetricasParticipante
     */
    private Participante par;
    public MetricasParticipante(){
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 500);
        this.setTitle("");
        setVisible(true);        
    }
    public MetricasParticipante(Participante par) {
        this.par=par;
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(400, 390);
        this.setTitle("Metricas");
        setVisible(true);
        txtNombre.setText(par.getNombre());
        txtGanados.setText(verCantidadGanador());
        txtCantidadTor.setText(cantidadParticipados());
        CargarFoto(par,foto);
    }
     public void CargarFoto(Participante par, JLabel label) {
        if (par.getFoto() != null) {
            ImageIcon icon = new ImageIcon(par.getFoto());
            Image scaledImage = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
            label.setIcon(new ImageIcon(scaledImage));
        } else {
            label.setIcon(null);
        }
    }
    public String verCantidadGanador(){
        Controladora control = new Controladora();
        ArrayList<Etapa> etaArray = control.traerTodoEtapa();
        int cantidad = 0;
        for(Etapa etaArr : etaArray){    
            System.out.println("Se rompe en esta\n");
            if(etaArr.getJerarquia()==0){
                System.out.println("Entra");
                if (etaArr.getIdParticipante() != null) {
                  if (etaArr.getIdParticipante().getIdParticipante().equals(par.getIdParticipante())) {
                    cantidad++;
                  }
                }
            }
        }
        return cantidad + "";
    }
    public String cantidadParticipados(){
        Controladora control = new Controladora();
        ArrayList<ParticipanteTorneo> parTorArray = control.traerTodoParticipanteTorneo();
        int cantidad = 0;
        for(ParticipanteTorneo parTor : parTorArray){
            if(parTor.getIdParticipante().getIdParticipante().equals(par.getIdParticipante())){
                cantidad++;
            }
        }
        return cantidad + "";
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtGanados = new javax.swing.JTextField();
        txtCantidadTor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 41, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Grupo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Cantidad torneos ganados:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Cantidad torneos participados:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));
        jPanel1.add(txtGanados, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, -1));
        jPanel1.add(txtCantidadTor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 180, -1));

        jButton1.setText("Volver Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        foto.setText("              Foto");
        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 120, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HomeParticipante homPart = new HomeParticipante(par);
        homPart.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MetricasParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetricasParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetricasParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetricasParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MetricasParticipante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidadTor;
    private javax.swing.JTextField txtGanados;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
