package co.iichi.shrine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by sat8bit on 2016/07/10.
 */
@ComponentScan
@EnableAutoConfiguration
public class TestApplication {

    @Bean(name = "shrineUnit")
    public EntityManagerFactory entityManager() {
        return Persistence.createEntityManagerFactory("shrineUnit");
    }
}
