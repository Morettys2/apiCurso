package dev.moretty.ApiCadastroDeCursos.service;

import dev.moretty.ApiCadastroDeCursos.model.modelCursos;
import dev.moretty.ApiCadastroDeCursos.repository.repositoryCursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceCursos {

    //Refatorar a isntancia futuramente
    @Autowired
    private repositoryCursos repo;

    //Post
    public modelCursos addCurso (modelCursos curso) {
        return repo.save(curso);
    }

    //List
    public List<modelCursos> getAllCursos() {
        return repo.findAll();
    }

    //delete
    public void deleteCursos(Long id) {
        repo.deleteById(id);
    }

    //get by id
    public Optional<modelCursos> findById(Long id) {
        return repo.findById(id);
    }

    //put
    public modelCursos updateCursos(modelCursos curso) {
        return repo.save(curso);
    }
}
