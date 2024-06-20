/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.persistencia;

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
}
