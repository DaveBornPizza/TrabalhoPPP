package quiz.framework;

public class Jogador {
    private String nome;
    private int pontuacaoAtual;
    private int acertos;
    private int erros;
    private long tempoInicioPergunta;
    private long tempoTotalGasto;

    public Jogador(String nome) {
        this.nome = nome;
        pontuacaoAtual = 0;
        acertos = 0;
        erros = 0;
        tempoTotalGasto = 0;
    }

    public String getNome() { return nome; }
    public int getPontuacaoAtual() { return pontuacaoAtual; }
    public void adicionarPontos(int pontos) { pontuacaoAtual += pontos; }
    public void registrarAcerto() { acertos++; }
    public void registrarErro() { erros++; }
    public int getAcertos() { return acertos; }
    public int getErros() { return erros; }
    public void setTempoInicioPergunta(long tempo) { tempoInicioPergunta = tempo; }
    public long getTempoInicioPergunta() { return tempoInicioPergunta; }
    public void adicionarTempoGasto(long tempo) { tempoTotalGasto += tempo; }
    public long getTempoTotalGasto() { return tempoTotalGasto; }
}