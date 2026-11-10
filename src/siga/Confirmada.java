package siga;

public class Confirmada implements EstadoMatricula {
    @Override
    public void concluir(Matricula matricula) {
        matricula.mudarPara(new Concluida());
    }

    @Override
    public String nome() {
        return "CONFIRMADA";
    }


    @Override
    public void trancar(Matricula matricula) {
        matricula.mudarPara(new Trancada());
    }

    @Override
    public void cancelar(Matricula matricula) {
        matricula.mudarPara(new Cancelada());
    }
}
