package siga;

import java.time.LocalDate;

/**
 * DESLIZE 1 — segunda cópia do mesmo rito.
 * DESLIZE 2 — e aqui alguem trocou a ordem: o registro no log acontece
 *             ANTES da validacao. Um aluno irregular deixa rastro no log
 *             de um documento que nunca foi emitido.
 */
public class DeclaracaoVinculo {

    public String emitir(Aluno aluno) {
        LogAcademico.registrar("DECLARACAO", aluno);   // fora de ordem

        if (!aluno.isRegular()) {
            throw new IllegalStateException(
                    "Aluno irregular: " + aluno.getMatricula());
        }

        StringBuilder documento = new StringBuilder();
        documento.append("FATEC DE PORTO FERREIRA\n");
        documento.append("Sistema de Gestao Academica\n---\n");
        documento.append("DECLARACAO DE VINCULO\n")
                 .append("Declaramos que ")
                 .append(aluno.getNome())
                 .append(" possui vinculo ativo com esta instituicao.");
        documento.append("\n---\nEmitido em ").append(LocalDate.now());
        documento.append("\nAssinado digitalmente pela secretaria academica.");

        return documento.toString();
    }
}
