# SIGA · Template Method e State

Atividade prática da Aula 13 de Técnicas de Programação II.

## Diagnóstico

O código inicial repetia validação, cabeçalho, rodapé e registro nos três
documentos. Em `DeclaracaoVinculo.emitir`, a chamada a `LogAcademico.registrar`
acontecia antes da validação de regularidade. A emissão falhava para um aluno
irregular, mas o log registrava uma declaração que nunca havia sido emitida.

## Template Method

`DocumentoAcademico.emitir` é `final` e fixa a ordem de validação, cabeçalho,
corpo, rodapé e registro. Cada documento fornece seu corpo. O atestado usa
o gancho `exigeAssinatura()` para omitir a assinatura do rodapé.

## State

`Matricula` delega as operações ao estado atual. Por exemplo,
`PreMatriculada.confirmar` chama `matricula.mudarPara(new Confirmada())`.
Ao contrário de uma Strategy que apenas fornece um algoritmo, o estado
controla as transições do ciclo de vida.

A operação `concluir` já estava prevista na interface. Para disponibilizar
a transição, bastou adicionar `Concluida.java` e alterar `Confirmada.java`.
Foram dois arquivos, sem alterar os três métodos que concentravam as
condições na versão inicial.

## Como executar

Com JDK 17 ou superior, execute na raiz do projeto.

```sh
javac -encoding UTF-8 -d bin src/siga/*.java
java -cp bin siga.Main
```

O programa verifica assinaturas, recusa de documentos sem registros
indevidos e transições válidas e inválidas da matrícula.
