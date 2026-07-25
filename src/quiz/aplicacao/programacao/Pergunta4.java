package quiz.aplicacao.programacao;

import quiz.framework.annotation.Opcao;
import quiz.framework.annotation.QuizPergunta;

@QuizPergunta(
        enunciado = "No padrão de projeto Strategy, o principal objetivo é:",
        alternativas = {
                @Opcao(item = 'A', texto = "Garantir que uma classe tenha apenas uma instância"),
                @Opcao(item = 'B', texto = "Encapsular algoritmos intercambiáveis em tempo de execução"),
                @Opcao(item = 'C', texto = "Notificar múltiplos objetos sobre mudanças de estado"),
                @Opcao(item = 'D', texto = "Criar objetos sem expor a lógica de instanciação")
        },
        respostaCorreta = 'B'
)
public class Pergunta4 {
}
