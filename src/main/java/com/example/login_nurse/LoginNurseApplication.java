package com.example.login_nurse;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_nurse.DaoJson;
import com.example.login_nurse.Nurse;

@SpringBootApplication
@RestController
public class LoginNurseApplication {
    public static void main(String[] args) {
      SpringApplication.run(LoginNurseApplication.class, args);
    }
    @GetMapping("/log_in")
    public boolean log_in(
    		@RequestParam(value = "user", defaultValue = "") String name,
    		@RequestParam(value = "pw", defaultValue = "") String pw
    		) throws IllegalArgumentException, IOException {
    	
      DaoJson dao = new DaoJson ();
      
      ArrayList<Nurse> nurses = new ArrayList<Nurse>();
      
      nurses = dao.readFile();
      
      boolean loggedin=false;
      
      Nurse loggedinNurse;
      
      for(Nurse nurse: nurses) {
    	  if(nurse.getUser().equals(name)&&nurse.getPw().equals(pw)) {
    		  loggedin=true;
    		  loggedinNurse=nurse;
    	  }else {
    		  
    	  }
      }
      
      return loggedin;
      
      
      
      
      
    }
}