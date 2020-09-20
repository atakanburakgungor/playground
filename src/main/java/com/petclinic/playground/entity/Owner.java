package com.petclinic.playground.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Owner extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "owner_id")
    private UUID id;

    private String fullName;

    private String details;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "owner_contact", joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    @JsonProperty("contact")
    private Set<Contact> contact;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    @JsonProperty("pets")
    private Set<Pet> pets = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    @JsonProperty("characteristic")
    private Set<Characteristic> characteristics;

    private Gender gender;

    public enum Status {
        ACTIVE, PASSIVE, OTHER
    }
}
