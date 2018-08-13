MORCELA{
    VAR { // Declaração de variáveis
       DOUBLE: nota; 
       DOUBLE: ic_nota;
       DOUBLE: count; 
       DOUBLE: media;
       BOOLEAN: aprovacao;
    }

    BODY {
        count = 1;
        PRINT("Informa a primeira nota: ");
        SCAN(ic_nota);

        WHILE (nota != -1) {
            PRINT("Informe outra nota ou digite '-1' para finalizar:");
            SCAN(nota);
            if(nota == -1) {
                STOP;
            }

            ic_nota = ic_nota + nota;
            count++;
        }
        media = ic_nota / count;

        PRINT("A média aritimética das notas informadas é: ");
        PRINT(media);
    }
}
