package com.paradigma0621.core.repository.person.sql;

public class PersonSQLParts {

    private PersonSQLParts() {}

    public static final String QUERY_ONE_PERSON_BY_ID = """
            SELECT id, name, enrollment, profile_id, customer_id, register_date, removed, birth_date, deletion_date
            FROM person WHERE id = :id
            """;

    public static final String QUERY_ONE_PERSON_BY_ID_AND_CUSTOMER_ID = """
            SELECT id, name, enrollment, profile_id, customer_id, register_date, removed, birth_date, deletion_date
            FROM person
            WHERE id = :id AND customer_id = :customer_id
            """;

    public static final String QUERY_ALL_PERSONS = """
            SELECT id, name, enrollment, profile_id, customer_id, register_date, removed, birth_date, deletion_date
            FROM person
            """;

    public static final String QUERY_COUNT_ALL_PERSONS = """
            SELECT COUNT(1) FROM person
            """;

    public static final String QUERY_SAVE_ONE_PERSON = """
            INSERT INTO person (name, register_date, enrollment, profile_id, customer_id, removed, birth_date, deletion_date) 
            VALUES (:name, :register_date, :enrollment, :profile_id, :customer_id, :removed, :birth_date, :deletion_date)
            """;



}