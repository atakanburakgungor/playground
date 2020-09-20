package com.petclinic.playground.resource;

import com.petclinic.playground.entity.Pet;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequestMapping("/rest/pets")
public interface IPet {

    @ApiOperation(value = "Create a new pet", nickname = "createPet",response = Pet.class, tags = {"giftCard",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Pet.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/create-pet",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Pet> createPet(@ApiParam(value = "Pet resource body", required = true) @RequestBody Pet pet
    );

    @ApiOperation(value = "Find pet", nickname = "findPet", notes = "Returns a single pet", response = Pet.class, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Pet.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/{petId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Pet> findPetByd(@ApiParam(value = "ID of the pet resource to return", required = true) @PathVariable("petId") UUID petId);

    @ApiOperation(value = "Delete pet", nickname = "deletePet", notes = "Returns a deleted pet ID", response = UUID.class, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UUID.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/{petId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<UUID> deletePet(@ApiParam(value = "ID of the pet resource to return", required = true) @PathVariable("petId") UUID petId);

    @ApiOperation(value = "Find all pets", nickname = "findAllPet", notes = "Returns a collections of pet", response = Collection.class, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Collection.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/find-all-pets",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Collection<Pet>> findAllPets();

    @ApiOperation(value = "Find all pets by searchCriteria", nickname = "findAllPetBySearchCriteria", notes = "Returns a list of pet", response = List.class, tags = {"pet"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = List.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/find-all-pets-by-search-criteria",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Pet>> search(@ApiParam(value = "Search criteria", required = true) @RequestParam String search);




}
