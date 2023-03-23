package com.beekei.companion.domain.member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByNicknameAndIsDeleted(String nickname, boolean isDeleted);
}
