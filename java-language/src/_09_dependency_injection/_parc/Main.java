package _09_dependency_injection._parc;

public class Main {
    public static void main(String[] args) {
        // 1. 생성자 주입
        NotificationService emailService = new EmailNotificationService();

        OrderService service1 = new OrderService(emailService);

        service1.processOrder1();

        System.out.println("---");
        // 2. setter 주입
        NotificationService smsService = new EmailNotificationService();
        OrderService service2 = new OrderService(smsService);
        service2.setSmsService(smsService);

        service2.processOrder2();
    }
}
