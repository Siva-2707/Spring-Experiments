package com.siva.socialmediaapp.APIVersioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    //Uri Versioning
    @GetMapping("/person/v1")
    public PersonV1 getPersonV1UsingURIVersioning() {
        return getPersonV1();
    }

    @GetMapping("/person/v2")
    public PersonV2 getPersonV2UsingURIVersioning() {
        return getPersonV2();
    }

    //Request Parameter Versioning
    @GetMapping(path = "/person", params = "v=1")
    public PersonV1 getPersonV1UsingRequestParmVersioning() {
        return getPersonV1();
    }

    @GetMapping(path = "/person", params = "v=2")
    public PersonV2 getPersonV2UsingRequestParmVersioning() {
        return getPersonV2();
    }

    //Header Versioning
    @GetMapping(path = "/person", headers = "version=1")
    public PersonV1 getPersonV1UsingHeaderParmVersioning() {
        return getPersonV1();
    }

    @GetMapping(path = "/person", headers = "version=2")
    public PersonV2 getPersonV2UsingHeaderParmVersioning() {
        return getPersonV2();
    }

    //Accept Type Header Versioning
    @GetMapping(path = "/person", produces = "application/v1+json")
    public PersonV1 getPersonV1UsingAcceptHeaderVersioning() {
        return getPersonV1();
    }

    @GetMapping(path = "/person", produces = "application/v2+json")
    public PersonV2 getPersonV2UsingAcceptHeaderVersioning() {
        return getPersonV2();
    }

    /**************************************************************************************************************** */

    private PersonV1 getPersonV1() {
        return new PersonV1("Shree Supriya");
    }

    private PersonV2 getPersonV2() {
        return new PersonV2(new Name("Shree", "Supriya"));
    }

}
