# MorcelaLang

Versão 2018

*Elixandre Michael Baldi*

*Luiz Guilherme Fonseca Rosa*

## Nome

Lê-se ‘murcilia’, é um embutido feito de sangue e vísceras, geralmente do porco, com confecção tradicional nos sítios do estado do Rio Grande do Sul, estado esse que compreende a descendência dos criadores da linguagem.

## Características

Em questões estruturais, a MorcelaLang é baseada em Pascal, pois as variáveis e escopos são separadas por seções, de forma que as variáveis são todas globais.

Ao final de cada linha deverá aparecer o ponto e vírgula (;).

Como estruturas de repetição, há o `WHILE` (verIFica condição antes de executar o procedimento) e o `DO WHILE` (verIFica condição depois de executar o procedimento).

Têm-se, também, o seguintes recursos: `IF`, `WHILE`, `DO WHILE` e `SWITCH CASE` e os seguintes tipos primitivos: `STRING`, `DOUBLE` e `BOOLEAN`.

A linguagem é indicada para uso de iniciantes em programação, pois os recursos são limitados, mas, ao mesmo tempo, permite explorar o básico de uma linguagem de programação.

## Operadores Aritméticos

As operações descritas abaixo resultarão em valores atribuídos num endereço temporário, podendo ser atribuído num endereço de um identIFicador posteriormente.

### Soma

Sintaxe:

```
operando1 + operando2 + … + operandoN;
```

Semântica:

Independente da quantidade de operandos na soma, a ordem sempre será da esquerda para a direita, ou seja, inicialmente o primeiro operando é armazenado no endereço temporário, e então o endereço temporário recebe o acúmulo da operação com o próximo operando até acabar.

Os operandos 1 e 2 podem ser tanto um identificador quanto um valor imediato.

### Subtração

Sintaxe:

```
operando1 - operando2 - … - operandoN;
```

Semântica:

Independente da quantidade de operandos na subtração a ordem sempre será da esquerda para a direita, ou seja, inicialmente o primeiro operando é armazenado no endereço temporário, e então o endereço temporário recebe o acúmulo da operação com o próximo operando até acabar.

Os operandos 1 e 2 podem ser tanto um identificador quanto um valor imediato.

### Multiplicação

Sintaxe:

```
operando1 * operando2 * … * operandoN;
```

Semântica:

Independente da quantidade de operandos na multiplicação a ordem sempre será da esquerda para a direita, ou seja, inicialmente o primeiro operando é armazenado no endereço temporário, e então o endereço temporário recebe o acúmulo da operação com o próximo operando até acabar.

Os operandos 1 e 2 podem ser tanto um identificador quanto um valor imediato.

### Divisão

Sintaxe:

```
operando1 / operando2 / … / operandoN;
```

Semântica:

Independente da quantidade de operandos na divisão a ordem sempre será da esquerda para a direita, ou seja, inicialmente o primeiro operando é armazenado no endereço temporário, e então o endereço temporário recebe o acúmulo da operação com o próximo operando até acabar.

Os operandos 1 e 2 podem ser tanto variáveis (endereço de valor em memória) quanto um valor direto (literal).

## Operadores Lógicos

Para a realizar operações com operadores lógicos é necessário que todas os operandos sejam do tipo `BOOLEAN`.

Vale lembrar que temos o tipo primitivo BOOLEANo e qualquer expressão relacional ou lógica armazena o resultado em um endereço temporário (identificador). O resultado da operação lógica também é armazenado num endereço temporário.

### And

Sintaxe:

```
operando1 && operando2;
```

Semântica:

O resultado proveniente desta operação seguirá as regras da tabela verdade do AND.

### Or

Sintaxe:

```
operando1 || operando2;
```

Semântica:

O resultado proveniente desta operação seguirá as regras da tabela verdade do OR.

### Xor

Sintaxe:

```
operando1 ^ operando2;
```

Semântica:

O resultado proveniente desta operação seguirá as regras da tabela verdade do XOR.

### Not

Sintaxe:

```
!(operador1);
```

Semântica:

O resultado proveniente desta operação será a negação do valor de entrada.

## Operadores relacionais

O resultado da operação lógica será do tipo `BOOLEAN`, armazenado num endereço temporário. Caso o operando seja uma expressão, a expressão é executada e a operação considerará o valor armazenado no endereço temporário.

### Menor

Sintaxe:

```
operando1 < operando2;
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`. A operação opera com qualquer combinação dos operandos. O resultado será `TRUE` caso o operando1 for menor que o operando2, e `FALSE` caso o operando1 for maior ou igual ao operando2.

### Maior

Sintaxe:

