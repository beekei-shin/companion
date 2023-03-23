package com.beekei.companion.domain.member;

import com.beekei.companion.domain.DefaultEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
public class Member extends DefaultEntity {

    protected Member(MemberType type, String email, String password, String nickname) {
        this.type = type;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 50, nullable = false, insertable = false, updatable = false)
    private MemberType type;

    @Column(name = "email", length = 200, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "password", length = 250, nullable = false)
    protected String password;

    @Column(name = "nickname", length = 100, nullable = false, unique = true)
    protected String nickname;

}
