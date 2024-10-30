package seahub.trabajofinaltorneo.logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.ParticipanteAdministrador;
import seahub.trabajofinaltorneo.logica.Torneo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-29T23:08:50", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, Integer> idAdministrador;
    public static volatile CollectionAttribute<Administrador, ParticipanteAdministrador> participanteAdministradorCollection;
    public static volatile SingularAttribute<Administrador, String> usuario;
    public static volatile SingularAttribute<Administrador, String> contrasena;
    public static volatile CollectionAttribute<Administrador, Torneo> torneoCollection;
    public static volatile CollectionAttribute<Administrador, Etapa> etapaCollection;
    public static volatile SingularAttribute<Administrador, String> nombre;
    public static volatile SingularAttribute<Administrador, String> email;

}