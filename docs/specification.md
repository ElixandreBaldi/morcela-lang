# MorcelaLang

Versão 2018

*Elixandre Michael Baldi*

*Luiz Guilherme Fonseca Rosa*

## Sumário

TO-DO

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
operando1 + operando2 + … + operandoN
```

Semântica:

Independente da quantidade de operandos na soma, a ordem sempre será da esquerda para a direita, ou seja, inicialmente o primeiro operando é armazenado no endereço temporário, e então o endereço temporário recebe o acúmulo da operação com o próximo operando até acabar.

Os operandos 1 e 2 podem ser tanto um identificador quanto um valor imediato.

### Subtração

Sintaxe:

```
operando1 - operando2 - … - operandoN
```

Semântica:

Independente da quantidade de operandos na subtração a ordem sempre será da esquerda para a direita, ou seja, inicialmente o primeiro operando é armazenado no endereço temporário, e então o endereço temporário recebe o acúmulo da operação com o próximo operando até acabar.

Os operandos 1 e 2 podem ser tanto um identificador quanto um valor imediato.

### Multiplicação

Sintaxe:

```
operando1 * operando2 * … * operandoN
```

Semântica:

Independente da quantidade de operandos na multiplicação a ordem sempre será da esquerda para a direita, ou seja, inicialmente o primeiro operando é armazenado no endereço temporário, e então o endereço temporário recebe o acúmulo da operação com o próximo operando até acabar.

Os operandos 1 e 2 podem ser tanto um identificador quanto um valor imediato.

### Divisão

Sintaxe:

```
operando1 / operando2 / … / operandoN
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
operando1 && operando2
```

Semântica:

O resultado proveniente desta operação seguirá as regras da tabela verdade do AND.

### Or

Sintaxe:

```
operando1 || operando2
```

Semântica:

O resultado proveniente desta operação seguirá as regras da tabela verdade do OR.

### Xor

Sintaxe:

```
operando1 ^ operando2
```

Semântica:

O resultado proveniente desta operação seguirá as regras da tabela verdade do XOR.

### Not

Sintaxe:

```
!(operador1)
```

Semântica:

O resultado proveniente desta operação será a negação do valor de entrada.

## Operadores relacionais

O resultado da operação lógica será do tipo `BOOLEAN`, armazenado num endereço temporário. Caso o operando seja uma expressão, a expressão é executada e a operação considerará o valor armazenado no endereço temporário.

### Menor

Sintaxe:

```
operando1 < operando2
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`. A operação opera com qualquer combinação dos operandos. O resultado será `TRUE` caso o operando1 for menor que o operando2, e `FALSE` caso o operando1 for maior ou igual ao operando2.

### Maior

Sintaxe:

```
operando1 > operando2
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`. A operação opera com qualquer combinação dos operandos. O resultado será `TRUE` caso o operando1 for maior que o operando2, e `FALSE` caso o operando1 for menor ou igual ao operando2.

### Igual

Sintaxe:

```
operando1 == operando2
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`, `BOOLEAN` ou `STRING`. O resultado será `TRUE` caso o operando1 igual ao operando2, e `FALSE` caso forem operandos diferentes.

### Diferente

Sintaxe:

```
operando1 != operando2
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`, `BOOLEAN` ou `STRING`. O resultado será `TRUE` caso o operando1 dIFerente ao operando2, e `FALSE` caso forem operandos iguais.

### Menor ou igual

Sintaxe:

```
operando1 <= operando2
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo `DOUBLE`. O resultado será `TRUE` caso o operando1 seja menor ou igual ao operando2, e `FALSE` se o operando1 for maior que o operando2.

### Maior ou igual

Sintaxe:

```
operando1 >= operando2
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
