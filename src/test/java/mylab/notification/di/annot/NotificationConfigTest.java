package mylab.notification.di.annot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NotificationConfigTest {

    @Test
    public void testNotificationManagerBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(NotificationConfig.class);
        NotificationManager manager = context.getBean(NotificationManager.class);

        assertNotNull(manager, "NotificationManager 주입 실패");

        assertNotNull(manager.getEmailService(), "EmailNotificationService 주입 실패");
        assertNotNull(manager.getSmsService(), "SmsNotificationService 주입 실패");

        manager.sendNotificationByEmail("이메일 테스트");

        manager.sendNotificationBySms("SMS 테스트");
    }
}
