/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seahub.trabajofinaltorneo.igu.principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Controladora;
import seahub.trabajofinaltorneo.logica.Participante;

/**
 *
 * @author tinov
 */
public class Login extends javax.swing.JFrame {
    private Controladora control = new Controladora();
    Participante parti = new Participante();
    public Login() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setVisible(true);
        this.setTitle("Login");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnLog = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserAdm = new javax.swing.JTextField();
        txtClaveAdm = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btnLogAdm = new javax.swing.JButton();
        btnRegisterAdm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(260, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(260, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 90, 30));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 170, 30));

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 240, 30));

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel1.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 240, 30));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese su clave");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        btnLog.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLog.setText("Ingresar");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });
        jPanel1.add(btnLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, 40));

        btnRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegister.setText("Registrarse");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 110, 40));

        jTabbedPane1.addTab("Participante", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(260, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(260, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ingrese Usuario de Administrador");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 280, 30));

        txtUserAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserAdmActionPerformed(evt);
            }
        });
        jPanel2.add(txtUserAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 240, 30));
        jPanel2.add(txtClaveAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 30));

        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingrese su clave");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        btnLogAdm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogAdm.setText("Ingresar");
        btnLogAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogAdmActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 100, 40));

        btnRegisterAdm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegisterAdm.setText("Registrarse");
        btnRegisterAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterAdmActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegisterAdm, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 110, 40));

        jTabbedPane1.addTab("Administrador", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        /*if(txtUser.getText().equals("") || txtClave.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Los Campos estan Vacios");
        }else{
            boolean valor = parti.login(txtUser.getText(), txtClave.getText());
            if(valor==true){
                JOptionPane.showMessageDialog(null, "Se conecto");
                HomeParticipante participante = new HomeParticipante();
                participante.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Error de Usuario o Contraseña");
            }
        }*/
        String usuario = txtUser.getText();
          String pass = "";
          char [] password = txtClave.getPassword();
          for(int x = 0 ; x<password.length ; x++){
          pass += password[x];
                  
          }
          //Hay un problema en contrasena , da numeros raros
        
          //System.out.println("TENEMOS USUARIO :"+usuario+"\nPASSWORD :"+pass);
          int idAuxiliar;
          ArrayList<Participante> participanteAux = control.traerTodoParticipante();
          boolean usuarioEncontrado = false;
          boolean passwordIgual = false;
          Participante par = new Participante();
          //System.out.println("Apunto de entrar en el for");
          for(Participante aux : participanteAux){
              //System.out.println("Entra en el for");
              //System.out.println("COMPARA: "+ aux.getUsuario() + "CON "+usuario); 
              String usuarioTraido = aux.getUsuario();
              //System.out.println("Usuario traido :"+usuarioTraido);
              if(usuarioTraido.compareTo(usuario)==0){
                  //System.out.println("Es igual");
                  usuarioEncontrado = true;
                  if(aux.getContrasena().compareTo(pass)==0){
                    par = aux;
                    passwordIgual = true;
                  }
              }else{
                  //System.out.println("No es igual");
              }
          }
          if(usuarioEncontrado == false){
                JOptionPane.showMessageDialog(null, "NO EXISTE ESE USUARIO");
                  //System.out.println("NO se encontro el usuario");             
                Login login = new Login();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
        this.setVisible(false);   
          }else{
              if(passwordIgual == false){
                    JOptionPane.showMessageDialog(null, "PASSWORD INCORRECTA");
                    Login login = new Login();
                    login.setVisible(true);
                    login.setLocationRelativeTo(null);
                    this.setVisible(false);   
              }else{
                  HomeParticipante nuevoHome = new HomeParticipante(par);
                  nuevoHome.setVisible(true);
                  nuevoHome.setLocationRelativeTo(null);
                  this.setVisible(false);
              }
          }
       
    }//GEN-LAST:event_btnLogActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        Register registro = new Register();
        this.setVisible(false);
        registro.setVisible(true);
        registro.setLocationRelativeTo(null);        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtUserAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserAdmActionPerformed

    private void btnLogAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogAdmActionPerformed
          String usuario = txtUserAdm.getText();
          String pass = "";
          char [] password = txtClaveAdm.getPassword();
          for(int x = 0 ; x<password.length ; x++){
          pass += password[x];
                  
          }
          //Hay un problema en contrasena , da numeros raros
        
          //System.out.println("TENEMOS USUARIO :"+usuario+"\nPASSWORD :"+pass);
          ArrayList<Administrador> admAux = control.traerTodoAdministrador();
          boolean usuarioEncontrado = false;
          boolean passwordIgual = false;
          //System.out.println("Apunto de entrar en el for");
          Administrador admEnviar = new Administrador();
          for(Administrador aux : admAux){
              //System.out.println("Entra en el for");
              //System.out.println("COMPARA: "+ aux.getUsuario() + "CON "+usuario); 
              String usuarioTraido = aux.getUsuario();
              //System.out.println("Usuario traido :"+usuarioTraido);
              if(usuarioTraido.compareTo(usuario)==0){
                  //System.out.println("Es igual");
                  usuarioEncontrado = true;
                  if(aux.getContrasena().compareTo(pass)==0){
                    passwordIgual = true;
                    admEnviar = aux;
                  }
              }else{
                  //System.out.println("No es igual");
              }
          }
          if(usuarioEncontrado == false){
                JOptionPane.showMessageDialog(null, "NO EXISTE ESE USUARIO");
                  //System.out.println("NO se encontro el usuario");             
                Login login = new Login();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
        this.setVisible(false);   
          }else{
              if(passwordIgual == false){
                  JOptionPane.showMessageDialog(null, "PASSWORD INCORRECTA");
                    Login login = new Login();
                    login.setVisible(true);
                    login.setLocationRelativeTo(null);
                    this.setVisible(false);   
              }else{
                  AdministradorHome nuevoHome = new AdministradorHome(admEnviar);
                  nuevoHome.setVisible(true);
                  nuevoHome.setLocationRelativeTo(null);
                  this.setVisible(false);
              }
          }
               // TODO add your handling code here:
    }//GEN-LAST:event_btnLogAdmActionPerformed

    private void btnRegisterAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterAdmActionPerformed
        Register registro = new Register();
        this.setVisible(false);
        registro.setVisible(true);
        registro.setLocationRelativeTo(null);   
    }//GEN-LAST:event_btnRegisterAdmActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnLogAdm;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegisterAdm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtClaveAdm;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtUserAdm;
    // End of variables declaration//GEN-END:variables
}
