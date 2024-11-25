package br.com.alunoonline.api.model;

import br.com.alunoonline.api.enums.FinanceiroStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
public class FinanceiroAluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Aluno student;

    private Double discount;

    private Integer dueDate;

    @Enumerated(EnumType.STRING)
    private FinanceiroStatusEnum status;

    public FinanceiroAluno() {
    }

    public FinanceiroAluno(Long id, Aluno student, Double discount, Integer dueDate, FinanceiroStatusEnum status) {
        this.id = id;
        this.student = student;
        this.discount = discount;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getStudent() {
        return student;
    }

    public void setStudent(Aluno student) {
        this.student = student;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getDueDate() {
        return dueDate;
    }

    public void setDueDate(Integer dueDate) {
        this.dueDate = dueDate;
    }

    public FinanceiroStatusEnum getStatus() {
        return status;
    }

    public void setStatus(FinanceiroStatusEnum status) {
        this.status = status;
    }
}
