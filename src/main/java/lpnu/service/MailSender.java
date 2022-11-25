package lpnu.service;

public interface MailSender {
    void send(String toAddress, String subject, String message);
}
