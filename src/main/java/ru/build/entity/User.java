package ru.build.entity;


import ru.build.tools.Column;
import ru.build.tools.EType;
import ru.build.tools.Id;
import ru.build.tools.Table;

@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", type = EType.REAL)
    private Long id;

    @Column(name = "username", type = EType.VARCHAR)
    private String username;

    @Column(name = "password", type = EType.VARCHAR)
    private String password;


    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
