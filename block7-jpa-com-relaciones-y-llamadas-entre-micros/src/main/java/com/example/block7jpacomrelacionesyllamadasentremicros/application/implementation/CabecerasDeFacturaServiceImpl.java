package com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.CabecerasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ClienteRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.LíneasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ProductoRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.application.CabecerasDeFacturaService;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.CabecerasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.CabecerasDeFacturaOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDtoSimple;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.CabecerasDeFactura;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class CabecerasDeFacturaServiceImpl implements CabecerasDeFacturaService {
    @Autowired
    CabecerasDeFacturaRepository cabecerasDeFacturaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    LíneasDeFacturaRepository líneasDeFacturaRepository;
    @Autowired
    ProductoRepository productoRepository;

    @Override
    public CabecerasDeFacturaOutputDto addCabeceraDeFactura(CabecerasDeFacturaInputDto cabecerasDeFacturaInputDto) {
        Set<LíneasDeFactura> líneasDeFacturaInputDtoSimples = new HashSet<>();
        CabecerasDeFactura cabecerasDeFactura = new CabecerasDeFactura();
        cabecerasDeFactura.setIdCabecera(cabecerasDeFacturaInputDto.getIdCabecera());
        cabecerasDeFactura.setFecha(cabecerasDeFacturaInputDto.getFecha());
        cabecerasDeFactura.setCliente(clienteRepository.findById(cabecerasDeFacturaInputDto.getDNI()).get());
        if (cabecerasDeFacturaInputDto.getLíneasDeFactura() != null) {
            for (LíneasDeFacturaOutputDtoSimple líneasDeFactura : cabecerasDeFacturaInputDto.getLíneasDeFactura()) {
                LíneasDeFactura líneasDeFactura1 = new LíneasDeFactura();
                líneasDeFactura1.setIdLínea(líneasDeFactura.getIdLínea());
                líneasDeFactura1.setCantidad(líneasDeFactura.getCantidad());
                líneasDeFactura1.setProducto(productoRepository.findById(líneasDeFactura.getIdProducto()).get());
                if (líneasDeFactura.getPrecio() != 0) {
                    líneasDeFactura1.setPrecio(líneasDeFactura.getPrecio());
                } else {
                    líneasDeFactura1.setPrecio(líneasDeFactura1.getProducto().getPrecio());
                }
                líneasDeFactura1.setCabecera(cabecerasDeFactura);
                líneasDeFactura1.setImporte(líneasDeFactura1.getPrecio() * líneasDeFactura1.getCantidad());
                líneasDeFacturaInputDtoSimples.add(líneasDeFactura1);
            }
            cabecerasDeFactura.setImporteTotalFactura(líneasDeFacturaInputDtoSimples.stream().map(LíneasDeFactura::getImporte).reduce(0f, Float::sum));
            cabecerasDeFacturaRepository.save(cabecerasDeFactura);
            cabecerasDeFactura.setLíneasDeFactura(líneasDeFacturaInputDtoSimples);
            líneasDeFacturaRepository.saveAll(líneasDeFacturaInputDtoSimples);
        } else {
            cabecerasDeFactura.setLíneasDeFactura(líneasDeFacturaInputDtoSimples);
        }
        return cabecerasDeFactura.toOutputDto();
    }

    @Override
    public CabecerasDeFacturaOutputDto getCabeceraDeFactura(Long id) {
        CabecerasDeFacturaOutputDto cabecerasDeFacturaOutputDto = new CabecerasDeFacturaOutputDto();
        cabecerasDeFacturaRepository.findById(Math.toIntExact(id));
        return cabecerasDeFacturaOutputDto;
    }

    @Override
    public void deleteCabeceraDeFactura(int id) {
        cabecerasDeFacturaRepository.findById(id).ifPresent(cabecerasDeFacturaRepository::delete);
    }

    @Override
    public CabecerasDeFacturaOutputDto updateCabeceraDeFactura(CabecerasDeFacturaInputDto cabecerasDeFacturaInputDto, Long id) {
        CabecerasDeFactura cabecerasDeFactura = new CabecerasDeFactura();
        cabecerasDeFactura.setIdCabecera(cabecerasDeFacturaInputDto.getIdCabecera());
        cabecerasDeFactura.setFecha(cabecerasDeFacturaInputDto.getFecha());
        cabecerasDeFactura.setCliente(clienteRepository.findById(cabecerasDeFacturaInputDto.getDNI()).get());
        if (cabecerasDeFacturaInputDto.getLíneasDeFactura() != null) {
            for (LíneasDeFacturaOutputDtoSimple líneasDeFactura : cabecerasDeFacturaInputDto.getLíneasDeFactura()) {
                LíneasDeFactura líneasDeFactura1 = new LíneasDeFactura();
                líneasDeFactura1.setIdLínea(líneasDeFactura.getIdLínea());
                líneasDeFactura1.setCantidad(líneasDeFactura.getCantidad());
                líneasDeFactura1.setPrecio(líneasDeFactura.getPrecio());
                líneasDeFactura1.setProducto(productoRepository.findById(líneasDeFactura.getIdProducto()).get());
                líneasDeFactura1.setImporte(líneasDeFactura1.getPrecio() * líneasDeFactura1.getCantidad());
                líneasDeFactura1.setCabecera(cabecerasDeFactura);
                líneasDeFacturaRepository.save(líneasDeFactura1);
            }
        } else {
            cabecerasDeFactura.setLíneasDeFactura(null);
        }
        return cabecerasDeFactura.toOutputDto();
    }

    @Override
    public List<CabecerasDeFacturaOutputDto> getAllCabecerasDeFactura() {
        List<CabecerasDeFacturaOutputDto> cabecerasDeFacturaList = new LinkedList<>();
        Set<LíneasDeFacturaOutputDtoSimple> líneasDeFacturaList = new HashSet<>();
        CabecerasDeFacturaOutputDto cabecerasDeFacturaOutputDto = new CabecerasDeFacturaOutputDto();
        for (CabecerasDeFactura cabecerasDeFactura : cabecerasDeFacturaRepository.findAll()) {
            cabecerasDeFacturaOutputDto.setIdCabecera(cabecerasDeFactura.getIdCabecera());
            cabecerasDeFacturaOutputDto.setFecha(cabecerasDeFactura.getFecha());
            cabecerasDeFacturaOutputDto.setImporteTotalFactura(cabecerasDeFactura.getImporteTotalFactura());
            cabecerasDeFacturaOutputDto.setCliente(cabecerasDeFactura.getCliente().toOutputDtoSimple());
            for (LíneasDeFactura líneasDeFactura : cabecerasDeFactura.getLíneasDeFactura()) {
                for (LíneasDeFactura líneasDeFactura1 : líneasDeFacturaRepository.findAll()) {
                    líneasDeFacturaList.add(líneasDeFactura1.toOutputDtoSimple());
                    cabecerasDeFacturaOutputDto.setLíneasDeFactura(líneasDeFacturaList);
                }
            }
            cabecerasDeFacturaList.add(cabecerasDeFacturaOutputDto);
        }
        return cabecerasDeFacturaList;
    }
}
