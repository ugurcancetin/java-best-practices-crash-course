package org.example.classes.dependencyinjection;


interface MessageSender {
  void send(String message);
}

class EmailSender implements MessageSender {
  public void send(String message) {
    System.out.println("Sending email: " + message);
  }
}

class SMSNotifier implements MessageSender {
  public void send(String message) {
    System.out.println("Sending SMS: " + message);
  }
}

// Decoupled Service
class NotificationService {
  private final MessageSender sender;

  public NotificationService(MessageSender sender) {
    this.sender = sender;
  }

  public void sendNotification(String message) {
    sender.send(message);
  }
}
public class GoodNotificationService {
  public static void main(String[] args) {
    NotificationService emailService = new NotificationService(new EmailSender());
    emailService.sendNotification("Hello via Email!");

    NotificationService smsService = new NotificationService(new SMSNotifier());
    smsService.sendNotification("Hello via SMS!");
  }
}
