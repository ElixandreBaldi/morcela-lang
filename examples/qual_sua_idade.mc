MORCELA {
    VAR { // Declaração de variáveis
       DOUBLE: year;
       DOUBLE: age;
       BOOLEAN: isFuture;
    }

    BODY {
        PRINT("Qual ano você nasceu?");
        SCAN(year);
        isFuture = year > 2018;
        IF (isFuture) {
            PRINT("Você ainda não nasceu");
        } ELSE {
            // Calcula o ano de nascimento
            age = year - 2018;
            PRINT("Você tem ");
            PRINT(age);
            PRINT(" anos");
        };
    }
}
