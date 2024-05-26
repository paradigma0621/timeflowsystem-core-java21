package com.paradigma0621.core.repository.person.sql;

public class PersonSQLParts {

    private PersonSQLParts() {}

    public static final String QUERY_ONE_PERSON = """
            SELECT id, name FROM person where id = :id
            """;
}