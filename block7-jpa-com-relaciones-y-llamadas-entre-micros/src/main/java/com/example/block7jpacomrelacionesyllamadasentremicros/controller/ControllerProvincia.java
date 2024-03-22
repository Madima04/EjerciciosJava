package com.example.block7jpacomrelacionesyllamadasentremicros.controller;

import com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation.ProvinciaServiceImpl;
import org.example.dtos.input.ProvinciaInputDto;
import org.example.dtos.output.ProvinciaOutputDto;
import org.example.dtos.output.ProvinciaOutputDtoImp;
import org.example.dtos.output.ProvinciaOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Provincia")
public class ControllerProvincia {

    @Autowired
    private ProvinciaServiceImpl provinciaService;

    @PutMapping(value ="/GetAllProvincias")
    public List<ProvinciaOutputDtoSimple> getAllProvincias() {
        return provinciaService.getAllProvincias();
    }

    @GetMapping(value = "/GetProvincia/{id}")
    public ProvinciaOutputDto getProvincia(@PathVariable Long id) {
        return provinciaService.getProvinciaById(id);
    }

    @GetMapping(value = "/addProvincia")
    public ProvinciaOutputDtoImp addProvincia(@RequestBody ProvinciaInputDto provincia) {
        return provinciaService.addProvincia(provincia);
    }

    @DeleteMapping(value = "/DeleteProvincia/{id}")
    public void deleteProvincia(@PathVariable Long id) { provinciaService.deleteProvincia(id);
    }

    @GetMapping(value = "/UpdateProvincia/{id}")
    public ProvinciaOutputDtoSimple updateProvincia(@RequestBody ProvinciaInputDto provincia, @PathVariable Long id) {
        return provinciaService.updateProvincia(provincia, id);
    }
}
