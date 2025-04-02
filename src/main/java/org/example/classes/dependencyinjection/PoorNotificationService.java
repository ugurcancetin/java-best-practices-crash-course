package org.example.classes.dependencyinjection;


public class PoorNotificationService {

  private NotificationSender emailSender = new NotificationSender(); // Direct dependency!

  public void sendNotification(String message) {
    emailSender.send(message);
  }
}

class NotificationSender {

  public void send(String message) {
  }

}

