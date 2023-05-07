package com.spe.jairu;

import com.spe.jairu.service.init.AddAdmin;
import com.spe.jairu.service.init.AddAdminImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JairuApplication {
    public static void main(String[] args) {
        SpringApplication.run(JairuApplication.class, args);
        AddAdminImpl addAdmin = new AddAdminImpl();
        try{
            addAdmin.postToApi();
        }
        catch(Exception e){
            System.out.println("e = " + e);
        }
    }
}
