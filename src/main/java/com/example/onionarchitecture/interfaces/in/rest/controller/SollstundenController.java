package com.example.onionarchitecture.interfaces.in.rest.controller;

import com.example.onionarchitecture.application.commands.SollstudenCommandService;
import com.example.onionarchitecture.application.queries.SollStundenQueryService;
import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.interfaces.in.rest.controller.dto.SollstundenDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v2/sollstunden")
@AllArgsConstructor
public class SollstundenController {

    SollstudenCommandService sollstudenCommandService;
    SollStundenQueryService sollStundenQueryService;

    @PostMapping
    public ResponseEntity<Void> erstelleSollstunden(@Valid @RequestBody SollstundenDto sollstundenDto) {

        sollstudenCommandService.sollstundeErstellen(sollstundenDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/{sollStundenId}")
    public ResponseEntity<BeraterSollStunden> getSollstunden(@PathVariable(value = "sollStundenId") Long id) {
        BeraterSollStunden beraterSollstundenByI = sollStundenQueryService.getBeraterSollstundenByI(id);
        return ResponseEntity.ok().body(beraterSollstundenByI);
    }

    @GetMapping
    public ResponseEntity<List<BeraterSollStunden>> getAllSollStunden() {
        List<BeraterSollStunden> listBeraterSollstunden = sollStundenQueryService.getListBeraterSollstunden();
        return ResponseEntity.ok().body(listBeraterSollstunden);
    }

    @DeleteMapping("/{sollstundenId}")
    public ResponseEntity<Void> deleleSollstunndeById(@PathVariable(value = "sollstundenId") Long sollstundenId){
        sollstudenCommandService.deleteSollstunden(sollstundenId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PutMapping("/{sollstundenId}")
    public ResponseEntity<Void> updateSollstunden(@RequestBody SollstundenDto sollstundenDto,
                                                  @PathVariable(value = "sollstundenId") Long id) {
        sollstudenCommandService.updateSollstunden(sollstundenDto, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
