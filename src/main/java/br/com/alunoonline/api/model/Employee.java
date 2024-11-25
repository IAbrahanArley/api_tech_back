package br.com.alunoonline.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_employee")
public class Employee extends Auth{

    private static final long serialVersionUID = 1L;

    @Column(name = "name_employee", nullable = false)
    private String nameEmployee;

    public Employee(String email, String password, String nameEmployee, Boolean accountNonExpired, Boolean accountNonLocked,
                    Boolean credentialsNonExpired, Boolean enabled) {
        super(email, password, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled);
        this.nameEmployee = nameEmployee;
    }

    public Employee() {
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

}