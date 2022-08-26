package org.rivera.mockitoapp.ejemplos.services;

import org.rivera.mockitoapp.ejemplos.models.Examen;

public interface ExamenService {
  Examen findExamByName(String name);
}
