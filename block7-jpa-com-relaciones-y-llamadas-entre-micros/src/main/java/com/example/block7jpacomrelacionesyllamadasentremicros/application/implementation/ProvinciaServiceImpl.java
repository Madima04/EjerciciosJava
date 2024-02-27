package com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ClienteRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ProvinciaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.application.ProvinciaService;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Provincia;
import org.example.dtos.input.ProvinciaInputDto;
import org.example.dtos.output.ProvinciaOutputDto;
import org.example.dtos.output.ProvinciaOutputDtoImp;
import org.example.dtos.output.ProvinciaOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {
    @Autowired
    ProvinciaRepository provinciaRepository;
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public ProvinciaOutputDto getProvinciaById(Long id) {
        Provincia provincia = provinciaRepository.findById(Math.toIntExact(id)).get();
        provincia.setClientes(clienteRepository.findByProvincia(provincia));
        return provincia.toOutputDto();
    }

    @Override
    public ProvinciaOutputDtoImp addProvincia(ProvinciaInputDto provinciaInputDto) {
        Provincia provincia = new Provincia();
        provincia.setIdProvincia(provinciaInputDto.getIdProvincia());
        provincia.setNombreProvincia(provinciaInputDto.getNombreProvincia());
        provinciaRepository.save(provincia);
        return provincia.toOutputDtoImp();
    }

    @Override
    public void deleteProvincia(Long id) {
        Provincia provincia = provinciaRepository.findById(Math.toIntExact(id)).get();
        provinciaRepository.delete(provincia);
    }

    @Override
    public ProvinciaOutputDtoSimple updateProvincia(ProvinciaInputDto provinciaInputDto, Long id) {
        Provincia provincia = provinciaRepository.findById(Math.toIntExact(id)).get();
        provincia.setIdProvincia(provinciaInputDto.getIdProvincia());
        provincia.setNombreProvincia(provinciaInputDto.getNombreProvincia());
        return provincia.toOutputDtoSimple();
    }

    @Override
    public List<ProvinciaOutputDtoSimple> getAllProvincias() {
        List<ProvinciaOutputDtoSimple> provincias = new ArrayList<>();
        for (Provincia provincia : provinciaRepository.findAll()) {
            provincia.setClientes(clienteRepository.findByProvincia(provincia));
            provincias.add(provincia.toOutputDtoSimple());
        }
        return provincias;
    }

    public ProvinciaOutputDtoSimple getProvinciaByName(String nombre) {
        Provincia provincia = provinciaRepository.findByNombre(nombre);
        provincia.setClientes(clienteRepository.findByProvincia(provincia));
        return provincia.toOutputDtoSimple();
    }
}
