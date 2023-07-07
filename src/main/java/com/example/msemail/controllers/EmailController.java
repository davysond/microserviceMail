package com.example.msemail.controllers;

import com.example.msemail.dtos.EmailDTO;
import com.example.msemail.models.EmailModel;
import com.example.msemail.services.EmailService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;
    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel);

        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

}
