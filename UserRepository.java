package mylab.user.di.repository;

import mylab.user.di.model.User;

public interface UserRepository {
    void save(User user);
    String getDbType(); // 과제 검증용: "MySQL" 반환하도록 구현
}
