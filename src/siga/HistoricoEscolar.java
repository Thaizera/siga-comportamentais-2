package siga;

import java.time.LocalDate;

/**
 * DESLIZE 1 — o rito de emissão escrito por inteiro, pela primeira vez.
 *
 * Cinco passos: validar, cabecalho, corpo, rodape, registrar.
 * Apenas o corpo varia entre os tres documentos; os outros quatro
 * serao copiados nas proximas duas classes.
 */
public class HistoricoEscolar {

    public String emitir(Aluno aluno) {
        if (!aluno.isRegular()) {
            throw new IllegalStateException(
                    "Aluno irregular: " + aluno.getMatricula());
        }

        StringBuilder documento = new StringBuilder();
        documento.append("FATEC DE PORTO FERREIRA\n");
        documento.append("Sistema de Gestao Academica\n---\n");
        documento.append("HISTORICO ESCOLAR\n")
                 .append(aluno.getNome())
                 .append("\nCarga horaria cumprida: ")
                 .append(aluno.getCargaCumprida())
                 .append("h");
        documento.append("\n---\nEmitido em ").append(LocalDate.now());
        documento.append("\nAssinado digitalmente pela secretaria academica.");

        LogAcademico.registrar("HISTORICO", aluno);
        return documento.toString();
    }
}
