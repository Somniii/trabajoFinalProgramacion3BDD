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
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;
import seahub.trabajofinaltorneo.persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author tinov
 */
public class ParticipanteEtapaJpaController implements Serializable {

    public ParticipanteEtapaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ParticipanteEtapaJpaController(){
        emf = Persistence.createEntityManagerFactory("torneoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ParticipanteEtapa participanteEtapa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Etapa idEtapa = participanteEtapa.getIdEtapa();
            if (idEtapa != null) {
                idEtapa = em.getReference(idEtapa.getClass(), idEtapa.getIdEtapa());
                participanteEtapa.setIdEtapa(idEtapa);
            }
            Participante idParticipante = participanteEtapa.getIdParticipante();
            if (idParticipante != null) {
                idParticipante = em.getReference(idParticipante.getClass(), idParticipante.getIdParticipante());
                participanteEtapa.setIdParticipante(idParticipante);
            }
            em.persist(participanteEtapa);
            if (idEtapa != null) {
                idEtapa.getParticipanteEtapaCollection().add(participanteEtapa);
                idEtapa = em.merge(idEtapa);
            }
            if (idParticipante != null) {
                idParticipante.getParticipanteEtapaCollection().add(participanteEtapa);
                idParticipante = em.merge(idParticipante);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParticipanteEtapa(participanteEtapa.getIdPE()) != null) {
                throw new PreexistingEntityException("ParticipanteEtapa " + participanteEtapa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ParticipanteEtapa participanteEtapa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ParticipanteEtapa persistentParticipanteEtapa = em.find(ParticipanteEtapa.class, participanteEtapa.getIdPE());
            Etapa idEtapaOld = persistentParticipanteEtapa.getIdEtapa();
            Etapa idEtapaNew = participanteEtapa.getIdEtapa();
            Participante idParticipanteOld = persistentParticipanteEtapa.getIdParticipante();
            Participante idParticipanteNew = participanteEtapa.getIdParticipante();
            if (idEtapaNew != null) {
                idEtapaNew = em.getReference(idEtapaNew.getClass(), idEtapaNew.getIdEtapa());
                participanteEtapa.setIdEtapa(idEtapaNew);
            }
            if (idParticipanteNew != null) {
                idParticipanteNew = em.getReference(idParticipanteNew.getClass(), idParticipanteNew.getIdParticipante());
                participanteEtapa.setIdParticipante(idParticipanteNew);
            }
            participanteEtapa = em.merge(participanteEtapa);
            if (idEtapaOld != null && !idEtapaOld.equals(idEtapaNew)) {
                idEtapaOld.getParticipanteEtapaCollection().remove(participanteEtapa);
                idEtapaOld = em.merge(idEtapaOld);
            }
            if (idEtapaNew != null && !idEtapaNew.equals(idEtapaOld)) {
                idEtapaNew.getParticipanteEtapaCollection().add(participanteEtapa);
                idEtapaNew = em.merge(idEtapaNew);
            }
            if (idParticipanteOld != null && !idParticipanteOld.equals(idParticipanteNew)) {
                idParticipanteOld.getParticipanteEtapaCollection().remove(participanteEtapa);
                idParticipanteOld = em.merge(idParticipanteOld);
            }
            if (idParticipanteNew != null && !idParticipanteNew.equals(idParticipanteOld)) {
                idParticipanteNew.getParticipanteEtapaCollection().add(participanteEtapa);
                idParticipanteNew = em.merge(idParticipanteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = participanteEtapa.getIdPE();
                if (findParticipanteEtapa(id) == null) {
                    throw new NonexistentEntityException("The participanteEtapa with id " + id + " no longer exists.");
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
            ParticipanteEtapa participanteEtapa;
            try {
                participanteEtapa = em.getReference(ParticipanteEtapa.class, id);
                participanteEtapa.getIdPE();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The participanteEtapa with id " + id + " no longer exists.", enfe);
            }
            Etapa idEtapa = participanteEtapa.getIdEtapa();
            if (idEtapa != null) {
                idEtapa.getParticipanteEtapaCollection().remove(participanteEtapa);
                idEtapa = em.merge(idEtapa);
            }
            Participante idParticipante = participanteEtapa.getIdParticipante();
            if (idParticipante != null) {
                idParticipante.getParticipanteEtapaCollection().remove(participanteEtapa);
                idParticipante = em.merge(idParticipante);
            }
            em.remove(participanteEtapa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ParticipanteEtapa> findParticipanteEtapaEntities() {
        return findParticipanteEtapaEntities(true, -1, -1);
    }

    public List<ParticipanteEtapa> findParticipanteEtapaEntities(int maxResults, int firstResult) {
        return findParticipanteEtapaEntities(false, maxResults, firstResult);
    }

    private List<ParticipanteEtapa> findParticipanteEtapaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ParticipanteEtapa.class));
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

    public ParticipanteEtapa findParticipanteEtapa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ParticipanteEtapa.class, id);
        } finally {
            em.close();
        }
    }

    public int getParticipanteEtapaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ParticipanteEtapa> rt = cq.from(ParticipanteEtapa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
