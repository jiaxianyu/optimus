package lfhfirst.repo;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;


@Repository
public class ProjectRepository implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
