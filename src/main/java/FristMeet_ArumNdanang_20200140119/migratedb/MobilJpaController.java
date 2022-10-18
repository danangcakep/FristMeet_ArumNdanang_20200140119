/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FristMeet_ArumNdanang_20200140119.migratedb;

import FristMeet_ArumNdanang_20200140119.migratedb.exceptions.NonexistentEntityException;
import FristMeet_ArumNdanang_20200140119.migratedb.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Microsoft
 */
public class MobilJpaController implements Serializable {

    public MobilJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FristMeet_ArumNdanang_20200140119_migratedb_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mobil mobil) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mobil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMobil(mobil.getIdMobil()) != null) {
                throw new PreexistingEntityException("Mobil " + mobil + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mobil mobil) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mobil = em.merge(mobil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mobil.getIdMobil();
                if (findMobil(id) == null) {
                    throw new NonexistentEntityException("The mobil with id " + id + " no longer exists.");
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
            Mobil mobil;
            try {
                mobil = em.getReference(Mobil.class, id);
                mobil.getIdMobil();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mobil with id " + id + " no longer exists.", enfe);
            }
            em.remove(mobil);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mobil> findMobilEntities() {
        return findMobilEntities(true, -1, -1);
    }

    public List<Mobil> findMobilEntities(int maxResults, int firstResult) {
        return findMobilEntities(false, maxResults, firstResult);
    }

    private List<Mobil> findMobilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mobil.class));
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

    public Mobil findMobil(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mobil.class, id);
        } finally {
            em.close();
        }
    }

    public int getMobilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mobil> rt = cq.from(Mobil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
