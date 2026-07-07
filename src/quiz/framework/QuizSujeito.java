package quiz.framework;

public interface QuizSujeito {
    void adicionarObserver(QuizObserver observer);
    void notificarResposta(Jogador jogador, ResultadoResposta resultado);
    void notificarFimDeQuiz();
}
