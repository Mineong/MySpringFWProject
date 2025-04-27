package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void testUserServiceInjection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-user-di.xml");
        UserService userService = context.getBean(UserService.class);

        assertNotNull(userService, "UserService 빈이 주입되지 않았습니다.");
        assertNotNull(userService.getUserRepository(), "UserRepository가 주입되지 않았습니다.");
        assertNotNull(userService.getSecurityService(), "SecurityService가 주입되지 않았습니다.");
        assertEquals("MySQL", userService.getUserRepository().getDbType(), "DB 타입이 다릅니다.");

        boolean result = userService.registerUser("user01", "햄", "password123");
        assertTrue(result, "registerUser 메서드가 실패했습니다.");
    }
}
