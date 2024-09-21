package com.paradigma0621.core.repository.clocking.sql;

public class ClockingSQLParts {

    private ClockingSQLParts() {}
/*
    public static final String QUERY_ONE_PERSON = """
            SELECT id, name, enrollment, profile_id, customer_id, register_date, removed FROM person where id = :id
            """;

    public static final String QUERY_ALL_PERSONS = """
            SELECT id, name, enrollment, profile_id, customer_id, register_date, removed FROM person
            """;

    public static final String QUERY_COUNT_ALL_PERSONS = """
            SELECT COUNT(1) FROM person
            """;
*/
    public static final String QUERY_SAVE_ONE_CLOCKING = """
            INSERT INTO clocking (seconds_duration, grade, description, subject, start_date, finish_date, localization,
                                  person_id, removed)
            VALUES (:seconds_duration, :grade, :description, :subject, :start_date, :finish_date, :localization,
                    :person_id, :removed)
            """;

}