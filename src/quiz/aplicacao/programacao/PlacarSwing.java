package quiz.aplicacao.programacao;

import quiz.framework.Jogador;
import quiz.framework.QuizObserver;
import quiz.framework.ResultadoResposta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Observador (padrão Observer) que mantém uma janela Swing com o placar
 * atualizado em tempo real, a cada resposta registrada pelo QuizEngine,
 * e exibe o ranking final ao término do quiz.
 */
public class PlacarSwing implements QuizObserver {

    private final JFrame frame;
    private final JTextArea areaTexto;

    public PlacarSwing() {
        frame = new JFrame("Placar - Quiz de Programação");
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));

        frame.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        frame.setSize(420, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void aoResponder(Jogador jogador, ResultadoResposta resultado) {
        String status = resultado.isAcertou() ? "acertou" : "errou";
        areaTexto.append(jogador.getNome() + " " + status
                + " (+" + resultado.getPontosGanhos() + " pts) - total: "
                + jogador.getPontuacaoAtual() + " pts\n");
    }

    @Override
    public void aoFinalizarQuiz(List<Jogador> jogadores) {
        areaTexto.append("\n=== Ranking Final ===\n");
        jogadores.stream()
                .sorted((a, b) -> b.getPontuacaoAtual() - a.getPontuacaoAtual())
                .forEach(j -> areaTexto.append(j.getNome() + ": " + j.getPontuacaoAtual() + " pontos\n"));
    }
}
