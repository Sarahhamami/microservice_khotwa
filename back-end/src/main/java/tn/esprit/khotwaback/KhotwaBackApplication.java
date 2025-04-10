package tn.esprit.khotwaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

@SpringBootApplication
=======
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
>>>>>>> origin/Cours-management
public class KhotwaBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhotwaBackApplication.class, args);
    }

}
