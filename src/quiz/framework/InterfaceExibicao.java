package quiz.framework;

import java.util.List;

public interface InterfaceExibicao {
    List<Jogador> capturarJogadores();
    void exibirPergunta(Pergunta pergunta);
    char obterResposta(Jogador jogador);
    void exibirResultado(Jogador jogador, ResultadoResposta resultadoResposta);
    void exibirSumario(List<Jogador> jogadores);
}
