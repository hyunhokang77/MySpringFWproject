package mylab.user.di.repository;

import mylab.user.di.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("userRepository")
public class InMemoryUserRepository implements UserRepository{
    private final List<User> store = new ArrayList<>();

    @Override
    public void save(User user) {
        store.add(user);
        System.out.println("[UserRepository] saved user = " + user.getUsername());
    }

    @Override
    public String getDbType() {
        return "MySQL"; // 과제 요구사항 검증 값
    }

    // (선택) 테스트 디버깅용
    public int count() { return store.size(); }
}
