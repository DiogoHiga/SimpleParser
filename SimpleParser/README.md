# UFABCGrammar

UFABCGrammar é uma gramática ANTLR4 projetada para um ambiente de programação customizado. Esta gramática permite:

- **Declaração de variáveis**: Suporte para variáveis dos tipos `NUMBER` e `TEXT`.
- **Comandos de controle**: Inclusão de estruturas de controle como `if`, `while` e `do-while`.
- **Comandos básicos**: Suporte para comandos de leitura (`leia`), escrita (`escreva`) e atribuição (`:=`).
- **Expressões aritméticas e lógicas**: Combinando operadores aritméticos (`+`, `-`, `*`, `/`) e operadores relacionais e lógicos.

## Funcionalidades

- **Tabela de Símbolos**: Gerencia a declaração e uso de variáveis, garantindo que todas as variáveis sejam usadas corretamente e exibindo avisos para variáveis não usadas.
- **Análise Semântica**: Verifica erros semânticos como variáveis não declaradas ou não inicializadas.
- **Expressões**: Suporte a expressões matemáticas e lógicas.

## Como Usar

1. **Baixe o ANTLR**: Você pode baixar o ANTLR no site oficial [ANTLR](https://www.antlr.org/download/antlr-4.13.2-complete.jar).

2. **Referencie o JAR**: Adicione o JAR do ANTLR como biblioteca no seu projeto.

3. **Gerar Arquivos Java**:
   - Para gerar os arquivos Java a partir do arquivo `.g4`, use o seguinte comando:

     ```bash
     java -cp antlr-4.13.2-complete.jar org.antlr.v4.Tool UFABCGrammar.g4 -o [pasta de destino] -package [nome do pacote Java]
     ```

   - Substitua `[pasta de destino]` pelo diretório onde deseja gerar os arquivos e `[nome do pacote Java]` pelo pacote Java desejado.

## Exemplo de Uso

    - No diretorio io\compiler\main, existe o arquivo MainClass.java. Executando ele é possível inserir o nome do arquivo de INPUT (escrito na UFABCGrammar), via terminal, para geração do código correspondente em Java.
    - Durante a geração do código, haverá a verificação de variaveis não declaradas, não inicializadas, não utilizadas e também conferencia de tipos.