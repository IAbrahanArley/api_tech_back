package br.com.alunoonline.api.model;

import br.com.alunoonline.api.enums.CursoTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CursoTypeEnum type;

    private BigDecimal monthlyCost;

    public Curso() {
    }

    public Curso(Long id, String name, CursoTypeEnum type, BigDecimal monthlyCost) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.monthlyCost = monthlyCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
