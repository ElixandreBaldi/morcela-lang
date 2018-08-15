MORCELA{
    VAR { // Declaração de variáveis
       STRING: texto[20];
    }

    BODY {
		STOP;
		
		ic_nota = ic_nota + nota;
		count = count + 1;
        
        media = ic_nota / count;               
    }
}
