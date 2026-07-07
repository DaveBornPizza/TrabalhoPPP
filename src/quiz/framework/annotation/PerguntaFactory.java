package quiz.framework.annotation;

import quiz.framework.Alternativa;
import quiz.framework.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class PerguntaFactory {
    private Alternativa montarAlternativa(Opcao opcao) {
        return new Alternativa(opcao.item(), opcao.texto());
    }

    public Pergunta montarPergunta(Class<?> classe) {
        QuizPergunta quizPergunta = classe.getAnnotation(QuizPergunta.class);
        List<Alternativa> alternativas = new ArrayList<>();
        for (Opcao opcao : quizPergunta.alternativas()) {
            alternativas.add(montarAlternativa(opcao));
        }
        return new Pergunta(quizPergunta.enunciado(), alternativas, quizPergunta.respostaCorreta());
    }
}
