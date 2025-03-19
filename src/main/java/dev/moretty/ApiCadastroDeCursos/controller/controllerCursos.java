package dev.moretty.ApiCadastroDeCursos.controller;

import dev.moretty.ApiCadastroDeCursos.model.modelCursos;
import dev.moretty.ApiCadastroDeCursos.service.serviceCursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Rota inicial da API
@RestController
@RequestMapping("/api/cursos")
public class controllerCursos {

    @Autowired
    private serviceCursos service;

    // Rota para adicionar um curso
    @PostMapping("/add")
    public ResponseEntity<modelCursos> addCursos(@RequestBody modelCursos curso) {
        modelCursos newCurso = service.addCurso(curso);
        return new ResponseEntity<>(newCurso, HttpStatus.CREATED);
    }

    // Rota para listar todos os cursos
    @GetMapping("/all")
    public ResponseEntity<List<modelCursos>> getAllCursos() {
        List<modelCursos> allCursos = service.getAllCursos();
        return new ResponseEntity<>(allCursos, HttpStatus.OK);
    }

    //Rota para deletar um curso por id
    @DeleteMapping("/delete/{id}")
    public void deleteCursos(@PathVariable Long id) {
        service.deleteCursos(id);
    }

    //Rota para buscar um curso por id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<modelCursos> OptinalCurso = service.findById(id);
        if (OptinalCurso.isPresent()) {
            return new ResponseEntity<>(OptinalCurso.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Curso não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    //Rota para atualizar um curso por id

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCursos(@PathVariable Long id, @RequestBody modelCursos curso) {
        Optional<modelCursos> OptinalCurso = service.findById(id);
        if (OptinalCurso.isPresent()) {
            modelCursos updateCurso = OptinalCurso.get();
            updateCurso.setPreco(curso.getPreco());
            updateCurso.setDescricao(curso.getDescricao());
            updateCurso.setNome(curso.getNome());
            service.addCurso(updateCurso);
            return new ResponseEntity<>(updateCurso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Curso não encontrado", HttpStatus.NOT_FOUND);
        }
    }

}