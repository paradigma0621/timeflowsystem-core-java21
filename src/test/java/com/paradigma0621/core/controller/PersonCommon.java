package com.paradigma0621.core.controller;

public class PersonCommon {
    public static final String RESPONSE_PERSON_ONE_REGISTER =
            """
            {
                "id": 1,
                "name": "João da Silva",
                "registerDate": "2024-01-15T10:30:00",
                "enrollment": "ENR-2024-001",
                "customerId": 12,
                "profileId": 2,
                "removed": false,
                "birthDate": "1990-05-12",
                "deletionDate": "2026-01-15T09:20:12"
            }
            """;

    public static final String RESPONSE_NO_PERSON_FOUND =
            """
            {
                "id": 0,
                "name": "No person found for the given personId and customerId",
                "registerDate": null,
                "enrollment": "0",
                "customerId": 0,
                "profileId": 0,
                "removed": false,
                "birthDate": null,
                "deletionDate": null
            }
            """;
}
