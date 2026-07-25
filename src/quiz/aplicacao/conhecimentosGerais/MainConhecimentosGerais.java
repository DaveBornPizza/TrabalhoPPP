package quiz.aplicacao.conhecimentosGerais;

/**
 * Ponto de entrada da Aplicação Cliente 2 (Quiz de Conhecimentos Gerais, console).
 *
 * Apenas dispara o Template Method herdado de AbstractQuiz.
 */
public class MainConhecimentosGerais {

    public static void main(String[] args) {
        System.out.println("=== Quiz de Conhecimentos Gerais ===");
        new QuizConhecimentosGerais().iniciar();
    }
}
