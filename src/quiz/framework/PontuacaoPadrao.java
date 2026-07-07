package quiz.framework;

public class PontuacaoPadrao implements PontuacaoStrategy{
    public int pontuarAcerto(RespostaContexto contexto) {
        return 5;
    }
    public int pontuarErro(RespostaContexto contexto) {
        return 0;
    }
}
