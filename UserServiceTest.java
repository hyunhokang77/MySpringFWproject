package mylab.user.di;

import mylab.user.di.repository.UserRepository;
import mylab.user.di.service.SecurityService;
import mylab.user.di.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void 의존성주입_및_기능검증() {
        // 1) UserService 주입 검증
        assertNotNull(userService, "UserService should be injected");

        // 2) UserRepository 주입 검증
        UserRepository repo = userService.getUserRepository();
        assertNotNull(repo, "UserRepository should be injected");

        // 3) DB 타입 값 비교 (MySQL)
        assertEquals("MySQL", repo.getDbType(), "dbType must be MySQL");

        // 4) SecurityService 주입 검증
        SecurityService sec = userService.getSecurityService();
        assertNotNull(sec, "SecurityService should be injected");

        // 5) 사용자 등록 로직 검증 (성공 케이스)
        boolean result = userService.registerUser("alice", "pw123");
        assertTrue(result, "registerUser() should return true when authenticated");
    }
}
