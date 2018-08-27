MORCELA{
    BODY {
        IF(test) {
            count = test;
        };

        SWITCH (test) {
            CASE 1:
                id = oi;
                STOP;						
            CASE op:
                id = oi;
                STOP;
            DFLT:
                STOP;
        };

        IF(test){
            i = 2;
        } ELSE {
            IF(oi) {
                i = 3;
            } ELSE {
                IF (jaz) {
                    i = 4;
                };
            };
        };

        DO {
            count++;
        } WHILE(test);       
    }
}
