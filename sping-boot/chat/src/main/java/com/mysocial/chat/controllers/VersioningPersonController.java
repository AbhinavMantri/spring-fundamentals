package com.mysocial.chat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysocial.chat.entity.PersonV1;
import com.mysocial.chat.entity.PersonV2;

@RestController
public class VersioningPersonController {
    
    @GetMapping(path = "/v1/person") 
    public PersonV1 getV1Person() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/v2/person") 
    public PersonV2 getV2Person() {
        return new PersonV2("Bob", "Charlie");
    }


    @GetMapping(path = "/person", params = "version=v1") 
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob charlie");
    }

    @GetMapping(path = "/person", params = "version=v2") 
    public PersonV2 getPersonV2() {
        return new PersonV2("Bob", "charlie");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=v1") 
    public PersonV1 getPersonHeaderV1() {
        return new PersonV1("Bob charlie");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=v2") 
    public PersonV2 getPersonHeaderV2() {
        return new PersonV2("Bob", "charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json") 
    public PersonV1 getPersonHeaderAcceptV1() {
        return new PersonV1("Bob charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json") 
    public PersonV2 getPersonHeaderAcceptV2() {
        return new PersonV2("Bob", "charlie");
    }
}
