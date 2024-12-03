public class Main {
    public static void main(String[] args) {

        Student[] students = new Student[3];

        for(int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }

        students[0].firstName = "Joao";
        students[0].lastName = "Silva";
        students[0].age = 20;
        students[0].grades = new int[]{10, 11, 12};
        students[0].n_notas = 3;
        students[0].subjects = new String[]{"POO", "BD", "RC"};
        students[0].city = "Porto";
        students[0].number = 123;
        students[0].gender = true;

        students[1].firstName = "Maria";
        students[1].lastName = "Silva";
        students[1].age = 20;
        students[1].grades = new int[]{10, 11, 12};
        students[1].n_notas = 3;
        students[1].subjects = new String[]{"POO", "BD", "RC"};
        students[1].city = "Porto";
        students[1].number = 456;
        students[1].gender = false;

        students[2].firstName = "Joao";
        students[2].lastName = "Silva";
        students[2].age = 20;
        students[2].grades = new int[]{10, 11, 12};
        students[2].n_notas = 3;
        students[2].subjects = new String[]{"POO", "BD", "RC"};
        students[2].city = "Porto";
        students[2].number = 789;
        students[2].gender = true;

        System.out.println(function(students, 456));

    }

    public static double function(Student[] students, int studentNumber) {

        int totalUCs = 31;

        for(int i = 0; i < students.length; i++) {
            if(students[i].number == studentNumber ) {
                return ((double) students[i].n_notas / totalUCs) * 100;
            }
        }
        return -1;
    }
}
