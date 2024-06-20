/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tinov
 */
@Entity
public class Etapa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEtapa")
    private Integer idEtapa;
    @Basic(optional = false)
    @Column(name = "Jerarquia")
    private int jerarquia;
    @Basic(optional = false)
    @Column(name = "FechaPuesto")
    @Temporal(TemporalType.DATE)
    private Date fechaPuesto;
    @Basic(optional = false)
    @Column(name = "FechaGanador")
    @Temporal(TemporalType.DATE)
    private Date fechaGanador;
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(optional = false)
    private Administrador idAdministrador;
    @JoinColumn(name = "idParticipante", referencedColumnName = "idParticipante")
    @ManyToOne(optional = false)
    private Participante idParticipante;
    @JoinColumn(name = "idTorneo", referencedColumnName = "idTorneo")
    @ManyToOne(optional = false)
    private Torneo idTorneo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtapa")
    private Collection<ParticipanteEtapa> participanteEtapaCollection;

    public Etapa() {
    }

    public Etapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Etapa(Integer idEtapa, int jerarquia, Date fechaPuesto, Date fechaGanador) {
        this.idEtapa = idEtapa;
        this.jerarquia = jerarquia;
        this.fechaPuesto = fechaPuesto;
        this.fechaGanador = fechaGanador;
    }

    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public int getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(int jerarquia) {
        this.jerarquia = jerarquia;
    }

    public Date getFechaPuesto() {
        return fechaPuesto;
    }

    public void setFechaPuesto(Date fechaPuesto) {
        this.fechaPuesto = fechaPuesto;
    }

    public Date getFechaGanador() {
        return fechaGanador;
    }

    public void setFechaGanador(Date fechaGanador) {
        this.fechaGanador = fechaGanador;
    }

    public Administrador getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Administrador idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Participante getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Participante idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Torneo getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneo idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Collection<ParticipanteEtapa> getParticipanteEtapaCollection() {
        return participanteEtapaCollection;
    }

    public void setParticipanteEtapaCollection(Collection<ParticipanteEtapa> participanteEtapaCollection) {
        this.participanteEtapaCollection = participanteEtapaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapa != null ? idEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.idEtapa == null && other.idEtapa != null) || (this.idEtapa != null && !this.idEtapa.equals(other.idEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "seahub.tournament.logica.Etapa[ idEtapa=" + idEtapa + " ]";
    }
    
}
