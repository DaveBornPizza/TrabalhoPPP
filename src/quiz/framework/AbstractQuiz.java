package quiz.framework;

import java.util.List;

/**
 * AbstractQuiz - TEMPLATE METHOD do framework.
 *
 * Define, em iniciar(), o algoritmo fixo de configuração e disparo de um
 * quiz: montar perguntas, montar jogadores, escolher a interface de
 * exibição e a estratégia de pontuação, opcionalmente registrar
 * observadores e então executar o QuizEngine. Essa sequência é a mesma
 * para qualquer aplicação cliente e por isso o método é "final".
 *
 * Os passos que variam de aplicação para aplicação (quais perguntas,
 * qual estratégia de pontuação, qual interface de exibição, quais
 * jogadores) são "hooks" abstratos ou com implementação padrão,
 * resolvidos pelas subclasses concretas de cada aplicação
 * (ex: QuizProgramacao, QuizConhecimentosGerais).
 */
public abstract class AbstractQuiz {

    public final void iniciar() {
        QuizEngine engine = new QuizEngine();

        InterfaceExibicao interfaceExibicao = criarInterfaceExibicao();

        engine.carregarPerguntas(criarPerguntas());
        engine.definirJogadores(interfaceExibicao.capturarJogadores()); /* Passo fixo */
        engine.definirInterfaceExibicao(interfaceExibicao);
        engine.definirPontuacaoStrategy(criarPontuacaoStrategy());

        configurarObservadores(engine);

        engine.executar();
    }

    /** Passo variável: quais perguntas compõem este quiz. */
    protected abstract List<Pergunta> criarPerguntas();

    /** Passo variável: qual tecnologia de exibição será usada (Swing, console, etc). */
    protected abstract InterfaceExibicao criarInterfaceExibicao();

    /** Passo variável: qual política de pontuação será aplicada. */
    protected abstract PontuacaoStrategy criarPontuacaoStrategy();

    /**
     * Hook opcional (passo com implementação padrão vazia): subclasses
     * podem sobrescrever para registrar observadores (ex: placar em
     * tempo real) sem serem obrigadas a isso.
     */
    protected void configurarObservadores(QuizEngine engine) {
        // por padrão, nenhum observador é registrado
    }
}
