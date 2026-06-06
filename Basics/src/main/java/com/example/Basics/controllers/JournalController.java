package com.example.Basics.controllers;

import com.example.Basics.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Basics.service.AppService;

import java.util.List;

@RestController
@RequestMapping("/Journal")
public class JournalController {
    @Autowired
    private AppService service;
    @GetMapping("/getdata")
    public List<JournalEntry> get(){
        return service.getall();
    }
    @GetMapping("/getuserdata/{username}")
    public List<JournalEntry> userdata(@PathVariable String username){
        return service.getUserData(username);
    }
    @PostMapping("/entry/{username}")
      public String posting(@RequestBody JournalEntry je,@PathVariable String username){
        service.inputData(je,username);
        return "Done";
    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updating (@RequestBody JournalEntry je,@PathVariable ObjectId id){
//        JournalEntry Old =service.findById(id).orElse(null);
//    Old.setTitle((je.getTitle()!=null && !je.getTitle().equals(""))?je.getTitle():Old.getTitle());
//    Old.setContent((je.getContent()!=null && !je.getContent().equals(""))?je.getContent():Old.getContent());
//    service.inputData(Old);
//    return new ResponseEntity<>(HttpStatus.ACCEPTED);
        //}
    }


