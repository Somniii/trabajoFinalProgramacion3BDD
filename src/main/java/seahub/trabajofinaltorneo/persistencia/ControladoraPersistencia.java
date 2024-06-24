/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteAdministrador;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import seahub.trabajofinaltorneo.logica.Torneo;
import seahub.trabajofinaltorneo.persistencia.exceptions.IllegalOrphanException;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author tinov
 */
public class ControladoraPersistencia {
    AdministradorJpaController admJpa = new AdministradorJpaController();
    EtapaJpaController etaJpa = new EtapaJpaController();
    ParticipanteAdministradorJpaController parAdmJpa = new ParticipanteAdministradorJpaController();
    ParticipanteEtapaJpaController parEtaJpa = new ParticipanteEtapaJpaController();
    ParticipanteJpaController parJpa = new ParticipanteJpaController();
    ParticipanteTorneoJpaController parTorJpa = new ParticipanteTorneoJpaController();
    TorneoJpaController torJpa = new TorneoJpaController();
    public ArrayList<Administrador> traerTodoAdministrador;
    //Throws es una medida preventiva , si no funciona provar con otra cosa
    //Metodos crear, EN CREACION SI PONES THROWS O TRY CATCH SE VA A CRASHEAR IGUAL SI YA EXISTE UN OBJETO CON EL MISMO ID
    public void crearAdministrador(Administrador adm) throws Exception {
        admJpa.create(adm);
    }

    public void crearEtapa(Etapa eta) throws Exception {
        etaJpa.create(eta);
    }

    public void crearTorneo(Torneo tor) throws Exception {
        torJpa.create(tor);
    }
   
    public void crearParticipanteAdminstrador(ParticipanteAdministrador parAdm) throws Exception{
        parAdmJpa.create(parAdm);
    }

    public void crearParticipanteEtapa(ParticipanteEtapa parEta) throws Exception {
        parEtaJpa.create(parEta);
    }

    public void crearParticipanteTorneo(ParticipanteTorneo parTor) throws Exception {
        parTorJpa.create(parTor);
    }

    public void crearParticipante(Participante par) throws Exception {
        parJpa.create(par);
    }
    //Metodos eliminar
    //EN ELIMINAR EL CATCH NON EXISTEN ENTITY EXEPTION TE AYUDA A DECIR QUE NO SE PUDO ELIMINAR PORQUE NO EXISTE CON ESE ID Y NO SE CRASHEA
    public void eliminarAdministrador(int id){
        try {
            admJpa.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            System.out.println("NO EXISTE ADMINISTRADOR CON ESE ID");
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEtapa(int id){
        try {
            etaJpa.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            System.out.println("NO EXISTE ETAPA CON ESE ID");

            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarParticipante(int id){
        try {
            parJpa.destroy(id);
        } catch (IllegalOrphanException ex) {
            System.out.println("Orphan exception");
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            System.out.println("NO EXISTE PARTICIPANTE CON ESE ID");
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarTorneo(int id){
        try {
            torJpa.destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            System.out.println("NO EXISTE TORNEO CON ESE ID");
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarParticipanteAdministrador(int id){
        try {
            parAdmJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println("NO EXISTE RELACION CON ESE ID");

            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarParticipanteEtapa(int id){
        try {
            parEtaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println("NO EXISTE RELACION CON ESE ID");

            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarParticipanteTorneo(int id){
        try {
            parTorJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println("NO EXISTE RELACION CON ESE ID");

            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    //FUNCIONES DE LECTURA

    public Administrador traerAdministrador(int id) {
        return admJpa.findAdministrador(id);
    }

    public Etapa traerEtapa(int id) {
        return etaJpa.findEtapa(id);
    }

    public Participante traerParticipante(int id) {
        return parJpa.findParticipante(id);
    }

    public Torneo traerTorneo(int id) {
        return torJpa.findTorneo(id);
    }

    public ArrayList<Administrador> traerTodoAdministrador() {
        List<Administrador> list = admJpa.findAdministradorEntities();
        ArrayList<Administrador> listaAdministradores = new ArrayList<Administrador> (list);
        return listaAdministradores;
    }

    public ArrayList<Etapa> traerTodoEtapa() {
        List<Etapa> list = etaJpa.findEtapaEntities();
        ArrayList<Etapa> listaEtapas = new ArrayList<Etapa> (list);
        return listaEtapas;
    }

    public ArrayList<Participante> traerTodoParticipante() {
        List<Participante> list = parJpa.findParticipanteEntities();
        ArrayList<Participante> listaParticipantes = new ArrayList<Participante> (list);
        return listaParticipantes;    
    }

    public ArrayList<Torneo> traerTodoTorneo() {
        List<Torneo> list = torJpa.findTorneoEntities();
        ArrayList<Torneo> listaTorneos = new ArrayList<Torneo> (list);
        return listaTorneos;
    }
        

    //FUNCIONES DE EDICION
    public void editarAdministrador1(Administrador adm) {
        try {
            admJpa.edit(adm);
        } catch (NonexistentEntityException ex) {
            System.out.println("No existe adminsitrador para editar");
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarEtapa(Etapa eta) {
        try {
            etaJpa.edit(eta);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarParticipante(Participante par) {
        try {
            parJpa.edit(par);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarTorneo(Torneo tor) {
        try {
            torJpa.edit(tor);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ParticipanteTorneo> traerTodoParticipanteTorneo() {
        List<ParticipanteTorneo> list = parTorJpa.findParticipanteTorneoEntities();
        ArrayList<ParticipanteTorneo> listaParticipanteTorneo = new ArrayList<ParticipanteTorneo> (list);
        return listaParticipanteTorneo;
    }
}
