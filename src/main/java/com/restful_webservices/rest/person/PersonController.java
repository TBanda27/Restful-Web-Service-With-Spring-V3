package com.restful_webservices.rest.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/api/v1")
    public PersonV1 getPersonV1(){
        return new PersonV1("John Doe");
    }

    @GetMapping("/api/v2")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("The John", "Doe"));
    }

    @GetMapping(value = "/api", params = "version=2")
    public PersonV2 getPersonParamsV2(){
        return new PersonV2(new Name("The Params", "Version 2"));
    }
    @GetMapping(value = "/api", params = "version=1")
    public PersonV1 getPersonParamsV1(){
        return new PersonV1("Params Version 1");
    }

    @GetMapping(value="/api/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonHeaderV1(){
        return new PersonV1("The Headers Version 1");
    }

    @GetMapping(value="/api/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonHeaderV2(){
        return new PersonV2(new Name("The Headers", "Version 2"));
    }

    @GetMapping(value="/api/accept", produces= "application/vnd.company.app-v1+json")
    public PersonV1 getPersonProducesV1(){
        return new PersonV1("The Application Produces Version 1");
    }

    @GetMapping(value="/api/accept", produces= "application/vnd.company.app-v2+json")
    public PersonV2 getPersonProducesV2(){
        return new PersonV2(new Name("The Application", "Produces Version 2"));
    }
}
