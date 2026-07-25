package quiz.framework;

import java.util.ArrayList;
import java.util.List;

public class QuizSujeito {
    private List<QuizObserver> observadores = new ArrayList<>();

    public void adicionarObserver(QuizObserver observer) {
        observadores.add(observer);
    }

    public void notificarResposta(Jogador jogador, ResultadoResposta resultado) {
        for (QuizObserver obs : observadores) {
            obs.aoResponder(jogador, resultado);
        }
    }

    public void notificarFimDeQuiz(List<Jogador> jogadores) {
        for (QuizObserver obs : observadores) {
            obs.aoFinalizarQuiz(jogadores);
        }
    }
}
