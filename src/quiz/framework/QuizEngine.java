package quiz.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * QuizEngine - núcleo do framework (pacote quiz.framework)
 *
 * TEMPLATE METHOD: executar() define a sequência fixa do quiz:
 *   1. exibir pergunta
 *   2. capturar resposta
 *   3. computar resposta e atualizar pontuação (via responder())
 *   4. avançar
 *   5. resultado final
 * Essa ordem nunca muda.
 *
 * Os pontos variáveis do algoritmo não são resolvidos por subclasses
 * de QuizEngine, e sim por composição: a classe é concreta e recebe
 * prontos os colaboradores responsáveis por cada parte variável
 * (Factory -> perguntas, Strategy -> pontuação, interface de
 * exibição -> exibir/capturar resposta).
 */
public class QuizEngine extends QuizSujeito {
    private List<Pergunta> perguntas;
    private List<Jogador> jogadores;
    private InterfaceExibicao interfaceExibicao;
    private PontuacaoStrategy pontuacaoStrategy;
    private int perguntaAtual;

    public QuizEngine() {
        perguntaAtual = 0;
    }

    public void carregarPerguntas(List<Pergunta> perguntas) { this.perguntas = perguntas; }
    public void definirJogadores(List<Jogador> jogadores) { this.jogadores = jogadores; }
    public void definirInterfaceExibicao(InterfaceExibicao interfaceExibicao) { this.interfaceExibicao = interfaceExibicao; }
    public void definirPontuacaoStrategy(PontuacaoStrategy pontuacaoStrategy) { this.pontuacaoStrategy = pontuacaoStrategy; }

    private void avancar() {
        perguntaAtual++;
    }

    public ResultadoResposta responder(Jogador jogador, char item) {
        long tempoAtual = System.currentTimeMillis();
        long tempoGasto = tempoAtual - jogador.getTempoInicioPergunta();
        RespostaContexto contexto = new RespostaContexto(tempoGasto);

        boolean acertou = item == perguntas.get(perguntaAtual).getAlternativaCorreta();
        int pontos = acertou
                ? pontuacaoStrategy.pontuarAcerto(contexto)
                : pontuacaoStrategy.pontuarErro(contexto);

        jogador.adicionarPontos(pontos);
        jogador.adicionarTempoGasto(tempoGasto);

        if (acertou) jogador.registrarAcerto(); else jogador.registrarErro();

        ResultadoResposta resultado = new ResultadoResposta(acertou, pontos, tempoGasto);
        notificarResposta(jogador, resultado);
        return resultado;
    }

    public final void executar() {
        while (perguntaAtual < perguntas.size()) {
            Pergunta pergunta = perguntas.get(perguntaAtual);
            interfaceExibicao.exibirPergunta(pergunta);

            for (Jogador jogador : jogadores) {
                jogador.setTempoInicioPergunta(System.currentTimeMillis());
                char resposta = interfaceExibicao.obterResposta(jogador);
                ResultadoResposta resultado = responder(jogador, resposta);
                interfaceExibicao.exibirResultado(jogador, resultado);
            }
            avancar();
        }
        notificarFimDeQuiz(jogadores);
        interfaceExibicao.exibirSumario(jogadores);
    }
}
