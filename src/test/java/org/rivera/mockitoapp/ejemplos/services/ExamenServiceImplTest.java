package org.rivera.mockitoapp.ejemplos.services;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.rivera.mockitoapp.ejemplos.models.Examen;
import org.rivera.mockitoapp.ejemplos.repositoriesdao.ExamenRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImplTest {

  //ASI SERIA SIN MOCKITO, ABAJO ENTRA MOCKITO
  /* @Test
  void findExamByName() {
    ExamenRepository repository = new ExamenRepositoryImpl();
    ExamenService service = new ExamenServiceImpl( repository );

    Examen exam = service.findExamByName("Matematicas");
    assertNotNull(exam);
    assertEquals(1L, exam.getId());
    assertEquals("Matematicas", exam.getName());
  } */

  @Test
  void findExamByName() {
    ExamenRepository repository = mock(ExamenRepository.class); //Lo importe de forma estática para no usar "Mockito.mock(ExamenRepository.class)"
    ExamenService service = new ExamenServiceImpl( repository );
    List<Examen> data = Arrays.asList( new Examen(1L, "Matematicas"), new Examen(2L, "Espanol"), new Examen(4L, "Programacion")
            , new Examen(5L, "Algoritmos"), new Examen(7L, "POO"));

    when(repository.findAllExams()).thenReturn(data);   //Cuando quiera ocupar el método de mi repositorio devuelvo "data"
    Examen exam = service.findExamByName("Matematicas");

    assertNotNull(exam);
    assertEquals(1L, exam.getId());
    assertEquals("Matematicas", exam.getName());
  }

  @Test
  void findExamByNameEmpty() {
    ExamenRepository repository = mock(ExamenRepository.class);
    ExamenService service = new ExamenServiceImpl( repository );
    List<Examen> data = Collections.emptyList();

    when(repository.findAllExams()).thenReturn(data);
    Examen exam = service.findExamByName("Matematicas");

    assertNull(exam);
  }

  //Muy parecido a los métodos de arriba pero lo modifique para usar "Optional<Examen>"
  @Test
  void findExamByNameOp() {
    ExamenRepository repository = mock(ExamenRepository.class);
    ExamenService service = new ExamenServiceImpl( repository );
    List<Examen> data = Arrays.asList( new Examen(1L, "Matematicas"), new Examen(2L, "Espanol"), new Examen(4L, "Programacion")
            , new Examen(5L, "Algoritmos"), new Examen(7L, "POO"));

    when(repository.findAllExams()).thenReturn(data);
    Optional<Examen> examOp = service.findExamByNameOp("Matematicas");

    assertTrue(examOp.isPresent());
    assertEquals(1L, examOp.orElseThrow().getId());
    assertEquals("Matematicas", examOp.get().getName());
  }
}