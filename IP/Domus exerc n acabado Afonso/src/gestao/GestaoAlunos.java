package gestao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import classes.Aluno;

public class GestaoAlunos implements Serializable{
    public final int TAM_INICIAL = 2; // tamanho inicial do array de alunos
    public final int TAM_INCREMENTO = 2; // fator de incremento do array, quando cheio
    public Aluno alunos[];
    public int n_alunos;
    public double[] media;
    public transient Scanner sc;

    public GestaoAlunos(Scanner sc) {
        // inicializar as variáveis necessárias
        this.alunos = new Aluno[TAM_INICIAL];
        this.n_alunos = 0;
        this.sc = sc;
        //this.media = new double[alunos.length];
    }

    @Override
    public String toString() {
        return "GestaoAlunos [alunos=" + Arrays.toString(alunos) + ", n_alunos=" + n_alunos + "]";
    }

    /**
     * Pesquisa um aluno dado o seu numéro mecanográfico
     * 
     * @param num_mec O número mecanográfico do aluno a pesquisar
     * @return O aluno, se existir, null caso contrário
     */
    public Aluno pesquisaAluno(int num_mec) {
        int i;
        for (i = 0; i < n_alunos; i++)
            if (alunos[i].num_mec == num_mec)
                return alunos[i];

        return null;
    }

    /**
     * Devolve a posição de um aluno no array
     * 
     * @param num_mec O número mecanográfico do aluno a pesquisar
     * @return A posição do aluno no array, se existir, -1 caso contrário
     */
    public int pesquisaPosAluno(int num_mec) {
        int i;
        for (i = 0; i < n_alunos; i++)
            if (alunos[i].num_mec == num_mec)
                return i;

        return -1;
    }

    /**
     * Lista na consola todos os alunos registados
     */
    public void listaAlunos() {
        int i;
        for (i = 0; i < n_alunos; i++)
            System.out.println(this.alunos[i]);
    }

    /*
     * As próximas funções implementam o CRUD (Create, Remove, Update, Delete) da
     * gestão de alunos
     */

    /**
     * Adiciona um novo aluno ao array, senão existir já
     * 
     * @return um booleano indicando o sucesso ou insucesso da operação
     */
    public boolean createAluno() {

        System.out.print("Digite o número mecanográfico do novo aluno: ");
        int num = Integer.parseInt(sc.nextLine());

        Aluno aluno = pesquisaAluno(num);
        if (aluno == null) { // não existe um aluno com este número, prosseguir

            // se array está cheio, realocar
            if (this.n_alunos == this.alunos.length) {
                System.out.println("Array cheio, a realocar...");
                Aluno[] temp = new Aluno[this.alunos.length + TAM_INCREMENTO];
                int i;
                for (i = 0; i < this.n_alunos; i++)
                    temp[i] = this.alunos[i];
                this.alunos = temp;
            }

            // pedir dados
            System.out.print("Digite o nome do aluno: ");
            String nome = sc.nextLine();
            System.out.print("Digite a password do aluno: ");
            String pass = sc.nextLine();
            Aluno novo_aluno = new Aluno(num, nome, pass);

            // inserir
            this.alunos[this.n_alunos] = novo_aluno;
            this.n_alunos++;

            return true;
        } else { // já existe um aluno com este número
            System.out.println("ERRO: já existe um aluno com este número.");
            return false;
        }
    }

    /**
     * Atualiza os dados de um aluno, caso exista
     * 
     * @return true se o aluno existe e foi editado, false caso contrário
     */
    public boolean updateAluno() {
        System.out.print("Digite o número mecanográfico do aluno a atualizar: ");
        int num = Integer.parseInt(sc.nextLine());

        Aluno aluno = pesquisaAluno(num);
        if (aluno == null) { // não existe um aluno com este número

            System.out.println("ERRO: aluno com o número " + num + " não existe.");
            return false;
        } else { // aluno existe
                 // pedir dados e atualizar
            System.out.print("Digite o nome do aluno: ");
            aluno.nome = sc.nextLine();
            System.out.print("Digite a password do aluno: ");
            aluno.password = sc.nextLine();

            return true;
        }
    }

    public boolean deleteAluno() {

        System.out.print("Digite o número mecanográfico do aluno a remover: ");
        int num = Integer.parseInt(sc.nextLine());

        int posAluno = pesquisaPosAluno(num);
        if (posAluno == -1) { // não existe um aluno com este número, nada a remover

            System.out.println("ERRO: aluno com o número " + num + " não existe.");
            return false;
        } else { // existe um aluno com este número
            if (this.n_alunos == posAluno) // se estamos a remover da última posição do array
                this.n_alunos--;
            else { // se estamos a remover de uma posição intermédia do array
                int i;
                for (i = posAluno; i < n_alunos - 1; i++)
                    this.alunos[i] = this.alunos[i + 1];
                this.n_alunos--;
            }
            return true;
        }
    }

