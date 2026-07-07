package quiz.framework;

/**
 * ResultadoResposta - dados sobre o resultado de uma resposta
 * (acertou/errou, pontos ganhos, tempo gasto), retornados por
 * responder() e usados pela interface de exibição para mostrar
 * feedback ao jogador.
 *
 * Novos dados podem ser adicionados aqui no futuro (ex: mensagem
 * motivacional, streak de acertos) sem precisar alterar a assinatura
 * de responder() — a interface simplesmente exibe os campos que
 * quiser usar.
 */
public class ResultadoResposta {
    private final boolean acertou;
    private final int pontosGanhos;
    private final long tempoGastoMs;

    public ResultadoResposta(boolean acertou, int pontosGanhos, long tempoGastoMs) {
        this.acertou = acertou;
        this.pontosGanhos = pontosGanhos;
        this.tempoGastoMs = tempoGastoMs;
    }

    public boolean isAcertou() { return acertou; }
    public int getPontosGanhos() { return pontosGanhos; }
    public long getTempoGastoMs() { return tempoGastoMs; }
}