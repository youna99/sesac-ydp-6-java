package _09_dependency_injection._parc;

public class SMSNotificationService implements NotificationService{
    public void processOrder() {
        System.out.println("processed successfully");
        System.out.println("Sending SMS notification: Your order has been processed");
    }
}