```
operando1 > operando2;
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`. A operação opera com qualquer combinação dos operandos. O resultado será `TRUE` caso o operando1 for maior que o operando2, e `FALSE` caso o operando1 for menor ou igual ao operando2.

### Igual

Sintaxe:

```
operando1 == operando2;
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`, `BOOLEAN` ou `STRING`. O resultado será `TRUE` caso o operando1 igual ao operando2, e `FALSE` caso forem operandos diferentes.

### Diferente

Sintaxe:

```
operando1 != operando2;
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`, `BOOLEAN` ou `STRING`. O resultado será `TRUE` caso o operando1 dIFerente ao operando2, e `FALSE` caso forem operandos iguais.

### Menor ou igual

Sintaxe:

```
operando1 <= operando2;
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`. O resultado será `TRUE` caso o operando1 seja menor ou igual ao operando2, e `FALSE` se o operando1 for maior que o operando2.

### Maior ou igual

Sintaxe:

```
operando1 >= operando2;
```

Semântica:

É permitido apenas operar sob dois operandos, de forma que devem ser do tipo `DOUBLE`. O resultado será `TRUE` caso o operando1 seja maior ou igual ao operando2, e `FALSE` o operando1 for menor que o operando2.

## Tipos de Dados

### DOUBLE

O tipo `DOUBLE` armazena valores numéricos que pertencem ao conjunto dos reais positivos e negativos, de forma que para cada variável do tipo `DOUBLE` terá 1 bit para o sinal, 11 bits para o expoente e 52 bits para a mantissa reservados, representando valores de 10⁻³⁰⁸ a 10³⁰⁸, tendo assim 16 dígitos de precisão.

A inicialização do tipo `DOUBLE` é feita da seguinte forma:

```
DOUBLE: nome_do_identificador;
```

### BOOLEAN

O tipo `BOOLEAN` armazena dois valores: `TRUE` e `FALSE`. Para representar esses valores utiliza-se 1 byte, de forma que o valor 0 (na base 2) representa `FALSE` e o valor 1 representa `TRUE` (na base 2).

A inicialização do tipo `BOOLEAN` é feita da seguinte forma:

```
BOOLEAN: nome_do_identificador;
```

### STRING

O tipo `STRING` armazena cadeias de caracteres. Seu armazenamento é estático, ou seja, o programador que define o tamanho da `STRING` e, em tempo de compilação o compilador alocará o tamanho em bytes informado na declaração.

A inicialização do tipo `STRING` é feita da seguinte forma:

```
STRING: nome_do_identificador[n]; // n é um valor imediato que será o tamanho em bytes da STRING. Caso n possua casas decimais, as mesmas serão desconsideradas.
```

## Atribuição

Toda atribuição feita na linguagem necessariamente deve ser feita a um operando, operando este que deve ser do mesmo tipo primitivo do valor atribuído.

Sintaxe:

```
operando1 = operando2;
```

Semântica:

Inicialmente o identificador operando1 está alocado num certo espaço da memória. Quando a atribuição é feita, o conteúdo do operando2 (podendo ser um imediato, um identificador temporário - resultado de alguma expressão - ou um outro identificador) será copiado ao espaço de memória que compreende o operando1, de forma independentemente do que exista naquele espaço, o conteúdo será substituído.

Vale lembrar que a linguagem tem apenas um escopo, ou seja, todas as variáveis são globais e não existe efeito colateral.

Dessa forma, a linguagem restringe alguns casos:

Caso o operando1 for do tipo `STRING`, a atribuição só será feita se o operando2 for do tipo `STRING`. Caso o operando2 ter tamanho maior que o o n definido para o tamanho da `STRING`, os primeiros n bytes do operando2 serão atribuídos ao operando1.

Caso o operando1 for do tipo `BOOLEAN`, a atribuição só será feita se o operando2 for do tipo `BOOLEAN`.

Caso o operando1 for do tipo `DOUBLE`, a atribuição só será feita se o operando2 for do tipo `DOUBLE`.

Exemplos de atribuições:

```
Nome_da_string = “olá mundo”;
Nome_da_string = Nome_de_outra_string;
Nome_do_boolean = TRUE;
Nome_do_boolean = FALSE;
Nome_do_boolean = 1 < 2;
Nome_do_double = Nome_de_outro_double;
```

## Saltos Condicionais

As estruturas de saltos condicionais operam com base em expressões lógicas, que retornam resultam num valor `BOOLEAN`.

Caso a condição resultar `TRUE`, aquele bloco será executado, caso contrário o fluxo do programa será seguido.

### Se então

Sintaxe:

```
IF (condição) {
	// procedimentos
} ELSE IF (condição) {
	// procedimentos
} ELSE {
	// procedimentos
}
```

