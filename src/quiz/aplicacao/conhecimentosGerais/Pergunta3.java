package quiz.aplicacao.conhecimentosGerais;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Qual é a capital da Austrália?",
        alternativas = {
                @Opcao(item = 'A', texto = "Sydney"),
                @Opcao(item = 'B', texto = "Melbourne"),
                @Opcao(item = 'C', texto = "Canberra"),
                @Opcao(item = 'D', texto = "Perth")
        },
        respostaCorreta = 'C'
)
public class Pergunta3 {
}
