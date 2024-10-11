package _09_dependency_injection._parc;

public class OrderService {

    // 1. 생성자 주입 방식
    private final NotificationService emailService;

    public OrderService(NotificationService emailService) {
        this.emailService = emailService;
    }

    public void processOrder1() {
        emailService.processOrder();
    }

    // 2. setter 주입
    private NotificationService smsService;

    public void setSmsService(NotificationService smsService) {
        this.smsService = smsService;
    }

    public void processOrder2() {
        smsService.processOrder();
    }
}
