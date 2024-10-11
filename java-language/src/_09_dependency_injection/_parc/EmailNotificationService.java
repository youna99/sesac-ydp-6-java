package _09_dependency_injection._parc;

public class EmailNotificationService implements NotificationService{
    public void processOrder() {
        System.out.println("processed successfully");
        System.out.println("Sending email notification: Your order has been processed");

    }
}
