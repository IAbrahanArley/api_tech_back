package br.com.alunoonline.api.dtos;

import lombok.Data;

import java.util.List;


public class HistoricoAlunoResponse {
    private String studentName;
    private String studentEmail;
    private List<DisciplinasAlunoResponse> studentSubjectsResponseList;

    public HistoricoAlunoResponse() {
    }

    public HistoricoAlunoResponse(String studentName, String studentEmail, List<DisciplinasAlunoResponse> studentSubjectsResponseList) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentSubjectsResponseList = studentSubjectsResponseList;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public List<DisciplinasAlunoResponse> getStudentSubjectsResponseList() {
        return studentSubjectsResponseList;
    }

    public void setStudentSubjectsResponseList(List<DisciplinasAlunoResponse> studentSubjectsResponseList) {
        this.studentSubjectsResponseList = studentSubjectsResponseList;
    }
}
