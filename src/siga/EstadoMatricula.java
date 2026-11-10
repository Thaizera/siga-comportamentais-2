package siga;

/** Cada estado define as transições válidas. Por padrão, elas são recusadas. */
public interface EstadoMatricula {
    String nome();

    default void confirmar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel confirmar uma matricula " + nome());
    }

    default void trancar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel trancar uma matricula " + nome());
    }

    default void cancelar(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel cancelar uma matricula " + nome());
    }

    default void concluir(Matricula matricula) {
        throw new IllegalStateException("Nao e possivel concluir uma matricula " + nome());
    }
}
