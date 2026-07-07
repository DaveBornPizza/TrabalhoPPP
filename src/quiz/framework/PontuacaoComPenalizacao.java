package quiz.framework;

public class PontuacaoComPenalizacao implements PontuacaoStrategy{
    public int pontuarAcerto(RespostaContexto contexto) {
        return 10;
    }
    public int pontuarErro(RespostaContexto contexto) {
        return -3;
    }
}
