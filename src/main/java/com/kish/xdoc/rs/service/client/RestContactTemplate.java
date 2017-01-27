package com.kish.xdoc.rs.service.client;

import com.kish.xdoc.dbo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by ThejKishore on 1/3/2017.
 */
@Component
public class RestContactTemplate {

    private static final String GET_CONTACTS = "http://localhost:9090/Contacts";


    public Contact[] getContacts(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(GET_CONTACTS,Contact[].class);
    }


}
