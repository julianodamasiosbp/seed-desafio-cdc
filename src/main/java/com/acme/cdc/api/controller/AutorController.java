package com.acme.cdc.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.cdc.api.assembler.AutorModelAssembler;
import com.acme.cdc.api.disassembler.AutorInputDisassembler;
import com.acme.cdc.api.model.AutorRequest;
import com.acme.cdc.api.model.AutorResponse;
import com.acme.cdc.domain.model.Autor;
import com.acme.cdc.domain.repository.AutorRepository;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    private AutorModelAssembler autorModelAssembler;
    private AutorInputDisassembler autorInputDisassembler;
    private AutorRepository autorRepository;

    public AutorController(AutorModelAssembler autorModelAssembler, AutorRepository autorRepository,
            AutorInputDisassembler autorInputDisassembler) {
        this.autorModelAssembler = autorModelAssembler;
        this.autorRepository = autorRepository;
        this.autorInputDisassembler = autorInputDisassembler;
    }

    @PostMapping
    private ResponseEntity<AutorResponse> salvar(@RequestBody AutorRequest autorRequest) {
        Autor autor = this.autorInputDisassembler.toDomainObject(autorRequest);
        Autor autorSalvo = autorRepository.save(autor);
        return ResponseEntity.ok().body(this.autorModelAssembler.toModel(autorSalvo));
    }

}
