package org.rivera.mockitoapp.ejemplos.repositoriesdao;

import java.util.List;

public interface PreguntasRepository {
  List<String> findQuestionsByExamId(Long id);
}
