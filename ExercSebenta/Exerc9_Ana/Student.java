public class Student {
    public String firstName, lastName; // primeiro e ultimo nomes
    public int age; // idade
    public int grades[]; // lista de notas, de tam. max. 31
    public int n_notas; // num. de UCs ja feitas, i.e., com notas
    public String subjects[]; // lista de UCs, pela mesma ordem que as notas
    public String city; // cidade
    public int number; // num. de estudante
    public boolean gender; // true -> masculino, false -> feminino


    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.grades = new int[31];
        this.n_notas = 0;
        this.subjects = new String[31];
        this.city = "";
        this.number = 0;
        this.gender = true;
    }

}
