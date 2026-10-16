
package com.github.victorabsousa.registro.services;

import com.github.victorabsousa.registro.dtos.RegistroMeteorologicoRequestDTO;
import com.github.victorabsousa.registro.dtos.RegistroMeteorologicoResponseDTO;
import com.github.victorabsousa.registro.entities.RegistroMeteorologico;
import com.github.victorabsousa.registro.repositories.RegistroMeteorologicoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RegistroMeteorologicoService {

    private final RegistroMeteorologicoRepository repository;

    public RegistroMeteorologicoService(
            RegistroMeteorologicoRepository repository) {
        this.repository = repository;
    }

    public List<RegistroMeteorologicoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(RegistroMeteorologicoResponseDTO::new)
                .toList();
    }

    public RegistroMeteorologicoResponseDTO buscarPorId(Long id) {
        RegistroMeteorologico registro = buscarEntidade(id);
        return new RegistroMeteorologicoResponseDTO(registro);
    }

    @Transactional
    public RegistroMeteorologicoResponseDTO cadastrar(
            RegistroMeteorologicoRequestDTO dto) {

        RegistroMeteorologico registro = new RegistroMeteorologico();
        preencherDados(registro, dto);

        registro = repository.save(registro);

        return new RegistroMeteorologicoResponseDTO(registro);
    }

    @Transactional
    public RegistroMeteorologicoResponseDTO atualizar(
            Long id, RegistroMeteorologicoRequestDTO dto) {

        RegistroMeteorologico registro = buscarEntidade(id);
        preencherDados(registro, dto);

        registro = repository.save(registro);

        return new RegistroMeteorologicoResponseDTO(registro);
    }

    @Transactional
    public void excluir(Long id) {
        RegistroMeteorologico registro = buscarEntidade(id);
        repository.delete(registro);
    }

    private RegistroMeteorologico buscarEntidade(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro meteorologico nao encontrado"
                ));
    }

    private void preencherDados(
            RegistroMeteorologico registro,
            RegistroMeteorologicoRequestDTO dto) {

        registro.setEstacaoNome(dto.getEstacaoNome());
        registro.setDataRegistro(dto.getDataRegistro());
        registro.setTemperatura(dto.getTemperatura());
        registro.setPercentualUmidade(dto.getPercentualUmidade());
        registro.setPrecipitacao(dto.getPrecipitacao());
        registro.setCondicaoClimatica(dto.getCondicaoClimatica());
    }
}
