package com.petclinic.playground.service;

import com.petclinic.playground.entity.Owner;
import com.petclinic.playground.exception.AppException;
import com.petclinic.playground.repository.OwnerRepository;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OwnerService {

    @NonNull
    private OwnerRepository ownerRepository;

    public Owner createOwner(Owner owner) {
        Object savedOwner = ownerRepository.save(owner);
        return (Owner) savedOwner;
    }

    public Owner findOwnerById(UUID ownerId) {
        Optional optionalOwner = ownerRepository.findById(ownerId);
        if (!optionalOwner.isPresent()) {
            log.info("Owner not found with id : ", ownerId);
            throw new AppException(String.format("Owner not found with id : [%s]", ownerId.toString()));
        }
        return (Owner) optionalOwner.get();
    }

    public UUID deleteOwner(UUID ownerId) {
        ownerRepository.delete(findOwnerById(ownerId));
        return ownerId;
    }

    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }
}
