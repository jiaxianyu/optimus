package lfhfirst.manager;

import lfhfirst.domain.Builder;
import lfhfirst.domain.entity.User;
import lfhfirst.repo.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;

@Component
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Builder builder;

    public User current() {
        return builder.buildUser(1);
    }

    @Data
    public static class UserQuery{
        private String name;
        private String tel;
    }

}
