package com.acme.cdc.api.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.acme.cdc.api.model.AutorRequest;
import com.acme.cdc.domain.model.Autor;

@Component
public class AutorInputDisassembler {

    private ModelMapper modelMapper;

    public AutorInputDisassembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Autor toDomainObject(AutorRequest autorRequest) {
        return modelMapper.map(autorRequest, Autor.class);
    }

}
