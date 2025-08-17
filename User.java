package mylab.user.di.model;

public class User {
    private final String username;
    private final String password; // 데모용 (실서비스에선 해싱 필요)

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
