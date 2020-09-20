package com.petclinic.playground.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, of = {"name", "value"})
@RequiredArgsConstructor
@NoArgsConstructor
public class Characteristic extends BaseEntity {

    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String value;
}
