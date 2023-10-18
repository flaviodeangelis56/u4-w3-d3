package flaviodeangelis.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location l) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(l);
        transaction.commit();
        System.out.println("La location" + l + "salvata nel DB in modo corretto");
    }

    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    public void delate(long id) {
        Location eventoById = em.find(Location.class, id);
        if (eventoById != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(eventoById);
            transaction.commit();
        } else {
            System.err.println("Location con id" + id + "non esistente");
        }
    }

    public void refresh(Location e) {
        em.refresh(e);
    }
}
