MORCELA {
    VAR { // Declaração de variáveis
       DOUBLE: year, age;
       BOOLEAN: isFuture;
    }

    BODY {
        PRINT("Qual ano você nasceu?");
        SCAN(year);
        isFuture = year > 2018
        if (isFuture) {
            PRINT("Você ainda não nasceu")
        } else {
            // Calcula o ano de nascimento
            age = year - 2018;
            PRINT("Você tem ");
            PRINT(age);
            PRINT(" anos");
        }
    }
}