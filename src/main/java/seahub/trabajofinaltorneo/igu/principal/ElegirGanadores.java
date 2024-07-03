/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seahub.trabajofinaltorneo.igu.principal;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Controladora;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import seahub.trabajofinaltorneo.logica.Torneo;

/**
 *
 * @author tinov
 */
public class ElegirGanadores extends javax.swing.JFrame {

    /**
     * Creates new form ElegirGanadores
     */
    private Torneo tor;
    private Administrador adm;
    private Participante ganador = new Participante();
    private Participante part1 = new Participante();
    private Participante part2 = new Participante();
    private ArrayList<Etapa> etapas;
    private ArrayList<Participante> participantes;
    private int etapaActual;
    private int cantidadParticipantes;
    private int totalEtapas;
    
    public ElegirGanadores() {
        initComponents();
    }
    
    public ElegirGanadores(Torneo tor , Administrador adm , ArrayList<Etapa> etapas , ArrayList<Participante> participantes ,int etapaActual, int totalEtapas , int cantidadParticipantes){
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 500);
        this.setTitle("");
        setVisible(true);
        this.tor = tor;
        this.adm = adm;       
        this.etapas = etapas;
        this.participantes = participantes;
        this.etapaActual = etapaActual;
        this.totalEtapas = totalEtapas;
        this.cantidadParticipantes = cantidadParticipantes;
        
