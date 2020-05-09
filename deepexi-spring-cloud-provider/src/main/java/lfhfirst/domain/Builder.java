package lfhfirst.domain;
import lfhfirst.domain.entity.User;
import lfhfirst.manager.UserManager;
import lfhfirst.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 实体工厂类
 */
@Component
public class Builder {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserManager userManager;

    public User buildUser(Integer i) {
        return new User(i, userRepository);
    }


}
