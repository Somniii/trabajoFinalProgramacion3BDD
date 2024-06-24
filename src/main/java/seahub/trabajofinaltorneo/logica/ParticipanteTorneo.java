/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tinov
 */
@Entity
public class ParticipanteTorneo implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @Column(name = "idP_T")
    private Integer idPT;
    @JoinColumn(name = "idTorneo", referencedColumnName = "idTorneo")
    @ManyToOne(optional = false)
    private Torneo idTorneo;
    @JoinColumn(name = "idParticipante", referencedColumnName = "idParticipante")
    @ManyToOne(optional = false)
    private Participante idParticipante;

    public ParticipanteTorneo() {
    }

    public ParticipanteTorneo(Integer idPT) {
        this.idPT = idPT;
    }
    public ParticipanteTorneo(Torneo tor , Participante par){
        this.idTorneo=tor;
        this.idParticipante=par;
    }

    public Integer getIdPT() {
        return idPT;
    }

    public void setIdPT(Integer idPT) {
        this.idPT = idPT;
    }

    public Torneo getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneo idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Participante getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Participante idParticipante) {
        this.idParticipante = idParticipante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPT != null ? idPT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipanteTorneo)) {
            return false;
        }
        ParticipanteTorneo other = (ParticipanteTorneo) object;
        if ((this.idPT == null && other.idPT != null) || (this.idPT != null && !this.idPT.equals(other.idPT))) {
            return false;
        }
        return true;
    }
    public void participanteTablaTorneo(JTable tabla , Torneo tor){
    DefaultTableModel model;
    String[] titulo = {"idParticipante", "Email","Nombre","Usuario"};
    model = new DefaultTableModel(null, titulo);

    try {
        Controladora control = new Controladora();
        List<ParticipanteTorneo> datos = control.traerTodoParticipanteTorneo();
        
        if (datos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY DATOS " );
            
            //System.out.println("La lista de torneos está vacía.");
        } else {
            //System.out.println("La lista de torneos contiene datos.");
            Torneo torneo = new Torneo();
            Participante parAux = new Participante();
            for (ParticipanteTorneo parTor : datos) {
                //System.out.println("Torneo NOMBRE ADM: " + trn.getIdAdministrador().getNombre() + ", Nombre ADM: " + adm.getNombre());
                torneo = parTor.getIdTorneo();
                if(torneo.getIdTorneo().equals(tor.getIdTorneo())==true){
                    //System.out.println("Torneo NOMBRE ADM: " + trn.getIdAdministrador().getNombre() + ", Nombre ADM: " + adm.getNombre());
                    parAux = parTor.getIdParticipante();
                    Object[] rowData = {
                        parAux.getIdParticipante(),
                        parAux.getEmail(),                
                        parAux.getNombre(),
                        parAux.getUsuario(),                    
                        };
                         //Que es addRow(rowData)
                         model.addRow(rowData);
                }

            }
        }

        tabla.setModel(model);
    } catch (Exception ex) {
        ex.printStackTrace(); // Imprime la traza de la excepción para depuración
        JOptionPane.showMessageDialog(null, "Error al cargar datos de torneos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    /*public int totalTorneos(Torneo tor){
        Controladora control = new Controladora();
        ArrayList<ParticipanteTorneo> parTor = control.traerTodoParticipanteTorneo();
        int contador;
        Torneo torAux = new Torneo();
        for(ParticipanteTorneo parTorAux : parTor){
            torAux = parTorAux.idTorneo;
            if(torAux.equals(tor)==true){
                contador++
            }
        }
        return contador;
    }*/
    @Override
    public String toString() {
        return "seahub.tournament.logica.ParticipanteTorneo[ idPT=" + idPT + " ]";
    }
       
}
