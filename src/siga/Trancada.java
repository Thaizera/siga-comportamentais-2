package siga;

public class Trancada implements EstadoMatricula {
    @Override
    public String nome() {
        return "TRANCADA";
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
