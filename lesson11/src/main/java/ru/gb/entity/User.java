package ru.gb.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username", length=50)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;
}
