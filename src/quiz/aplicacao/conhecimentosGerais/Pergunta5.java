package quiz.aplicacao.conhecimentosGerais;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Qual é o elemento químico representado pelo símbolo 'O' na tabela periódica?",
        alternativas = {
                @Opcao(item = 'A', texto = "Ouro"),
                @Opcao(item = 'B', texto = "Oxigênio"),
                @Opcao(item = 'C', texto = "Ósmio"),
                @Opcao(item = 'D', texto = "Óxido")
        },
        respostaCorreta = 'B'
)
public class Pergunta5 {
}
