/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import seahub.trabajofinaltorneo.persistencia.ControladoraPersistencia;
import seahub.trabajofinaltorneo.persistencia.exceptions.IllegalOrphanException;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author tinov
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    //Metodos administrador
    public void crearAdministrador(Administrador adm) throws Exception{
        controlPersis.crearAdministrador(adm);
    }
    public void eliminarAdministrador(int id) throws IllegalOrphanException, NonexistentEntityException{
        controlPersis.eliminarAdministrador(id);
    }
    
    public void editarAdministrador1(Administrador adm){
        controlPersis.editarAdministrador1(adm);
    }
    
    public Administrador traerAdministrador(int id){
        return controlPersis.traerAdministrador(id);
    }
    public ArrayList<Administrador> traerTodoAdministrador(){
        return controlPersis.traerTodoAdministrador();
    }
    //Metodos etapa
    public void crearEtapa(Etapa eta) throws Exception{
        controlPersis.crearEtapa(eta);
    }
    public void eliminarEtapa(int id) throws IllegalOrphanException, NonexistentEntityException{
        controlPersis.eliminarEtapa(id);
    }
    public Etapa traerEtapa(int id){
        return controlPersis.traerEtapa(id);
    }
    public ArrayList<Etapa> traerTodoEtapa(){
        return controlPersis.traerTodoEtapa();
    }
    public void editarEtapa1(Etapa eta){
        controlPersis.editarEtapa(eta);
    }
    //Metodos Participante
    public void crearParticipante(Participante par) throws Exception{
        controlPersis.crearParticipante(par);
    }
    public void eliminarParticipante(int id) throws IllegalOrphanException, NonexistentEntityException{
        controlPersis.eliminarParticipante(id);
    }
    public Participante traerParticipante(int id){
        return controlPersis.traerParticipante(id);
    }
    public ArrayList<Participante> traerTodoParticipante(){
        return controlPersis.traerTodoParticipante();
    }
    public void editarParticipante(Participante par){
        controlPersis.editarParticipante(par);
    }
    //Metodos torneo
    public void crearTorneo(Torneo tor) throws Exception{
        controlPersis.crearTorneo(tor);
    }
    public void eliminarTorneo(int id) throws IllegalOrphanException, NonexistentEntityException{
        controlPersis.eliminarTorneo(id);
    }
    public Torneo traerTorneo(int id){
        return controlPersis.traerTorneo(id);
    }
    public ArrayList<Torneo> traerTodoTorneo(){
        return controlPersis.traerTodoTorneo();
    }
    public void editarTorneo(Torneo tor){
        controlPersis.editarTorneo(tor);
    }
    //Creacion relaciones muchos a muchos
    //Metodos relacion Participante Administrador
    public void crearParticipanteAdministrador(ParticipanteAdministrador parAdm) throws Exception{
        controlPersis.crearParticipanteAdminstrador(parAdm);
    }
    public void eliminarParticipanteAdministrador(int id) throws NonexistentEntityException{
        controlPersis.eliminarParticipanteAdministrador(id);
    }
    //Metodos relacion Participante etapa
    public void crearParticipanteEtapa(ParticipanteEtapa parEta) throws Exception{
        controlPersis.crearParticipanteEtapa(parEta);
    }
    public void eliminarParticipanteEtapa(int id) throws NonexistentEntityException{
        controlPersis.eliminarParticipanteEtapa(id);
    }
    //Metodos relacion Participante Torneo
    public void crearParticipanteTorneo(ParticipanteTorneo parTor) throws Exception{
        controlPersis.crearParticipanteTorneo(parTor);
    }
    public void eliminarParticipanteTorneo(int id) throws NonexistentEntityException{
        controlPersis.eliminarParticipanteTorneo(id);
    }
    public ArrayList<ParticipanteTorneo> traerTodoParticipanteTorneo(){
        return controlPersis.traerTodoParticipanteTorneo();
    }

    EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
