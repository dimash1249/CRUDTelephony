CREATE TABLE IF NOT EXISTS person_phones
(
    person_id integer NOT NULL,
    person_name character varying COLLATE pg_catalog."default" NOT NULL,
    person_birth_year integer NOT NULL,
    person_phone_first character varying COLLATE pg_catalog."default" NOT NULL,
    person_phone_second character varying COLLATE pg_catalog."default" NOT NULL,
    person_creation_date date NOT NULL,
    CONSTRAINT person_phones_pkey PRIMARY KEY (person_id),
    CONSTRAINT person_phones_person_phone_first_key UNIQUE (person_phone_first),
    CONSTRAINT person_phones_person_phone_second_key UNIQUE (person_phone_second)
);

ALTER TABLE IF EXISTS person_phones
    OWNER to postgres;
