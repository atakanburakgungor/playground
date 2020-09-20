package com.petclinic.playground.resource;

import com.petclinic.playground.entity.Owner;
import com.petclinic.playground.service.OwnerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OwnerController implements IOwner {

    @NonNull
    private OwnerService ownerService;

    @Override
    public ResponseEntity<Owner> createOwner(Owner owner) {
        Owner createdOwner = ownerService.createOwner(owner);
        return new ResponseEntity<Owner>(createdOwner, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Owner> findOwnerById(UUID ownerId) {
        Owner createdOwner = ownerService.findOwnerById(ownerId);
        return new ResponseEntity<Owner>(createdOwner, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UUID> deleteOwner(UUID ownerId) {
        UUID deletedOwner = ownerService.deleteOwner(ownerId);
        return new ResponseEntity<UUID>(deletedOwner, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Owner>> findAllOwners() {
        Collection<Owner> owners = ownerService.findAllOwners();
        return new ResponseEntity<Collection<Owner>>(owners, HttpStatus.OK);
    }
}
