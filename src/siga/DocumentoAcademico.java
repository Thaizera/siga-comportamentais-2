package siga;

import java.time.LocalDate;

/** Define a ordem de emissão compartilhada por todos os documentos. */
public abstract class DocumentoAcademico {
    private final String tipo;

    protected DocumentoAcademico(String tipo) {
        this.tipo = tipo;
    }

    public final String emitir(Aluno aluno) {
        validar(aluno);
        String documento = cabecalho() + corpo(aluno) + rodape();
        // O log só recebe documentos que passaram por todos os passos.
        registrarEmissao(aluno);
        return documento;
    }

    private void validar(Aluno aluno) {
        if (!aluno.isRegular()) {
            throw new IllegalStateException("Aluno irregular: " + aluno.getMatricula());
        }
    }

    private String cabecalho() {
        return "FATEC DE PORTO FERREIRA\nSistema de Gestao Academica\n---\n";
    }

    protected abstract String corpo(Aluno aluno);

    private String rodape() {
        String data = "\n---\nEmitido em " + LocalDate.now();
        return exigeAssinatura()
                ? data + "\nAssinado digitalmente pela secretaria academica."
                : data;
    }

    /** Gancho para documentos dispensados de assinatura. */
    protected boolean exigeAssinatura() {
        return true;
    }

    private void registrarEmissao(Aluno aluno) {
        LogAcademico.registrar(tipo, aluno);
    }
}
