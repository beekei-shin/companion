package com.beekei.companion.infrastructure;

import com.beekei.companion.domain.pet.Pet;
import com.beekei.companion.domain.pet.PetRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJpaRepository extends JpaRepository<Pet, Long>, PetRepository {
}
