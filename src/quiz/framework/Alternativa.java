package quiz.framework;

public class Alternativa {
    private char item;
    private String texto;

    public Alternativa(char item, String texto) {
        this.item = item;
        this.texto = texto;
    }

    public char getItem() { return item; }
    public String getTexto() { return texto; }
}
