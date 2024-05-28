package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.CriarAlunoRequest;
import br.com.alunoonline.api.dtos.CriarCursoRequest;
import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Curso;
import br.com.alunoonline.api.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findAll(){ return cursoService.findAll();}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CriarCursoRequest criarCursoRequest) {
        cursoService.create(criarCursoRequest);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Curso curso, @PathVariable Long id) {
        cursoService.update(id, curso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        cursoService.deleteById(id);
    }


}
