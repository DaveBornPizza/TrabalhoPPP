package quiz.aplicacao.programacao;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Em Java, qual palavra-chave é usada para herança entre classes?",
        alternativas = {
                @Opcao(item = 'A', texto = "implements"),
                @Opcao(item = 'B', texto = "extends"),
                @Opcao(item = 'C', texto = "inherits"),
                @Opcao(item = 'D', texto = "super")
        },
        respostaCorreta = 'B'
)
public class Pergunta2 {
}