Semântica:

A estrutura `IF` contém um bloco de procedimentos que serão executados caso a condição seja verdadeira e, caso haja um bloco `ELSE`, o programa ignorará. Caso a condição seja falsa o programa segue o fluxo de forma que pode encontrar um `ELSE IF`, um `ELSE`, ou o fim da estrutura. Caso entre na condição `ELSE IF`, o bloco `ELSE` será ignorado, e caso entre no `ELSE` quer dizer que o(s) bloco(s) acima não foram executados.

As restrições ficam por conta das expressões lógicas (descritas anteriormente).

### Caso

Sintaxe:

```
SWITCH (operando) {
	CASE operando1:
    //procedimentos
	   STOP;
	CASE operando2:
    //procedimentos
	   STOP;
  DFLT:
    //procedimentos
	   STOP;
}
```

Semântica:

A estrutura `SWITCH CASE` compara o operando_para_testes com os operandos nos "casos" com o operador de igualdade (`==`).

Caso alguma comparação resulte em `TRUE`, o bloco do operando em questão é executado, até que o `STOP` finalize a estrutura.

Caso nenhuma comparação for satisfeita o bloco do `DFLT` será executado e assim a estrutura será finalizada.

As restrições ficam por conta das expressões lógicas (descritas anteriormente).

## Repetição

Assim como nas estruturas de saltos condicionais, as estruturas de repetição são executadas com base em expressões lógicas, de forma que as restrições ficam por conta da determinada expressão descrita anteriormente.

### Enquanto

Sintaxe:

```
WHILE (operando){
	//procedimentos
}
```

Semântica:

Nesta estrutura, o bloco em questão será repetido até o momento que a condição resultar num valor `FALSE`, de forma que a o teste condicional é realizado antes de executar a primeira vez do laço, podendo assim acontecer do laço nunca ser executado.

### Faça enquanto

Sintaxe:

```
DO {
	//procedimentos
} WHILE (operando);
```

Semântica:

Nesta estrutura, o bloco em questão será repetido até o momento que a condição resultar num valor `FALSE`, de forma que a o teste condicional é realizado depois de executar a primeira vez do laço, assim o bloco será executado pelo menos uma vez.

## Identificadores

Identificadores são utilizados são utilizados para rotular a identidade de uma variável. Eles devem estar sempre antes do nome de uma variável. Servem também para dizer ao compilador que tudo que está escrito após eles são conteúdos de variáveis

```
DOUBLE: variavel1;
```

O termo `DOUBLE` será utilizado para definir que uma variável será do tipo real de dupla precisão.

```
BOOLEAN: variavel1;
```

O termo `BOOLEAN` será utilizado para definir que uma variável será do tipo booleano.

```
STRING: variavel1;
```

O termo `STRING`, será utilizado para definir que uma variável será do tipo cadeia de caracteres.

## Palavras reservadas

As palavras reservadas da MorcelaLang são todas em maiúsculo:

- `IF`: Comando condicional que altera o fluxo do programa de acordo com uma condição que pode ser `TRUE` ou `FALSE`.

- `ELSE`: Indica um bloco de comandos a ser executado quando a condição do comando `IF` for `FALSE`.

- `DO`: Estrutura de repetição usada em conjunto com o `WHILE`. O comando `DO ... WHILE` faz com que os comandos do bloco a ser repetido sejam executados no mínimo uma vez.

- `WHILE`: Estrutura de repetição que executa enquanto uma condição é `TRUE`.

- `SWITCH`: Comando de seleção usando em conjunto com o comando `CASE`, permite escolher entre várias opções.

- `CASE`: Utilizado dentro do comando `SWITCH` para selecionar uma constante.

- `VAR`: Seção no código que denota que tudo o que está escrito nele são variáveis.

- `MORCELA`: Seção principal do código, em que todo o programa é escrito dentro.

- `BODY`: Seção no código que denota que tudo o que está escrito nele faz parte do corpo principal do código.

- `STOP`: Comando para forçar a saída imediata dos comandos `SWITCH`, `WHILE`, e, `DO ... WHILE`.

- `PRINT`: Comando utilizado para escrever na tela as saídas desejadas.

- `SCAN`: Comando utilizado para ler alguma entrada.

## Estrutura geral

