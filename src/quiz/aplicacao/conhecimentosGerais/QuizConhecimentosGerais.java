package quiz.aplicacao.conhecimentosGerais;

import quiz.framework.AbstractQuiz;
import quiz.framework.InterfaceExibicao;
import quiz.framework.Pergunta;
import quiz.framework.PontuacaoPorTempo;
import quiz.framework.PontuacaoStrategy;
import quiz.framework.QuizEngine;
import quiz.framework.annotation.PerguntaFactory;
import quiz.framework.annotation.ProcessadorAnotacoes;

import java.util.List;
import java.util.Scanner;

/**
 * Aplicação Cliente 2: Quiz de Conhecimentos Gerais, com interface de
 * exibição em console.
 *
 * Implementa os passos variáveis do Template Method definido em
 * AbstractQuiz, usando exatamente o mesmo QuizEngine da Aplicação 1 —
 * apenas trocando perguntas, estratégia de pontuação, interface de
 * exibição e observador de placar.
 */
public class QuizConhecimentosGerais extends AbstractQuiz {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    protected List<Pergunta> criarPerguntas() {
        ProcessadorAnotacoes processador = new ProcessadorAnotacoes(new PerguntaFactory());
        return processador.processarPacote(getClass().getPackage().getName());
    }

    @Override
    protected InterfaceExibicao criarInterfaceExibicao() {
        return new InterfaceExibicaoConsole(scanner);
    }

    @Override
    protected PontuacaoStrategy criarPontuacaoStrategy() {
        return new PontuacaoPorTempo();
    }

    @Override
    protected void configurarObservadores(QuizEngine engine) {
        engine.adicionarObserver(new PlacarConsole());
    }
}
