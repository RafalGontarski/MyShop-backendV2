package com.codeMaker.MyShop.App.emailSender.service;

import com.codeMaker.MyShop.App.emailSender.model.ResetToken;
import com.codeMaker.MyShop.App.emailSender.model.ResetTokenRepository;
import com.codeMaker.MyShop.App.user.model.UserRepository;
import com.codeMaker.MyShop.App.user.service.UserService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRepository userRepository;
    private final ResetTokenRepository resetTokenRepository;

    public EmailService(
            JavaMailSender javaMailSender,
            PasswordEncoder passwordEncoder,
            UserService userService,
            UserRepository userRepository,
            ResetTokenRepository resetTokenRepository) {
        this.javaMailSender = javaMailSender;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.resetTokenRepository = resetTokenRepository;
        this.userService = userService;
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);
        javaMailSender.send(mail);
    }

    public void createPasswordSetupToken(String email) {
        String token = UUID.randomUUID().toString();
        resetTokenRepository.save(ResetToken.builder().token(token).email(email).build());
        // Sending an email with a link to set up the password
        String setPasswordUrl = "http://localhost:3000/setup-password?token=" + token;
        String subject = "Setup Your Password";
        String body = "To set up your password, click on the link below:\n" + setPasswordUrl;
        sendEmail(email, subject, body);
    }
}