```
MORCELA {
  VAR {		
    STRING: word[255];
    DOUBLE: double1, y, var, var2;
    BOLEAN: flag;
	}

	BODY {
    double1 = 1.0;
    y = 2.0;    
    var2 = double1;
    word = "Entre com um valor";
    PRINT(word);
    SCAN(var);

    IF ( double1 < y ) {
		    // Procedimento
    }

    WHILE ( var < var2 ) {
		    // Procedimento
		}

		DO {
		    // Procedimento --

		} WHILE ( var < var2 );

		SWITCH ( flag ) {
      CASE flag:
        -- Procedimento --
      STOP;
			CASE 1:
        -- Procedimento --
      STOP;
      DFLT:
			   -- Procedimento --
	    STOP;
		}
	}
}

```

## EBNF

```
<PROGRAM> -> morcela open_braces <SECTION> close_braces
<SECTION> -> <VAR_SECTION> body | body
<VAR_SECTION> -> var open_braces <VAR_DECLARATION> close_braces
<BODY_SECTION> -> body open_braces <BODY_STATEMENT> close_braces
<VAR_DECLARATION> -> <VAR_TYPE> double_dot id <SIZE_DECLARATION> semicolon <VAR_DECLARATION> | ε
<VAR_TYPE> -> boolean | double | string
<SIZE_DECLARATION> -> open_size_string number close_size_string | ε
<BODY_STATEMENT> -> <SWITCH_STATEMENT> <BODY_STATEMENT> | <IF_STATEMENT> <BODY_STATEMENT> | <WHILE_STATEMENT> <BODY_STATEMENT> | <DO_WHILE_STATEMENT> <BODY_STATEMENT> | <ATTRIBUTION_STATEMENT> <BODY_STATEMENT> | <STOP_STATEMENT> <BODY_STATEMENT> | <PRINT_STATEMENT> <BODY_STATEMENT> | <SCAN_STATEMENT> <BODY_STATEMENT> | ε
<WHILE_STATEMENT> -> while <CONDITION> open_braces <BODY_STATEMENT> close_braces
<STOP_STATEMENT> -> stop semicolon
<CONDITION> -> open_par <OPERATOR> close_par
<DO_WHILE_STATEMENT> -> do open_braces <BODY_STATEMENT> close_braces while <CONDITION> semicolon
<IF_STATEMENT> -> if <CONDITION> open_braces <BODY_STATEMENT> close_braces <ELSE_IF_STATEMENT> <ELSE_STATEMENT>
<ELSE_IF_STATEMENT> -> else if <CONDITION> open_braces <BODY_STATEMENT> close_braces <ELSE_IF_STATEMENT> | ε
<ELSE_STATEMENT> -> else open_braces <BODY_STATEMENT> close_braces | ε
<SWITCH_STATEMENT> -> switch open_braces id close_par open_braces <CASE_STATEMENT> close_braces
<CASE_STATEMENT> -> case id double_dot <BODY STATEMENT> <CASE_STATEMENT> | dflt double_dot <BODY_STATEMENT> |  ε
<PRINT_STATEMENT> -> print open_par string_value close_par
<SCAN_STATEMENT> -> scan open_par id close_par


<OPERATOR> -> id | <RELATIONAL_STATEMENT> | <ARITHMETIC_STATEMENT> | <LOGICAL_STATEMENT> | DIRECT_VALUE
<LOGICAL_STATEMENT> -> ( <OPERATOR> ‘&&’ <OPERATOR> │ <OPERATOR> ‘II’ <OPERATOR> │ <OPERATOR> ‘^’ <OPERATOR> │ ‘!’ <OPERATOR> )
<ARITHMETIC_STATEMENT> -> ( <OPERATOR> ‘+’ <OPERATOR> │ <OPERATOR> ‘-’ <OPERATOR> │ <OPERATOR> ‘*’ <OPERATOR> │ <OPERATOR> ‘/’ <OPERATOR> )
<RELATIONAL_STATEMENT> -> 	( <OPERATOR> ‘==’ <OPERATOR> | <OPERATOR> ‘>’ <OPERATOR> │ <OPERATOR> ‘<’ <OPERATOR> │ <OPERATOR> ‘>=’ <OPERATOR> │ <OPERATOR> ‘<=’ <OPERATOR> | <OPERATOR> ‘!=’ <OPERATOR> )
<ATTRIBUTION_STATEMENT> -> <EXPRESSION_NAMES> ‘=’ <OPERATOR> ‘;’



```

## Reconhecimento Léxico

![Autômato Léxico](img/lexautomata.jpg "Autômato Léxico")

Itens:

- `letter`: Qualquer letra. Regex: `[A-Za-z]`.
- `space`: Caractere de espaço (` `).
- `digit`: Qualquer algarismo. Regex: `[0-9]`.
- `tab/space`: Caractere de epaço ou um tab. Regex: `(\t| )`.
- `other`: Qualquer caractere.
- `special characters`: Caracteres especiais. Regex: `[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]`
