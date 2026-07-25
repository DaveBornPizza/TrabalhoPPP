package quiz.aplicacao.programacao;

import quiz.framework.InterfaceExibicao;
import quiz.framework.Pergunta;
import quiz.framework.PontuacaoPadrao;
import quiz.framework.PontuacaoStrategy;
import quiz.framework.QuizEngine;
import quiz.framework.AbstractQuiz;
import quiz.framework.annotation.PerguntaFactory;
import quiz.framework.annotation.ProcessadorAnotacoes;

import javax.swing.*;
import java.util.List;

/**
 * Aplicação Cliente 1: Quiz de Programação, com interface gráfica Java Swing.
 *
 * Implementa os passos variáveis do Template Method definido em
 * AbstractQuiz, além de registrar um observador de placar (Observer).
 */
public class QuizProgramacao extends AbstractQuiz {

    @Override
    protected List<Pergunta> criarPerguntas() {
        ProcessadorAnotacoes processador = new ProcessadorAnotacoes(new PerguntaFactory());
        return processador.processarPacote(getClass().getPackage().getName());
    }

    @Override
    protected InterfaceExibicao criarInterfaceExibicao() {
        return new InterfaceExibicaoSwing();
    }

    @Override
    protected PontuacaoStrategy criarPontuacaoStrategy() {
        return new PontuacaoPadrao();
    }

    @Override
    protected void configurarObservadores(QuizEngine engine) {
        engine.adicionarObserver(new PlacarSwing());
    }
}
