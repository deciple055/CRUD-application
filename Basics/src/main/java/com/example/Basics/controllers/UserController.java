package com.example.Basics.controllers;

import com.example.Basics.entity.JournalEntry;
import com.example.Basics.entity.UserEntry;
import com.example.Basics.service.AppService;
import com.example.Basics.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService uservice;
    @Autowired
    private AppService app;
    @PostMapping("/userentry")
    public ResponseEntity<?> entries(@RequestBody UserEntry use){
        uservice.entry(use);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/getuser")
   public List<UserEntry> getdata(){
        return uservice.data();
    }
}
