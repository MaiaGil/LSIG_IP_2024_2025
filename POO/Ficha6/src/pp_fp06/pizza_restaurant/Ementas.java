package pp_fp06.pizza_restaurant;

public class Ementas {
    private int numberEmentas;
    private int countEmentas;
    private Ementa[] ementas;

    public Ementas(int numberEmentas) {
        this.numberEmentas = numberEmentas;
        this.ementas = new Ementa[numberEmentas];
        this.countEmentas = 0;
    }

    public int getNumberEmentas() {
        return numberEmentas;
    }

    public void addEmenta(Ementa ementa) {
        if (this.countEmentas > this.numberEmentas) {
            System.out.println("Erro: A lista de ementas já está cheia");
            return;
        }
        ementas[this.countEmentas++] = ementa;
    }

    public void removeEmenta(Ementa ementa) {
        if (!this.searchEmenta(ementa)) {
            System.out.println("Erro: A lista de ementas não possui esta ementa");
            return;
        }
        for (int i = 0; i < this.countEmentas; i++) {
            if (ementas[i].equals(ementa)) {
                for (int j = i; j < this.countEmentas - 1; j++) {
                    ementas[j] = ementas[j + 1];
                }
                this.countEmentas--;
                break;
            }
        }
    }

    public boolean searchEmenta(Ementa ementa) {
        for (int i = 0; i < this.countEmentas; i++) {
            if (ementas[i].equals(ementa)) {
                return true;
            }
        }
        return false;
    }

    public void updateEmentas(Ementa ementa){

    }

}
