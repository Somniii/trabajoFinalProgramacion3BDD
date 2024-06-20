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
public class ParticipanteAdministrador {
   
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idP_A")
    private Integer idPA;
    @JoinColumn(name = "idParticipante", referencedColumnName = "idParticipante")
    @ManyToOne(optional = false)
    private Participante idParticipante;
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(optional = false)
    private Administrador idAdministrador;

    public ParticipanteAdministrador() {
    }

    public ParticipanteAdministrador(Integer idPA) {
        this.idPA = idPA;
    }

    public Integer getIdPA() {
        return idPA;
    }

    public void setIdPA(Integer idPA) {
        this.idPA = idPA;
    }

    public Participante getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Participante idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Administrador getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Administrador idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPA != null ? idPA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipanteAdministrador)) {
            return false;
        }
        ParticipanteAdministrador other = (ParticipanteAdministrador) object;
        if ((this.idPA == null && other.idPA != null) || (this.idPA != null && !this.idPA.equals(other.idPA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seahub.tournament.logica.ParticipanteAdministrador[ idPA=" + idPA + " ]";
    }
    
}
