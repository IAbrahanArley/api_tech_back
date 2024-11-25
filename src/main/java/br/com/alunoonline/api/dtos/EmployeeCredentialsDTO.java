package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.model.Employee;
import java.io.Serializable;

public class EmployeeCredentialsDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String password;
    private String nameEmployee;

    public EmployeeCredentialsDTO() {}

    public EmployeeCredentialsDTO(Employee entity) {
        id = entity.getId();
        email = entity.getEmail();
        password = entity.getPassword();
        nameEmployee = entity.getNameEmployee();
    }

    public EmployeeCredentialsDTO(String email, String password, String nameEmployee) {
        this.email = email;
        this.password = password;
        this.nameEmployee = nameEmployee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }
}