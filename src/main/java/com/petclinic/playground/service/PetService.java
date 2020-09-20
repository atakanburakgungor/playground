package com.petclinic.playground.service;

import com.petclinic.playground.entity.Pet;
import com.petclinic.playground.exception.AppException;
import com.petclinic.playground.repository.PetRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PetService {

    @NonNull
    private PetRepository petRepository;

    public Pet createPet(Pet pet) {
        Object savedPet = petRepository.save(pet);
        return (Pet) savedPet;
    }

    public Pet findPetById(UUID petId) {
        Optional optionalPet = petRepository.findById(petId);
        if (!optionalPet.isPresent()) {
            log.info("Pet not found with id : ", petId);
            throw new AppException(String.format("Pet not found with id : [%s]", petId.toString()));
        }
        return (Pet) optionalPet.get();
    }

    public UUID deletePet(UUID petId) {
        petRepository.delete(findPetById(petId));
        return petId;
    }

    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> search(Specification<Pet> spec) {
        return petRepository.findAll(spec);
    }
}
