/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seahub.trabajofinaltorneo.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import seahub.trabajofinaltorneo.logica.Torneo;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;
import seahub.trabajofinaltorneo.persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author tinov
 */
public class ParticipanteTorneoJpaController implements Serializable {

    public ParticipanteTorneoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ParticipanteTorneoJpaController(){
        emf = Persistence.createEntityManagerFactory("torneoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ParticipanteTorneo participanteTorneo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo idTorneo = participanteTorneo.getIdTorneo();
            if (idTorneo != null) {
                idTorneo = em.getReference(idTorneo.getClass(), idTorneo.getIdTorneo());
                participanteTorneo.setIdTorneo(idTorneo);
            }
            Participante idParticipante = participanteTorneo.getIdParticipante();
            if (idParticipante != null) {
                idParticipante = em.getReference(idParticipante.getClass(), idParticipante.getIdParticipante());
                participanteTorneo.setIdParticipante(idParticipante);
            }
            em.persist(participanteTorneo);
            if (idTorneo != null) {
                idTorneo.getParticipanteTorneoCollection().add(participanteTorneo);
                idTorneo = em.merge(idTorneo);
            }
            if (idParticipante != null) {
                idParticipante.getParticipanteTorneoCollection().add(participanteTorneo);
                idParticipante = em.merge(idParticipante);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParticipanteTorneo(participanteTorneo.getIdPT()) != null) {
                throw new PreexistingEntityException("ParticipanteTorneo " + participanteTorneo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ParticipanteTorneo participanteTorneo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ParticipanteTorneo persistentParticipanteTorneo = em.find(ParticipanteTorneo.class, participanteTorneo.getIdPT());
            Torneo idTorneoOld = persistentParticipanteTorneo.getIdTorneo();
            Torneo idTorneoNew = participanteTorneo.getIdTorneo();
            Participante idParticipanteOld = persistentParticipanteTorneo.getIdParticipante();
            Participante idParticipanteNew = participanteTorneo.getIdParticipante();
            if (idTorneoNew != null) {
                idTorneoNew = em.getReference(idTorneoNew.getClass(), idTorneoNew.getIdTorneo());
                participanteTorneo.setIdTorneo(idTorneoNew);
            }
            if (idParticipanteNew != null) {
                idParticipanteNew = em.getReference(idParticipanteNew.getClass(), idParticipanteNew.getIdParticipante());
                participanteTorneo.setIdParticipante(idParticipanteNew);
            }
            participanteTorneo = em.merge(participanteTorneo);
            if (idTorneoOld != null && !idTorneoOld.equals(idTorneoNew)) {
                idTorneoOld.getParticipanteTorneoCollection().remove(participanteTorneo);
                idTorneoOld = em.merge(idTorneoOld);
            }
            if (idTorneoNew != null && !idTorneoNew.equals(idTorneoOld)) {
                idTorneoNew.getParticipanteTorneoCollection().add(participanteTorneo);
                idTorneoNew = em.merge(idTorneoNew);
            }
            if (idParticipanteOld != null && !idParticipanteOld.equals(idParticipanteNew)) {
                idParticipanteOld.getParticipanteTorneoCollection().remove(participanteTorneo);
                idParticipanteOld = em.merge(idParticipanteOld);
            }
            if (idParticipanteNew != null && !idParticipanteNew.equals(idParticipanteOld)) {
                idParticipanteNew.getParticipanteTorneoCollection().add(participanteTorneo);
                idParticipanteNew = em.merge(idParticipanteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = participanteTorneo.getIdPT();
                if (findParticipanteTorneo(id) == null) {
                    throw new NonexistentEntityException("The participanteTorneo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ParticipanteTorneo participanteTorneo;
            try {
                participanteTorneo = em.getReference(ParticipanteTorneo.class, id);
                participanteTorneo.getIdPT();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The participanteTorneo with id " + id + " no longer exists.", enfe);
            }
            Torneo idTorneo = participanteTorneo.getIdTorneo();
            if (idTorneo != null) {
                idTorneo.getParticipanteTorneoCollection().remove(participanteTorneo);
                idTorneo = em.merge(idTorneo);
            }
            Participante idParticipante = participanteTorneo.getIdParticipante();
            if (idParticipante != null) {
                idParticipante.getParticipanteTorneoCollection().remove(participanteTorneo);
                idParticipante = em.merge(idParticipante);
            }
            em.remove(participanteTorneo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ParticipanteTorneo> findParticipanteTorneoEntities() {
        return findParticipanteTorneoEntities(true, -1, -1);
    }

    public List<ParticipanteTorneo> findParticipanteTorneoEntities(int maxResults, int firstResult) {
        return findParticipanteTorneoEntities(false, maxResults, firstResult);
    }

    private List<ParticipanteTorneo> findParticipanteTorneoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ParticipanteTorneo.class));
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

    public ParticipanteTorneo findParticipanteTorneo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ParticipanteTorneo.class, id);
        } finally {
            em.close();
        }
    }

    public int getParticipanteTorneoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ParticipanteTorneo> rt = cq.from(ParticipanteTorneo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
