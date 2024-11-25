package br.com.alunoonline.api.dtos;


public class CriarAlunoRequest {
    private String name;
    private String email;
    private Long courseId;
    private Double discount;
    private Integer dueDate;

    public CriarAlunoRequest() {
    }

    public CriarAlunoRequest(String name, String email, Long courseId, Double discount, Integer dueDate) {
        this.name = name;
        this.email = email;
        this.courseId = courseId;
        this.discount = discount;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
}
