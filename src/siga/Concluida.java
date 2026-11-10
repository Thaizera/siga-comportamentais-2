package siga;

/** Estado terminal. Nenhuma nova transição é permitida. */
public class Concluida implements EstadoMatricula {
    @Override
    public String nome() {
        return "CONCLUIDA";
    }
}
