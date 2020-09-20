package com.petclinic.playground.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(of = {"type"}, callSuper = false)
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    private Boolean preferred;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String detailedAddress;

    private String emailAddress;

    private String faxNumber;

    private String phoneNumber;

    public enum Type {
        EMAIL_ADDRESS, TELEPHONE_NUMBER, POSTAL_ADDRESS, FAX_NUMBER
    }
}

