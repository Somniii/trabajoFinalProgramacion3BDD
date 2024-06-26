package seahub.trabajofinaltorneo.logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-25T23:00:30", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Torneo.class)
public class Torneo_ { 

    public static volatile SingularAttribute<Torneo, Administrador> idAdministrador;
    public static volatile SingularAttribute<Torneo, Integer> pisos;
    public static volatile SingularAttribute<Torneo, Integer> pisosTotales;
    public static volatile SingularAttribute<Torneo, Boolean> vigente;
    public static volatile CollectionAttribute<Torneo, ParticipanteTorneo> participanteTorneoCollection;
    public static volatile CollectionAttribute<Torneo, Etapa> etapaCollection;
    public static volatile SingularAttribute<Torneo, String> nombre;
    public static volatile SingularAttribute<Torneo, Boolean> inscripcionVigente;
    public static volatile SingularAttribute<Torneo, Integer> idTorneo;

}