package quiz.aplicacao.programacao;

import quiz.framework.Alternativa;
import quiz.framework.InterfaceExibicao;
import quiz.framework.Jogador;
import quiz.framework.Pergunta;
import quiz.framework.ResultadoResposta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da camada de exibição do framework utilizando Java Swing.
 * O núcleo do framework (QuizEngine) não conhece esta classe: ele conversa
 * apenas com a abstração InterfaceExibicao, definida no pacote quiz.framework.
 */
public class InterfaceExibicaoSwing implements InterfaceExibicao {

    private Pergunta perguntaAtual;

    @Override
    public List<Jogador> capturarJogadores() {
        List<Jogador> jogadores = new ArrayList<>();

        String quantidadeStr = JOptionPane.showInputDialog(
                null, "Quantos jogadores vão participar?", "Quiz de Programação", JOptionPane.QUESTION_MESSAGE);

        int quantidade;
        try {
            quantidade = Integer.parseInt(quantidadeStr.trim());
        } catch (Exception e) {
            quantidade = 1;
        }
        if (quantidade < 1) quantidade = 1;

        for (int i = 1; i <= quantidade; i++) {
            String nome = JOptionPane.showInputDialog(
                    null, "Nome do jogador " + i + ":", "Quiz de Programação", JOptionPane.QUESTION_MESSAGE);
            if (nome == null || nome.trim().isEmpty()) nome = "Jogador " + i;
            jogadores.add(new Jogador(nome));
        }
        return jogadores;
    }

    @Override
    public void exibirPergunta(Pergunta pergunta) {
        this.perguntaAtual = pergunta;
    }

    @Override
    public char obterResposta(Jogador jogador) {
        List<Alternativa> alternativas = perguntaAtual.getAlternativas();
        String[] opcoes = new String[alternativas.size()];
        for (int i = 0; i < alternativas.size(); i++) {
            Alternativa alternativa = alternativas.get(i);
            opcoes[i] = alternativa.getItem() + ") " + alternativa.getTexto();
        }

        String mensagem = "Vez de " + jogador.getNome() + ":\n\n" + perguntaAtual.getEnunciado();

        Object escolha = JOptionPane.showInputDialog(
                null,
                mensagem,
                "Quiz de Programação",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        String opcaoEscolhida = (escolha == null) ? opcoes[0] : escolha.toString();
        return opcaoEscolhida.charAt(0);
    }

    @Override
    public void exibirResultado(Jogador jogador, ResultadoResposta resultadoResposta) {
        String titulo = resultadoResposta.isAcertou() ? "Resposta correta!" : "Resposta incorreta!";
        String mensagem = titulo
                + "\nPontos ganhos: " + resultadoResposta.getPontosGanhos()
                + "\nTempo de resposta: " + String.format("%.1fs", resultadoResposta.getTempoGastoMs() / 1000.0)
                + "\nPontuação atual de " + jogador.getNome() + ": " + jogador.getPontuacaoAtual();
        JOptionPane.showMessageDialog(null, mensagem, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void exibirSumario(List<Jogador> jogadores) {
        StringBuilder sb = new StringBuilder("=== Resultado final ===\n\n");
        for (Jogador jogador : jogadores) {
            sb.append(jogador.getNome()).append(":\n")
              .append("   Acertos: ").append(jogador.getAcertos()).append("\n")
              .append("   Erros: ").append(jogador.getErros()).append("\n")
              .append("   Pontuação final: ").append(jogador.getPontuacaoAtual()).append("\n\n")
              .append("   Tempo total: ").append(String.format("%.1fs", jogador.getTempoTotalGasto() / 1000.0)).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(),
                "Quiz de Programação - Resultado Final", JOptionPane.PLAIN_MESSAGE);
    }
}
