-- auto-generated definition
create table characteristic
(
    id                 uuid not null
        constraint characteristic_pkey
            primary key,
    created_by         varchar(255),
    created_date       timestamp,
    end_date           timestamp,
    last_modified_by   varchar(255),
    last_modified_date timestamp,
    name               varchar(255),
    value              varchar(255),
    owner_id           uuid
        constraint fkjrevlhwel3fpycv75k6pabakk
            references owner,
    pet_id             uuid
        constraint fk2xi83a760twm1mbxpfwkvju2p
            references pet,
    vet_id             uuid
        constraint fk67xcamnld7bei4u11fvi06h7b
            references veterinary
);

alter table characteristic
    owner to postgres;

-- auto-generated definition
create table contact
(
    id                 uuid not null
        constraint contact_pkey
            primary key,
    created_by         varchar(255),
    created_date       timestamp,
    end_date           timestamp,
    last_modified_by   varchar(255),
    last_modified_date timestamp,
    detailed_address   varchar(255),
    email_address      varchar(255),
    fax_number         varchar(255),
    phone_number       varchar(255),
    preferred          boolean,
    type               varchar(255)
);

alter table contact
    owner to postgres;

-- auto-generated definition
create table owner
(
    owner_id           uuid not null
        constraint owner_pkey
            primary key,
    created_by         varchar(255),
    created_date       timestamp,
    end_date           timestamp,
    last_modified_by   varchar(255),
    last_modified_date timestamp,
    details            varchar(255),
    full_name          varchar(255),
    gender             integer,
    status             varchar(255)
);

alter table owner
    owner to postgres;

-- auto-generated definition
create table owner_contact
(
    owner_id   uuid not null
        constraint fkk1nrn2bexfk7xuf77aoteg6o6
            references owner,
    contact_id uuid not null
        constraint uk_sh2uell1q0xtg3noemofnajng
            unique
        constraint fk1n9vstv76yw7jhtv07r8qam71
            references contact,
    constraint owner_contact_pkey
        primary key (owner_id, contact_id)
);

alter table owner_contact
    owner to postgres;

-- auto-generated definition
create table pet
(
    id                 uuid not null
        constraint pet_pkey
            primary key,
    created_by         varchar(255),
    created_date       timestamp,
    end_date           timestamp,
    last_modified_by   varchar(255),
    last_modified_date timestamp,
    birth_date         timestamp,
    gender             integer,
    last_vet_visit     timestamp,
    medical_details    varchar(255),
    name               varchar(255),
    type               varchar(255),
    vet_id             uuid
        constraint fkb57t68hejvprlc94liqk7ttvy
            references veterinary,
    owner_id           uuid
        constraint fk7qfti9yba86tgfe9oobeqxfxg
            references owner
);

alter table pet
    owner to postgres;

-- auto-generated definition
create table vet_contact
(
    vet_id     uuid not null
        constraint fknfwg9j7af0jjh9irvhh6ab88a
            references veterinary,
    contact_id uuid not null
        constraint uk_cmk1p5n9y0wsnbn76810mdeqh
            unique
        constraint fk7nokltdvikt512asdec5lyvil
            references contact,
    constraint vet_contact_pkey
        primary key (vet_id, contact_id)
);

alter table vet_contact
    owner to postgres;

-- auto-generated definition
create table veterinary
(
    vet_id             uuid not null
        constraint veterinary_pkey
            primary key,
    created_by         varchar(255),
    created_date       timestamp,
    end_date           timestamp,
    last_modified_by   varchar(255),
    last_modified_date timestamp,
    details            varchar(255),
    full_name          varchar(255),
    gender             integer
);

alter table veterinary
    owner to postgres;

