package siga;

public class AtestadoFrequencia extends DocumentoAcademico {
    public AtestadoFrequencia() {
        super("ATESTADO");
    }

    @Override
    protected String corpo(Aluno aluno) {
        return "ATESTADO DE FREQUENCIA\n" + aluno.getNome();
    }

    @Override
    protected boolean exigeAssinatura() {
        return false;
    }
}
