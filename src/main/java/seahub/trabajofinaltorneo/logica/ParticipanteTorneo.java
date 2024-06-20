/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author tinov
 */
@Entity
public class ParticipanteTorneo {
 
    private static final long serialVersionUID = 1L;
    @Id
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

    @Override
    public String toString() {
        return "seahub.tournament.logica.ParticipanteTorneo[ idPT=" + idPT + " ]";
    }
       
}
