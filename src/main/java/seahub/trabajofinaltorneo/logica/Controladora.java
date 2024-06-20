/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.logica;

import seahub.trabajofinaltorneo.persistencia.ControladoraPersistencia;

/**
 *
 * @author tinov
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    public void crearAdministrador(Administrador adm){
        controlPersis.crearAdministrador(adm);
    }
    public void crearEtapa(Etapa eta){
        controlPersis.crearEtapa(eta);
    }
    public void crearParticipante(Participante par){
        controlPersis.crearParticipante(par);
    }
    public void crearTorneo(Torneo tor){
        controlPersis.crearTorneo(tor);
    }
    //Creacion relaciones muchos a muchos
    public void crearParticipanteAdministrador(ParticipanteAdministrador parAdm){
        controlPersis.crearParticipanteAdminstrador();
    }
    public void crearParticipanteEtapa(ParticipanteEtapa parEta){
        controlPersis.crearParticipanteEtapa();
    }
    public void crearParticipanteTorneo(ParticipanteTorneo parTor){
        controlPersis.crearParticipanteTorneo();
    }
}
