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
      
}
