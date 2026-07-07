package quiz.framework;

import java.util.List;

public interface QuizObserver {
    void aoResponder(Jogador jogador, ResultadoResposta resultado);
    void aoFinalizarQuiz(List<Jogador> jogadores);
}
