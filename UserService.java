package mylab.user.di.service;

import mylab.user.di.model.User;
import mylab.user.di.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepository userRepository;
    private final SecurityService securityService;

    // 전략2: 어노테이션 기반 DI (생성자 주입 권장)
    @Autowired
    public UserService(UserRepository userRepository, SecurityService securityService) {
        this.userRepository = userRepository;
        this.securityService = securityService;
    }

    // 과제에서 getter 검증하므로 제공
    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }

    // 사용자 등록: SecurityService로 인증 후 UserRepository에 저장
    public boolean registerUser(String username, String password) {
        if (!securityService.authenticate(username, password)) {
            return false;
        }
        userRepository.save(new User(username, password));
        return true;
    }
}
