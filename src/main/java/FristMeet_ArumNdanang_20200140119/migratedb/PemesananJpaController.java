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
public class PemesananJpaController implements Serializable {

    public PemesananJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FristMeet_ArumNdanang_20200140119_migratedb_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pemesanan pemesanan) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pemesanan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPemesanan(pemesanan.getIdPesan()) != null) {
                throw new PreexistingEntityException("Pemesanan " + pemesanan + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pemesanan pemesanan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pemesanan = em.merge(pemesanan);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pemesanan.getIdPesan();
                if (findPemesanan(id) == null) {
                    throw new NonexistentEntityException("The pemesanan with id " + id + " no longer exists.");
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
            Pemesanan pemesanan;
            try {
                pemesanan = em.getReference(Pemesanan.class, id);
                pemesanan.getIdPesan();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pemesanan with id " + id + " no longer exists.", enfe);
            }
            em.remove(pemesanan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pemesanan> findPemesananEntities() {
        return findPemesananEntities(true, -1, -1);
    }

    public List<Pemesanan> findPemesananEntities(int maxResults, int firstResult) {
        return findPemesananEntities(false, maxResults, firstResult);
    }

    private List<Pemesanan> findPemesananEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pemesanan.class));
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

    public Pemesanan findPemesanan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pemesanan.class, id);
        } finally {
            em.close();
        }
    }

    public int getPemesananCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pemesanan> rt = cq.from(Pemesanan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
