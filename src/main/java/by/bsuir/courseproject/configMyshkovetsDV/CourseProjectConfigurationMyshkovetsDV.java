package by.bsuir.courseproject.configMyshkovetsDV;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.bsuir.courseproject.repositoryMyshkovetsDV.BankOrderRepositoryImplMyshkovetsDV;
import by.bsuir.courseproject.repositoryMyshkovetsDV.BankOrderRepositoryMyshkovetsDV;
import by.bsuir.courseproject.repositoryMyshkovetsDV.UserRepositoryImplMyshkovetsDV;
import by.bsuir.courseproject.repositoryMyshkovetsDV.UserRepositoryMyshkovetsDV;
import by.bsuir.courseproject.serviceMyshkovetsDV.CourseProjectServiceImplMyshkovetsDV;

@Configuration
public class CourseProjectConfigurationMyshkovetsDV {

    @Bean
    public UserRepositoryImplMyshkovetsDV userRepository(EntityManager entityManager){
        return new UserRepositoryImplMyshkovetsDV(entityManager);
    }

    @Bean
    public BankOrderRepositoryMyshkovetsDV orderRepository(EntityManager entityManager){
        return new BankOrderRepositoryImplMyshkovetsDV(entityManager);
    }

    @Bean("courseProjectService")
    public CourseProjectServiceImplMyshkovetsDV courseProjectService(
        UserRepositoryMyshkovetsDV userRepository, BankOrderRepositoryMyshkovetsDV orderRepository){

        return new CourseProjectServiceImplMyshkovetsDV(userRepository, orderRepository);
    }

}
