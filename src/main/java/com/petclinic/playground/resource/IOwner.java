package com.petclinic.playground.resource;

import com.petclinic.playground.entity.Owner;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.UUID;

@RequestMapping("/rest/owners")
public interface IOwner {

    @ApiOperation(value = "Create a new owner", nickname = "createOwner", response = Owner.class, tags = {"owner"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Owner.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/create-owner",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Owner> createOwner(@ApiParam(value = "Owner resource body", required = true) @RequestBody Owner owner
    );

    @ApiOperation(value = "Find owner by ID", nickname = "findOwner", notes = "Returns a single owner", response = Owner.class, tags = {"owner"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Owner.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/{ownerId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Owner> findOwnerById(@ApiParam(value = "ID of the owner resource to return", required = true) @PathVariable("ownerId") UUID ownerId);

    @ApiOperation(value = "Delete owner", nickname = "deleteOwner", notes = "Returns a deleted Owner ID", response = UUID.class, tags = {"owner"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UUID.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/{ownerId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<UUID> deleteOwner(@ApiParam(value = "ID of the owner resource to return", required = true) @PathVariable("ownerId") UUID ownerId);

    @ApiOperation(value = "Find all owners", nickname = "findAllOwner", notes = "Returns a collections of owner", response = Collection.class, tags = {"owner"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Collection.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
            @ApiResponse(code = 409, message = "Conflict", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)})
    @RequestMapping(value = "/find-all-owners",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Collection<Owner>> findAllOwners();


}
