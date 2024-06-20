/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.persistencia;

import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteAdministrador;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import seahub.trabajofinaltorneo.logica.Torneo;

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

    //Throws es una medida preventiva , si no funciona provar con otra cosa
    public void crearAdministrador(Administrador adm) throws Exception {
        admJpa.create(adm);
    }

    public void crearEtapa(Etapa eta) throws Exception {
        etaJpa.create(eta);
    }

    public void crearTorneo(Torneo tor) throws Exception {
        torJpa.create(tor);
    }

    public void crearParticipanteAdminstrador(ParticipanteAdministrador parAdm) throws Exception {
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
}
