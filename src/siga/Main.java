package siga;

/**
 * Demonstra os três deslizes acontecendo. Execute e observe a saída:
 * é dela que partem as etapas da ficha de atividade prática.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Aula 13: Template Method e State (codigo inicial) ===");

        Aluno regular = new Aluno("2024001", "Maria Silva");
        regular.setCargaCumprida(560);

        Aluno irregular = new Aluno("2024002", "Joao Souza");
        irregular.setRegular(false);

        System.out.println();
        System.out.println("1) Tres documentos, tres copias do mesmo rito");
        System.out.println(recuar(new HistoricoEscolar().emitir(regular)));
        System.out.println(recuar(new AtestadoFrequencia().emitir(regular)));
        System.out.println("   >> DESLIZE 1: cinco passos, quatro deles identicos nas tres");
        System.out.println("      classes. So o corpo varia.");

        System.out.println();
        System.out.println("2) A declaracao de vinculo, com os passos fora de ordem");
        System.out.println("   Emitindo para um aluno IRREGULAR:");
        try {
            new DeclaracaoVinculo().emitir(irregular);
        } catch (IllegalStateException e) {
            System.out.println("   [erro] " + e.getMessage());
        }
        System.out.println("   >> DESLIZE 2: repare na linha de log acima do erro.");
        System.out.println("      O documento nao foi emitido, mas ja consta no log.");
        System.out.println("      Registros no log: " + LogAcademico.getRegistros());

        System.out.println();
        System.out.println("3) O ciclo de vida da matricula em condicionais");
        Matricula m = new Matricula(regular, "DSM-2A");
        System.out.println("   situacao inicial: " + m.getSituacao());
        m.confirmar();
        System.out.println("   apos confirmar:   " + m.getSituacao());
        m.trancar();
        System.out.println("   apos trancar:     " + m.getSituacao());
        m.confirmar();
        System.out.println("   apos confirmar:   " + m.getSituacao());
        m.cancelar();
        System.out.println("   apos cancelar:    " + m.getSituacao());
        try {
            m.confirmar();
        } catch (IllegalStateException e) {
            System.out.println("   [erro] " + e.getMessage());
        }
        System.out.println("   >> DESLIZE 3: as regras de transicao estao espalhadas por");
        System.out.println("      tres metodos. Acrescentar o estado CONCLUIDA exige");
        System.out.println("      alterar os tres. E a situacao e uma String.");

        System.out.println();
        System.out.println("Sua tarefa: ver o README.md e a ficha de atividade pratica.");
    }

    private static String recuar(String texto) {
        StringBuilder saida = new StringBuilder();
        for (String linha : texto.split("\n")) {
            saida.append("     ").append(linha).append("\n");
        }
        return saida.toString().stripTrailing();
    }
}
