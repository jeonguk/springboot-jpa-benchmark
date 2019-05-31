package com.jeonguk.web.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
@NoArgsConstructor
public class UserKey implements Serializable {

    @EqualsAndHashCode.Include
    @Column
    private Long idOne;

    @EqualsAndHashCode.Include
    @Column
    private Long idTwo;

    public UserKey(Long idOne,
                 Long idTwo) {
        this.idOne = idOne;
        this.idTwo = idTwo;
    }

}
