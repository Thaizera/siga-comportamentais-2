package siga;

/** Contexto do State. O objeto de estado decide se a transição é válida. */
public class Matricula {
    private final Aluno aluno;
    private final String codigoTurma;
    private EstadoMatricula estado = new PreMatriculada();

    public Matricula(Aluno aluno, String codigoTurma) {
        this.aluno = aluno;
        this.codigoTurma = codigoTurma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public String getSituacao() {
        return estado.nome();
    }

    public void confirmar() {
        estado.confirmar(this);
    }

    public void trancar() {
        estado.trancar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public void concluir() {
        estado.concluir(this);
    }

    // Só os estados do pacote precisam trocar o estado diretamente.
    void mudarPara(EstadoMatricula novoEstado) {
        estado = novoEstado;
    }
}
