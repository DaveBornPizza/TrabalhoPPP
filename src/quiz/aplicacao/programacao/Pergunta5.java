package quiz.aplicacao.programacao;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Qual a complexidade de tempo, no pior caso, de uma busca binária em um array ordenado de n elementos?",
        alternativas = {
                @Opcao(item = 'A', texto = "O(n)"),
                @Opcao(item = 'B', texto = "O(n log n)"),
                @Opcao(item = 'C', texto = "O(log n)"),
                @Opcao(item = 'D', texto = "O(1)")
        },
        respostaCorreta = 'C'
)
public class Pergunta5 {
}
