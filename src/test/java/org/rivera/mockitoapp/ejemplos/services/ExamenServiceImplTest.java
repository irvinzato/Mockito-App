package org.rivera.mockitoapp.ejemplos.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.rivera.mockitoapp.ejemplos.models.Examen;
import org.rivera.mockitoapp.ejemplos.repositoriesdao.ExamenRepository;
import org.rivera.mockitoapp.ejemplos.repositoriesdao.PreguntasRepository;

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
  ExamenRepository repositoryExam;
  PreguntasRepository repositoryQuestions;
  ExamenService service;

  @BeforeEach
  void setUp() {
    repositoryExam = mock(ExamenRepository.class);            //Indico que estará mockeada la interfaz
    repositoryQuestions = mock(PreguntasRepository.class);    //Lo importe de forma estática para no usar "Mockito.mock(ExamenRepository.class)"
    service = new ExamenServiceImpl( repositoryExam, repositoryQuestions );
  }

  @Test
  void findExamByName() {
    when(repositoryExam.findAllExams()).thenReturn(Datos.EXAMS);   //Cuando quiera ocupar el método de mi repositorio devuelvo "data"
    Examen exam = service.findExamByName("Matematicas");

    assertNotNull(exam);
    assertEquals(1L, exam.getId());
    assertEquals("Matematicas", exam.getName());
  }

  @Test
  void findExamByNameEmpty() {
    List<Examen> data = Collections.emptyList();

    when(repositoryExam.findAllExams()).thenReturn(data);
    Examen exam = service.findExamByName("Matematicas");

    assertNull(exam);
  }

  //Muy parecido a los métodos de arriba pero lo modifique para usar "Optional<Examen>"
  @Test
  void findExamByNameOp() {
    when(repositoryExam.findAllExams()).thenReturn(Datos.EXAMS);
    Optional<Examen> examOp = service.findExamByNameOp("Algoritmos");

    assertTrue(examOp.isPresent());
    assertEquals(5L, examOp.orElseThrow().getId());
    assertEquals("Algoritmos", examOp.get().getName());
  }

  @Test
  void questionsExamTest() {
    when(repositoryExam.findAllExams()).thenReturn(Datos.EXAMS);
    when(repositoryQuestions.findQuestionsByExamId(1L)).thenReturn(Datos.QUESTIONS_MAT);
    Examen exam = service.findExamByNameWithQuestions("Matematicas");

    assertEquals(5, exam.getQuestions().size());
    assertTrue( exam.getQuestions().contains("Discretas") );
  }
}