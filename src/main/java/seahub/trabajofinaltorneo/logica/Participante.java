/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author tinov
 */
@Entity
public class Participante implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // o IDENTITY para JPA 2.1+ FUNCINOA AUTO Y TABLE , TABLE TE LOS PONE EN ORDEN
    @Basic(optional = false)
    @Column(name = "idParticipante")
    private Integer idParticipante;
    @Basic(optional = false)
    @Lob
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @Lob
    @Column(name = "Contrasena")
    private String contrasena;
    @Basic(optional = false)
    @Lob
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "Imagen")
    private byte[] foto;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParticipante")
    private Collection<ParticipanteAdministrador> participanteAdministradorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParticipante")
    private Collection<ParticipanteTorneo> participanteTorneoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParticipante")
    private Collection<Etapa> etapaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParticipante")
    private Collection<ParticipanteEtapa> participanteEtapaCollection;

    public Participante() {
    }

    public Participante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Participante(Integer idParticipante, String nombre, String usuario, String contrasena, String email) {
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
    }
    public Participante( String nombre, String usuario, String contrasena, String email , int cantidad) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.foto = null;
        this.cantidad = cantidad;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<ParticipanteAdministrador> getParticipanteAdministradorCollection() {
        return participanteAdministradorCollection;
    }

    public void setParticipanteAdministradorCollection(Collection<ParticipanteAdministrador> participanteAdministradorCollection) {
        this.participanteAdministradorCollection = participanteAdministradorCollection;
    }

    public Collection<ParticipanteTorneo> getParticipanteTorneoCollection() {
        return participanteTorneoCollection;
    }

    public void setParticipanteTorneoCollection(Collection<ParticipanteTorneo> participanteTorneoCollection) {
        this.participanteTorneoCollection = participanteTorneoCollection;
    }

    public Collection<Etapa> getEtapaCollection() {
        return etapaCollection;
    }

    public void setEtapaCollection(Collection<Etapa> etapaCollection) {
        this.etapaCollection = etapaCollection;
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
        hash += (idParticipante != null ? idParticipante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.idParticipante == null && other.idParticipante != null) || (this.idParticipante != null && !this.idParticipante.equals(other.idParticipante))) {
            return false;
        }
        return true;
    }
    public void crearEnBase() throws Exception{
        Controladora control = new Controladora();
        control.crearParticipante(this);
    }
    /*
    public boolean login(String usuario, String clave){
        Controladora control = new Controladora();
        EntityManager em = control.getEntityManager();
        boolean valor;
        try{
            Query query = em.createQuery("SELECT p.usuario , p.contrasena FROM Participante p WHERE p.usuario = :usuario AND p.contrasena = :contrasena");
            query.setParameter("Usuario", usuario);
            query.setParameter("Contrasena", clave);
            List resultado = query.getResultList();
            if(!resultado.isEmpty()){
                valor=true;
            }else{
                valor=false;
            }
        }catch(Exception e){ 
            valor=false;
        }
        return valor;
    }

    public boolean login(String usuario, String clave) {
    Controladora control = new Controladora();
    EntityManager em = control.getEntityManager();
    boolean valor;
    try {
        Query query = em.createQuery("SELECT p FROM Participante p WHERE p.usuario = :usuario AND p.contrasena = :contrasena");
        query.setParameter("usuario", usuario);
        query.setParameter("contrasena", clave);
        List resultado = query.getResultList();
        if (!resultado.isEmpty()) {
            valor = true;
        } else {
            valor = false;
        }
    } catch (Exception e) {
        e.printStackTrace();
        valor = false;
    } finally {
        em.close();  // Asegúrate de cerrar el EntityManager
    }
    return valor;
}*/


    @Override
    public String toString() {
        return "Participante{" + "idParticipante=" + idParticipante + ", nombre=" + nombre + ", usuario=" + usuario + ", contrasena=" + contrasena + ", email=" + email + ", participanteAdministradorCollection=" + participanteAdministradorCollection + ", participanteTorneoCollection=" + participanteTorneoCollection + ", etapaCollection=" + etapaCollection + ", participanteEtapaCollection=" + participanteEtapaCollection + '}';
    }
    public String idUsuPass(){
        return "-------------\nID = "+idParticipante+ "\nUSUARIO : "+usuario+"\nPASSWORD : "+contrasena;
    }
}
