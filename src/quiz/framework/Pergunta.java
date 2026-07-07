package quiz.framework;

import java.util.List;

public class Pergunta {
    private String enunciado;
    private List<Alternativa> alternativas;
    private char alternativaCorreta;

    public Pergunta(String enunciado, List<Alternativa> alternativas, char alternativaCorreta) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getEnunciado() { return enunciado; }
    public List<Alternativa> getAlternativas() { return alternativas; }
    public char getAlternativaCorreta() { return alternativaCorreta; }

}
