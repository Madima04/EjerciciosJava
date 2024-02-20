package com.example.block7jpacomrelacionesyllamadasentremicros2.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros2.application.HistoricoVentasService;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoVentas;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.input.HistoricoVentasInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoVentasOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoVentasRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.*;

@Service
public class HistoricoVentasServiceImpl implements HistoricoVentasService {

    @Autowired
    public void setHistoricoVentasRepository(HistoricoVentasRepository repositorio) {
        this.historicoVentasRepository = repositorio;
    }

    private HistoricoVentasRepository historicoVentasRepository;

    @Override
    public HistoricoVentasOutputDto createHistoricoVentas(HistoricoVentasInputDto historicoVentasInputDto) {
        historicoVentasRepository.save(historicoVentasInputDto.toHistoricoVentas());
        return historicoVentasInputDto.toHistoricoVentas().toHistoricoVentasOutputDto();
    }

    @Override
    public List<HistoricoVentasOutputDto> readHistoricoVentas(int id) {
        HistoricoVentas historicoVentasAux;
        List<HistoricoVentasOutputDto> historicoVentasOutputDtoList = new ArrayList<>();
        Optional<HistoricoVentas> historicoVentas = historicoVentasRepository.findById(id);
        if (historicoVentas.isPresent()) {
            return Collections.singletonList(historicoVentas.get().toHistoricoVentasOutputDto());
        } else {
            Map<String, Object> resultado = obtenerHistoricoVentas(id);
            System.out.println(resultado);
            List<Object> listaLíneasDeFactura = (List<Object>) resultado.get("líneasDeFactura");
            List<Object> cliente = Collections.singletonList(resultado.get("cliente"));
            Map<String, Object> clienteMap = (Map<String, Object>) cliente.get(0);

            // Inicializamos el importe total a 0
            double importeTotal = 0;

            // Iteramos sobre todas las líneas de factura
            for (Object linea : listaLíneasDeFactura) {
                Map<String, Object> lineaMap = (Map<String, Object>) linea;
                historicoVentasAux = new HistoricoVentas();
                historicoVentasAux.setClienteId((Integer) clienteMap.get("dni"));
                historicoVentasAux.setProductoId((Integer) lineaMap.get("idProducto"));
                historicoVentasAux.setMes(Integer.parseInt(resultado.get("fecha").toString().substring(5, 7)));
                historicoVentasAux.setAño(Integer.parseInt(resultado.get("fecha").toString().substring(0, 4)));
                historicoVentasAux.setCantidad((Integer) lineaMap.get("cantidad"));
                Object cantidad =  lineaMap.get("cantidad");
                Object precio = lineaMap.get("precio");
                double importe = (Integer) cantidad * (Double) precio;
                importeTotal += importe;  // Sumamos el importe de cada línea al total
                historicoVentasAux.setImporte(importe);
                historicoVentasRepository.save(historicoVentasAux);
                historicoVentasOutputDtoList.add(historicoVentasAux.toHistoricoVentasOutputDto());
            }
            return historicoVentasOutputDtoList;
        }
    }


    private Map<String, Object> obtenerHistoricoVentas(int id) {
        try {
            String url = "http://localhost:8080/CabeceraDeFactura/GetCabeceraDeFactura/" + id;

            WebClient webClient = WebClient.create(url);
            Mono<String> jsonMono = webClient.get().uri(url).retrieve().bodyToMono(String.class);
            String json = jsonMono.block(); // Obtener el JSON como cadena
            ObjectMapper objectMapper = new ObjectMapper();
            // Convertir el JSON a un Map<String, Object>
            return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            // Manejo de excepciones
            throw new RuntimeException("Error al obtener el historial de ventas", e);
        }

    }

    private Map<String, Object> obtenerHistoricoVentasFecha(int dni, String fechaInicio, String fechaFin) {
        try {
            String url = "http://localhost:8080/CabeceraDeFactura/GetCabeceraDeFacturaByClienteInDateRange?dni=";

            WebClient webClient = WebClient.create(url);
            Mono<String> jsonMono = webClient.get().uri(url).retrieve().bodyToMono(String.class);
            String json = jsonMono.block(); // Obtener el JSON como cadena
            ObjectMapper objectMapper = new ObjectMapper();
            // Convertir el JSON a un Map<String, Object>
            return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            // Manejo de excepciones
            throw new RuntimeException("Error al obtener el historial de ventas", e);
        }

    }

    private HistoricoVentasOutputDto mapToHistoricoVentasOutputDto(Map<String, List<Object>> resultado) {
        HistoricoVentasOutputDto historicoVentasOutputDto = new HistoricoVentasOutputDto();
        List<Object> columnas = resultado.get("Resultado");
        historicoVentasOutputDto.setClienteId((Integer) columnas.get(1));
        historicoVentasOutputDto.setProductoId((Integer) columnas.get(2));
        historicoVentasOutputDto.setMes((Integer) columnas.get(3));
        historicoVentasOutputDto.setAño((Integer) columnas.get(4));
        historicoVentasOutputDto.setImporte((Double) columnas.get(6));
        return historicoVentasOutputDto;
    }


    @Override
    public HistoricoVentasOutputDto updateHistoricoVentas(HistoricoVentasInputDto historicoVentasInputDto, int id) {
        Optional<HistoricoVentas> historicoVentas = historicoVentasRepository.findById(id);
        if (historicoVentas.isPresent()) {
            HistoricoVentas historicoVentas1 = historicoVentas.get();
            historicoVentas1.setId(id);
            historicoVentas1.setClienteId(historicoVentasInputDto.getClienteId());
            historicoVentas1.setProductoId(historicoVentasInputDto.getProductoId());
            historicoVentas1.setMes(historicoVentasInputDto.getMes());
            historicoVentas1.setAño(historicoVentasInputDto.getAño());
            historicoVentas1.setCantidad(historicoVentasInputDto.getCantidad());
            historicoVentas1.setImporte(historicoVentasInputDto.getImporte());
            historicoVentasRepository.save(historicoVentas1);
            return historicoVentas1.toHistoricoVentasOutputDto();
        }
        return null;
    }

    @Override
    public void deleteHistoricoVentas(int id) {
        historicoVentasRepository.deleteById(id);
    }

    @Override
    public Iterable<HistoricoVentasOutputDto> findAllHistoricoVentas() {
        List<HistoricoVentasOutputDto> historicoVentasList = new ArrayList<>();
        Iterable<HistoricoVentas> historicoVentas = historicoVentasRepository.findAll();
        for (HistoricoVentas historicoVentas1 : historicoVentas) {
            historicoVentasList.add(historicoVentas1.toHistoricoVentasOutputDto());
        }
        return historicoVentasList;
    }

}
