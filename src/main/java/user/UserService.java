package user;

import user.model.User;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class UserService {
    @Inject
    EntityManager entityManager;

    public List<User> getUsers() {
        return entityManager.createQuery("SELECT users FROM User users ", User.class).getResultList();
    }

    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }
}
