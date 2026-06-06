package com.example.Basics.service;

import com.example.Basics.entity.UserEntry;
import com.example.Basics.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserService {
    @Autowired
    private UserRepo urepo;
    public List<UserEntry> data(){
      return urepo.findAll();
    }
    public void entry(UserEntry ue){
        urepo.save(ue);
    }
    public UserEntry findByName(String username){
return urepo.findByUsername(username);

    }

}
