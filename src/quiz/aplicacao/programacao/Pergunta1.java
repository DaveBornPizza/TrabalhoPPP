package quiz.aplicacao.programacao;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Qual é a saída de: System.out.println(1 + 1)?",
        alternativas = {
                @Opcao(item = 'A', texto = "11"),
                @Opcao(item = 'B', texto = "2"),
                @Opcao(item = 'C', texto = "Erro de compilação")
        },
        respostaCorreta = 'B'
)
public class Pergunta1 {
}
