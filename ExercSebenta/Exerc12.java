import tipos.Student;

public class Exerc12 {
    public static void main(String[] arg){
        Student estudante[] = new Student[3];

        for (int i = 0; i < estudante.length; i++) {
            estudante[i] = new Student();
        }

        estudante[0].n_notas=31;
        estudante[1].n_notas=31;
        estudante[2].n_notas=0;

        System.out.println(function(estudante));
    }
    public static double function(Student students[]){
        if(students.length==0){
            return 0;
        }
        
        int conta = 0;
        for(int i = 0; i<students.length; i++){
            if(students[i].n_notas<0 || students[i].n_notas>31)
                return -1;
            if(students[i].n_notas==31.0)
                conta++;
        }
        
        return conta*100/students.length;
    }
}
