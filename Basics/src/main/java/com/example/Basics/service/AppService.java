package com.example.Basics.service;

import com.example.Basics.entity.JournalEntry;
import com.example.Basics.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.Basics.repository.JournalRepo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class AppService {
    @Autowired
   private JournalRepo jrepo;
    @Autowired
    private UserService uservice;
   public List<JournalEntry> getall(){
       return jrepo.findAll();
   }
 @Transactional
   public void inputData(JournalEntry entry,String username){
    try{   UserEntry use=uservice.findByName(username);
     JournalEntry jre=  jrepo.save(entry);
use.getJrEntries().add(jre);
uservice.entry(use);}
    catch(Exception e){
        throw  new RuntimeException("there is an exception while running",e);
    }
   }
   public List<JournalEntry> getUserData(String username){
      UserEntry ue= uservice.findByName(username);
       return ue.getJrEntries();
   }
   public Optional<JournalEntry> findById(ObjectId id){
      return jrepo.findById(id);
   }
}
