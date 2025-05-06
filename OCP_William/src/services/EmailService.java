package services;

import exceptions.EmailException;

public interface EmailService {
    void sendEmail(String email, String subject, String message) throws EmailException;
}
