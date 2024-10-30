/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import seahub.trabajofinaltorneo.persistencia.TorneoJpaController;

/**
 *
 * @author tinov
 */
@Entity
public class Torneo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Basic(optional = false)
    @Column(name = "idTorneo")
    private Integer idTorneo;
    @Basic(optional = false)
    @Lob
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "pisos")
    private int pisos;
    @Basic(optional = false)
    @Column(name = "pisosTotales")
    private int pisosTotales;
    @Basic(optional = false)
    @Column(name = "vigente")
    private boolean vigente;
    @Basic(optional = false)
    @Column(name = "inscripcionVigente")
    private boolean inscripcionVigente;
    @Basic(optional = false)
    @Lob
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidadPorParticipante;
    @Basic(optional = false)
    @Column(name = "maximosParticipantes")
    private int maximosParticipantes;
    //esto es el grupo

    @JoinColumn(name = "idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(optional = false)
    private Administrador idAdministrador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTorneo")
    private Collection<ParticipanteTorneo> participanteTorneoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTorneo")
    private Collection<Etapa> etapaCollection;

    public Torneo() {
    }

    public Torneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }
    public Torneo(String nombre ,Administrador adm , int cantidad , String categoria , int maximosParticipantes){
        this.nombre = nombre;
        this.idAdministrador = adm;
        this.cantidadPorParticipante = cantidad;
        this.categoria = categoria;
        this.vigente = true;
        this.inscripcionVigente = true;
        this.maximosParticipantes = maximosParticipantes;
    }

    public Torneo(Integer idTorneo, String nombre, int pisos, int pisosTotales, boolean vigente , boolean inscripcionVigente) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.pisos = pisos;
        this.pisosTotales = pisosTotales;
        this.vigente = vigente;
        this.inscripcionVigente = inscripcionVigente;
    }

    public int getMaximosParticipantes() {
        return maximosParticipantes;
    }

    public void setMaximosParticipantes(int maximosParticipantes) {
        this.maximosParticipantes = maximosParticipantes;
    }
    

    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getPisosTotales() {
        return pisosTotales;
    }

    public void setPisosTotales(int pisosTotales) {
        this.pisosTotales = pisosTotales;
    }

    public boolean getVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
    public boolean getInscripcionVigente(){
        return inscripcionVigente;
    }
    
    public void setInscripcionVigente(boolean inscripcionVigente){
        this.inscripcionVigente = inscripcionVigente;
    }

    public Administrador getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Administrador idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadPorParticipante() {
        return cantidadPorParticipante;
    }

    public void setCantidadPorParticipante(int cantidadPorParticipante) {
        this.cantidadPorParticipante = cantidadPorParticipante;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTorneo != null ? idTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.idTorneo == null && other.idTorneo != null) || (this.idTorneo != null && !this.idTorneo.equals(other.idTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Torneo{" + "idTorneo=" + idTorneo + ", nombre=" + nombre + ", pisos=" + pisos + ", pisosTotales=" + pisosTotales + ", vigente=" + vigente + ", inscripcionVigente=" + inscripcionVigente + ", idAdministrador=" + idAdministrador + ", participanteTorneoCollection=" + participanteTorneoCollection + ", etapaCollection=" + etapaCollection + '}';
    }





 public void ListaTorneoParticipante(JTable tabla , Participante par) {
     //Definis la table
    DefaultTableModel model;
    String[] titulo = {"idTorneo", "nombre" , "administrador", "disponible", "ya unido" , "cantidad personas por participante" , "categoria","participantes"};
    model = new DefaultTableModel(null, titulo);

    try {
        Controladora control = new Controladora();
        List<Torneo> datos = control.traerTodoTorneo();
        List<ParticipanteTorneo> parTor = control.traerTodoParticipanteTorneo();
        if (datos.isEmpty()) {
            System.out.println("La lista de torneos está vacía.");
        } else {
            System.out.println("La lista de torneos contiene datos.");
            for (Torneo trn : datos) {
                    String yaUnido = "NO";
                    for (ParticipanteTorneo parTorAux : parTor) {
                        if (parTorAux.getIdParticipante().getIdParticipante().equals(par.getIdParticipante()) &&
                            parTorAux.getIdTorneo().getIdTorneo().equals(trn.getIdTorneo())) {
                            yaUnido = "SI";
                            break; // Salir del bucle si se encuentra al participante inscrito
                        }
                    }
                    System.out.println("Torneo ID: " + trn.getIdTorneo() + ", Nombre: " + trn.getNombre() + "Inscripcion vigente :"+ trn.getInscripcionVigente() + " cantidad personas :" + trn.getCantidadPorParticipante() + " categoria :"+ trn.getCategoria());
                    String disponible = "NO";
                    if (trn.getInscripcionVigente() == true ) {
                        disponible = "SI";
                    }       
                    String auxiliar = Integer.toString(trn.cantidadParticipantes()) + "/" +trn.maximosParticipantes;
                    Object[] rowData = {
                        trn.getIdTorneo(),
                        trn.getNombre(),
                        trn.getIdAdministrador().getUsuario(),
                        disponible,
                        yaUnido,
                        trn.getCantidadPorParticipante(),
                        trn.getCategoria(),
                        auxiliar
                        ,

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

public void ListaTorneoAdminsitrador(JTable tabla ,Administrador adm) {
     //Definis la table
    //JOptionPane.showMessageDialog(null, "ENTRA" );
    DefaultTableModel model;
    String[] titulo = {"idTorneo", "nombre","categoria","cantidad participantes por grupo","vigente","inscripcionVigente","participantes","TUYO"};
    
    model = new DefaultTableModel(null, titulo);

    try {
        Controladora control = new Controladora();
        List<Torneo> datos = control.traerTodoTorneo();
        
        if (datos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY DATOS " );
            
            //System.out.println("La lista de torneos está vacía.");
        } else {
            //System.out.println("La lista de torneos contiene datos.");
            Administrador admAux = new Administrador();
            String tuyo = "NO";
            for (Torneo trn : datos) {
                System.out.println("Torneo NOMBRE ADM: " + trn.getIdAdministrador().getNombre() + ", Nombre ADM: " + adm.getNombre());
                admAux = trn.getIdAdministrador();
                if(admAux.getIdAdministrador().equals(adm.getIdAdministrador())==true){
                    //System.out.println("Torneo NOMBRE ADM: " + trn.getIdAdministrador().getNombre() + ", Nombre ADM: " + adm.getNombre());
                    tuyo = "SI";
                }else{
                    tuyo = "NO";
                }
                String auxiliar = Integer.toString(trn.cantidadParticipantes()) + "/" +trn.maximosParticipantes;
                    Object[] rowData = {
                        trn.getIdTorneo(),
                        trn.getNombre(),     
                        trn.getCategoria(),
                        trn.getCantidadPorParticipante(),
                        trn.getVigente(),
                        trn.getInscripcionVigente(),  
                        auxiliar,
                        tuyo,
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

public void ListaTorneo(JTable tabla){
     //Definis la table
    DefaultTableModel model;
    String[] titulo = {"nombre", "usuario","Id","inscripcionVigente","pisosTotales"};
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
public int cantidadParticipantes(){
    Controladora control = new Controladora();
    ArrayList<ParticipanteTorneo> parTor = control.traerTodoParticipanteTorneo();
    Torneo torAux = new Torneo();
    int contador = 0;
    for(ParticipanteTorneo parTorAux: parTor){
        torAux = parTorAux.getIdTorneo();
        if(torAux.getIdTorneo().equals(this.getIdTorneo())){
            contador++;
        }
    }
    return contador;
}


/*
String[] columnNames = {"pedido_id", "nombre_cliente", "estado_pedido_id", "fecha_alta", "fecha_ult_modif", "total"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
		for (Pedido p : tienda.getPedidos()) {
			Object[] rowData = {
				p.getId(),
				p.getCliente().getNombre(),
				p.getEstado(),
				p.getFechaAlta(),
				p.getFechaUltModif(),
				p.getTotal()				
			};
			model.addRow(rowData);
		}
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
*/
}
