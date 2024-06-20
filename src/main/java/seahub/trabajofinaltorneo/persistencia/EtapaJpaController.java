/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.Torneo;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.persistencia.exceptions.IllegalOrphanException;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;
import seahub.trabajofinaltorneo.persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author tinov
 */
public class EtapaJpaController implements Serializable {

    public EtapaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EtapaJpaController(){
        emf = Persistence.createEntityManagerFactory("torneoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Etapa etapa) throws PreexistingEntityException, Exception {
        if (etapa.getParticipanteEtapaCollection() == null) {
            etapa.setParticipanteEtapaCollection(new ArrayList<ParticipanteEtapa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador idAdministrador = etapa.getIdAdministrador();
            if (idAdministrador != null) {
                idAdministrador = em.getReference(idAdministrador.getClass(), idAdministrador.getIdAdministrador());
                etapa.setIdAdministrador(idAdministrador);
            }
            Participante idParticipante = etapa.getIdParticipante();
            if (idParticipante != null) {
                idParticipante = em.getReference(idParticipante.getClass(), idParticipante.getIdParticipante());
                etapa.setIdParticipante(idParticipante);
            }
            Torneo idTorneo = etapa.getIdTorneo();
            if (idTorneo != null) {
                idTorneo = em.getReference(idTorneo.getClass(), idTorneo.getIdTorneo());
                etapa.setIdTorneo(idTorneo);
            }
            Collection<ParticipanteEtapa> attachedParticipanteEtapaCollection = new ArrayList<ParticipanteEtapa>();
            for (ParticipanteEtapa participanteEtapaCollectionParticipanteEtapaToAttach : etapa.getParticipanteEtapaCollection()) {
                participanteEtapaCollectionParticipanteEtapaToAttach = em.getReference(participanteEtapaCollectionParticipanteEtapaToAttach.getClass(), participanteEtapaCollectionParticipanteEtapaToAttach.getIdPE());
                attachedParticipanteEtapaCollection.add(participanteEtapaCollectionParticipanteEtapaToAttach);
            }
            etapa.setParticipanteEtapaCollection(attachedParticipanteEtapaCollection);
            em.persist(etapa);
            if (idAdministrador != null) {
                idAdministrador.getEtapaCollection().add(etapa);
                idAdministrador = em.merge(idAdministrador);
            }
            if (idParticipante != null) {
                idParticipante.getEtapaCollection().add(etapa);
                idParticipante = em.merge(idParticipante);
            }
            if (idTorneo != null) {
                idTorneo.getEtapaCollection().add(etapa);
                idTorneo = em.merge(idTorneo);
            }
            for (ParticipanteEtapa participanteEtapaCollectionParticipanteEtapa : etapa.getParticipanteEtapaCollection()) {
                Etapa oldIdEtapaOfParticipanteEtapaCollectionParticipanteEtapa = participanteEtapaCollectionParticipanteEtapa.getIdEtapa();
                participanteEtapaCollectionParticipanteEtapa.setIdEtapa(etapa);
                participanteEtapaCollectionParticipanteEtapa = em.merge(participanteEtapaCollectionParticipanteEtapa);
                if (oldIdEtapaOfParticipanteEtapaCollectionParticipanteEtapa != null) {
                    oldIdEtapaOfParticipanteEtapaCollectionParticipanteEtapa.getParticipanteEtapaCollection().remove(participanteEtapaCollectionParticipanteEtapa);
                    oldIdEtapaOfParticipanteEtapaCollectionParticipanteEtapa = em.merge(oldIdEtapaOfParticipanteEtapaCollectionParticipanteEtapa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEtapa(etapa.getIdEtapa()) != null) {
                throw new PreexistingEntityException("Etapa " + etapa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Etapa etapa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Etapa persistentEtapa = em.find(Etapa.class, etapa.getIdEtapa());
            Administrador idAdministradorOld = persistentEtapa.getIdAdministrador();
            Administrador idAdministradorNew = etapa.getIdAdministrador();
            Participante idParticipanteOld = persistentEtapa.getIdParticipante();
            Participante idParticipanteNew = etapa.getIdParticipante();
            Torneo idTorneoOld = persistentEtapa.getIdTorneo();
            Torneo idTorneoNew = etapa.getIdTorneo();
            Collection<ParticipanteEtapa> participanteEtapaCollectionOld = persistentEtapa.getParticipanteEtapaCollection();
            Collection<ParticipanteEtapa> participanteEtapaCollectionNew = etapa.getParticipanteEtapaCollection();
            List<String> illegalOrphanMessages = null;
            for (ParticipanteEtapa participanteEtapaCollectionOldParticipanteEtapa : participanteEtapaCollectionOld) {
                if (!participanteEtapaCollectionNew.contains(participanteEtapaCollectionOldParticipanteEtapa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ParticipanteEtapa " + participanteEtapaCollectionOldParticipanteEtapa + " since its idEtapa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idAdministradorNew != null) {
                idAdministradorNew = em.getReference(idAdministradorNew.getClass(), idAdministradorNew.getIdAdministrador());
                etapa.setIdAdministrador(idAdministradorNew);
            }
            if (idParticipanteNew != null) {
                idParticipanteNew = em.getReference(idParticipanteNew.getClass(), idParticipanteNew.getIdParticipante());
                etapa.setIdParticipante(idParticipanteNew);
            }
            if (idTorneoNew != null) {
                idTorneoNew = em.getReference(idTorneoNew.getClass(), idTorneoNew.getIdTorneo());
                etapa.setIdTorneo(idTorneoNew);
            }
            Collection<ParticipanteEtapa> attachedParticipanteEtapaCollectionNew = new ArrayList<ParticipanteEtapa>();
            for (ParticipanteEtapa participanteEtapaCollectionNewParticipanteEtapaToAttach : participanteEtapaCollectionNew) {
                participanteEtapaCollectionNewParticipanteEtapaToAttach = em.getReference(participanteEtapaCollectionNewParticipanteEtapaToAttach.getClass(), participanteEtapaCollectionNewParticipanteEtapaToAttach.getIdPE());
                attachedParticipanteEtapaCollectionNew.add(participanteEtapaCollectionNewParticipanteEtapaToAttach);
            }
            participanteEtapaCollectionNew = attachedParticipanteEtapaCollectionNew;
            etapa.setParticipanteEtapaCollection(participanteEtapaCollectionNew);
            etapa = em.merge(etapa);
            if (idAdministradorOld != null && !idAdministradorOld.equals(idAdministradorNew)) {
                idAdministradorOld.getEtapaCollection().remove(etapa);
                idAdministradorOld = em.merge(idAdministradorOld);
            }
            if (idAdministradorNew != null && !idAdministradorNew.equals(idAdministradorOld)) {
                idAdministradorNew.getEtapaCollection().add(etapa);
                idAdministradorNew = em.merge(idAdministradorNew);
            }
            if (idParticipanteOld != null && !idParticipanteOld.equals(idParticipanteNew)) {
                idParticipanteOld.getEtapaCollection().remove(etapa);
                idParticipanteOld = em.merge(idParticipanteOld);
            }
            if (idParticipanteNew != null && !idParticipanteNew.equals(idParticipanteOld)) {
                idParticipanteNew.getEtapaCollection().add(etapa);
                idParticipanteNew = em.merge(idParticipanteNew);
            }
            if (idTorneoOld != null && !idTorneoOld.equals(idTorneoNew)) {
                idTorneoOld.getEtapaCollection().remove(etapa);
                idTorneoOld = em.merge(idTorneoOld);
            }
            if (idTorneoNew != null && !idTorneoNew.equals(idTorneoOld)) {
                idTorneoNew.getEtapaCollection().add(etapa);
                idTorneoNew = em.merge(idTorneoNew);
            }
            for (ParticipanteEtapa participanteEtapaCollectionNewParticipanteEtapa : participanteEtapaCollectionNew) {
                if (!participanteEtapaCollectionOld.contains(participanteEtapaCollectionNewParticipanteEtapa)) {
                    Etapa oldIdEtapaOfParticipanteEtapaCollectionNewParticipanteEtapa = participanteEtapaCollectionNewParticipanteEtapa.getIdEtapa();
                    participanteEtapaCollectionNewParticipanteEtapa.setIdEtapa(etapa);
                    participanteEtapaCollectionNewParticipanteEtapa = em.merge(participanteEtapaCollectionNewParticipanteEtapa);
                    if (oldIdEtapaOfParticipanteEtapaCollectionNewParticipanteEtapa != null && !oldIdEtapaOfParticipanteEtapaCollectionNewParticipanteEtapa.equals(etapa)) {
                        oldIdEtapaOfParticipanteEtapaCollectionNewParticipanteEtapa.getParticipanteEtapaCollection().remove(participanteEtapaCollectionNewParticipanteEtapa);
                        oldIdEtapaOfParticipanteEtapaCollectionNewParticipanteEtapa = em.merge(oldIdEtapaOfParticipanteEtapaCollectionNewParticipanteEtapa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = etapa.getIdEtapa();
                if (findEtapa(id) == null) {
                    throw new NonexistentEntityException("The etapa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Etapa etapa;
            try {
                etapa = em.getReference(Etapa.class, id);
                etapa.getIdEtapa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The etapa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ParticipanteEtapa> participanteEtapaCollectionOrphanCheck = etapa.getParticipanteEtapaCollection();
            for (ParticipanteEtapa participanteEtapaCollectionOrphanCheckParticipanteEtapa : participanteEtapaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Etapa (" + etapa + ") cannot be destroyed since the ParticipanteEtapa " + participanteEtapaCollectionOrphanCheckParticipanteEtapa + " in its participanteEtapaCollection field has a non-nullable idEtapa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Administrador idAdministrador = etapa.getIdAdministrador();
            if (idAdministrador != null) {
                idAdministrador.getEtapaCollection().remove(etapa);
                idAdministrador = em.merge(idAdministrador);
            }
            Participante idParticipante = etapa.getIdParticipante();
            if (idParticipante != null) {
                idParticipante.getEtapaCollection().remove(etapa);
                idParticipante = em.merge(idParticipante);
            }
            Torneo idTorneo = etapa.getIdTorneo();
            if (idTorneo != null) {
                idTorneo.getEtapaCollection().remove(etapa);
                idTorneo = em.merge(idTorneo);
            }
            em.remove(etapa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Etapa> findEtapaEntities() {
        return findEtapaEntities(true, -1, -1);
    }

    public List<Etapa> findEtapaEntities(int maxResults, int firstResult) {
        return findEtapaEntities(false, maxResults, firstResult);
    }

    private List<Etapa> findEtapaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Etapa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Etapa findEtapa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Etapa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEtapaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Etapa> rt = cq.from(Etapa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
