package flaviodeangelis.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione l) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(l);
        transaction.commit();
        System.out.println("La Partecipazione" + l + "salvata nel DB in modo corretto");
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delate(long id) {
        Partecipazione eventoById = em.find(Partecipazione.class, id);
        if (eventoById != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(eventoById);
            transaction.commit();
        } else {
            System.err.println("Partecipazione con id" + id + "non esistente");
        }
    }
}
