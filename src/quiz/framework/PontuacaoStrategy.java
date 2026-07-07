package quiz.framework;

public interface PontuacaoStrategy {
    int pontuarAcerto(RespostaContexto contexto);
    int pontuarErro(RespostaContexto contexto);
}
