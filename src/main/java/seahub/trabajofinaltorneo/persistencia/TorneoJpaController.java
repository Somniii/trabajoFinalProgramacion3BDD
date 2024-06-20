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
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static javax.persistence.Persistence.createEntityManagerFactory;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.Torneo;
import seahub.trabajofinaltorneo.persistencia.exceptions.IllegalOrphanException;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;
import seahub.trabajofinaltorneo.persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author tinov
 */
public class TorneoJpaController implements Serializable {

    public TorneoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public TorneoJpaController(){
        emf = createEntityManagerFactory("torneoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Torneo torneo) throws PreexistingEntityException, Exception {
        if (torneo.getParticipanteTorneoCollection() == null) {
            torneo.setParticipanteTorneoCollection(new ArrayList<ParticipanteTorneo>());
        }
        if (torneo.getEtapaCollection() == null) {
            torneo.setEtapaCollection(new ArrayList<Etapa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador idAdministrador = torneo.getIdAdministrador();
            if (idAdministrador != null) {
                idAdministrador = em.getReference(idAdministrador.getClass(), idAdministrador.getIdAdministrador());
                torneo.setIdAdministrador(idAdministrador);
            }
            Collection<ParticipanteTorneo> attachedParticipanteTorneoCollection = new ArrayList<ParticipanteTorneo>();
            for (ParticipanteTorneo participanteTorneoCollectionParticipanteTorneoToAttach : torneo.getParticipanteTorneoCollection()) {
                participanteTorneoCollectionParticipanteTorneoToAttach = em.getReference(participanteTorneoCollectionParticipanteTorneoToAttach.getClass(), participanteTorneoCollectionParticipanteTorneoToAttach.getIdPT());
                attachedParticipanteTorneoCollection.add(participanteTorneoCollectionParticipanteTorneoToAttach);
            }
            torneo.setParticipanteTorneoCollection(attachedParticipanteTorneoCollection);
            Collection<Etapa> attachedEtapaCollection = new ArrayList<Etapa>();
            for (Etapa etapaCollectionEtapaToAttach : torneo.getEtapaCollection()) {
                etapaCollectionEtapaToAttach = em.getReference(etapaCollectionEtapaToAttach.getClass(), etapaCollectionEtapaToAttach.getIdEtapa());
                attachedEtapaCollection.add(etapaCollectionEtapaToAttach);
            }
            torneo.setEtapaCollection(attachedEtapaCollection);
            em.persist(torneo);
            if (idAdministrador != null) {
                idAdministrador.getTorneoCollection().add(torneo);
                idAdministrador = em.merge(idAdministrador);
            }
            for (ParticipanteTorneo participanteTorneoCollectionParticipanteTorneo : torneo.getParticipanteTorneoCollection()) {
                Torneo oldIdTorneoOfParticipanteTorneoCollectionParticipanteTorneo = participanteTorneoCollectionParticipanteTorneo.getIdTorneo();
                participanteTorneoCollectionParticipanteTorneo.setIdTorneo(torneo);
                participanteTorneoCollectionParticipanteTorneo = em.merge(participanteTorneoCollectionParticipanteTorneo);
                if (oldIdTorneoOfParticipanteTorneoCollectionParticipanteTorneo != null) {
                    oldIdTorneoOfParticipanteTorneoCollectionParticipanteTorneo.getParticipanteTorneoCollection().remove(participanteTorneoCollectionParticipanteTorneo);
                    oldIdTorneoOfParticipanteTorneoCollectionParticipanteTorneo = em.merge(oldIdTorneoOfParticipanteTorneoCollectionParticipanteTorneo);
                }
            }
            for (Etapa etapaCollectionEtapa : torneo.getEtapaCollection()) {
                Torneo oldIdTorneoOfEtapaCollectionEtapa = etapaCollectionEtapa.getIdTorneo();
                etapaCollectionEtapa.setIdTorneo(torneo);
                etapaCollectionEtapa = em.merge(etapaCollectionEtapa);
                if (oldIdTorneoOfEtapaCollectionEtapa != null) {
                    oldIdTorneoOfEtapaCollectionEtapa.getEtapaCollection().remove(etapaCollectionEtapa);
                    oldIdTorneoOfEtapaCollectionEtapa = em.merge(oldIdTorneoOfEtapaCollectionEtapa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTorneo(torneo.getIdTorneo()) != null) {
                throw new PreexistingEntityException("Torneo " + torneo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Torneo torneo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo persistentTorneo = em.find(Torneo.class, torneo.getIdTorneo());
            Administrador idAdministradorOld = persistentTorneo.getIdAdministrador();
            Administrador idAdministradorNew = torneo.getIdAdministrador();
            Collection<ParticipanteTorneo> participanteTorneoCollectionOld = persistentTorneo.getParticipanteTorneoCollection();
            Collection<ParticipanteTorneo> participanteTorneoCollectionNew = torneo.getParticipanteTorneoCollection();
            Collection<Etapa> etapaCollectionOld = persistentTorneo.getEtapaCollection();
            Collection<Etapa> etapaCollectionNew = torneo.getEtapaCollection();
            List<String> illegalOrphanMessages = null;
            for (ParticipanteTorneo participanteTorneoCollectionOldParticipanteTorneo : participanteTorneoCollectionOld) {
                if (!participanteTorneoCollectionNew.contains(participanteTorneoCollectionOldParticipanteTorneo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ParticipanteTorneo " + participanteTorneoCollectionOldParticipanteTorneo + " since its idTorneo field is not nullable.");
                }
            }
            for (Etapa etapaCollectionOldEtapa : etapaCollectionOld) {
                if (!etapaCollectionNew.contains(etapaCollectionOldEtapa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Etapa " + etapaCollectionOldEtapa + " since its idTorneo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idAdministradorNew != null) {
                idAdministradorNew = em.getReference(idAdministradorNew.getClass(), idAdministradorNew.getIdAdministrador());
                torneo.setIdAdministrador(idAdministradorNew);
            }
            Collection<ParticipanteTorneo> attachedParticipanteTorneoCollectionNew = new ArrayList<ParticipanteTorneo>();
            for (ParticipanteTorneo participanteTorneoCollectionNewParticipanteTorneoToAttach : participanteTorneoCollectionNew) {
                participanteTorneoCollectionNewParticipanteTorneoToAttach = em.getReference(participanteTorneoCollectionNewParticipanteTorneoToAttach.getClass(), participanteTorneoCollectionNewParticipanteTorneoToAttach.getIdPT());
                attachedParticipanteTorneoCollectionNew.add(participanteTorneoCollectionNewParticipanteTorneoToAttach);
            }
            participanteTorneoCollectionNew = attachedParticipanteTorneoCollectionNew;
            torneo.setParticipanteTorneoCollection(participanteTorneoCollectionNew);
            Collection<Etapa> attachedEtapaCollectionNew = new ArrayList<Etapa>();
            for (Etapa etapaCollectionNewEtapaToAttach : etapaCollectionNew) {
                etapaCollectionNewEtapaToAttach = em.getReference(etapaCollectionNewEtapaToAttach.getClass(), etapaCollectionNewEtapaToAttach.getIdEtapa());
                attachedEtapaCollectionNew.add(etapaCollectionNewEtapaToAttach);
            }
            etapaCollectionNew = attachedEtapaCollectionNew;
            torneo.setEtapaCollection(etapaCollectionNew);
            torneo = em.merge(torneo);
            if (idAdministradorOld != null && !idAdministradorOld.equals(idAdministradorNew)) {
                idAdministradorOld.getTorneoCollection().remove(torneo);
                idAdministradorOld = em.merge(idAdministradorOld);
            }
            if (idAdministradorNew != null && !idAdministradorNew.equals(idAdministradorOld)) {
                idAdministradorNew.getTorneoCollection().add(torneo);
                idAdministradorNew = em.merge(idAdministradorNew);
            }
            for (ParticipanteTorneo participanteTorneoCollectionNewParticipanteTorneo : participanteTorneoCollectionNew) {
                if (!participanteTorneoCollectionOld.contains(participanteTorneoCollectionNewParticipanteTorneo)) {
                    Torneo oldIdTorneoOfParticipanteTorneoCollectionNewParticipanteTorneo = participanteTorneoCollectionNewParticipanteTorneo.getIdTorneo();
                    participanteTorneoCollectionNewParticipanteTorneo.setIdTorneo(torneo);
                    participanteTorneoCollectionNewParticipanteTorneo = em.merge(participanteTorneoCollectionNewParticipanteTorneo);
                    if (oldIdTorneoOfParticipanteTorneoCollectionNewParticipanteTorneo != null && !oldIdTorneoOfParticipanteTorneoCollectionNewParticipanteTorneo.equals(torneo)) {
                        oldIdTorneoOfParticipanteTorneoCollectionNewParticipanteTorneo.getParticipanteTorneoCollection().remove(participanteTorneoCollectionNewParticipanteTorneo);
                        oldIdTorneoOfParticipanteTorneoCollectionNewParticipanteTorneo = em.merge(oldIdTorneoOfParticipanteTorneoCollectionNewParticipanteTorneo);
                    }
                }
            }
            for (Etapa etapaCollectionNewEtapa : etapaCollectionNew) {
                if (!etapaCollectionOld.contains(etapaCollectionNewEtapa)) {
                    Torneo oldIdTorneoOfEtapaCollectionNewEtapa = etapaCollectionNewEtapa.getIdTorneo();
                    etapaCollectionNewEtapa.setIdTorneo(torneo);
                    etapaCollectionNewEtapa = em.merge(etapaCollectionNewEtapa);
                    if (oldIdTorneoOfEtapaCollectionNewEtapa != null && !oldIdTorneoOfEtapaCollectionNewEtapa.equals(torneo)) {
                        oldIdTorneoOfEtapaCollectionNewEtapa.getEtapaCollection().remove(etapaCollectionNewEtapa);
                        oldIdTorneoOfEtapaCollectionNewEtapa = em.merge(oldIdTorneoOfEtapaCollectionNewEtapa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = torneo.getIdTorneo();
                if (findTorneo(id) == null) {
                    throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.");
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
            Torneo torneo;
            try {
                torneo = em.getReference(Torneo.class, id);
                torneo.getIdTorneo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ParticipanteTorneo> participanteTorneoCollectionOrphanCheck = torneo.getParticipanteTorneoCollection();
            for (ParticipanteTorneo participanteTorneoCollectionOrphanCheckParticipanteTorneo : participanteTorneoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Torneo (" + torneo + ") cannot be destroyed since the ParticipanteTorneo " + participanteTorneoCollectionOrphanCheckParticipanteTorneo + " in its participanteTorneoCollection field has a non-nullable idTorneo field.");
            }
            Collection<Etapa> etapaCollectionOrphanCheck = torneo.getEtapaCollection();
            for (Etapa etapaCollectionOrphanCheckEtapa : etapaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Torneo (" + torneo + ") cannot be destroyed since the Etapa " + etapaCollectionOrphanCheckEtapa + " in its etapaCollection field has a non-nullable idTorneo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Administrador idAdministrador = torneo.getIdAdministrador();
            if (idAdministrador != null) {
                idAdministrador.getTorneoCollection().remove(torneo);
                idAdministrador = em.merge(idAdministrador);
            }
            em.remove(torneo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Torneo> findTorneoEntities() {
        return findTorneoEntities(true, -1, -1);
    }

    public List<Torneo> findTorneoEntities(int maxResults, int firstResult) {
        return findTorneoEntities(false, maxResults, firstResult);
    }

    private List<Torneo> findTorneoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Torneo.class));
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

    public Torneo findTorneo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Torneo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTorneoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Torneo> rt = cq.from(Torneo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
