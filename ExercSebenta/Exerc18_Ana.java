public class Main {
    public static void main(String[] args) {

        Student[] students = new Student[3];

        for(int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }

        students[0].number = 8223984;
        students[1].number = 8235346;
        students[2].number = 8224567;

        System.out.println(function(students, 2022));


    }

    public static boolean function(Student[] students, int year) {

        int currentYear = 0;

        for(int i = 0; i < students.length; i++) {

            currentYear = 2000 + ((students[i].number / 10000) % 100);

            if(currentYear != year) {
                return false;
            }
        }
        return true;
    }
}
