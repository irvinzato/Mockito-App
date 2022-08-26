package org.rivera.mockitoapp.ejemplos.services;

import org.rivera.mockitoapp.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {

  public final static List<Examen> EXAMS = Arrays.asList( new Examen(1L, "Matematicas"), new Examen(2L, "Espanol"), new Examen(4L, "Programacion")
          , new Examen(5L, "Algoritmos"), new Examen(7L, "POO"));

  public final static List<String> QUESTIONS_MAT = Arrays.asList("Geometria", "Diferencial", "Ecuaciones"
          , "Discretas", "Ordinarias");
}
