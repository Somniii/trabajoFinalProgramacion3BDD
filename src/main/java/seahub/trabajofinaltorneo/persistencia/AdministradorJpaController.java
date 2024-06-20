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
import seahub.trabajofinaltorneo.logica.Torneo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import seahub.trabajofinaltorneo.logica.Administrador;
import seahub.trabajofinaltorneo.logica.ParticipanteAdministrador;
import seahub.trabajofinaltorneo.logica.Etapa;
import seahub.trabajofinaltorneo.persistencia.exceptions.IllegalOrphanException;
import seahub.trabajofinaltorneo.persistencia.exceptions.NonexistentEntityException;
import seahub.trabajofinaltorneo.persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author tinov
 */
public class AdministradorJpaController implements Serializable {

    public AdministradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public AdministradorJpaController(){
        emf = Persistence.createEntityManagerFactory("torneoJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrador administrador) throws PreexistingEntityException, Exception {
        if (administrador.getTorneoCollection() == null) {
            administrador.setTorneoCollection(new ArrayList<Torneo>());
        }
        if (administrador.getParticipanteAdministradorCollection() == null) {
            administrador.setParticipanteAdministradorCollection(new ArrayList<ParticipanteAdministrador>());
        }
        if (administrador.getEtapaCollection() == null) {
            administrador.setEtapaCollection(new ArrayList<Etapa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Torneo> attachedTorneoCollection = new ArrayList<Torneo>();
            for (Torneo torneoCollectionTorneoToAttach : administrador.getTorneoCollection()) {
                torneoCollectionTorneoToAttach = em.getReference(torneoCollectionTorneoToAttach.getClass(), torneoCollectionTorneoToAttach.getIdTorneo());
                attachedTorneoCollection.add(torneoCollectionTorneoToAttach);
            }
            administrador.setTorneoCollection(attachedTorneoCollection);
            Collection<ParticipanteAdministrador> attachedParticipanteAdministradorCollection = new ArrayList<ParticipanteAdministrador>();
            for (ParticipanteAdministrador participanteAdministradorCollectionParticipanteAdministradorToAttach : administrador.getParticipanteAdministradorCollection()) {
                participanteAdministradorCollectionParticipanteAdministradorToAttach = em.getReference(participanteAdministradorCollectionParticipanteAdministradorToAttach.getClass(), participanteAdministradorCollectionParticipanteAdministradorToAttach.getIdPA());
                attachedParticipanteAdministradorCollection.add(participanteAdministradorCollectionParticipanteAdministradorToAttach);
            }
            administrador.setParticipanteAdministradorCollection(attachedParticipanteAdministradorCollection);
            Collection<Etapa> attachedEtapaCollection = new ArrayList<Etapa>();
            for (Etapa etapaCollectionEtapaToAttach : administrador.getEtapaCollection()) {
                etapaCollectionEtapaToAttach = em.getReference(etapaCollectionEtapaToAttach.getClass(), etapaCollectionEtapaToAttach.getIdEtapa());
                attachedEtapaCollection.add(etapaCollectionEtapaToAttach);
            }
            administrador.setEtapaCollection(attachedEtapaCollection);
            em.persist(administrador);
            for (Torneo torneoCollectionTorneo : administrador.getTorneoCollection()) {
                Administrador oldIdAdministradorOfTorneoCollectionTorneo = torneoCollectionTorneo.getIdAdministrador();
                torneoCollectionTorneo.setIdAdministrador(administrador);
                torneoCollectionTorneo = em.merge(torneoCollectionTorneo);
                if (oldIdAdministradorOfTorneoCollectionTorneo != null) {
                    oldIdAdministradorOfTorneoCollectionTorneo.getTorneoCollection().remove(torneoCollectionTorneo);
                    oldIdAdministradorOfTorneoCollectionTorneo = em.merge(oldIdAdministradorOfTorneoCollectionTorneo);
                }
            }
            for (ParticipanteAdministrador participanteAdministradorCollectionParticipanteAdministrador : administrador.getParticipanteAdministradorCollection()) {
                Administrador oldIdAdministradorOfParticipanteAdministradorCollectionParticipanteAdministrador = participanteAdministradorCollectionParticipanteAdministrador.getIdAdministrador();
                participanteAdministradorCollectionParticipanteAdministrador.setIdAdministrador(administrador);
                participanteAdministradorCollectionParticipanteAdministrador = em.merge(participanteAdministradorCollectionParticipanteAdministrador);
                if (oldIdAdministradorOfParticipanteAdministradorCollectionParticipanteAdministrador != null) {
                    oldIdAdministradorOfParticipanteAdministradorCollectionParticipanteAdministrador.getParticipanteAdministradorCollection().remove(participanteAdministradorCollectionParticipanteAdministrador);
                    oldIdAdministradorOfParticipanteAdministradorCollectionParticipanteAdministrador = em.merge(oldIdAdministradorOfParticipanteAdministradorCollectionParticipanteAdministrador);
                }
            }
            for (Etapa etapaCollectionEtapa : administrador.getEtapaCollection()) {
                Administrador oldIdAdministradorOfEtapaCollectionEtapa = etapaCollectionEtapa.getIdAdministrador();
                etapaCollectionEtapa.setIdAdministrador(administrador);
                etapaCollectionEtapa = em.merge(etapaCollectionEtapa);
                if (oldIdAdministradorOfEtapaCollectionEtapa != null) {
                    oldIdAdministradorOfEtapaCollectionEtapa.getEtapaCollection().remove(etapaCollectionEtapa);
                    oldIdAdministradorOfEtapaCollectionEtapa = em.merge(oldIdAdministradorOfEtapaCollectionEtapa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdministrador(administrador.getIdAdministrador()) != null) {
                throw new PreexistingEntityException("Administrador " + administrador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administrador administrador) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador persistentAdministrador = em.find(Administrador.class, administrador.getIdAdministrador());
            Collection<Torneo> torneoCollectionOld = persistentAdministrador.getTorneoCollection();
            Collection<Torneo> torneoCollectionNew = administrador.getTorneoCollection();
            Collection<ParticipanteAdministrador> participanteAdministradorCollectionOld = persistentAdministrador.getParticipanteAdministradorCollection();
            Collection<ParticipanteAdministrador> participanteAdministradorCollectionNew = administrador.getParticipanteAdministradorCollection();
            Collection<Etapa> etapaCollectionOld = persistentAdministrador.getEtapaCollection();
            Collection<Etapa> etapaCollectionNew = administrador.getEtapaCollection();
            List<String> illegalOrphanMessages = null;
            for (Torneo torneoCollectionOldTorneo : torneoCollectionOld) {
                if (!torneoCollectionNew.contains(torneoCollectionOldTorneo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Torneo " + torneoCollectionOldTorneo + " since its idAdministrador field is not nullable.");
                }
            }
            for (ParticipanteAdministrador participanteAdministradorCollectionOldParticipanteAdministrador : participanteAdministradorCollectionOld) {
                if (!participanteAdministradorCollectionNew.contains(participanteAdministradorCollectionOldParticipanteAdministrador)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ParticipanteAdministrador " + participanteAdministradorCollectionOldParticipanteAdministrador + " since its idAdministrador field is not nullable.");
                }
            }
            for (Etapa etapaCollectionOldEtapa : etapaCollectionOld) {
                if (!etapaCollectionNew.contains(etapaCollectionOldEtapa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Etapa " + etapaCollectionOldEtapa + " since its idAdministrador field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Torneo> attachedTorneoCollectionNew = new ArrayList<Torneo>();
            for (Torneo torneoCollectionNewTorneoToAttach : torneoCollectionNew) {
                torneoCollectionNewTorneoToAttach = em.getReference(torneoCollectionNewTorneoToAttach.getClass(), torneoCollectionNewTorneoToAttach.getIdTorneo());
                attachedTorneoCollectionNew.add(torneoCollectionNewTorneoToAttach);
            }
            torneoCollectionNew = attachedTorneoCollectionNew;
            administrador.setTorneoCollection(torneoCollectionNew);
            Collection<ParticipanteAdministrador> attachedParticipanteAdministradorCollectionNew = new ArrayList<ParticipanteAdministrador>();
            for (ParticipanteAdministrador participanteAdministradorCollectionNewParticipanteAdministradorToAttach : participanteAdministradorCollectionNew) {
                participanteAdministradorCollectionNewParticipanteAdministradorToAttach = em.getReference(participanteAdministradorCollectionNewParticipanteAdministradorToAttach.getClass(), participanteAdministradorCollectionNewParticipanteAdministradorToAttach.getIdPA());
                attachedParticipanteAdministradorCollectionNew.add(participanteAdministradorCollectionNewParticipanteAdministradorToAttach);
            }
            participanteAdministradorCollectionNew = attachedParticipanteAdministradorCollectionNew;
            administrador.setParticipanteAdministradorCollection(participanteAdministradorCollectionNew);
            Collection<Etapa> attachedEtapaCollectionNew = new ArrayList<Etapa>();
            for (Etapa etapaCollectionNewEtapaToAttach : etapaCollectionNew) {
                etapaCollectionNewEtapaToAttach = em.getReference(etapaCollectionNewEtapaToAttach.getClass(), etapaCollectionNewEtapaToAttach.getIdEtapa());
                attachedEtapaCollectionNew.add(etapaCollectionNewEtapaToAttach);
            }
            etapaCollectionNew = attachedEtapaCollectionNew;
            administrador.setEtapaCollection(etapaCollectionNew);
            administrador = em.merge(administrador);
            for (Torneo torneoCollectionNewTorneo : torneoCollectionNew) {
                if (!torneoCollectionOld.contains(torneoCollectionNewTorneo)) {
                    Administrador oldIdAdministradorOfTorneoCollectionNewTorneo = torneoCollectionNewTorneo.getIdAdministrador();
                    torneoCollectionNewTorneo.setIdAdministrador(administrador);
                    torneoCollectionNewTorneo = em.merge(torneoCollectionNewTorneo);
                    if (oldIdAdministradorOfTorneoCollectionNewTorneo != null && !oldIdAdministradorOfTorneoCollectionNewTorneo.equals(administrador)) {
                        oldIdAdministradorOfTorneoCollectionNewTorneo.getTorneoCollection().remove(torneoCollectionNewTorneo);
                        oldIdAdministradorOfTorneoCollectionNewTorneo = em.merge(oldIdAdministradorOfTorneoCollectionNewTorneo);
                    }
                }
            }
            for (ParticipanteAdministrador participanteAdministradorCollectionNewParticipanteAdministrador : participanteAdministradorCollectionNew) {
                if (!participanteAdministradorCollectionOld.contains(participanteAdministradorCollectionNewParticipanteAdministrador)) {
                    Administrador oldIdAdministradorOfParticipanteAdministradorCollectionNewParticipanteAdministrador = participanteAdministradorCollectionNewParticipanteAdministrador.getIdAdministrador();
                    participanteAdministradorCollectionNewParticipanteAdministrador.setIdAdministrador(administrador);
                    participanteAdministradorCollectionNewParticipanteAdministrador = em.merge(participanteAdministradorCollectionNewParticipanteAdministrador);
                    if (oldIdAdministradorOfParticipanteAdministradorCollectionNewParticipanteAdministrador != null && !oldIdAdministradorOfParticipanteAdministradorCollectionNewParticipanteAdministrador.equals(administrador)) {
                        oldIdAdministradorOfParticipanteAdministradorCollectionNewParticipanteAdministrador.getParticipanteAdministradorCollection().remove(participanteAdministradorCollectionNewParticipanteAdministrador);
                        oldIdAdministradorOfParticipanteAdministradorCollectionNewParticipanteAdministrador = em.merge(oldIdAdministradorOfParticipanteAdministradorCollectionNewParticipanteAdministrador);
                    }
                }
            }
            for (Etapa etapaCollectionNewEtapa : etapaCollectionNew) {
                if (!etapaCollectionOld.contains(etapaCollectionNewEtapa)) {
                    Administrador oldIdAdministradorOfEtapaCollectionNewEtapa = etapaCollectionNewEtapa.getIdAdministrador();
                    etapaCollectionNewEtapa.setIdAdministrador(administrador);
                    etapaCollectionNewEtapa = em.merge(etapaCollectionNewEtapa);
                    if (oldIdAdministradorOfEtapaCollectionNewEtapa != null && !oldIdAdministradorOfEtapaCollectionNewEtapa.equals(administrador)) {
                        oldIdAdministradorOfEtapaCollectionNewEtapa.getEtapaCollection().remove(etapaCollectionNewEtapa);
                        oldIdAdministradorOfEtapaCollectionNewEtapa = em.merge(oldIdAdministradorOfEtapaCollectionNewEtapa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = administrador.getIdAdministrador();
                if (findAdministrador(id) == null) {
                    throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.");
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
            Administrador administrador;
            try {
                administrador = em.getReference(Administrador.class, id);
                administrador.getIdAdministrador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Torneo> torneoCollectionOrphanCheck = administrador.getTorneoCollection();
            for (Torneo torneoCollectionOrphanCheckTorneo : torneoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Administrador (" + administrador + ") cannot be destroyed since the Torneo " + torneoCollectionOrphanCheckTorneo + " in its torneoCollection field has a non-nullable idAdministrador field.");
            }
            Collection<ParticipanteAdministrador> participanteAdministradorCollectionOrphanCheck = administrador.getParticipanteAdministradorCollection();
            for (ParticipanteAdministrador participanteAdministradorCollectionOrphanCheckParticipanteAdministrador : participanteAdministradorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Administrador (" + administrador + ") cannot be destroyed since the ParticipanteAdministrador " + participanteAdministradorCollectionOrphanCheckParticipanteAdministrador + " in its participanteAdministradorCollection field has a non-nullable idAdministrador field.");
            }
            Collection<Etapa> etapaCollectionOrphanCheck = administrador.getEtapaCollection();
            for (Etapa etapaCollectionOrphanCheckEtapa : etapaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Administrador (" + administrador + ") cannot be destroyed since the Etapa " + etapaCollectionOrphanCheckEtapa + " in its etapaCollection field has a non-nullable idAdministrador field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(administrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Administrador> findAdministradorEntities() {
        return findAdministradorEntities(true, -1, -1);
    }

    public List<Administrador> findAdministradorEntities(int maxResults, int firstResult) {
        return findAdministradorEntities(false, maxResults, firstResult);
    }

    private List<Administrador> findAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrador.class));
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

    public Administrador findAdministrador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrador> rt = cq.from(Administrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
