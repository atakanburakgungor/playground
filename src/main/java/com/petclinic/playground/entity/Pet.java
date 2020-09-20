package com.petclinic.playground.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Pet extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Date lastVetVisit;

    private String medicalDetails;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="vet_id")
    @JsonIgnore
    private Veterinary veterinary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    @JsonProperty("characteristic")
    private Set<Characteristic> characteristics;

    private Gender gender;

    public enum Type {
        BIRD, DOG, MOUSE, FISH, CAT, CHAMELEON, SNAKE, TURTLE, RABBIT
    }

}
