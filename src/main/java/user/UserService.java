package user;

import user.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserService {
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
