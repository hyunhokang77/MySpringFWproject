package mylab.user.di.service;

import org.springframework.stereotype.Component;

@Component("securityService")
public class SecurityService {
    // Java 11+ : isBlank()
    public boolean authenticate(String username, String password) {
        return username != null && !username.isBlank()
                && password != null && password.length() >= 3;
    }
    // 만약 Java 8이면 아래로 교체:
    // return username != null && !username.trim().isEmpty()
    //        && password != null && password.length() >= 3;
}
