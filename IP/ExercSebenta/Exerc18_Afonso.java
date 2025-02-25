import tipos.Student;

public class Exerc18 {

    public static void main(String[] args) {
        Student estudante[] = new Student[3];

        for (int i = 0; i < estudante.length; i++) {
            estudante[i] = new Student();
        }

        estudante[0].number=8245346;
        estudante[1].number=8245347;
        estudante[2].number=82453;

        int ano = 2024;

        System.out.println(function(estudante,ano));

    }

    public static boolean function(Student[] students, int year) {
        int meio = 0;
        int num = 8000000;
        if(year<2000){
            meio=year-1900; 
        }
        if(year>=2000){
            meio=year-2000;
        }
        num += meio*10000;
        
        for(int i = 0; i<students.length;i++){
            if(students[i].number<num||students[i].number>num+10000)
                return false;
        }
        return true; 
    }
}

