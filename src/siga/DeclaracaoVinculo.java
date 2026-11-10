package siga;

public class DeclaracaoVinculo extends DocumentoAcademico {
    public DeclaracaoVinculo() {
        super("DECLARACAO");
    }

    @Override
    protected String corpo(Aluno aluno) {
        return "DECLARACAO DE VINCULO\nDeclaramos que " + aluno.getNome()
                + " possui vinculo ativo com esta instituicao.";
    }
}
