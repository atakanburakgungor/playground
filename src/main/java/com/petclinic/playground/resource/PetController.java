package com.petclinic.playground.resource;

import com.petclinic.playground.entity.Pet;
import com.petclinic.playground.search.CustomRsqlVisitor;
import com.petclinic.playground.service.PetService;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PetController implements IPet {

    @NonNull
    private PetService petService;

    @Override
    public ResponseEntity<Pet> createPet(Pet pet) {
        Pet createdPet = petService.createPet(pet);
        return new ResponseEntity<Pet>(createdPet, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Pet> findPetByd(UUID petId) {
        Pet existingPet = petService.findPetById(petId);
        return new ResponseEntity<Pet>(existingPet, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UUID> deletePet(UUID petId) {
        UUID deletedPet = petService.deletePet(petId);
        return new ResponseEntity<UUID>(deletedPet, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Pet>> findAllPets() {
        Collection<Pet> pets = petService.findAllPets();
        return new ResponseEntity<Collection<Pet>>(pets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Pet>> search(String search) {
        Node rootNode = new RSQLParser().parse(search);
        Specification<Pet> spec = rootNode.accept(new CustomRsqlVisitor<Pet>());
        List<Pet> searches = petService.search(spec);
        return new ResponseEntity<List<Pet>>(searches, HttpStatus.OK);
    }
}
