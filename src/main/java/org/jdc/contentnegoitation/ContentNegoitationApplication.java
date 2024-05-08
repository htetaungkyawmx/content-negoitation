package org.jdc.contentnegoitation;

import lombok.RequiredArgsConstructor;
import org.jdc.contentnegoitation.dao.CustomerDao;
import org.jdc.contentnegoitation.entity.Customer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class ContentNegoitationApplication {
    private final CustomerDao customerDao;
    @Bean @Transactional @Profile("dev")
    public ApplicationRunner runner(){
        return r ->{
            Customer c1=new Customer("John","Doe","john@gmial.com");
            Customer c2=new Customer("John","William","william@gmial.com");
            Customer c3=new Customer("John","Updike","updike@gmial.com");
            customerDao.save(c1);
            customerDao.save(c2);
            customerDao.save(c3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ContentNegoitationApplication.class, args);
    }

}
