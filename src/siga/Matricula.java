package siga;

/**
 * DESLIZE 3 — o ciclo de vida da matrícula resolvido com condicionais
 * sobre uma String.
 *
 * Três problemas: (a) as regras de transição estão espalhadas por três
 * métodos, e ninguém le o ciclo de vida inteiro num lugar so; (b) um
 * estado novo — "concluida" — exige alterar os TRES metodos; e (c) a
 * situacao e texto, entao um erro de digitacao so aparece em execucao.
 */
public class Matricula {

    private final Aluno aluno;
    private final String codigoTurma;
    private String situacao = "PRE_MATRICULADA";

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
        return situacao;
    }

    public void confirmar() {
        if (situacao.equals("PRE_MATRICULADA")) {
            situacao = "CONFIRMADA";
        } else if (situacao.equals("TRANCADA")) {
            situacao = "CONFIRMADA";
        } else {
            throw new IllegalStateException(
                    "Nao e possivel confirmar uma matricula " + situacao);
        }
    }

    public void trancar() {
        if (situacao.equals("CONFIRMADA")) {
            situacao = "TRANCADA";
        } else {
            throw new IllegalStateException(
                    "Nao e possivel trancar uma matricula " + situacao);
        }
    }

    public void cancelar() {
        if (situacao.equals("PRE_MATRICULADA")
                || situacao.equals("CONFIRMADA")
                || situacao.equals("TRANCADA")) {
            situacao = "CANCELADA";
        } else {
            throw new IllegalStateException(
                    "Nao e possivel cancelar uma matricula " + situacao);
        }
    }
}
