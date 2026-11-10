package siga;

import java.util.List;

/** Executa cenários de emissão e transição de matrícula. */
public class Main {
    public static void main(String[] args) {
        Aluno regular = new Aluno("2024001", "Maria Silva");
        regular.setCargaCumprida(560);
        Aluno irregular = new Aluno("2024002", "Joao Souza");
        irregular.setRegular(false);

        demonstrarEmissao(regular, irregular);
        demonstrarMatricula(regular);
        System.out.println("Todos os cenários passaram.");
    }

    private static void demonstrarEmissao(Aluno regular, Aluno irregular) {
        DocumentoAcademico[] documentos = {
            new HistoricoEscolar(), new DeclaracaoVinculo(), new AtestadoFrequencia()
        };
        for (DocumentoAcademico documento : documentos) {
            String emitido = documento.emitir(regular);
            boolean assinado = emitido.contains("Assinado digitalmente");
            verificar(assinado == !(documento instanceof AtestadoFrequencia),
                    "Assinatura incorreta");
            System.out.println(emitido);
        }

        // Compare o log antes e depois das três tentativas recusadas.
        List<String> antes = LogAcademico.getRegistros();
        verificar(antes.size() == 3, "Esperava três emissões no log");
        for (DocumentoAcademico documento : documentos) {
            esperarRecusa(() -> documento.emitir(irregular));
        }
        verificar(antes.equals(LogAcademico.getRegistros()), "O log mudou após recusa");
    }

    private static void demonstrarMatricula(Aluno aluno) {
        Matricula matricula = new Matricula(aluno, "DSM-2A");
        verificarSituacao(matricula, "PRE_MATRICULADA");
        esperarRecusa(matricula::trancar);
        esperarRecusa(matricula::concluir);
        matricula.confirmar();
        verificarSituacao(matricula, "CONFIRMADA");
        matricula.trancar();
        verificarSituacao(matricula, "TRANCADA");
        matricula.confirmar();
        matricula.concluir();
        verificarSituacao(matricula, "CONCLUIDA");
        esperarRecusa(matricula::cancelar);

        Matricula cancelada = new Matricula(aluno, "DSM-2B");
        cancelada.cancelar();
        verificarSituacao(cancelada, "CANCELADA");
        esperarRecusa(cancelada::confirmar);
    }

    private static void esperarRecusa(Runnable operacao) {
        try {
            operacao.run();
        } catch (IllegalStateException esperada) {
            System.out.println("[recusa esperada] " + esperada.getMessage());
            return;
        }
        throw new AssertionError("A operação deveria ter sido recusada");
    }

    private static void verificarSituacao(Matricula matricula, String esperada) {
        verificar(esperada.equals(matricula.getSituacao()),
                "Esperava " + esperada + ", mas a situação era " + matricula.getSituacao());
        System.out.println("Matrícula " + matricula.getSituacao());
    }

    private static void verificar(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }
}
