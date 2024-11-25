package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.enums.CursoTypeEnum;
import lombok.*;

import java.math.BigDecimal;


public class CriarCursoRequest {

    private String name;

    private CursoTypeEnum type;

    private BigDecimal monthlyCost;

    public CriarCursoRequest() {
    }

    public CriarCursoRequest(String name, CursoTypeEnum type, BigDecimal monthlyCost) {
        this.name = name;
        this.type = type;
        this.monthlyCost = monthlyCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CursoTypeEnum getType() {
        return type;
    }

    public void setType(CursoTypeEnum type) {
        this.type = type;
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(BigDecimal monthlyCost) {
        this.monthlyCost = monthlyCost;
    }
}
