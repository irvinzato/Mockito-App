package org.rivera.mockitoapp.ejemplos.repositoriesdao;

import org.rivera.mockitoapp.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
  List<Examen> findAllExams();

  Examen save(Examen examen);
}
