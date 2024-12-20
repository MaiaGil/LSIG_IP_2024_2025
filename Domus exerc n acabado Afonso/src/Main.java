import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import gestao.GestaoAlunos;

public class Main {

    public static GestaoAlunos g_alunos;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        g_alunos = new GestaoAlunos(sc);
        int op;

        do {
            System.out.println("\n<<Menu Principal>>");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - Editar aluno");
            System.out.println("3 - Pesquisar aluno");
            System.out.println("4 - Listar todos os alunos");
            System.out.println("5 - Remover aluno");
            System.out.println("6 - Exportar alunos para CSV");
            System.out.println("7 - Save");
            System.out.println("8 - Load");
            System.out.println("9 - Menu Notas");
            System.out.println("0 - Sair");
            System.out.print(">> ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1: g_alunos.createAluno();
                    break;
                case 2: g_alunos.updateAluno();
                    break;
                case 3: 
                    System.out.print("Número do aluno a pesquisar: ");
                    int num = Integer.parseInt(sc.nextLine());
                    System.out.println(g_alunos.pesquisaAluno(num));
                    break;
                case 4: g_alunos.listaAlunos();
                    break;
                case 5: g_alunos.deleteAluno();
                    break;
                case 6: g_alunos.exportarAlunos();
                    break;
                case 7: save();
                    break;
                case 8: load();
                    break;
                case 9:
                    if(g_alunos.n_alunos==0){
                        System.out.println("Erro: Ainda não existem alunos!");
                        break;
                    }
                    else{
                        int op1;
                        do {
                            System.out.println("\n<<Menu Notas>>");
                            System.out.println("1 - Inserir nota");
                            System.out.println("2 - Editar nota");
                            System.out.println("3 - Eleminar nota");
                            System.out.println("4 - Pesquisar nota");
                            System.out.println("5 - Ver nota de um aluno");
                            System.out.println("6 - Ver media de um aluno");
                            System.out.println("7 - Ver aluno com melhor média");
                            System.out.println("8 - Ver notas de todos os alunos");
                            System.out.println("9 - Ver media de todos os alunos");
                            System.out.println("0 - Voltar ao Menu Principal");
                            System.out.print(">> ");
                            op1 = Integer.parseInt(sc.nextLine());

                            switch (op1) {
                                case 1: g_alunos.inserirNota();
                                    break;
                                case 2: g_alunos.editNota();
                                    break;
                                case 3: g_alunos.elemNota();
                                    break;
                                case 4: g_alunos.pesquisaNota();
                                    break;
                                case 5: g_alunos.verNotas();
                                    break;
                                case 6: g_alunos.MediaAluno();
                                    break;
                                case 7: g_alunos.AlunoMelhorMedia();
                                    break;
                                case 8: g_alunos.verNotasTodos();
                                    break;
                                case 9: g_alunos.verMediasAlunos();
                                    break;
                                case 0: System.out.println("A voltar...");
                                    break;
                                default: System.out.println("Opção errada!");
                                    break;
                            }
                        } while (op1 != 0);                         
                        break;
                    }
                case 0: System.out.println("A sair...");
                    break;
                default: System.out.println("Opção errada!");
                    break;
            }
        }while(op != 0);
    }

    /**
     * Escreve todo o conteúdo do gestor de alunos em ficheiro binário 
     * 
     * @return true em caso de sucesso, false caso contrário
     */
    public static boolean save(){
        System.out.print("Digite o nome do ficheiro: ");
        String fileName = sc.nextLine();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(g_alunos);
            objectOutputStream.flush();
            objectOutputStream.close();
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao escrever no ficheiro...");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Lê todo o conteúdo do gestor de alunos em ficheiro binário 
     * 
     * @return true em caso de sucesso, false caso contrário
     */
    public static boolean load(){
        System.out.print("Digite o nome do ficheiro: ");
        String fileName = sc.nextLine();

        ObjectInputStream file;
        try {
            file = new ObjectInputStream(new FileInputStream(fileName));
            g_alunos = (GestaoAlunos) file.readObject();
            file.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler de ficheiro...");
            e.printStackTrace();
            return false;
        }
    }
}


