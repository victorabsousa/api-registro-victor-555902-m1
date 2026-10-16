
package com.github.victorabsousa.registro.dtos;

import com.github.victorabsousa.registro.entities.CondicaoClimatica;
import com.github.victorabsousa.registro.entities.RegistroMeteorologico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistroMeteorologicoResponseDTO {

    private Long registroId;
    private String estacaoNome;
    private LocalDate dataRegistro;
    private BigDecimal temperatura;
    private BigDecimal percentualUmidade;
    private BigDecimal precipitacao;
    private CondicaoClimatica condicaoClimatica;

    public RegistroMeteorologicoResponseDTO(RegistroMeteorologico registro) {
        this.registroId = registro.getRegistroId();
        this.estacaoNome = registro.getEstacaoNome();
        this.dataRegistro = registro.getDataRegistro();
        this.temperatura = registro.getTemperatura();
        this.percentualUmidade = registro.getPercentualUmidade();
        this.precipitacao = registro.getPrecipitacao();
        this.condicaoClimatica = registro.getCondicaoClimatica();
    }

    public Long getRegistroId() {
        return registroId;
    }

    public String getEstacaoNome() {
        return estacaoNome;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public BigDecimal getPercentualUmidade() {
        return percentualUmidade;
    }

    public BigDecimal getPrecipitacao() {
        return precipitacao;
    }

    public CondicaoClimatica getCondicaoClimatica() {
        return condicaoClimatica;
    }
}
