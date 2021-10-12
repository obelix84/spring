package ru.gb.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class AuthoritiesId  implements Serializable {
    String username;
    String authority;
}
