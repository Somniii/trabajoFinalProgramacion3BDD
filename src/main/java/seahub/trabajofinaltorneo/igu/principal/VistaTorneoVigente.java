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
public class VistaTorneoVigente extends javax.swing.JFrame {

    /**
     * Creates new form VistaTorneoVigente
     */
    private Torneo tor;
    private Administrador adm;
    public VistaTorneoVigente() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public VistaTorneoVigente(Torneo tor, Administrador adm){
        initComponents();
        Controladora control = new Controladora();       
        Torneo torAux = control.traerTorneo(tor.getIdTorneo());
        this.tor = torAux;
        this.adm = adm;
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(685,530);
        this.setTitle("Pasar etapa");        
        String pisoActual = Integer.toString(torAux.getPisos());
        System.out.println("Piso : " + tor.getPisos());
        textPisos.setText(torAux.getPisos()+"");
        String id = Integer.toString(tor.getIdTorneo());
        textId.setText(id);
        mostrarTorneo();        
    }
    public VistaTorneoVigente(Torneo tor, Administrador adm ,boolean crear){
        initComponents();
        Controladora control = new Controladora();       
        Torneo torAux = control.traerTorneo(tor.getIdTorneo());
        this.tor = torAux;
        this.adm = adm;        
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(685,530);
        this.setTitle("Pasar etapa");        
        String pisoActual = Integer.toString(tor.getPisos());
        System.out.println("Piso : " + tor.getPisos());
        textPisos.setText(pisoActual);
        String id = Integer.toString(tor.getIdTorneo());
        textId.setText(id);
        if(crear==true){
            crearEtapasNuevas();
        }else{
            
        }
        mostrarTorneo();        
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
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textPisos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPasar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAtras.setText("irAtras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 287, 80, 40));

        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Estamos en pisos:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 20));

        textPisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPisosActionPerformed(evt);
            }
        });
        jPanel1.add(textPisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("id Torneo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        textId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdActionPerformed(evt);
            }
        });
        jPanel1.add(textId, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Desea pasar a la siguiente etapa?");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("hasta terminar de elegir los ganadores de esa etapa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Al pasar a la siguiente etapa , tiene que elegir los ganadores sucesivamente ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        btnPasar.setText("Pasar de etapa");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPasar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 470, 360));

        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("participantes restantes:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void mostrarTorneo(){
        ParticipanteEtapa parEta = new ParticipanteEtapa();
        parEta.ListaTorneoEtapa(jTable1, tor);
    }
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VerTorneosAdm torAdm = new VerTorneosAdm(adm);
        torAdm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtrasActionPerformed



    public boolean necesitaCrearEtapas(){
        System.out.println("Entra");
        Controladora control = new Controladora();
        boolean bool = false;
        ArrayList<Etapa> etaArr = control.traerTodoEtapa();
        for(Etapa etaAux : etaArr){
            if(etaAux.getIdTorneo().getIdTorneo().equals( tor.getIdTorneo())){
                System.out.println("Entra al if despues del for osea iguala el id del torneo");
                int pisosAnteriores = tor.getPisos()+1;
                //System.out.println("Pisos anteriores:"+pisosAnteriores+"\nPisos actuales:"+pisosAnteriores-1);
                if(etaAux.getJerarquia()==pisosAnteriores){
                    System.out.println("Entra al if de la misma cantidad de pisos");
                    System.out.println("Entra al ultimo if antes del importante");
                    if(etaAux.getIdParticipante()!=null || etaAux.getIdParticipante().getIdParticipante()!=null){
                        bool = true;
                        System.out.println("NECESITA CREAR NUEVAS ETAPAS");
                        System.out.println(etaAux.getIdParticipante());
                        break;
                        
                    }else{
                        bool = false;                       
                    }
                }
            }
        }
        
        return bool;
    }

    public void crearEtapasNuevas(){
        System.out.println("Esta por crear las etapas nuevas");       
        Controladora control = new Controladora();
        ArrayList<Participante> parArray = new ArrayList<>();
        ArrayList<Etapa> etaArr = control.traerTodoEtapa();
        for(Etapa etaAux : etaArr){
            if(etaAux.getIdTorneo().getIdTorneo().equals(tor.getIdTorneo())){
                int pisosAnteriores = tor.getPisos()+1;
                if(etaAux.getJerarquia()==pisosAnteriores){
                    parArray.add(etaAux.getIdParticipante());
                    System.out.println("Participante a poner:"+etaAux.getIdParticipante().getUsuario());
                }
            }
        }
        System.out.println("Cantidad de participantes a poner :" + parArray.size());
        int cantidadPart = parArray.size();
        
        for(int i = 0 ; i < cantidadPart ; i= i+2){
            System.out.println("i:"+i);
            System.out.println("Entra al for");
            Etapa eta = new Etapa(tor.getPisos(),tor,adm);
            try {
                control.crearEtapa(eta);
            } catch (Exception ex) {
                Logger.getLogger(VistaTorneoVigente.class.getName()).log(Level.SEVERE, null, ex);
            }
            ParticipanteEtapa parEta1 = new ParticipanteEtapa(eta,parArray.get(i));
            ParticipanteEtapa parEta2 = new ParticipanteEtapa(eta,parArray.get(i+1));    
            System.out.println("Crea los dos par eta");
            try {
                control.crearParticipanteEtapa(parEta1);
            } catch (Exception ex) {
                Logger.getLogger(VistaTorneoVigente.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                control.crearParticipanteEtapa(parEta2);
            } catch (Exception ex) {
                Logger.getLogger(VistaTorneoVigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void textPisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPisosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPisosActionPerformed

    private void textIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIdActionPerformed
    
    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
            Controladora control = new Controladora();

            // voy a llevar:  los usuarios de esa etapa que estamos viendo
            // podria llevar array de etapas para luego modificarlas una por una 
            // primero :  encontrar etapas con torneo y mismo piso , ponerlas en un arraylist
            // segundo : al encontrar las etapas anotar todos los usuarios de que estan vinculados a ella a un arraylist
            // tercero : pasar los dos arraylist a elegirGanadores
            //VERIFICA QUE NO HAYA FINALIZADO EL TORNEO CON UN GANADOR 
            ArrayList<Etapa> etaArray = control.traerTodoEtapa();
            ArrayList<Etapa> etapaLlevar = new ArrayList<>();
            System.out.println("Torneo vigente? :"+ tor.getVigente());
            if(tor.getVigente()==false){
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
                for(Etapa etaArr : etaArray){
                    if(etaArr.getIdTorneo().getIdTorneo()==tor.getIdTorneo()){
                        if(etaArr.getJerarquia()==tor.getPisos()){
                            etapaLlevar.add(etaArr);
                            System.out.println("ETAPA ID:"+etaArr.getIdEtapa());
                        }
                    }
                }
                ArrayList<Participante> parLlevar = new ArrayList();
                ArrayList<ParticipanteEtapa> parEtaArray = control.traerTodoParticipanteEtapa();
                //ahora busco entre todas las EtapaParticipante si es de la misma etapa anoto los participantes en el arraylist
                for(ParticipanteEtapa parEtaArr : parEtaArray){
                    for(Etapa etaArr : etapaLlevar){
                        if(parEtaArr.getIdEtapa().getIdEtapa().equals(etaArr.getIdEtapa())==true){
                            parLlevar.add(parEtaArr.getIdParticipante());
                            System.out.println("PARTICIPANTE :" +parEtaArr.getIdParticipante().getUsuario());
                        }
                    }
                }
                int cantidadEtapas = etapaLlevar.size();            
                int cantidadParticipantes = parLlevar.size();
                System.out.println("Etapas a llevar :"+cantidadEtapas+"\nParticipantes a llevar:"+cantidadParticipantes);                   
                //YA TENEMOS LOS PARTICIPANTES Y LAS ETAPAS , AHORA LO LLEVAMOS TODO A ELEGIR GANADORES
                //public ElegirGanadores(Torneo tor , Administrador adm , ArrayList<Etapa> etapas , ArrayList<Participante> participantes , int cantidadEtapas , int cantidadParticipantes){
                ElegirGanadores elegirGanador = new ElegirGanadores(tor,adm,etapaLlevar,parLlevar , cantidadEtapas, cantidadEtapas,cantidadParticipantes);
                elegirGanador.setVisible(true);
                this.setVisible(false);
            }            
            
            //AHORA SI EMPIEZA A RECORRER PARA VER 

    }//GEN-LAST:event_btnPasarActionPerformed
    
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
            java.util.logging.Logger.getLogger(VistaTorneoVigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaTorneoVigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaTorneoVigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaTorneoVigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaTorneoVigente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnPasar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textPisos;
    // End of variables declaration//GEN-END:variables
}
/**
        
        //ELEGIR GANADORES DE CADA ETAPA
        //VER SI YA HAY UN GANADOR
        System.out.println("VISTA TORNEO VIGENTE BOTON TOCADO");
        Controladora control = new Controladora();        
        if(tor.getPisos()==0){

            System.out.println("Entra al if de la final 227");            
            ArrayList<Etapa> etaArr = control.traerTodoEtapa();
            Participante ganador = new Participante();        
            //ESTO VE SI YA HAY GANADOR 
            for(Etapa etaAux : etaArr){
                System.out.println("Entra al for 231");
                if(etaAux.getIdTorneo().getIdTorneo().equals(tor.getIdTorneo())==true){
                    System.out.println("Entra al if 234");
                    if(etaAux.getJerarquia()==tor.getPisos()){
                        System.out.println("Entra el if 236");
                        if(etaAux.getIdParticipante()!=null){                            
                            JOptionPane.showMessageDialog(null, "GANADOR TORNEO :" + etaAux.getIdParticipante().getUsuario()); 
                            AdministradorHome admHome = new AdministradorHome(adm);
                            admHome.setVisible(true);
                            this.setVisible(false);
                        }

                    }
                }
            }            
        }    
        ArrayList<Etapa> etaArr = control.traerTodoEtapa(); 
        ArrayList<ParticipanteEtapa> parEtaArr = control.traerTodoParticipanteEtapa();
        int cantidadEtapas = 0;        
        int cantParPorEta = 0;
        ArrayList<Participante> parAux = new ArrayList<>();
        for(Etapa etaAux : etaArr){
            System.out.println("Enrta al for etaAux 185");   
            if(etaAux.getIdTorneo().getIdTorneo().equals(tor.getIdTorneo())==true){
                //Si estamos en el mismo torneo
                System.out.println("Entra al if 186");
                if(etaAux.getJerarquia()==tor.getPisos()){
                    //Si estamos en la misma jerarquia
                    System.out.println("Entra al if 189");
                    cantidadEtapas++;
                    System.out.println("CANTIDAD DE ETAPAS : "+cantidadEtapas);
                    //YA SE QUE HAY UNA ETAPA ACA , SE SUMA EL CONTADOR +1                  
                    //AHORA TENGO QUE IDENTIFICAR CUANTAS ETAPA-PARTICIPANTES HAY CON ESTA ETAPA , SI HAY 1 SE ELIGE A ESA COMO GANADOR DE LA ETAPA 
                    //SI HAY 2 SE PASA A ELEGIR UN GANADOR
                    cantParPorEta = 0;
                    parAux = new ArrayList<>();
                    for(ParticipanteEtapa parEtaAux : parEtaArr){
                        System.out.println("Entra al for 198");
                        if(parEtaAux.getIdEtapa().getIdEtapa().equals(etaAux.getIdEtapa())){
                            System.out.println("Entra al if 199");
                            System.out.println("Cantidad de participantes por etapa: "+cantParPorEta);
                            cantParPorEta++;                            
                            parAux.add(parEtaAux.getIdParticipante());
                        }
                    }
                    System.out.println("Sale for 198 con cantidad Participatnes por etapa :"+cantParPorEta);
                    //SI SOLO HAY UN PARTICIPANTE EN ESA ETAPA SE ELIGE A ESE COMO GANADOR
                    //Aca ya tengo anotado , el piso , el arraylist de participante , la cantidad de participantes por etapa, el torneo 
                    
                    if(cantParPorEta == 1){
                        //Esta parte anda creo
                        System.out.println("Entra if 207");
                        Participante ganador =parAux.get(0);
                        int id = etaAux.getIdEtapa();
                        Etapa eta = control.traerEtapa(id);
                        eta.setIdParticipante(ganador);
                        control.editarEtapa1(eta);
                    }else if(cantParPorEta ==2){                        
                        System.out.println("Entra if 214");
                        //public ElegirGanadores(Torneo tor ,Administrador adm, Participante par1 ,Participante par2 ,Etapa eta){
                        ElegirGanadores elegir = new ElegirGanadores(tor,adm,parAux.get(0),parAux.get(1),etaAux ,this,cantidadEtapas);
                        elegir.setVisible(true);
                        this.setVisible(false);
                    }
                }
            }
        }
        System.out.println("Sale del for 184");
        //SI ESTAMOS EN LA FINAL
        if(tor.getPisos()==0){
            System.out.println("Entra al if de la final 227");            
            etaArr = control.traerTodoEtapa();
            Participante ganador = new Participante();                      
            for(Etapa etaAux : etaArr){
                System.out.println("Entra al for 231");
                if(etaAux.getIdTorneo().getIdTorneo().equals(tor.getIdTorneo())==true){
                    System.out.println("Entra al if 234");
                    if(etaAux.getJerarquia()==tor.getPisos()){
                        System.out.println("Entra el if 236");
                        /*if(etaAux.getIdParticipante()!=null){
                            ArrayList<ParticipanteEtapa> buscarFinalistas = control.traerTodoParticipanteEtapa();
                            ArrayList<Participante> finalistas = new ArrayList<>();
                            for(ParticipanteEtapa parEtaFin : buscarFinalistas){
                                if(parEtaFin.getIdEtapa().getIdEtapa()==etaAux.getIdEtapa()){
                                    finalistas.add(parEtaFin.getIdParticipante());
                                }
                            }
                            ElegirGanadores elegir = new ElegirGanadores(tor, adm , finalistas.get(0), finalistas.get(1), etaAux , 1);
                        }else{*//*
                            //pongo el participante que gano en el arraylist
                            ganador=etaAux.getIdParticipante();
                            JOptionPane.showMessageDialog(null, "GANADOR TORNEO :" + ganador.getUsuario()); 
                        //}

                    }
                }
            }            
        }
        //SI NO ESTAMOS EN LA FINAL
        else{
            System.out.println("Entra al else 246 , NO ERA LA FINAL");
            //Actualizo etaArr con los datos nuevos que puse(LOS GANADORES)
            //Ya que se que la cantidad de etapas a crear va a ser la mitad hago 
            etaArr = control.traerTodoEtapa();
            ArrayList<Participante> parGanadores = new ArrayList<>();
            for(Etapa etaAux : etaArr){
                System.out.println("Entra al for 251");
                if(etaAux.getIdTorneo().getIdTorneo().equals(tor.getIdTorneo())==true){
                    System.out.println("Entra al if 253");
                    if(etaAux.getJerarquia()==tor.getPisos()){
                        System.out.println("Entra al if 256");
                        //pongo el participante que gano en el arraylist
                        parGanadores.add(etaAux.getIdParticipante());
                    }
                }
            }
            double aux = parGanadores.size();
            double cantidadEtapasNuevas = aux/2;
            tor.setPisos(tor.getPisos()-1);
            for(int i = 0 ; i <cantidadEtapasNuevas ; i = i+2){
                System.out.println("Entra al for 265");
                //public Etapa(int jerarquia,Torneo idTorneo,Administrador idAdministrador) {
                Etapa etaNueva = new Etapa(tor.getPisos(),tor,adm);
                try {
                    control.crearEtapa(etaNueva);
                    //public ParticipanteEtapa(Etapa idEtapa, Participante idParticipante)
                } catch (Exception ex) {
                    Logger.getLogger(VistaTorneoVigente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //Ahora tengo que reactualizar el array de etapas con las etaps con el piso mas alto
            etaArr = control.traerTodoEtapa();
            ArrayList<Etapa> etaRelacion = new ArrayList<>();
            for(Etapa etaAux : etaArr){
                System.out.println("Entra al for 279");
                if(etaAux.getIdTorneo().getIdTorneo().equals(tor.getIdTorneo())==true){
                    System.out.println("Entra al if 282");
                    if(etaAux.getJerarquia()==tor.getPisos()){
                        System.out.println("Entra al if 284");
                        //pongo el participante que gano en el arraylist
                        etaRelacion.add(etaAux);
                    }
                }
            }        
            for(int i = 0 ; i <cantidadEtapasNuevas ; i = i+2){
                System.out.println("Entra al for 291");
                ParticipanteEtapa parEtaNueva = new ParticipanteEtapa(etaRelacion.get(i),parGanadores.get(i));
                System.out.println("crea?");
                ParticipanteEtapa parEtaNueva1 = new ParticipanteEtapa(etaRelacion.get(i), parGanadores.get(i+1));
                try {
                    control.crearParticipanteEtapa(parEtaNueva);
                } catch (Exception ex) {
                    Logger.getLogger(VistaTorneoVigente.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    control.crearParticipanteEtapa(parEtaNueva1);
                } catch (Exception ex) {
                    Logger.getLogger(VistaTorneoVigente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("Termina");
        Torneo torAux = control.traerTorneo(tor.getIdTorneo());
        torAux.setPisos(tor.getPisos());
        control.editarTorneo(torAux);
        VistaTorneoVigente vistaTor = new VistaTorneoVigente(torAux,adm);
        vistaTor.setVisible(true);
        this.setVisible(false);                
        //EN BASE A ESTO Y SABIENDO LA CANTIDAD DE ETAPAS , DIVIDIMOS ESTA CANTIDAD POR DOS Y PONEMOS CADA DOS GANADORES DE LAS ETAPAS PASADA EN UNA NUEVA
*/