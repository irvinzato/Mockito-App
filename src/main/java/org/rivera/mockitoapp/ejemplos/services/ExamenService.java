package org.rivera.mockitoapp.ejemplos.services;

import org.rivera.mockitoapp.ejemplos.models.Examen;

import java.util.Optional;

public interface ExamenService {
  Examen findExamByName(String name);
  //Método que hace lo mismo que el de arriba pero utilizando "Optional"
  Optional<Examen> findExamByNameOp(String name);

  Examen findExamByNameWithQuestions(String name);

  Examen saveExam(Examen examen);

}
