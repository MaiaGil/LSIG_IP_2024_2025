package classes;

import java.io.Serializable;

public class Nota implements Serializable {
    public String UC;
    int nota;
    
    public Nota(String uC, int nota) {
        UC = uC;
        this.nota = nota;
    }

    @Override
    public String toString() {
        if (nota == 0){
            return "Na UC "+ UC + " ainda não tem nota";
        }
        return "Na UC "+ UC + " teve "+nota+".";
    }
}


