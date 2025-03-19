package dev.moretty.ApiCadastroDeCursos.repository;

import dev.moretty.ApiCadastroDeCursos.model.modelCursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryCursos extends JpaRepository<modelCursos, Long> {
}
