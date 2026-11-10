package siga;

public class HistoricoEscolar extends DocumentoAcademico {
    public HistoricoEscolar() {
        super("HISTORICO");
    }

    @Override
    protected String corpo(Aluno aluno) {
        return "HISTORICO ESCOLAR\n" + aluno.getNome()
                + "\nCarga horaria cumprida: " + aluno.getCargaCumprida() + "h";
    }
}