    /**
     * Exporta a lista de alunos em formato CSV
     * 
     * @return true em caso de sucesso, false em caso contrário
     */
    public boolean exportarAlunos() {
        System.out.print("Digite o nome do ficheiro: ");
        String fileName = sc.nextLine();
        FileWriter file;

        try {
            file = new FileWriter(fileName);
            int i;
            //imprimir cabeçalho
            file.write("num_mec, nome, password, num_UCs\n");
            //imprimir conteúdo
            for (i=0;i<this.n_alunos;i++){
                file.write(this.alunos[i].num_mec+","+this.alunos[i].nome+","+this.alunos[i].password+","+this.alunos[i].n_notas);
                if(i+1 < this.n_alunos)
                    file.write("\n");
            }
                
            file.close();
            System.out.println("Ficheiro gerado com sucesso");
            return true;
        }
        catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no ficheiro...");
            e.printStackTrace();
            return false;
        }
    }

// feito por mim tudo para baixo, tudo para cima pelo stor
    public void inserirNota(){
        System.out.print("Digite o número do aluno: ");
        Aluno aluno = this.pesquisaAluno(Integer.parseInt(sc.nextLine()));
        if (aluno != null){
            System.out.print("Digite a UC: ");
            String uc = sc.nextLine();
            System.out.print("Digite a nota final: ");
            int nota = Integer.parseInt(sc.nextLine());
            aluno.insereNota(uc, nota);
        }
        else{
            System.out.println("Erro: o aluno não existe");
        }

    }

    public void editNota(){
        int conta = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta ++;
            }
        }
        if(conta!=0){ //para ver se algum aluno já tem nota

            System.out.print("Digite o número do aluno: ");
            Aluno aluno = this.pesquisaAluno(Integer.parseInt(sc.nextLine()));
            if (aluno != null){
                System.out.print("Digite a UC que vai editar: ");
                String uc = sc.nextLine();
                System.out.print("Digite a nova nota final: ");
                int nota = Integer.parseInt(sc.nextLine());
                aluno.editNota(uc, nota);
            }
            else{
                System.out.println("Erro: o aluno não existe");
            }

        }
        else{
            System.out.println("Erro: Ainda nenhum aluno tem notas!");
        }
        
    }

    public void elemNota(){
        int conta = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta ++;
            }
        }
        if(conta!=0){//para ver se algum aluno já tem nota

            System.out.print("Digite o número do aluno: ");
            Aluno aluno = this.pesquisaAluno(Integer.parseInt(sc.nextLine()));
            if (aluno != null){
                System.out.print("Digite a UC que vai eliminar a nota: ");
                String uc = sc.nextLine();
                aluno.elemNota(uc,0);
                
            }
            else{
                System.out.println("Erro: o aluno não existe");
            }

        }
        else{
            System.out.println("Erro: Ainda nenhum aluno tem notas!");
        }

    }
    
    public void pesquisaNota(){
        int conta = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta ++;
            }
        }
        if(conta!=0){//para ver se algum aluno já tem nota

            System.out.print("Digite o número do aluno: ");
            Aluno aluno = this.pesquisaAluno(Integer.parseInt(sc.nextLine()));
            if (aluno != null){
                System.out.print("Digite a UC que quer a nota: ");
                String uc = sc.nextLine();
                aluno.pesqnota(uc);
            }
            else{
                System.out.println("Erro: o aluno não existe");
            }
        
        }
        else{
            System.out.println("Erro: Ainda nenhum aluno tem notas!");
        }
    }

    public void verNotas(){
        int conta = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta ++;
            }
        }
        if(conta!=0){//para ver se algum aluno já tem nota

            System.out.print("Digite o número do aluno: ");
            Aluno aluno = this.pesquisaAluno(Integer.parseInt(sc.nextLine()));
            if (aluno != null){
                for(int i = 0; i<n_alunos;i++){
                    if(aluno.n_notas==0){
                        System.out.println("\nO aluno "+alunos[i].nome+" ainda não tem notas!");
                        continue;
                    }
                    System.out.println("\nO aluno "+aluno.nome+":");
                    for(int j = 0; j<aluno.n_notas; j++){
                        System.out.println(aluno.notas[j]);
                    }
                }
            }
            else{
                System.out.println("Erro: o aluno não existe");
            }
        }
        else{
            System.out.println("Erro: Ainda nenhum aluno tem notas!");
        }
    }
    
    public void verNotasTodos(){
        int conta = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta ++;
            }
        }
        if(conta!=0){//para ver se algum aluno já tem nota
            for(int i = 0; i<n_alunos;i++){
                if(alunos[i].n_notas==0){
                    System.out.println("\nO aluno "+alunos[i].nome+" ainda não tem notas!");
                    continue;
                }
                System.out.println("\nO aluno "+alunos[i].nome+":");
                for(int j = 0; j<alunos[i].n_notas; j++){
                    System.out.println(alunos[i].notas[j]);
                }
            }
        }
        else{
            System.out.println("Erro: Ainda nenhum aluno tem notas!");
        }
        
    }

    public void MediaAluno(){
        int conta = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta ++;
            }
        }
        if(conta!=0){//para ver se algum aluno já tem nota
            System.out.print("Digite o número do aluno: ");
            Aluno aluno = this.pesquisaAluno(Integer.parseInt(sc.nextLine()));
            if (aluno != null){
                if(aluno.n_notas==0||aluno.mediaNotas()==0.0){
                    System.out.println("\nErro: o aluno "+aluno.nome+" ainda não tem notas!");
                }
                else{
                    System.out.println("A media das notas do aluno "+aluno.nome+" é: "+aluno.mediaNotas());
                }
            }
            else{
                System.out.println("Erro: o aluno não existe");
            }
        }
        else{
            System.out.println("Erro: Ainda nenhum aluno tem notas!");
        }
    }

    public void CalculoMediaAlunos(){
        int conta = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta ++;
            }
        }
        if(conta!=0){//para ver se algum aluno já tem nota
            media = new double[n_alunos];
            for(int i = 0; i<n_alunos; i++){
                media[i] = alunos[i].mediaNotas();
            }
        }
        else{
            System.out.println("Erro: Ainda nenhum aluno tem notas!");
        }
    }

    public void verMediasAlunos(){
        CalculoMediaAlunos();
        int conta = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta ++;
            }
        }
        if(conta!=0){
            for(int i= 0; i<n_alunos; i++){
                if(alunos[i].n_notas==0||media[i]==0.0){
                    System.out.println("O aluno "+alunos[i].nome+" ainda não tem notas!");
                    continue;
                }
                else{
                    System.out.println("O aluno "+alunos[i].nome+" tem média: "+media[i]);
                }
            }
        }
        else{
            System.out.println("");
        }
        
    }

    public void AlunoMelhorMedia(){
        CalculoMediaAlunos();
        int conta1 = 0;
        for (int i = 0; i<n_alunos; i++){
            if(alunos[i].n_notas!=0){
                conta1 ++;
            }
        }
        if(conta1!=0){
            int conta = 0;
        int melhor = 0;
        for(int i = 1; i<n_alunos; i++){
            if(media[i] > media[i-1]){
                melhor = i;
            }
        }
        
        for (int i = 0; i<n_alunos; i++){
            if(media[i] == media[melhor]){
                conta++;
                System.out.println("\nUm dos alunos com a melhor média é: "+alunos[i].nome + " o seu numero é o " + alunos[i].num_mec + 
                            "\nA sua média é " + media[i] + " as suas UC e respetivas notas são: " );
                for(int j = 0; j<alunos[i].n_notas; j++){
                    System.out.println(alunos[i].notas[j]);
                }
                
            }
        }

        /* 
        if (conta != 0) {
            System.out.println("\nUm dos alunos com a melhor média é: "+alunos[melhor].nome + "o seu numero é o " + alunos[melhor].num_mec + 
                            "\nA sua média é " + media[melhor] + "as suas UC e respetivas notas são: " );
            for(int j = 0; j<alunos[melhor].n_notas; j++){
                System.out.println(alunos[melhor].notas[j]);
            }
        }
        */
        if(conta == 0){
            System.out.println("\nO aluno com a melhor média é: "+alunos[melhor].nome + "o seu numero é o " + alunos[melhor].num_mec + 
                            "\nA sua média é " + media[melhor] + " as suas UC e respetivas notas são: " );
            for(int j = 0; j<alunos[melhor].n_notas; j++){
                System.out.println(alunos[melhor].notas[j]);
            }
        }
        }
        else{
            System.out.println("");
        }
         
    }

}