package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.CriarAlunoRequest;
import br.com.alunoonline.api.dtos.CriarCursoRequest;
import br.com.alunoonline.api.enums.FinanceiroStatusEnum;
import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Curso;
import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.FinanceiroAluno;
import br.com.alunoonline.api.repository.CursoRepository;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public Curso create(CriarCursoRequest criarCursoRequest) {
        return cursoRepository.save(fromDTO(criarCursoRequest));
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

    public void update(Long id, Curso curso) {
        Optional<Curso> cursoFromDb = cursoRepository.findById(id);

        if (cursoFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado no banco de dados");
        }

        Curso cursoUpdated = cursoFromDb.get();

        cursoUpdated.setName(curso.getName());
        cursoUpdated.setType(curso.getType());
        cursoUpdated.setMonthlyCost(curso.getMonthlyCost());

        cursoRepository.save(cursoUpdated);
    }

    public Curso fromDTO(CriarCursoRequest obj){
        return new Curso(null, obj.getName(), obj.getType(), obj.getMonthlyCost());
    }




}
