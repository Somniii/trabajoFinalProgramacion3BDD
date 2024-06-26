/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author tinov
 */
@Entity
public class ParticipanteEtapa implements Serializable {
  
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @Column(name = "idP_E")
    private Integer idPE;
    @JoinColumn(name = "idEtapa", referencedColumnName = "idEtapa")
    @ManyToOne(optional = false)
    private Etapa idEtapa;
    @JoinColumn(name = "idParticipante", referencedColumnName = "idParticipante")
    @ManyToOne(optional = false)
    private Participante idParticipante;

    public ParticipanteEtapa() {
    }
    public ParticipanteEtapa(Etapa idEtapa, Participante idParticipante){
        this.idEtapa = idEtapa;
        this.idParticipante = idParticipante;
    }
    public ParticipanteEtapa(Integer idPE) {
        this.idPE = idPE;
    }

    public Integer getIdPE() {
        return idPE;
    }

    public void setIdPE(Integer idPE) {
        this.idPE = idPE;
    }

    public Etapa getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Etapa idEtapa) {
        this.idEtapa = idEtapa;
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
        hash += (idPE != null ? idPE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipanteEtapa)) {
            return false;
        }
        ParticipanteEtapa other = (ParticipanteEtapa) object;
        if ((this.idPE == null && other.idPE != null) || (this.idPE != null && !this.idPE.equals(other.idPE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seahub.tournament.logica.ParticipanteEtapa[ idPE=" + idPE + " ]";
    }
         //Definis la table
    DefaultTableModel model;
    String[] titulo = {"idTorneo", "nombre","vigente","inscripcionVigente","pisosTotales"};
    model = new DefaultTableModel(null, titulo);

    try {
        Controladora control = new Controladora();
        List<Torneo> datos = control.traerTodoTorneo();
        
        if (datos.isEmpty()) {
            System.out.println("La lista de torneos está vacía.");
        } else {
            System.out.println("La lista de torneos contiene datos.");
            for (Torneo trn : datos) {
                System.out.println("Torneo ID: " + trn.getIdTorneo() + ", Nombre: " + trn.getNombre());
                Object[] rowData = {
                    trn.getIdTorneo(),
                    trn.getNombre(),
                    trn.getInscripcionVigente(),
                    trn.getVigente(),
                    trn.getPisosTotales(),
                };
                //Que es addRow(rowData)
                model.addRow(rowData);
            }
        }

        tabla.setModel(model);
    } catch (Exception ex) {
        ex.printStackTrace(); // Imprime la traza de la excepción para depuración
        JOptionPane.showMessageDialog(null, "Error al cargar datos de torneos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
      
}
