package quiz.framework.annotation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;
import quiz.framework.Pergunta;

public class ProcessadorAnotacoes {
    public PerguntaFactory perguntaFactory;

    public ProcessadorAnotacoes(PerguntaFactory perguntaFactory) {
        this.perguntaFactory = perguntaFactory;
    }

    public Set<Class<?>> descobrirClassesAnotadas(String nomePacote) {
        Reflections reflections = new Reflections(nomePacote);
        return reflections.getTypesAnnotatedWith(QuizPergunta.class);
    }

    private List<Pergunta> montarPerguntas(Collection<Class<?>> classes) {
        List<Pergunta> perguntas = new ArrayList<>();
        for (Class<?> classe : classes) {
            perguntas.add(perguntaFactory.montarPergunta(classe));
        }
        return perguntas;
    }

    public List<Pergunta> processarPacote(String nomePacote) {
        Set<Class<?>> classes = descobrirClassesAnotadas(nomePacote);
        return montarPerguntas(classes);
    }

}
