package com.jeonguk.web.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@IdClass(UserKey.class)
@Table(name = "user")
public class User {

    @Id
    private Long idOne;
    @Id
    private Long idTwo;
    private String name;
    private LocalDateTime createdAt;

    public User(Long idOne,
                Long idTwo,
                String name,
                LocalDateTime createdAt) {
        this.idOne = idOne;
        this.idTwo = idTwo;
        this.name = name;
        this.createdAt = createdAt;
    }

}
