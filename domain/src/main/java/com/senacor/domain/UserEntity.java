package com.senacor.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Jochen Mader
 */
@Table(name = "USER_ENTITY")
@Entity
public class UserEntity {
    @Id
    @Column(name = "UE_ID")
    private Long id;
    @Column(name = "UE_FIRSTNAME")
    private String firstname;
    @Column(name = "UE_LASTNAME")
    private String lastname;
    @Temporal(TemporalType.DATE)
    @Column(name = "UE_BIRTHDAY")
    private java.util.Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
