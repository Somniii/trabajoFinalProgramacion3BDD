package seahub.trabajofinaltorneo.logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.Participante;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-23T02:00:44", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ParticipanteEtapa.class)
public class ParticipanteEtapa_ { 

    public static volatile SingularAttribute<ParticipanteEtapa, Integer> idPE;
    public static volatile SingularAttribute<ParticipanteEtapa, Participante> idParticipante;
    public static volatile SingularAttribute<ParticipanteEtapa, Etapa> idEtapa;

}