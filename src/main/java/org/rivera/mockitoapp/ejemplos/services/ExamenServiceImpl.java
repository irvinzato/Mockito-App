package org.rivera.mockitoapp.ejemplos.services;

import org.rivera.mockitoapp.ejemplos.models.Examen;
import org.rivera.mockitoapp.ejemplos.repositoriesdao.ExamenRepository;
import org.rivera.mockitoapp.ejemplos.repositoriesdao.PreguntasRepository;

import java.util.List;
import java.util.Optional;

//La idea es interactuar con el repositorio(simulación DAO)
public class ExamenServiceImpl implements ExamenService{
  private ExamenRepository examenRepository;  //Simulación del repositorio que tiene todos los exámenes
  private PreguntasRepository preguntasRepository;

  public ExamenServiceImpl(ExamenRepository examenRepository, PreguntasRepository preguntasRepository) {
    this.examenRepository = examenRepository;
    this.preguntasRepository = preguntasRepository;
  }

  @Override
  public Examen findExamByName(String name) {
     Optional<Examen> examenOptional = examenRepository.findAllExams().stream()
                .filter( e -> e.getName().contains(name))
                .findFirst();
     Examen exam = null;
     if( examenOptional.isPresent() ) {
       exam = examenOptional.orElseThrow();
     }
    return exam;
  }

  //El mismo método de arriba lo hago que retorne un "Optional" para disminuirlo
  @Override
  public Optional<Examen> findExamByNameOp(String name) {
    return  examenRepository.findAllExams().stream()
            .filter( e -> e.getName().contains(name))
            .findFirst();
  }

  @Override
  public Examen findExamByNameWithQuestions(String name) {
    Optional<Examen> examOpt = findExamByNameOp(name);
    Examen exam = null;
    if( examOpt.isPresent() ) {
      exam = examOpt.orElseThrow();
      List<String> questions = preguntasRepository.findQuestionsByExamId( exam.getId() );
      exam.setQuestions(questions);
    }
    return exam;
  }
}
