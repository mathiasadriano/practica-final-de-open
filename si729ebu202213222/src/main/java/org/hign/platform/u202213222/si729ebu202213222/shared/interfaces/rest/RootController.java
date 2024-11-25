package org.hign.platform.u202213222.si729ebu202213222.shared.infrastructure.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String root() {
        return "Welcome to the SI729 API!";
    }
}
