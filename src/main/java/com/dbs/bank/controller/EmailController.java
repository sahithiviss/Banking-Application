package com.dbs.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.bank.service.EmailService;

@RestController
@RequestMapping("/api/v1")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
   @GetMapping(value = "/sendemail")
   public String sendEmail() {
	   this.emailService.sendMail("sahithivsl@gmail.com", "Nothing", "I am a example");
      return "Email sent successfully";
   }   
}