package com.paradigma0621.core.repository.person.sql;

public class PersonSQLParts {

    private PersonSQLParts() {}

    public static final String QUERY_ONE_PERSON = """
            SELECT id, name, enrollment, profile_id, customer_id, register_date, removed FROM person where id = :id
            """;

    public static final String QUERY_ALL_PERSONS = """
            SELECT id, name, enrollment, profile_id, customer_id, register_date, removed FROM person
            """;

    public static final String QUERY_COUNT_ALL_PERSONS = """
            SELECT COUNT(1) FROM person
            """;

    public static final String QUERY_SAVE_ONE_PERSON = """
            INSERT INTO person (name, register_date, enrollment, profile_id, customer_id, removed) 
            VALUES (:name, :register_date, :enrollment, :profile_id, :customer_id, :removed)
            """;



}