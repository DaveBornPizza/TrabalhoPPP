package quiz.framework;

public class PontuacaoPorTempo implements PontuacaoStrategy{
    public int pontuarAcerto(RespostaContexto contexto) {
        long tempoGasto = contexto.getTempoGasto();
        if (tempoGasto <= 10000) {
            return 10;
        } else if (tempoGasto <= 30000) {
            return 5;
        } else {
            return 3;
        }
    }
    public int pontuarErro(RespostaContexto contexto) {
        return 0;
    }
}