        String pisos = Integer.toString(tor.getPisos());
        piso.setText(pisos);
        String numeroEtapa = Integer.toString(etapaActual);
        String totalEtapa = Integer.toString(totalEtapas);
        etapa.setText(numeroEtapa);
        total.setText(totalEtapa);
        actual();
        System.out.println("ETAPA ACTUAL :"+ etapaActual);
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
        btnPar1 = new javax.swing.JButton();
        btnPar2 = new javax.swing.JButton();
        nombrePar1 = new javax.swing.JTextField();
        nombrePar2 = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        participanteGanador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        piso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        etapa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        FotoRival2 = new javax.swing.JLabel();
        FotoRival1 = new javax.swing.JLabel();
        FotoGanador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 41, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(241, 241, 241));
        jLabel1.setForeground(new java.awt.Color(241, 241, 241));
        jLabel1.setText("VS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        btnPar1.setText("Gano");
        btnPar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        btnPar2.setText("Gano");
        btnPar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnPar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        nombrePar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrePar1ActionPerformed(evt);
            }
        });
        jPanel1.add(nombrePar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, -1));
        jPanel1.add(nombrePar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 130, 20));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Participante Ganador:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        participanteGanador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participanteGanadorActionPerformed(evt);
            }
        });
        jPanel1.add(participanteGanador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, -1));

        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Piso:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        piso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pisoActionPerformed(evt);
            }
        });
        jPanel1.add(piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 30, -1));

        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Etapa:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));
        jPanel1.add(etapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 30, -1));

        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("De");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 30, -1));

        FotoRival2.setText("           Foto");
        FotoRival2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(FotoRival2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 90, 90));

        FotoRival1.setText("          Foto");
        FotoRival1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(FotoRival1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, 90));

        FotoGanador.setText("          Foto");
        FotoGanador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jPanel1.add(FotoGanador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 90, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void actual(){
        System.out.println("Entra a actual");
        Controladora control = new Controladora();
        if(tor.getPisos() == 0){
            part1 = participantes.get(0);
            part2 = participantes.get(1);
            this.part1 = part1;
            this.part2 = part2;
            nombrePar1.setText(part1.getNombre());
            nombrePar2.setText(part2.getNombre());
        }else{
            ArrayList<ParticipanteEtapa> parEtaArray = control.traerTodoParticipanteEtapa();
            int cantidadParticipantesEtapa = 0;
            System.out.println("Entra al else");
            for(ParticipanteEtapa parEtaArr : parEtaArray){
                //System.out.println("Entra al for");
                //Encontramos la etapa
                if(parEtaArr.getIdEtapa().getIdEtapa().equals(etapas.get(etapaActual-1).getIdEtapa())){
                    System.out.println("Entra al primer if");
                    for(Participante parAux : participantes){
                        System.out.println("Busca a los participantes en el arrayList");
                        if(parEtaArr.getIdParticipante().getIdParticipante().equals(parAux.getIdParticipante())){
                            System.out.println("Encontro participante con mismo id");
                            if(cantidadParticipantesEtapa==0){
                                this.part1 = parAux;
                            }else{
                                this.part2 = parAux;                                
                            }
                            cantidadParticipantesEtapa++;
                            System.out.println("Cantidad Participantes Etapa :"+cantidadParticipantesEtapa++);
                                
                        }
                    }
                }
                System.out.println("Sale del for");
            }
            if(part2.getIdParticipante()==null){
                ganador = part1;
                participanteGanador.setText(ganador.getUsuario());
                CargarFoto(part1,FotoGanador);
            }
            CargarFoto(part1, FotoRival1);
            CargarFoto(part2, FotoRival2);
            nombrePar1.setText(part1.getNombre());
            nombrePar2.setText(part2.getNombre());
        }
    }
    
    private void participanteGanadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participanteGanadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participanteGanadorActionPerformed

    private void pisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pisoActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Controladora control = new Controladora();
        if(ganador==new Participante() ||ganador.getIdParticipante()==null){
            JOptionPane.showMessageDialog(null, "NO SELECCIONASTE UN GANADOR!");            
        }else{
            //SI ESTAMOS EN EL ULTIMO PISO
            if(tor.getPisos() == 0 ){ 
                System.out.println("ENTRA A GANADOR X VECES");
                System.out.println("GANADOR nombre : "+ganador);
                System.out.println("Entra a elegir ganador");
                Etapa etaAux = control.traerEtapa(etapas.get(0).getIdEtapa());
                System.out.println("Etapa ID:"+etaAux.getIdEtapa());
                etaAux.setFechaGanador(new Date());
                etaAux.setIdParticipante(ganador);
                control.editarEtapa1(etaAux);
                Torneo torAux = control.traerTorneo(tor.getIdTorneo());
                torAux.setVigente(false);
                control.editarTorneo(torAux);
                VerTorneosAdm vistaTor = new VerTorneosAdm(adm);
                vistaTor.setVisible(true);
                this.setVisible(false);                
            }else{//SI NO ESTAMOS EN EL ULTIMO PISO
                Etapa etaAux = control.traerEtapa(etapas.get(etapaActual-1).getIdEtapa());
                System.out.println("TRAJO LA ETAPA ");
                System.out.println("Etapa ID:"+etaAux.getIdEtapa());
                System.out.println("PARA EL GANADOR: "+ganador);
                etaAux.setFechaGanador(new Date());
                etaAux.setIdParticipante(ganador);
                control.editarEtapa1(etaAux);
                Torneo torAux = control.traerTorneo(tor.getIdTorneo());
                if(etapaActual==0){
                    torAux.setPisos(torAux.getPisos()-1);
                    control.editarTorneo(torAux);
                    VistaTorneoVigente vistaTor = new VistaTorneoVigente(tor,adm);
                    vistaTor.setVisible(true);
                    this.setVisible(false);  
                }else{
                    etapaActual--;      
                    if(etapaActual==0){
                        System.out.println("Etapa actual es 0");
                        torAux.setPisos(torAux.getPisos()-1);
                        control.editarTorneo(torAux);
                        VistaTorneoVigente vistaTor = new VistaTorneoVigente(tor,adm ,true);
                        vistaTor.setVisible(true);
                        this.setVisible(false);
                    }else{
                        ElegirGanadores elegirGanador = new ElegirGanadores(tor, adm ,etapas,participantes,etapaActual,totalEtapas,cantidadParticipantes);
                        elegirGanador.setVisible(true);
                        this.setVisible(false);
                        //ACA ENVIO DE NUEVO RECURSIVAMENTE
                        //public ElegirGanadores(Torneo tor , Administrador adm , ArrayList<Etapa> etapas , ArrayList<Participante> participantes ,int etapaActual, int totalEtapas , int cantidadParticipantes)s
                    }


                }
   
            }                
            
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed
/*
        public void CargarFoto1(Participante par){
        if(par.getFoto()!= null){
            if (!par.getFoto().equals(null)){
                FotoRival1.setIcon(new ImageIcon(new ImageIcon(par.getFoto()).getImage().getScaledInstance(FotoRival1.getWidth(), FotoRival1.getHeight(), Image.SCALE_DEFAULT)));
            }else{
                FotoRival1.setIcon(null);
            }
        }
    }
  */      
    public void CargarFoto(Participante par, JLabel label) {
    if (par.getFoto() != null) {
        ImageIcon icon = new ImageIcon(par.getFoto());
        Image scaledImage = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT);
        label.setIcon(new ImageIcon(scaledImage));
    } else {
        label.setIcon(null);
    }
}

    
    private void btnPar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPar1ActionPerformed
        ganador = part1;
        participanteGanador.setText(ganador.getNombre());
        CargarFoto(part1, FotoGanador);
    }//GEN-LAST:event_btnPar1ActionPerformed

    private void btnPar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPar2ActionPerformed
        ganador = part2;
        participanteGanador.setText(ganador.getNombre());
    }//GEN-LAST:event_btnPar2ActionPerformed

    private void nombrePar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrePar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrePar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ElegirGanadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirGanadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirGanadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirGanadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElegirGanadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FotoGanador;
    private javax.swing.JLabel FotoRival1;
    private javax.swing.JLabel FotoRival2;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnPar1;
    private javax.swing.JButton btnPar2;
    private javax.swing.JTextField etapa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombrePar1;
    private javax.swing.JTextField nombrePar2;
    private javax.swing.JTextField participanteGanador;
    private javax.swing.JTextField piso;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
