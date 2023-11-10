package sk.tuke.pegasus.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import sk.tuke.pegasus.dto.DummyDto;
import sk.tuke.pegasus.dto.GraphFilterDto;
import sk.tuke.pegasus.dto.GraphResponseDto;
import sk.tuke.pegasus.service.TransakciaService;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE } )
public class BankingController {

    private TransakciaService transakciaService;

    public BankingController(@NonNull TransakciaService transakciaService){
        this.transakciaService = transakciaService;
    }

    @GetMapping("/ping")
    public ResponseEntity<DummyDto> ping() {
        log.info("Prevolanie sluzby /ping {}", LocalDate.now());
        DummyDto dto = new DummyDto();
        dto.setDummyString(String.format("Prevolanie sluzby /ping %s", LocalDate.now()));
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/graph")
    public ResponseEntity<List<GraphResponseDto>> getGraph(@RequestBody GraphFilterDto filter){
        return ResponseEntity.ok(transakciaService.getGraph(filter));
    }

}
