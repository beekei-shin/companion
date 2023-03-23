package com.beekei.companion.domain.member.client;

import com.beekei.companion.domain.member.Member;
import com.beekei.companion.domain.member.MemberType;
import com.beekei.companion.domain.pet.Pet;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "client_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DiscriminatorValue("CLIENT")
public class ClientMember extends Member {

    private ClientMember(String email, String password, String nickname) {
        super(MemberType.CLIENT, email, password, nickname);
    }

    @OneToMany(mappedBy = "member")
    private List<Pet> pets;

    public static ClientMember create(String email, String password, String nickname) {
        return new ClientMember(email, password, nickname);
    }

    public void updateInfo(String nickname) {
        this.nickname = nickname;
    }

}
