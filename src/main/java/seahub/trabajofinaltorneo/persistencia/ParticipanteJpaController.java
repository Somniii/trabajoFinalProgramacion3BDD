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
import seahub.trabajofinaltorneo.logica.ParticipanteAdministrador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import seahub.trabajofinaltorneo.logica.ParticipanteTorneo;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.logica.Participante;
import seahub.trabajofinaltorneo.logica.ParticipanteEtapa;
import seahub.trabajofinaltorneo.persistencia.exceptions.IllegalOrphanException;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;
import seahub.trabajofinaltorneo.persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author tinov
 */
public class ParticipanteJpaController implements Serializable {

    public ParticipanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public ParticipanteJpaController(){
        emf = Persistence.createEntityManagerFactory("torneoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Participante participante) throws PreexistingEntityException, Exception {
        if (participante.getParticipanteAdministradorCollection() == null) {
            participante.setParticipanteAdministradorCollection(new ArrayList<ParticipanteAdministrador>());
        }
        if (participante.getParticipanteTorneoCollection() == null) {
            participante.setParticipanteTorneoCollection(new ArrayList<ParticipanteTorneo>());
        }
        if (participante.getEtapaCollection() == null) {
            participante.setEtapaCollection(new ArrayList<Etapa>());
        }
        if (participante.getParticipanteEtapaCollection() == null) {
            participante.setParticipanteEtapaCollection(new ArrayList<ParticipanteEtapa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ParticipanteAdministrador> attachedParticipanteAdministradorCollection = new ArrayList<ParticipanteAdministrador>();
            for (ParticipanteAdministrador participanteAdministradorCollectionParticipanteAdministradorToAttach : participante.getParticipanteAdministradorCollection()) {
                participanteAdministradorCollectionParticipanteAdministradorToAttach = em.getReference(participanteAdministradorCollectionParticipanteAdministradorToAttach.getClass(), participanteAdministradorCollectionParticipanteAdministradorToAttach.getIdPA());
                attachedParticipanteAdministradorCollection.add(participanteAdministradorCollectionParticipanteAdministradorToAttach);
            }
            participante.setParticipanteAdministradorCollection(attachedParticipanteAdministradorCollection);
            Collection<ParticipanteTorneo> attachedParticipanteTorneoCollection = new ArrayList<ParticipanteTorneo>();
            for (ParticipanteTorneo participanteTorneoCollectionParticipanteTorneoToAttach : participante.getParticipanteTorneoCollection()) {
                participanteTorneoCollectionParticipanteTorneoToAttach = em.getReference(participanteTorneoCollectionParticipanteTorneoToAttach.getClass(), participanteTorneoCollectionParticipanteTorneoToAttach.getIdPT());
                attachedParticipanteTorneoCollection.add(participanteTorneoCollectionParticipanteTorneoToAttach);
            }
            participante.setParticipanteTorneoCollection(attachedParticipanteTorneoCollection);
            Collection<Etapa> attachedEtapaCollection = new ArrayList<Etapa>();
            for (Etapa etapaCollectionEtapaToAttach : participante.getEtapaCollection()) {
                etapaCollectionEtapaToAttach = em.getReference(etapaCollectionEtapaToAttach.getClass(), etapaCollectionEtapaToAttach.getIdEtapa());
                attachedEtapaCollection.add(etapaCollectionEtapaToAttach);
            }
            participante.setEtapaCollection(attachedEtapaCollection);
            Collection<ParticipanteEtapa> attachedParticipanteEtapaCollection = new ArrayList<ParticipanteEtapa>();
            for (ParticipanteEtapa participanteEtapaCollectionParticipanteEtapaToAttach : participante.getParticipanteEtapaCollection()) {
                participanteEtapaCollectionParticipanteEtapaToAttach = em.getReference(participanteEtapaCollectionParticipanteEtapaToAttach.getClass(), participanteEtapaCollectionParticipanteEtapaToAttach.getIdPE());
                attachedParticipanteEtapaCollection.add(participanteEtapaCollectionParticipanteEtapaToAttach);
            }
            participante.setParticipanteEtapaCollection(attachedParticipanteEtapaCollection);
            em.persist(participante);
            for (ParticipanteAdministrador participanteAdministradorCollectionParticipanteAdministrador : participante.getParticipanteAdministradorCollection()) {
                Participante oldIdParticipanteOfParticipanteAdministradorCollectionParticipanteAdministrador = participanteAdministradorCollectionParticipanteAdministrador.getIdParticipante();
                participanteAdministradorCollectionParticipanteAdministrador.setIdParticipante(participante);
                participanteAdministradorCollectionParticipanteAdministrador = em.merge(participanteAdministradorCollectionParticipanteAdministrador);
                if (oldIdParticipanteOfParticipanteAdministradorCollectionParticipanteAdministrador != null) {
                    oldIdParticipanteOfParticipanteAdministradorCollectionParticipanteAdministrador.getParticipanteAdministradorCollection().remove(participanteAdministradorCollectionParticipanteAdministrador);
                    oldIdParticipanteOfParticipanteAdministradorCollectionParticipanteAdministrador = em.merge(oldIdParticipanteOfParticipanteAdministradorCollectionParticipanteAdministrador);
                }
            }
            for (ParticipanteTorneo participanteTorneoCollectionParticipanteTorneo : participante.getParticipanteTorneoCollection()) {
                Participante oldIdParticipanteOfParticipanteTorneoCollectionParticipanteTorneo = participanteTorneoCollectionParticipanteTorneo.getIdParticipante();
                participanteTorneoCollectionParticipanteTorneo.setIdParticipante(participante);
                participanteTorneoCollectionParticipanteTorneo = em.merge(participanteTorneoCollectionParticipanteTorneo);
                if (oldIdParticipanteOfParticipanteTorneoCollectionParticipanteTorneo != null) {
                    oldIdParticipanteOfParticipanteTorneoCollectionParticipanteTorneo.getParticipanteTorneoCollection().remove(participanteTorneoCollectionParticipanteTorneo);
                    oldIdParticipanteOfParticipanteTorneoCollectionParticipanteTorneo = em.merge(oldIdParticipanteOfParticipanteTorneoCollectionParticipanteTorneo);
                }
            }
            for (Etapa etapaCollectionEtapa : participante.getEtapaCollection()) {
                Participante oldIdParticipanteOfEtapaCollectionEtapa = etapaCollectionEtapa.getIdParticipante();
                etapaCollectionEtapa.setIdParticipante(participante);
                etapaCollectionEtapa = em.merge(etapaCollectionEtapa);
                if (oldIdParticipanteOfEtapaCollectionEtapa != null) {
                    oldIdParticipanteOfEtapaCollectionEtapa.getEtapaCollection().remove(etapaCollectionEtapa);
                    oldIdParticipanteOfEtapaCollectionEtapa = em.merge(oldIdParticipanteOfEtapaCollectionEtapa);
                }
            }
            for (ParticipanteEtapa participanteEtapaCollectionParticipanteEtapa : participante.getParticipanteEtapaCollection()) {
                Participante oldIdParticipanteOfParticipanteEtapaCollectionParticipanteEtapa = participanteEtapaCollectionParticipanteEtapa.getIdParticipante();
                participanteEtapaCollectionParticipanteEtapa.setIdParticipante(participante);
                participanteEtapaCollectionParticipanteEtapa = em.merge(participanteEtapaCollectionParticipanteEtapa);
                if (oldIdParticipanteOfParticipanteEtapaCollectionParticipanteEtapa != null) {
                    oldIdParticipanteOfParticipanteEtapaCollectionParticipanteEtapa.getParticipanteEtapaCollection().remove(participanteEtapaCollectionParticipanteEtapa);
                    oldIdParticipanteOfParticipanteEtapaCollectionParticipanteEtapa = em.merge(oldIdParticipanteOfParticipanteEtapaCollectionParticipanteEtapa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findParticipante(participante.getIdParticipante()) != null) {
                throw new PreexistingEntityException("Participante " + participante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Participante participante) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Participante persistentParticipante = em.find(Participante.class, participante.getIdParticipante());
            Collection<ParticipanteAdministrador> participanteAdministradorCollectionOld = persistentParticipante.getParticipanteAdministradorCollection();
            Collection<ParticipanteAdministrador> participanteAdministradorCollectionNew = participante.getParticipanteAdministradorCollection();
            Collection<ParticipanteTorneo> participanteTorneoCollectionOld = persistentParticipante.getParticipanteTorneoCollection();
            Collection<ParticipanteTorneo> participanteTorneoCollectionNew = participante.getParticipanteTorneoCollection();
            Collection<Etapa> etapaCollectionOld = persistentParticipante.getEtapaCollection();
            Collection<Etapa> etapaCollectionNew = participante.getEtapaCollection();
            Collection<ParticipanteEtapa> participanteEtapaCollectionOld = persistentParticipante.getParticipanteEtapaCollection();
            Collection<ParticipanteEtapa> participanteEtapaCollectionNew = participante.getParticipanteEtapaCollection();
            List<String> illegalOrphanMessages = null;
            for (ParticipanteAdministrador participanteAdministradorCollectionOldParticipanteAdministrador : participanteAdministradorCollectionOld) {
                if (!participanteAdministradorCollectionNew.contains(participanteAdministradorCollectionOldParticipanteAdministrador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ParticipanteAdministrador " + participanteAdministradorCollectionOldParticipanteAdministrador + " since its idParticipante field is not nullable.");
                }
            }
            for (ParticipanteTorneo participanteTorneoCollectionOldParticipanteTorneo : participanteTorneoCollectionOld) {
                if (!participanteTorneoCollectionNew.contains(participanteTorneoCollectionOldParticipanteTorneo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ParticipanteTorneo " + participanteTorneoCollectionOldParticipanteTorneo + " since its idParticipante field is not nullable.");
                }
            }
            for (Etapa etapaCollectionOldEtapa : etapaCollectionOld) {
                if (!etapaCollectionNew.contains(etapaCollectionOldEtapa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Etapa " + etapaCollectionOldEtapa + " since its idParticipante field is not nullable.");
                }
            }
            for (ParticipanteEtapa participanteEtapaCollectionOldParticipanteEtapa : participanteEtapaCollectionOld) {
                if (!participanteEtapaCollectionNew.contains(participanteEtapaCollectionOldParticipanteEtapa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ParticipanteEtapa " + participanteEtapaCollectionOldParticipanteEtapa + " since its idParticipante field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ParticipanteAdministrador> attachedParticipanteAdministradorCollectionNew = new ArrayList<ParticipanteAdministrador>();
            for (ParticipanteAdministrador participanteAdministradorCollectionNewParticipanteAdministradorToAttach : participanteAdministradorCollectionNew) {
                participanteAdministradorCollectionNewParticipanteAdministradorToAttach = em.getReference(participanteAdministradorCollectionNewParticipanteAdministradorToAttach.getClass(), participanteAdministradorCollectionNewParticipanteAdministradorToAttach.getIdPA());
                attachedParticipanteAdministradorCollectionNew.add(participanteAdministradorCollectionNewParticipanteAdministradorToAttach);
            }
            participanteAdministradorCollectionNew = attachedParticipanteAdministradorCollectionNew;
            participante.setParticipanteAdministradorCollection(participanteAdministradorCollectionNew);
            Collection<ParticipanteTorneo> attachedParticipanteTorneoCollectionNew = new ArrayList<ParticipanteTorneo>();
            for (ParticipanteTorneo participanteTorneoCollectionNewParticipanteTorneoToAttach : participanteTorneoCollectionNew) {
                participanteTorneoCollectionNewParticipanteTorneoToAttach = em.getReference(participanteTorneoCollectionNewParticipanteTorneoToAttach.getClass(), participanteTorneoCollectionNewParticipanteTorneoToAttach.getIdPT());
                attachedParticipanteTorneoCollectionNew.add(participanteTorneoCollectionNewParticipanteTorneoToAttach);
            }
            participanteTorneoCollectionNew = attachedParticipanteTorneoCollectionNew;
            participante.setParticipanteTorneoCollection(participanteTorneoCollectionNew);
            Collection<Etapa> attachedEtapaCollectionNew = new ArrayList<Etapa>();
            for (Etapa etapaCollectionNewEtapaToAttach : etapaCollectionNew) {
                etapaCollectionNewEtapaToAttach = em.getReference(etapaCollectionNewEtapaToAttach.getClass(), etapaCollectionNewEtapaToAttach.getIdEtapa());
                attachedEtapaCollectionNew.add(etapaCollectionNewEtapaToAttach);
            }
            etapaCollectionNew = attachedEtapaCollectionNew;
            participante.setEtapaCollection(etapaCollectionNew);
            Collection<ParticipanteEtapa> attachedParticipanteEtapaCollectionNew = new ArrayList<ParticipanteEtapa>();
            for (ParticipanteEtapa participanteEtapaCollectionNewParticipanteEtapaToAttach : participanteEtapaCollectionNew) {
                participanteEtapaCollectionNewParticipanteEtapaToAttach = em.getReference(participanteEtapaCollectionNewParticipanteEtapaToAttach.getClass(), participanteEtapaCollectionNewParticipanteEtapaToAttach.getIdPE());
                attachedParticipanteEtapaCollectionNew.add(participanteEtapaCollectionNewParticipanteEtapaToAttach);
            }
            participanteEtapaCollectionNew = attachedParticipanteEtapaCollectionNew;
            participante.setParticipanteEtapaCollection(participanteEtapaCollectionNew);
            participante = em.merge(participante);
            for (ParticipanteAdministrador participanteAdministradorCollectionNewParticipanteAdministrador : participanteAdministradorCollectionNew) {
                if (!participanteAdministradorCollectionOld.contains(participanteAdministradorCollectionNewParticipanteAdministrador)) {
                    Participante oldIdParticipanteOfParticipanteAdministradorCollectionNewParticipanteAdministrador = participanteAdministradorCollectionNewParticipanteAdministrador.getIdParticipante();
                    participanteAdministradorCollectionNewParticipanteAdministrador.setIdParticipante(participante);
                    participanteAdministradorCollectionNewParticipanteAdministrador = em.merge(participanteAdministradorCollectionNewParticipanteAdministrador);
                    if (oldIdParticipanteOfParticipanteAdministradorCollectionNewParticipanteAdministrador != null && !oldIdParticipanteOfParticipanteAdministradorCollectionNewParticipanteAdministrador.equals(participante)) {
                        oldIdParticipanteOfParticipanteAdministradorCollectionNewParticipanteAdministrador.getParticipanteAdministradorCollection().remove(participanteAdministradorCollectionNewParticipanteAdministrador);
                        oldIdParticipanteOfParticipanteAdministradorCollectionNewParticipanteAdministrador = em.merge(oldIdParticipanteOfParticipanteAdministradorCollectionNewParticipanteAdministrador);
                    }
                }
            }
            for (ParticipanteTorneo participanteTorneoCollectionNewParticipanteTorneo : participanteTorneoCollectionNew) {
                if (!participanteTorneoCollectionOld.contains(participanteTorneoCollectionNewParticipanteTorneo)) {
                    Participante oldIdParticipanteOfParticipanteTorneoCollectionNewParticipanteTorneo = participanteTorneoCollectionNewParticipanteTorneo.getIdParticipante();
                    participanteTorneoCollectionNewParticipanteTorneo.setIdParticipante(participante);
                    participanteTorneoCollectionNewParticipanteTorneo = em.merge(participanteTorneoCollectionNewParticipanteTorneo);
                    if (oldIdParticipanteOfParticipanteTorneoCollectionNewParticipanteTorneo != null && !oldIdParticipanteOfParticipanteTorneoCollectionNewParticipanteTorneo.equals(participante)) {
                        oldIdParticipanteOfParticipanteTorneoCollectionNewParticipanteTorneo.getParticipanteTorneoCollection().remove(participanteTorneoCollectionNewParticipanteTorneo);
                        oldIdParticipanteOfParticipanteTorneoCollectionNewParticipanteTorneo = em.merge(oldIdParticipanteOfParticipanteTorneoCollectionNewParticipanteTorneo);
                    }
                }
            }
            for (Etapa etapaCollectionNewEtapa : etapaCollectionNew) {
                if (!etapaCollectionOld.contains(etapaCollectionNewEtapa)) {
                    Participante oldIdParticipanteOfEtapaCollectionNewEtapa = etapaCollectionNewEtapa.getIdParticipante();
                    etapaCollectionNewEtapa.setIdParticipante(participante);
                    etapaCollectionNewEtapa = em.merge(etapaCollectionNewEtapa);
                    if (oldIdParticipanteOfEtapaCollectionNewEtapa != null && !oldIdParticipanteOfEtapaCollectionNewEtapa.equals(participante)) {
                        oldIdParticipanteOfEtapaCollectionNewEtapa.getEtapaCollection().remove(etapaCollectionNewEtapa);
                        oldIdParticipanteOfEtapaCollectionNewEtapa = em.merge(oldIdParticipanteOfEtapaCollectionNewEtapa);
                    }
                }
            }
            for (ParticipanteEtapa participanteEtapaCollectionNewParticipanteEtapa : participanteEtapaCollectionNew) {
                if (!participanteEtapaCollectionOld.contains(participanteEtapaCollectionNewParticipanteEtapa)) {
                    Participante oldIdParticipanteOfParticipanteEtapaCollectionNewParticipanteEtapa = participanteEtapaCollectionNewParticipanteEtapa.getIdParticipante();
                    participanteEtapaCollectionNewParticipanteEtapa.setIdParticipante(participante);
                    participanteEtapaCollectionNewParticipanteEtapa = em.merge(participanteEtapaCollectionNewParticipanteEtapa);
                    if (oldIdParticipanteOfParticipanteEtapaCollectionNewParticipanteEtapa != null && !oldIdParticipanteOfParticipanteEtapaCollectionNewParticipanteEtapa.equals(participante)) {
                        oldIdParticipanteOfParticipanteEtapaCollectionNewParticipanteEtapa.getParticipanteEtapaCollection().remove(participanteEtapaCollectionNewParticipanteEtapa);
                        oldIdParticipanteOfParticipanteEtapaCollectionNewParticipanteEtapa = em.merge(oldIdParticipanteOfParticipanteEtapaCollectionNewParticipanteEtapa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = participante.getIdParticipante();
                if (findParticipante(id) == null) {
                    throw new NonexistentEntityException("The participante with id " + id + " no longer exists.");
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
            Participante participante;
            try {
                participante = em.getReference(Participante.class, id);
                participante.getIdParticipante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The participante with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ParticipanteAdministrador> participanteAdministradorCollectionOrphanCheck = participante.getParticipanteAdministradorCollection();
            for (ParticipanteAdministrador participanteAdministradorCollectionOrphanCheckParticipanteAdministrador : participanteAdministradorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Participante (" + participante + ") cannot be destroyed since the ParticipanteAdministrador " + participanteAdministradorCollectionOrphanCheckParticipanteAdministrador + " in its participanteAdministradorCollection field has a non-nullable idParticipante field.");
            }
            Collection<ParticipanteTorneo> participanteTorneoCollectionOrphanCheck = participante.getParticipanteTorneoCollection();
            for (ParticipanteTorneo participanteTorneoCollectionOrphanCheckParticipanteTorneo : participanteTorneoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Participante (" + participante + ") cannot be destroyed since the ParticipanteTorneo " + participanteTorneoCollectionOrphanCheckParticipanteTorneo + " in its participanteTorneoCollection field has a non-nullable idParticipante field.");
            }
            Collection<Etapa> etapaCollectionOrphanCheck = participante.getEtapaCollection();
            for (Etapa etapaCollectionOrphanCheckEtapa : etapaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Participante (" + participante + ") cannot be destroyed since the Etapa " + etapaCollectionOrphanCheckEtapa + " in its etapaCollection field has a non-nullable idParticipante field.");
            }
            Collection<ParticipanteEtapa> participanteEtapaCollectionOrphanCheck = participante.getParticipanteEtapaCollection();
            for (ParticipanteEtapa participanteEtapaCollectionOrphanCheckParticipanteEtapa : participanteEtapaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Participante (" + participante + ") cannot be destroyed since the ParticipanteEtapa " + participanteEtapaCollectionOrphanCheckParticipanteEtapa + " in its participanteEtapaCollection field has a non-nullable idParticipante field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(participante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Participante> findParticipanteEntities() {
        return findParticipanteEntities(true, -1, -1);
    }

    public List<Participante> findParticipanteEntities(int maxResults, int firstResult) {
        return findParticipanteEntities(false, maxResults, firstResult);
    }

    private List<Participante> findParticipanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Participante.class));
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

    public Participante findParticipante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Participante.class, id);
        } finally {
            em.close();
        }
    }

    public int getParticipanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Participante> rt = cq.from(Participante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
