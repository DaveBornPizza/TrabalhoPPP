package quiz.aplicacao.quiz2;

import quiz.framework.Jogador;
import quiz.framework.QuizObserver;
import quiz.framework.ResultadoResposta;

import java.util.List;

public class PlacarConsole implements QuizObserver {
    @Override
    public void aoResponder(Jogador jogador, ResultadoResposta resultado) {
        System.out.println(jogador.getNome() + " agora tem " + jogador.getPontuacaoAtual() + " pontos");
    }

    @Override
    public void aoFinalizarQuiz(List<Jogador> jogadores) {
        System.out.println("=== Ranking final ===");
        jogadores.stream()
                .sorted((a, b) -> b.getPontuacaoAtual() - a.getPontuacaoAtual())
                .forEach(j -> System.out.println(j.getNome() + ": " + j.getPontuacaoAtual()));
    }
}