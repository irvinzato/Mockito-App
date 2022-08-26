package org.rivera.mockitoapp.ejemplos.repositoriesdao;

import org.rivera.mockitoapp.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

//Simulación del repositorio de exámenes(La parte que conecta DB, API REST, etc.)
//Utilizando "mockito" esta implementación da igual, solo bastaría con la interfaz
public class ExamenRepositoryImpl implements ExamenRepository{
  @Override
  public List<Examen> findAllExams() {
    return Arrays.asList( new Examen(1L, "Matematicas"), new Examen(2L, "Espanol"), new Examen(4L, "Programacion")
                  , new Examen(5L, "Algoritmos"), new Examen(7L, "POO"));
  }
}
