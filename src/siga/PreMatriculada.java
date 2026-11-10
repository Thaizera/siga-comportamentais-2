package siga;

public class PreMatriculada implements EstadoMatricula {
    @Override
    public String nome() {
        return "PRE_MATRICULADA";
    }

    @Override
    public void confirmar(Matricula matricula) {
        matricula.mudarPara(new Confirmada());
    }


    @Override
    public void cancelar(Matricula matricula) {
        matricula.mudarPara(new Cancelada());
    }
}
