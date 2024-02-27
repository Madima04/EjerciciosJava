package com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.CabecerasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.LíneasDeFacturaRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.Repository.ProductoRepository;
import com.example.block7jpacomrelacionesyllamadasentremicros.application.LíneasDeFacturaService;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import org.example.dtos.input.LíneasDeFacturaInputDto;
import org.example.dtos.output.LíneasDeFacturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LíneasDeFacturaServiceImpl implements LíneasDeFacturaService {
    @Autowired
    LíneasDeFacturaRepository líneasDeFacturaRepository;
    @Autowired
    CabecerasDeFacturaRepository cabecerasDeFacturaRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Override
    public LíneasDeFacturaOutputDto getLíneasDeFactura(Long id) {
        return líneasDeFacturaRepository.findById(Math.toIntExact(id)).get().toOutputDto();
    }

    @Override
    public LíneasDeFacturaOutputDto addLíneasDeFactura(LíneasDeFacturaInputDto líneasDeFacturaInputDto) {
        LíneasDeFactura líneasDeFactura = new LíneasDeFactura();
        líneasDeFactura.setIdLínea(líneasDeFacturaInputDto.getIdLínea());
        líneasDeFactura.setCantidad(líneasDeFacturaInputDto.getCantidad());
        líneasDeFactura.setPrecio(líneasDeFacturaInputDto.getPrecio());
        líneasDeFactura.setImporte(líneasDeFacturaInputDto.getImporte());
        líneasDeFactura.setCabecerasDeFactura(cabecerasDeFacturaRepository.findById(líneasDeFacturaInputDto.getIdCabecera()).get());
        líneasDeFactura.setProducto(productoRepository.findById(líneasDeFacturaInputDto.getIdProducto()).get());
        return líneasDeFacturaRepository.save(líneasDeFactura).toOutputDto();
    }

    @Override
    public void deleteLíneasDeFactura(Long id) {
        líneasDeFacturaRepository.findById(Math.toIntExact(id)).ifPresent(líneasDeFacturaRepository::delete);
    }

    @Override
    public LíneasDeFacturaOutputDto updateLíneasDeFactura(LíneasDeFacturaInputDto líneasDeFacturaInputDto, Long id) {
        LíneasDeFactura líneasDeFactura = líneasDeFacturaRepository.findById(Math.toIntExact(id)).get();
        líneasDeFactura.setIdLínea(líneasDeFacturaInputDto.getIdLínea());
        líneasDeFactura.setCantidad(líneasDeFacturaInputDto.getCantidad());
        líneasDeFactura.setPrecio(líneasDeFacturaInputDto.getPrecio());
        líneasDeFactura.setImporte(líneasDeFacturaInputDto.getImporte());
        líneasDeFactura.setCabecerasDeFactura(cabecerasDeFacturaRepository.findById(líneasDeFacturaInputDto.getIdCabecera()).get());
        líneasDeFactura.setProducto(productoRepository.findById(líneasDeFacturaInputDto.getIdProducto()).get());
        return líneasDeFactura.toOutputDto();
    }

    @Override
    public Iterable<LíneasDeFacturaOutputDto> getAllLíneasDeFactura() {
        return líneasDeFacturaRepository.findAll().stream().map(LíneasDeFactura::toOutputDto).toList();
    }
}
