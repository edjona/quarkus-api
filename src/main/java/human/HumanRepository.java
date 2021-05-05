package human;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class HumanRepository {
    @Inject
    EntityManager entityManager;

    public List<Human> getHumans() {
        return entityManager.createQuery("SELECT humans FROM Human humans ", Human.class).getResultList();
    }

    @Transactional
    public void createHuman(Human human) {
        entityManager.persist(human);
    }
}
