package siga;

import java.time.LocalDate;

/**
 * DESLIZE 1 — terceira cópia do mesmo rito.
 *
 * Este documento é o único que NÃO leva assinatura digital — e a diferença
 * está perdida no meio do código duplicado, em vez de declarada.
 */
public class AtestadoFrequencia {

    public String emitir(Aluno aluno) {
        if (!aluno.isRegular()) {
            throw new IllegalStateException(
                    "Aluno irregular: " + aluno.getMatricula());
        }

        StringBuilder documento = new StringBuilder();
        documento.append("FATEC DE PORTO FERREIRA\n");
        documento.append("Sistema de Gestao Academica\n---\n");
        documento.append("ATESTADO DE FREQUENCIA\n")
                 .append(aluno.getNome());
        documento.append("\n---\nEmitido em ").append(LocalDate.now());

        LogAcademico.registrar("ATESTADO", aluno);
        return documento.toString();
    }
}
