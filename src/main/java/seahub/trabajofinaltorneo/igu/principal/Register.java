/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seahub.trabajofinaltorneo.igu.principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import seahub.trabajofinaltorneo.logica.Participante;
        import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Controladora;

/**
 *
 * @author tinov
 */
public class Register extends javax.swing.JFrame {

  private Controladora control = new Controladora();
  
    public Register() {
        initComponents();
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
        tableAdm = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        panelAdm4 = new javax.swing.JLabel();
        panelAdm5 = new javax.swing.JLabel();
        panelAdm6 = new javax.swing.JLabel();
        panelAdm7 = new javax.swing.JLabel();
        txtNombreAdm = new javax.swing.JTextField();
        txtUserAdm = new javax.swing.JTextField();
        PasswordAdm = new javax.swing.JPasswordField();
        panelAdm8 = new javax.swing.JLabel();
        PasswordClaveAdm = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        panelUser = new javax.swing.JPanel();
        panelAdm = new javax.swing.JLabel();
        panelAdm1 = new javax.swing.JLabel();
        panelAdm2 = new javax.swing.JLabel();
        panelAdm3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        PasswordClave = new javax.swing.JPasswordField();
        btnRegisterUser = new javax.swing.JButton();
        panelAdm9 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableAdm.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAdm4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm4.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm4.setText("Ingrese Clave");
        jPanel3.add(panelAdm4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 150, 30));

        panelAdm5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm5.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm5.setText("Registro");
        jPanel3.add(panelAdm5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        panelAdm6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm6.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm6.setText("Ingrese Clave Adm");
        jPanel3.add(panelAdm6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 170, 30));

        panelAdm7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm7.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm7.setText("Ingrese User");
        jPanel3.add(panelAdm7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 150, 30));

        txtNombreAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAdmActionPerformed(evt);
            }
        });
        jPanel3.add(txtNombreAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 180, 30));
        jPanel3.add(txtUserAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 180, 30));
        jPanel3.add(PasswordAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 180, 30));

        panelAdm8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm8.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm8.setText("Ingrese Nombre");
        jPanel3.add(panelAdm8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 150, 30));
        jPanel3.add(PasswordClaveAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 180, 30));

        btnRegister.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegister.setText("Registrarse");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 160, 40));

        tableAdm.addTab("Admin", jPanel3);

        panelUser.setBackground(new java.awt.Color(51, 51, 51));
        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAdm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm.setText("Ingrese Clave");
        panelUser.add(panelAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 150, 30));

        panelAdm1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm1.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm1.setText("Registro");
        panelUser.add(panelAdm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 29, 120, 30));

        panelAdm2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm2.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm2.setText("Ingrese Nombre");
        panelUser.add(panelAdm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 150, 30));

        panelAdm3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm3.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm3.setText("Ingrese Email");
        panelUser.add(panelAdm3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 150, 30));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelUser.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 180, 30));
        panelUser.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 180, 30));
        panelUser.add(PasswordClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 180, 30));

        btnRegisterUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegisterUser.setText("Register");
        btnRegisterUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterUserActionPerformed(evt);
            }
        });
        panelUser.add(btnRegisterUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 130, 40));

        panelAdm9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelAdm9.setForeground(new java.awt.Color(255, 255, 255));
        panelAdm9.setText("Ingrese User");
        panelUser.add(panelAdm9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 150, 30));
        panelUser.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 180, 30));

        btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        panelUser.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 130, 40));

        tableAdm.addTab("User", panelUser);

        jPanel1.add(tableAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAdmActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
       
        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRegisterUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterUserActionPerformed
       String nombre = txtNombre.getText();
       String user = txtUser.getText();
       String email = txtEmail.getText();
       String pass = "asd";   
       char [] password = PasswordClave.getPassword();
       for(int x = 0 ; x<password.length ; x++){
           pass += password[x];
       }
       //JOptionPane.showMessageDialog(null,pass);
       Participante part = new Participante(nombre,user,pass,email);
       System.out.println("Entra");
       System.out.println(part.toString());
       Controladora controlll = new Controladora();
        try {
          controlll.crearParticipante(part);
      } catch (Exception ex) {
          System.out.println("Entra en exception");
          Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_btnRegisterUserActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordAdm;
    private javax.swing.JPasswordField PasswordClave;
    private javax.swing.JPasswordField PasswordClaveAdm;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegisterUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel panelAdm;
    private javax.swing.JLabel panelAdm1;
    private javax.swing.JLabel panelAdm2;
    private javax.swing.JLabel panelAdm3;
    private javax.swing.JLabel panelAdm4;
    private javax.swing.JLabel panelAdm5;
    private javax.swing.JLabel panelAdm6;
    private javax.swing.JLabel panelAdm7;
    private javax.swing.JLabel panelAdm8;
    private javax.swing.JLabel panelAdm9;
    private javax.swing.JPanel panelUser;
    private javax.swing.JTabbedPane tableAdm;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreAdm;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtUserAdm;
    // End of variables declaration//GEN-END:variables
}
