package sk.tuke.pegasus.controllers;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/ping", produces = { MediaType.APPLICATION_JSON_VALUE } )
public class DummyController {

    @GetMapping()
    public ResponseEntity<String> ping() {
        log.info("/ping {}", LocalDate.now());
        return ResponseEntity.ok(String.format("/ping %s", LocalDate.now()));
    }

}
