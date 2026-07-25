package quiz.aplicacao.conhecimentosGerais;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Em que ano ocorreu a queda do Muro de Berlim?",
        alternativas = {
                @Opcao(item = 'A', texto = "1979"),
                @Opcao(item = 'B', texto = "1989"),
                @Opcao(item = 'C', texto = "1999"),
                @Opcao(item = 'D', texto = "1969")
        },
        respostaCorreta = 'B'
)
public class Pergunta4 {
}
