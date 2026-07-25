package quiz.aplicacao.programacao;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Qual estrutura de dados segue a política 'primeiro a entrar, primeiro a sair' (FIFO)?",
        alternativas = {
                @Opcao(item = 'A', texto = "Pilha (Stack)"),
                @Opcao(item = 'B', texto = "Fila (Queue)"),
                @Opcao(item = 'C', texto = "Árvore binária"),
                @Opcao(item = 'D', texto = "Grafo")
        },
        respostaCorreta = 'B'
)
public class Pergunta3 {
}
