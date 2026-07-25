package quiz.aplicacao.programacao;

/**
 * Ponto de entrada da Aplicação Cliente 1 (Quiz de Programação, Swing).
 *
 * Apenas dispara o Template Method herdado de AbstractQuiz. Toda a
 * configuração (perguntas, jogadores, pontuação, interface, observadores)
 * fica em QuizProgramacao; todo o fluxo de execução fica em QuizEngine,
 * no framework.
 */
public class MainProgramacao {

    public static void main(String[] args) {
        new QuizProgramacao().iniciar();
        System.exit(0);
    }
}
