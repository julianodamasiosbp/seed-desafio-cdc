package com.acme.cdc.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.acme.cdc.api.model.AutorResponse;
import com.acme.cdc.domain.model.Autor;

@Component
public class AutorModelAssembler {

    private ModelMapper modelMapper;

    public AutorModelAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AutorResponse toModel(Autor autor) {
        return this.modelMapper.map(autor, AutorResponse.class);
    }

}
