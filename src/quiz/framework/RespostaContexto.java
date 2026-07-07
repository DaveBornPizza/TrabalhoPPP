package quiz.framework;

/**
 * RespostaContexto - dados adicionais sobre a resposta do jogador
 * (ex: tempo gasto), usados pelas EstrategiaPontuacao que precisam
 * de mais do que só "acertou/errou" para calcular a pontuação.
 *
 * Novos dados podem ser adicionados aqui no futuro (ex: dificuldade
 * da pergunta) sem precisar alterar a assinatura da interface
 * PontuacaoStrategy — estratégias que não usam um campo simplesmente
 * o ignoram.
 */
public class RespostaContexto {
    private long tempoGasto;

    public RespostaContexto(long tempo) {
        tempoGasto = tempo;
    }

    public long getTempoGasto() { return tempoGasto; }
}
