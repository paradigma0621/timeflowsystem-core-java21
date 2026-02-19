package com.paradigma0621.core.repository.clocking.sql;

public class ClockingSQLParts {

    private ClockingSQLParts() {}

    public static final String QUERY_SAVE_ONE_CLOCKING = """
            INSERT INTO clocking (seconds_duration, grade, description, subject, start_date, finish_date, localization,
                                  person_id, removed)
            VALUES (:seconds_duration, :grade, :description, :subject, :start_date, :finish_date, :localization,
                    :person_id, :removed)
            """;

    public static final String QUERY_MAIN_FIND_ALL_CLOCKING = """
            SELECT
                id,
                seconds_duration,
                grade,
                description,
                subject,
                start_date,
                finish_date,
                localization,
                person_id,
                removed
            FROM clocking
            WHERE 1=1""";
}