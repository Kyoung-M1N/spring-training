package com.spring_training.domain.member;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
/*
 * @Entity어노테이션을 통해 해당 클래스를 DB에 접근하기 위한 Entity로써 mapping한다.
 * 해당 entity는 jpa가 관리하게 된다.
 */
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
     * @Id를 통해 해당 필드를 pirmary key와 mapping한다.
     * IDENTITY는 DB가 자동으로 생성해주는 값이라는 의미이다.
     */
    private long id;
    // @Column(name = "name")
    private String name;
    private String email;
    private String password;

    // Member(long id, String name) {
    //     this.id = id;
    //     this.name = name;
    // }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
