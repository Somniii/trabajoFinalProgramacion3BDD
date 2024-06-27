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
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import seahub.trabajofinaltorneo.logica.Torneo;

/**
 *
 * @author tinov
 */
public class AceptacionInscripcion extends javax.swing.JFrame {

    /**
     * Creates new form aceptacionInscripcion
     */
    private Torneo tor;
    private Administrador adm;
    public AceptacionInscripcion() {
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 500);
        initComponents();
    }
    public AceptacionInscripcion(Torneo tor, Administrador adm){
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(500, 500);
        initComponents();
        this.tor = tor;
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
        btnCerrar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 41, 41));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setText("Cerrar Inscripcion");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        btnAtras.setText("Volver atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Una vez cerrada la inscripcion no se puede volver atras, estas seguro?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        ArrayList<Participante> arrayPart = crearArrayListParticipante(this.getTor());
        Controladora control = new Controladora();
        int cantidad = tor.cantidadParticipantes();
        JOptionPane.showMessageDialog(null, "CANTIDAD PARTICIPANTES:"+cantidad);
        for(Participante part : arrayPart){
            System.out.println("Id:"+part.getIdParticipante());
        }
        int exponenteDos = -1;
        while(Math.pow(2,exponenteDos)*2<cantidad){
            System.out.println(cantidad+" es mayor que "+Math.pow(2, exponenteDos)*2);
            exponenteDos++;
        }
        
        int exponencialNecesario = (int) Math.pow(2,exponenteDos);
        System.out.println(cantidad+" es menor que "+exponencialNecesario);
        int cantidadEtapas = exponencialNecesario;
        tor.setPisosTotales(exponenteDos);
        System.out.println("Cantidad etapas necesarias:"+cantidadEtapas+" pisos necesarios:"+exponenteDos+" cantidad participantes que pueden entrar:"+exponencialNecesario*2);
        int j = 0;
        for(int i = 0; i<cantidadEtapas ; i++){
            System.out.println("Recorre i:"+ i + " j:" + j);
            Etapa eta = new Etapa(exponenteDos,tor, adm);
            try {
                //MANDAR A BDD
                control.crearEtapa(eta);
            } catch (Exception ex) {
                Logger.getLogger(AceptacionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
            }
            j++;
        }
        int i = 0;
        ArrayList<Etapa> etaArray = control.traerTodoEtapa();
        for(Etapa etaAux : etaArray){       
                    System.out.println("-----------------\nEntra al primer for con i al "+ i);
                    Administrador admAux = etaAux.getIdAdministrador();
                    System.out.println("Entra al for, id etapa:"+etaAux.getIdEtapa());
                    if(i>=cantidadEtapas){
                        break;
                    }
                    System.out.println("Compara:" +admAux.getUsuario() +"con "+adm.getUsuario());
                    if(admAux.getIdAdministrador().equals(adm.getIdAdministrador())==true){
                        System.out.println("ENTRA PRIMER IF");                
                        Torneo torAux = etaAux.getIdTorneo();
                        System.out.println("Compara : "+ torAux.getIdTorneo() + "con "+tor.getIdTorneo());
                        if(torAux.getIdTorneo().equals(tor.getIdTorneo())==true){
                            System.out.println("ENTRA SEGUNDO IF");                    
                            System.out.println("Solo llego a la igualdad de torneo , falta 1");                   
                            int alturaMax = etaAux.getJerarquia();
                            System.out.println("Compara "+ alturaMax +"con" + exponenteDos);
                            if(alturaMax==exponenteDos){
                                System.out.println("Anda todo bien");
                                System.out.println("No sale del for con i al "+ i);
                                if(arrayPart.get(i)!=null){                                    
                                    //Vincular participante con una etapa
                                    System.out.println("index enrta al if:"+i);

                                    ParticipanteEtapa partEta = new ParticipanteEtapa(etaAux, arrayPart.get(i));
                                    try {
                                        control.crearParticipanteEtapa(partEta);
                                    } catch (Exception ex) {
                                        Logger.getLogger(AceptacionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    i++;
                                }else{
                                    break;
                                }                                               
                            }
                        }
                    }   
        }
        System.out.println("Sale del for con i al "+ i);
        if(i==5){
            System.out.println("Sale del for con i al 5");
        }
        if(arrayPart.get(i)==null || i>=cantidad){
            System.out.println("Es nulo");
        }else{
            for(Etapa etaAux : etaArray){  
                    if(i>=cantidad){
                        break;
                    }
                    Administrador admAux = etaAux.getIdAdministrador();
                    System.out.println("Entra al for SEGUNDO");
                    System.out.println("Compara:" +admAux.getUsuario() +"con "+adm.getUsuario());
                    if(admAux.getIdAdministrador().equals(adm.getIdAdministrador())==true){
                        System.out.println("ENTRA PRIMER IF");                
                        Torneo torAux = etaAux.getIdTorneo();
                        System.out.println("Compara : "+ torAux.getIdTorneo() + "con "+tor.getIdTorneo());
                        if(torAux.getIdTorneo().equals(tor.getIdTorneo())==true){
                            System.out.println("ENTRA SEGUNDO IF");                    
                            //System.out.println("Solo llego a la igualdad de torneo , falta 1");  
                            
                            int alturaMax = etaAux.getJerarquia();
                            //System.out.println("SE ROMPE A VER LA ALTURA");
                            System.out.println("Compara "+ alturaMax +"con" + exponenteDos);
                            if(alturaMax==exponenteDos){
                                System.out.println("Anda todo bien");
                                if(arrayPart.get(i)!=null){
                                    //Vincular participante con una etapa
                                    System.out.println("index :"+i);
                                    ParticipanteEtapa partEta = new ParticipanteEtapa(etaAux, arrayPart.get(i));
                                    try {
                                        control.crearParticipanteEtapa(partEta);
                                        System.out.println("Crea el partEta");
                                    } catch (Exception ex) {
                                        System.out.println("Error exception ex");
                                        Logger.getLogger(AceptacionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    i++;
                                }else{
                                    break;
                                }                                               
                            }
                        }
                    }   
            } 
            System.out.println("Sale del segundo FOR");
            Torneo torAux = control.traerTorneo(tor.getIdTorneo());
            torAux.setInscripcionVigente(false);    
            torAux.setPisosTotales(exponenteDos);
            torAux.setPisos(exponenteDos);
            System.out.println("Setea la inscripcionvigente en " + torAux.getInscripcionVigente() + "y pisos en " + torAux.getPisosTotales() + "y piso actual "+ torAux.getPisos() );
            control.editarTorneo(torAux);
            System.out.println("edita el torneo con la nueva inscripcion vigente");
        }
       
        //while(i<arrayPart.size() && arrayPart.get(i)!=null){

        /*while (i < arrayPart.size() && arrayPart.get(i) != null) {
            System.out.println("Entra, participante:" + arrayPart.get(i).getNombre());
            i++;
        }*/
        System.out.println("Total participantes :" + i);
        System.out.println("POR FIN SALIR DEL CODIGO");
        VistaTorneoVigente vistaTorVig = new VistaTorneoVigente(tor,adm);
        vistaTorVig.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed
    /*private void enviarParticipanteEtapa(Etapa eta,Participante part){
        
    }*/
    /*        for(Participante auxPart : arrayPart){
            if(auxPart==null){
                break;
            }else{
                for(Etapa etaAux : etaArray){       
                    Administrador admAux = etaAux.getIdAdministrador();
                    System.out.println("Entra al for");
                    System.out.println("Compara:" +admAux.getUsuario() +"con "+adm.getUsuario());
                    if(admAux.getIdAdministrador().equals(adm.getIdAdministrador())==true){
                        System.out.println("ENTRA PRIMER IF");                
                        Torneo torAux = etaAux.getIdTorneo();
                        System.out.println("Compara : "+ torAux.getIdTorneo() + "con "+tor.getIdTorneo());
                        if(torAux.getIdTorneo().equals(tor.getIdTorneo())==true){
                            System.out.println("ENTRA SEGUNDO IF");                    
                            System.out.println("Solo llego a la igualdad de torneo , falta 1");                   
                            int alturaMax = etaAux.getJerarquia();
                            System.out.println("Compara "+ alturaMax +"con" + exponenteDos);
                            if(alturaMax==exponenteDos){
                                System.out.println("Anda todo bien");
                                if(auxPart!=null){
                                    //Vincular participante con una etapa
                                    System.out.println("index :"+i);
                                    ParticipanteEtapa partEta = new ParticipanteEtapa(etaAux, auxPart);
                                    i++;
                                }else{
                                    break;
                                }                                               
                            }
                        }
                    }
                }
            //}
        }

        //}
        }*/
    
    
    private ArrayList<Participante> crearArrayListParticipante(Torneo tor) {
        ArrayList<Participante> aMandar = new ArrayList<>(); // Inicializar correctamente el ArrayList

        Controladora control = new Controladora();
        ArrayList<ParticipanteTorneo> parTorArr = control.traerTodoParticipanteTorneo();

        for (ParticipanteTorneo parTorAux : parTorArr) {
            Torneo torAux = parTorAux.getIdTorneo(); // No necesitas reasignar torAux aquí si no es necesario
            if (torAux.getIdTorneo().equals(tor.getIdTorneo())) {
                // Agregar el participante correspondiente a aMandar
                aMandar.add(parTorAux.getIdParticipante());
            }
        }

   
    return aMandar;
    }
    
    private void auxiliarTorneo(){
                //PRIMERO poner todos los participantes inscriptos al torneo en un ArrayList
        ArrayList<Participante> arrayPart = crearArrayListParticipante(this.getTor());        
        Controladora control = new Controladora();
        //LUEGO contar cantidad de usuarios que tengo
        int cantidad = tor.cantidadParticipantes();
        //EN BASE a la cantidad de usuarios que tengo empezar a ver que potencia de dos es la minima para que entren todos los usuarios
        int cantidadPisos = -2;
        while((Math.pow(2,cantidadPisos)/2)<cantidad){
            System.out.println("Cantidad pisos:"+ (Math.pow(2,cantidadPisos)) +" es menos que :"+cantidad);
            cantidadPisos++;
        }
        System.out.println("Cantidad pisos:"+cantidadPisos);
        //EJ si tengo 15 participantes necesito 2^4 
        //Ahora ya tengo la cantidad de etapas necesarias para el torneo
        int totalEtapas = (int) (Math.pow(2,cantidadPisos))/2;
        JOptionPane.showMessageDialog(null, "CANTIDAD PISOS:"+cantidadPisos+"Total etapas"+totalEtapas);
        System.out.println("Total etapas : " + totalEtapas);
        //Vamos a crear la misma cantidad de participantes que partEtas
        //(si solo hay un partEta y no dos , automaticamente se le pasa a la siguiente ronda)
        int cantidadPuestos = 0;
        for(int i = 0;i < totalEtapas ;i++){
            cantidadPuestos++;
            //Tengo que crear una etapa
            Participante part = arrayPart.get(i);
            Etapa eta = new Etapa(cantidadPisos,tor, adm);
            try {
                control.crearEtapa(eta);
            } catch (Exception ex) {
                Logger.getLogger(AceptacionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Como relaciono dos participantes en la misma etapa
            //Como creo dos partEta que tengan la misma etapa?
            ParticipanteEtapa partEta = new ParticipanteEtapa(eta, part);            
            try {
                control.crearParticipanteEtapa(partEta);
            } catch (Exception ex) {
                Logger.getLogger(AceptacionInscripcion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ArrayList<Etapa> etapasTotales = control.traerTodoEtapa();
        System.out.println("Cantidad puestos"+ cantidadPuestos);
        //Etapa para comprobar con aux
        Etapa etaAux = new Etapa();
        for(Etapa aux : etapasTotales){        
            if(arrayPart.get(cantidadPuestos+1) != null){
               cantidadPuestos++;
               etaAux = aux;
               if(etaAux.getIdAdministrador().equals(adm)==true){
                   if(etaAux.getIdTorneo().equals(tor)==true){
                       System.out.println("Entra segundo if");
                       //DUDA CON EL ULTIMO IF , NO SE SI ESTA BIEN ISNTANCIADO
                       if(etaAux.getJerarquia() == cantidadPisos){
                            ParticipanteEtapa partEta = new ParticipanteEtapa(aux,arrayPart.get(cantidadPuestos));
                            System.out.println("Cantidad puestos"+ cantidadPuestos);
                       }
                   }
               }
               else{
                   System.out.println("Array participantes es null");
               }
            }else{
                break;
            }
        } 
    }
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VistaTorneoInscripcion vistaInscripcion = new VistaTorneoInscripcion(tor,adm);
        vistaInscripcion.setVisible(true);
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
            java.util.logging.Logger.getLogger(AceptacionInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AceptacionInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AceptacionInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AceptacionInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AceptacionInscripcion().setVisible(true);
            }
        });
    }

    public Torneo getTor() {
        return tor;
    }

    public void setTor(Torneo tor) {
        this.tor = tor;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
