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
    public void crearAdministrador(Administrador adm) throws Exception{
        controlPersis.crearAdministrador(adm);
    }
    public void crearEtapa(Etapa eta) throws Exception{
        controlPersis.crearEtapa(eta);
    }
    public void crearParticipante(Participante par) throws Exception{
        controlPersis.crearParticipante(par);
    }
    public void crearTorneo(Torneo tor) throws Exception{
        controlPersis.crearTorneo(tor);
    }
    //Creacion relaciones muchos a muchos
    public void crearParticipanteAdministrador(ParticipanteAdministrador parAdm) throws Exception{
        controlPersis.crearParticipanteAdminstrador(parAdm);
    }
    public void crearParticipanteEtapa(ParticipanteEtapa parEta) throws Exception{
        controlPersis.crearParticipanteEtapa(parEta);
    }
    public void crearParticipanteTorneo(ParticipanteTorneo parTor) throws Exception{
        controlPersis.crearParticipanteTorneo(parTor);
    }
}
