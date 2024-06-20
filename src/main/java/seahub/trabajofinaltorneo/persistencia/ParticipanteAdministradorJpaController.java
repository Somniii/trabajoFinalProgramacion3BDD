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
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.ParticipanteAdministrador;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;
import seahub.trabajofinaltorneo.persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author tinov
 */
public class ParticipanteAdministradorJpaController implements Serializable {

    public ParticipanteAdministradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ParticipanteAdministradorJpaController(){
        emf = Persistence.createEntityManagerFactory("torneoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ParticipanteAdministrador participanteAdministrador) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Participante idParticipante = participanteAdministrador.getIdParticipante();
            if (idParticipante != null) {
                idParticipante = em.getReference(idParticipante.getClass(), idParticipante.getIdParticipante());
                participanteAdministrador.setIdParticipante(idParticipante);
            }
            Administrador idAdministrador = participanteAdministrador.getIdAdministrador();
            if (idAdministrador != null) {
                idAdministrador = em.getReference(idAdministrador.getClass(), idAdministrador.getIdAdministrador());
                participanteAdministrador.setIdAdministrador(idAdministrador);
            }
            em.persist(participanteAdministrador);
            if (idParticipante != null) {
                idParticipante.getParticipanteAdministradorCollection().add(participanteAdministrador);
                idParticipante = em.merge(idParticipante);
            }
            if (idAdministrador != null) {
                idAdministrador.getParticipanteAdministradorCollection().add(participanteAdministrador);
                idAdministrador = em.merge(idAdministrador);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParticipanteAdministrador(participanteAdministrador.getIdPA()) != null) {
                throw new PreexistingEntityException("ParticipanteAdministrador " + participanteAdministrador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ParticipanteAdministrador participanteAdministrador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ParticipanteAdministrador persistentParticipanteAdministrador = em.find(ParticipanteAdministrador.class, participanteAdministrador.getIdPA());
            Participante idParticipanteOld = persistentParticipanteAdministrador.getIdParticipante();
            Participante idParticipanteNew = participanteAdministrador.getIdParticipante();
            Administrador idAdministradorOld = persistentParticipanteAdministrador.getIdAdministrador();
            Administrador idAdministradorNew = participanteAdministrador.getIdAdministrador();
            if (idParticipanteNew != null) {
                idParticipanteNew = em.getReference(idParticipanteNew.getClass(), idParticipanteNew.getIdParticipante());
                participanteAdministrador.setIdParticipante(idParticipanteNew);
            }
            if (idAdministradorNew != null) {
                idAdministradorNew = em.getReference(idAdministradorNew.getClass(), idAdministradorNew.getIdAdministrador());
                participanteAdministrador.setIdAdministrador(idAdministradorNew);
            }
            participanteAdministrador = em.merge(participanteAdministrador);
            if (idParticipanteOld != null && !idParticipanteOld.equals(idParticipanteNew)) {
                idParticipanteOld.getParticipanteAdministradorCollection().remove(participanteAdministrador);
                idParticipanteOld = em.merge(idParticipanteOld);
            }
            if (idParticipanteNew != null && !idParticipanteNew.equals(idParticipanteOld)) {
                idParticipanteNew.getParticipanteAdministradorCollection().add(participanteAdministrador);
                idParticipanteNew = em.merge(idParticipanteNew);
            }
            if (idAdministradorOld != null && !idAdministradorOld.equals(idAdministradorNew)) {
                idAdministradorOld.getParticipanteAdministradorCollection().remove(participanteAdministrador);
                idAdministradorOld = em.merge(idAdministradorOld);
            }
            if (idAdministradorNew != null && !idAdministradorNew.equals(idAdministradorOld)) {
                idAdministradorNew.getParticipanteAdministradorCollection().add(participanteAdministrador);
                idAdministradorNew = em.merge(idAdministradorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = participanteAdministrador.getIdPA();
                if (findParticipanteAdministrador(id) == null) {
                    throw new NonexistentEntityException("The participanteAdministrador with id " + id + " no longer exists.");
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
            ParticipanteAdministrador participanteAdministrador;
            try {
                participanteAdministrador = em.getReference(ParticipanteAdministrador.class, id);
                participanteAdministrador.getIdPA();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The participanteAdministrador with id " + id + " no longer exists.", enfe);
            }
            Participante idParticipante = participanteAdministrador.getIdParticipante();
            if (idParticipante != null) {
                idParticipante.getParticipanteAdministradorCollection().remove(participanteAdministrador);
                idParticipante = em.merge(idParticipante);
            }
            Administrador idAdministrador = participanteAdministrador.getIdAdministrador();
            if (idAdministrador != null) {
                idAdministrador.getParticipanteAdministradorCollection().remove(participanteAdministrador);
                idAdministrador = em.merge(idAdministrador);
            }
            em.remove(participanteAdministrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ParticipanteAdministrador> findParticipanteAdministradorEntities() {
        return findParticipanteAdministradorEntities(true, -1, -1);
    }

    public List<ParticipanteAdministrador> findParticipanteAdministradorEntities(int maxResults, int firstResult) {
        return findParticipanteAdministradorEntities(false, maxResults, firstResult);
    }

    private List<ParticipanteAdministrador> findParticipanteAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ParticipanteAdministrador.class));
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

    public ParticipanteAdministrador findParticipanteAdministrador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ParticipanteAdministrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getParticipanteAdministradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ParticipanteAdministrador> rt = cq.from(ParticipanteAdministrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
