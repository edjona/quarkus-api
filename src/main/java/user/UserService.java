package user;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class UserService {
    public List<User> getUsers() {
        return User.getUsers();
    }

    public User getUser(long id) {
        return User.getUser(id);
    }

    @Transactional
    public void createUser(User user) {
        user.persist();
    }
}
