package classes;

import java.io.Serializable;
import java.util.Arrays;
//import java.util.Scanner;


public class Aluno implements Serializable {
    public int num_mec;
    public String nome;
    public String password;
    public int n_notas;
    public Nota notas[];
    public double media[];
    //public int[] mediaTodos;
    

    public Aluno(int num_mec, String nome, String password) {
        this.num_mec = num_mec;
        this.nome = nome;
        this.password = password;
        this.n_notas = 0;
        this.notas = new Nota[10];
    }

    @Override
    public String toString() {
        return "Aluno [num_mec=" + num_mec + ", nome=" + nome + ", password=" + password + ", n_notas=" + n_notas
                + ", notas=" + Arrays.toString(notas) + "]";
    }


    public boolean insereNota(String uc, int nota){
        int i;

        if (this.n_notas == this.notas.length){
            System.out.println("Erro: array de notas cheio");
            return false;
        }

        if (nota < 10 || nota > 20){
            System.out.println("Erro: nota inválida");
            return false;
        }

        //validar se a UC não é repetida
        for (i=0;i<n_notas;i++){
            if (notas[i].UC.equals(uc)){
                System.out.println("Erro: UC já existe");
                return false;
            }
        }
        
        //se passou todas as validações...
        this.notas[this.n_notas] = new Nota(uc, nota);
        this.n_notas++;
        return true;
    }

    
    public boolean editNota(String uc, int nota){
        int temp[] = new int[n_notas];
        for(int i=0; i<n_notas; i++){
            if(notas[i].UC.equals(uc)){
                if(notas[i].nota==nota){
                    System.out.println("Erro: a nota não foi alterada");
                    return false;
                }
                if (nota < 10 || nota > 20){
                    System.out.println("Erro: nota inválida");
                    return false;
                }
                if(notas[i].nota==temp[i]){
                    System.out.println("Erro: o aluno ainda não tem nota nesta UC");
                    return false;
                }
                this.notas[i]=new Nota(notas[i].UC,nota);
                return true;
            }
            else{
                System.out.println("Erro: o aluno não tem esta UC");
                return false;
            }
        }
        return true;
    }

    
    public boolean elemNota(String uc, int nota){
        int temp[] = new int[n_notas];
        for(int i=0; i<n_notas; i++){
            if(notas[i].UC.equals(uc)){
                if(notas[i].nota==temp[i]){
                    System.out.println("Erro: o aluno ainda não tem nota nesta UC");
                    return false;
                }
                this.notas[i]=new Nota(notas[i].UC,0);
                n_notas--;
                System.out.println("Nota eliminada com sucesso!");
                return true;
            }
            else{
                System.out.println("Erro: o aluno não tem esta UC");
                return false;
            }
        }
        return true;
    }
    
    
    public boolean pesqnota(String uc){

        int temp[] = new int[n_notas];
        for(int i=0; i<n_notas; i++){
            if(notas[i].UC.equals(uc)){
                if(notas[i].nota==temp[i]||notas[i].nota ==0){
                    System.out.println("O aluno ainda não tem nota nesta UC!");
                    return false;
                }
                System.out.println("A nota nesta UC é "+notas[i].nota);
                return true;
            }
            else{
                System.out.println("Erro: o aluno não tem esta UC");
                return false;
            }
        }
        return true;
    }

    public double mediaNotas(){
        int soma = 0;
        for(int i = 0; i < n_notas; i++){
            soma += notas[i].nota;
        }
        if(soma == 0){
            return 0;
        }
        double media = (soma / n_notas);
        return media;
    }

    
}

