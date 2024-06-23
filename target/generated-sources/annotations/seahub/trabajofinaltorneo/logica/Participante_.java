package seahub.trabajofinaltorneo.logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.ParticipanteAdministrador;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-23T03:15:08", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Participante.class)
public class Participante_ { 

    public static volatile CollectionAttribute<Participante, ParticipanteAdministrador> participanteAdministradorCollection;
    public static volatile SingularAttribute<Participante, String> usuario;
    public static volatile SingularAttribute<Participante, String> contrasena;
    public static volatile CollectionAttribute<Participante, ParticipanteTorneo> participanteTorneoCollection;
    public static volatile SingularAttribute<Participante, Integer> idParticipante;
    public static volatile CollectionAttribute<Participante, Etapa> etapaCollection;
    public static volatile CollectionAttribute<Participante, ParticipanteEtapa> participanteEtapaCollection;
    public static volatile SingularAttribute<Participante, String> nombre;
    public static volatile SingularAttribute<Participante, String> email;

}