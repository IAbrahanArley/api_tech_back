package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
public class Fatura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_financial_id")
    private FinanceiroAluno studentFinancial;

    private LocalDateTime dueDate;

    private LocalDateTime paidOn;

    private LocalDateTime createdAt;

    public Fatura() {
    }

    public Fatura(Long id, FinanceiroAluno studentFinancial, LocalDateTime dueDate, LocalDateTime paidOn, LocalDateTime createdAt) {
        this.id = id;
        this.studentFinancial = studentFinancial;
        this.dueDate = dueDate;
        this.paidOn = paidOn;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FinanceiroAluno getStudentFinancial() {
        return studentFinancial;
    }

    public void setStudentFinancial(FinanceiroAluno studentFinancial) {
        this.studentFinancial = studentFinancial;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(LocalDateTime paidOn) {
        this.paidOn = paidOn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
