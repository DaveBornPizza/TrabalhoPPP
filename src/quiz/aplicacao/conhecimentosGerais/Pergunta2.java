package quiz.aplicacao.conhecimentosGerais;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "Quem pintou a Mona Lisa?",
        alternativas = {
                @Opcao(item = 'A', texto = "Vincent van Gogh"),
                @Opcao(item = 'B', texto = "Pablo Picasso"),
                @Opcao(item = 'C', texto = "Leonardo da Vinci"),
                @Opcao(item = 'D', texto = "Michelangelo")
        },
        respostaCorreta = 'C'
)
public class Pergunta2 {
}
