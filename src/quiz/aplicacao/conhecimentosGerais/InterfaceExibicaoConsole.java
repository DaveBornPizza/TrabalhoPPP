package quiz.aplicacao.conhecimentosGerais;

import quiz.framework.Alternativa;
import quiz.framework.InterfaceExibicao;
import quiz.framework.Jogador;
import quiz.framework.Pergunta;
import quiz.framework.ResultadoResposta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementação da camada de exibição do framework utilizando o console.
 * O núcleo do framework (QuizEngine) não conhece esta classe: ele conversa
 * apenas com a abstração InterfaceExibicao, definida no pacote quiz.framework.
 */
public class InterfaceExibicaoConsole implements InterfaceExibicao {

    private final Scanner scanner;

    public InterfaceExibicaoConsole(Scanner scanner) {
        this.scanner = scanner;
    }
    private Pergunta perguntaAtual;

    @Override
    public List<Jogador> capturarJogadores() {
        List<Jogador> jogadores = new ArrayList<>();

        System.out.print("Quantos jogadores vão participar? ");
        int quantidade;
        try {
            quantidade = Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            quantidade = 1;
        }
        if (quantidade < 1) quantidade = 1;

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Nome do jogador " + i + ": ");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()) nome = "Jogador " + i;
            jogadores.add(new Jogador(nome));
        }
        return jogadores;
    }

    @Override
    public void exibirPergunta(Pergunta pergunta) {
        this.perguntaAtual = pergunta;
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println(pergunta.getEnunciado());
        for (Alternativa alternativa : pergunta.getAlternativas()) {
            System.out.println("  " + alternativa.getItem() + ") " + alternativa.getTexto());
        }
    }

    @Override
    public char obterResposta(Jogador jogador) {
        List<Alternativa> alternativas = perguntaAtual.getAlternativas();
        char resposta = ' ';
        boolean valido = false;

        while (!valido) {
            System.out.print(jogador.getNome() + ", digite a letra da alternativa: ");
            String linha = scanner.nextLine().trim().toUpperCase();
            if (!linha.isEmpty()) {
                resposta = linha.charAt(0);
                for (Alternativa alternativa : alternativas) {
                    if (alternativa.getItem() == resposta) {
                        valido = true;
                        break;
                    }
                }
            }
            if (!valido) {
                System.out.println("Alternativa inválida, tente novamente.");
            }
        }
        return resposta;
    }

    @Override
    public void exibirResultado(Jogador jogador, ResultadoResposta resultadoResposta) {
        System.out.println(resultadoResposta.isAcertou() ? "Correto!" : "Incorreto!");
        System.out.println("Pontos ganhos: " + resultadoResposta.getPontosGanhos());
        System.out.printf("Tempo de resposta: %.1fs%n", resultadoResposta.getTempoGastoMs() / 1000.0);
    }

    @Override
    public void exibirSumario(List<Jogador> jogadores) {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("                    RESULTADO FINAL");
        System.out.println("=========================================================");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ":");
            System.out.println("  Acertos: " + jogador.getAcertos());
            System.out.println("  Erros: " + jogador.getErros());
            System.out.println("  Pontuação final: " + jogador.getPontuacaoAtual());
            System.out.printf("  Tempo total: %.1fs%n", jogador.getTempoTotalGasto() / 1000.0);
            System.out.println();
        }
    }
}
