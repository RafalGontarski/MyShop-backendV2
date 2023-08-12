package com.codeMaker.MyShop.App.emailSender.controller;

import com.codeMaker.MyShop.App.emailSender.model.ResetTokenRequest;
import com.codeMaker.MyShop.App.emailSender.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/setupPassword")
    public void SetupPassword(@RequestBody ResetTokenRequest request) {
        emailService.createPasswordSetupToken(request.getEmail());
    }

}
