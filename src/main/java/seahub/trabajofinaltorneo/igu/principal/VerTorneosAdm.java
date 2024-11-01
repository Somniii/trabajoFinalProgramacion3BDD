/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seahub.trabajofinaltorneo.igu.principal;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Controladora;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import seahub.trabajofinaltorneo.logica.Torneo;

/**
 *
 * @author tinov
 */
public class VerTorneosAdm extends javax.swing.JFrame {

    /**
     * Creates new form VerTorneos
     */
    private Administrador adm;
    public VerTorneosAdm() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(810, 540);
        this.setTitle("");
        setVisible(true);
        mostrarTorneo();
       
    }
    public VerTorneosAdm(Administrador adm){
        initComponents();
        this.adm = adm;
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(810, 540);
        this.setTitle("Ver Torneos Existentes");
        setVisible(true);
        mostrarTorneo();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTorneo = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaTorneo.setBackground(new java.awt.Color(42, 42, 42));
        tablaTorneo.setForeground(new java.awt.Color(242, 242, 242));
        tablaTorneo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaTorneo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTorneoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTorneo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 810, 490));

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Elegir torneo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        irAtras();         // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void tablaTorneoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTorneoMouseClicked
        Controladora control = new Controladora();
        int select = tablaTorneo.getSelectedRow(); 
        ArrayList<Torneo> torneoArr = control.traerTodoTorneo();
        int contador = 0;
        //boolean yaTerminado = false;
        Torneo tor = new Torneo();
        Boolean inscripcionVigente = true;
        Boolean poderEntrar = false;
        Boolean esFinalizado = false;
        for(Torneo torAux : torneoArr){
            if(contador == select){
                tor = torAux;
                if(tor.getInscripcionVigente() == false){
                    inscripcionVigente = false;
                }
                Administrador admAux = tor.getIdAdministrador();
                if(admAux.getIdAdministrador()==adm.getIdAdministrador()){
                    poderEntrar = true;
                }
                if(torAux.getVigente()==false){
                    esFinalizado = true;
                }
                    
                break;
            }
            contador++;
        }
        /*for(ParticipanteTorneo parTorAux : parTorArr){
            if(parTorAux.getIdParticipante().equals(par)== true){
                if(parTorAux.getIdTorneo().equals(tor)==true){
                    yaUnido = true;  
                }
            }
        }*/
        ArrayList<Etapa> etaArray = control.traerTodoEtapa();
        if(esFinalizado == true){
                System.out.println("Torneo finalizado");
                for(Etapa etaArr : etaArray){
                    if(etaArr.getIdTorneo().getIdTorneo()==tor.getIdTorneo()){                        
                        if(etaArr.getJerarquia()==0){
                            if(etaArr.getIdParticipante()!=null){
                                JOptionPane.showMessageDialog(null, "GANADOR TORNEO :" + etaArr.getIdParticipante().getUsuario()); 
                            }
                        }
                    }
                }
        }else{
            if(poderEntrar == false){
                JOptionPane.showMessageDialog(null, "NO ES UN TORNEO TUYO");
            }else{
                if(inscripcionVigente == true){
                    VistaTorneoInscripcion vistaTor = new VistaTorneoInscripcion(tor , adm);
                    vistaTor.setVisible(true);
                    this.setVisible(false);
                }else{
                    VistaTorneoVigente vistaTor = new VistaTorneoVigente(tor ,adm);
                    vistaTor.setVisible(true);
                    this.setVisible(false);
                }               
            }
        }


        
       // TODO add your handling code here:
    }//GEN-LAST:event_tablaTorneoMouseClicked

    /**
     * @param args the command line arguments
     */
    public void mostrarTorneo(){
        Torneo tor = new Torneo();
        tor.ListaTorneoAdminsitrador(tablaTorneo ,adm);
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
            java.util.logging.Logger.getLogger(VerTorneosAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerTorneosAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerTorneosAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerTorneosAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerTorneosAdm().setVisible(true);
            }
        });
    }
    private void irAtras(){
        AdministradorHome admHome = new AdministradorHome(adm);
        admHome.setVisible(true);
        admHome.setLocationRelativeTo(null);
        this.setVisible(false);          
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTorneo;
    // End of variables declaration//GEN-END:variables
}
