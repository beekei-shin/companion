package com.beekei.companion.domain.pet;

import com.beekei.companion.domain.DefaultEntity;
import com.beekei.companion.domain.Gender;
import com.beekei.companion.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pet")
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Pet extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 50, nullable = false, updatable = false)
    private PetType type;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1, nullable = false)
    private Gender gender;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public static Pet create(Member member, PetType type, String name, Gender gender, LocalDate birthday) {
        return Pet.builder()
            .member(member)
            .type(type)
            .name(name)
            .gender(gender)
            .birthday(birthday)
            .build();
    }

}
