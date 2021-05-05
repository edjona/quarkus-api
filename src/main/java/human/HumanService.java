package human;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class HumanService {
    private final HumanRepository humanRepository;

    @Inject
    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public void createHuman(Human human) {
        humanRepository.createHuman(human);
    }

    public List<Human> getHumans() {
        return humanRepository.getHumans();
    }
}
