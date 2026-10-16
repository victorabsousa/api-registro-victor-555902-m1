
package com.github.victorabsousa.registro.dtos;

import com.github.victorabsousa.registro.entities.CondicaoClimatica;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistroMeteorologicoRequestDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    private String estacaoNome;

    @NotNull
    @PastOrPresent
    private LocalDate dataRegistro;

    @NotNull
    private BigDecimal temperatura;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private BigDecimal percentualUmidade;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal precipitacao;

    @NotNull
    private CondicaoClimatica condicaoClimatica;

    public String getEstacaoNome() {
        return estacaoNome;
    }

    public void setEstacaoNome(String estacaoNome) {
        this.estacaoNome = estacaoNome;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public BigDecimal getPercentualUmidade() {
        return percentualUmidade;
    }

    public void setPercentualUmidade(BigDecimal percentualUmidade) {
        this.percentualUmidade = percentualUmidade;
    }

    public BigDecimal getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(BigDecimal precipitacao) {
        this.precipitacao = precipitacao;
    }

    public CondicaoClimatica getCondicaoClimatica() {
        return condicaoClimatica;
    }

    public void setCondicaoClimatica(CondicaoClimatica condicaoClimatica) {
        this.condicaoClimatica = condicaoClimatica;
    }
}
