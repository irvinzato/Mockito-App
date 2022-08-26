package org.rivera.mockitoapp.ejemplos.services;

import org.rivera.mockitoapp.ejemplos.models.Examen;
import org.rivera.mockitoapp.ejemplos.repositoriesdao.ExamenRepository;

import java.util.Optional;

//La idea es interactuar con el repositorio(simulación DAO)
public class ExamenServiceImpl implements ExamenService{
  private ExamenRepository examenRepository;  //Simulación del repositorio que tiene todos los exámenes

  public ExamenServiceImpl(ExamenRepository examenRepository) {
    this.examenRepository = examenRepository;
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
}
