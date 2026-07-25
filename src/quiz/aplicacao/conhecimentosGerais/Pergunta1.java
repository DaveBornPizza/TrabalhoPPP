package quiz.aplicacao.conhecimentosGerais;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Qual é o maior planeta do Sistema Solar?",
        alternativas = {
                @Opcao(item = 'A', texto = "Terra"),
                @Opcao(item = 'B', texto = "Saturno"),
                @Opcao(item = 'C', texto = "Júpiter"),
                @Opcao(item = 'D', texto = "Netuno")
        },
        respostaCorreta = 'C'
)
public class Pergunta1 {
}
