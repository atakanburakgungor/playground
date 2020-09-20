package com.petclinic.playground.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Veterinary extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "vet_id")
    private UUID id;

    private String fullName;

    private String details;

    private Gender gender;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vet_id")
    @JsonProperty("characteristic")
    private Set<Characteristic> characteristics;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vet_contact", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    @JsonProperty("contact")
    private Set<Contact> contact;
}
