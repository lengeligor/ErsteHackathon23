package sk.tuke.pegasus.controllers;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sk.tuke.pegasus.dto.DummyDto;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/ping", produces = { MediaType.APPLICATION_JSON_VALUE } )
public class DummyController {

    @GetMapping()
    public ResponseEntity<DummyDto> ping() {
        log.info("Prevolanie sluzby /ping {}", LocalDate.now());
        DummyDto dto = new DummyDto();
        dto.setDummyString(String.format("Prevolanie sluzby /ping %s", LocalDate.now()));
        return ResponseEntity.ok(dto);
    }

}
