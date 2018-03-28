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

Como estruturas de repetição, há o `while` (verifica condição antes de executar o procedimento) e o `do while` (verifica condição depois de executar o procedimento).

Têm-se, também, o seguintes recursos: `if`, `while`, `do while` e `switch case` e os seguintes tipos primitivos: `String`, `Double` e `Boolean`.

A linguagem é indicada para uso de iniciantes em programação, pois os recursos são limitados, mas, ao mesmo tempo, permite explorar o básico de uma linguagem de programação.

## Operadores Aritméticos

As operações descritas abaixo resultarão em valores atribuídos num endereço temporário, podendo ser atribuído num endereço de um identificador posteriormente.

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

Para a realizar operações com operadores lógicos é necessário que todas os operandos sejam do tipo `Boolean`.

Vale lembrar que temos o tipo primitivo booleano e qualquer expressão relacional ou lógica armazena o resultado em um endereço temporário (identificador). O resultado da operação lógica também é armazenado num endereço temporário.

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

O resultado proveniente desta operação seguirá as regras da tabela verdade do XOR

### Not

Sintaxe:

```
!(operador1)
```

Semântica:

O resultado proveniente desta operação seguirá as regras da tabela verdade do XOR

##Operadores relacionais

O resultado da operação lógica será do tipo boolean, armazenado num endereço temporário. Caso o operando seja uma expressão, a expressão é executada e a operação considerará o valor armazenado no endereço temporário.

### Menor que (<)

Sintaxe:

```
operando1 < operando2
```
Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo double. A operação opera com qualquer combinação dos operandos. O resultado será true caso o operando1 for menor que o operando2, e false caso o operando1 for maior ou igual ao operando2.

### Maior que (>)

Sintaxe:
```
operando1 > operando2
```
Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo double. A operação opera com qualquer combinação dos operandos. O resultado será true caso o operando1 for maior que o operando2, e false caso o operando1 for menor ou igual ao operando2.

### Igual a (==)

Sintaxe:
```
operando1 == operando2
```
Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo double, boolean ou string. O resultado será true caso o operando1 igual ao operando2, e false caso forem operandos diferentes.

### Diferente de (!=)
Sintaxe:
```
operando1 != operando2
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo double, boolean ou string. O resultado será true caso o operando1 diferente ao operando2, e false caso forem operandos iguais.

### Menor ou igual a (<=):
Sintaxe:
```
operando1 <= operando2
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo double. O resultado será true caso o operando1 for menor ou igual ao operando2, e false o operando1 for maior que o operando2.

### Maior ou igual a (>=):
Sintaxe:
```
operando1 >= operando2
```

Semântica:

É permitido apenas operar sob dois operandos de forma que devem ser do tipo double. O resultado será true caso o operando1 for maior ou igual ao operando2, e false o operando1 for menor que o operando2.

## Tipo de Dados

## Double

O tipo double armazena valores numéricos que pertencem ao conjunto dos reais positivos e negativos, de forma que para cada variável do tipo double terá 1 bit para o sinal, 11 bits para o expoente e 52 bits para a mantissa reservados, representando valores de 10⁻³⁰⁸ a 10³⁰⁸, tendo assim 16 dígitos de precisão.

A inicialização do tipo double é feita da seguinte forma:
```
double: nome_do_identificador;
```
## Boolean

O tipo boolean armazena dois valores: true e false. Para representar esses valores utiliza-se 1 byte, de forma que o valor 0 (na base 2) representa false e o valor 1 representa true (na base 2).

A inicialização do tipo boolean é feita da seguinte forma:
```
boolean: nome_do_identificador;
```

## String

O tipo String armazena cadeias de caracteres. Seu armazenamento é estático, ou seja, o programador que define o tamanho da string, e em tempo de compilação o compilador alocará o tamanho em bytes informado na declaração.

A inicialização do tipo string é feita da seguinte forma:
```
string: nome_do_identificador[n]; // n é um valor imediato que será o tamanho em bytes da string. Caso n possua casas decimais, as mesmas serão desconsideradas.
```

## Atribuição (=)
