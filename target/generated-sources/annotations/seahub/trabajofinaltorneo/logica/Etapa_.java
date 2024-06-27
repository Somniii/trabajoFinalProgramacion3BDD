package seahub.trabajofinaltorneo.logica;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import seahub.trabajofinaltorneo.logica.Torneo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-27T17:39:04", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Etapa.class)
public class Etapa_ { 

    public static volatile SingularAttribute<Etapa, Integer> jerarquia;
    public static volatile SingularAttribute<Etapa, Date> fechaPuesto;
    public static volatile SingularAttribute<Etapa, Administrador> idAdministrador;
    public static volatile SingularAttribute<Etapa, Date> fechaGanador;
    public static volatile SingularAttribute<Etapa, Participante> idParticipante;
    public static volatile CollectionAttribute<Etapa, ParticipanteEtapa> participanteEtapaCollection;
    public static volatile SingularAttribute<Etapa, Integer> idEtapa;
    public static volatile SingularAttribute<Etapa, Torneo> idTorneo;

}