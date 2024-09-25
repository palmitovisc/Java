import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
public class Agenda {
    
    public static HashMap<String,Contato> contatos = new HashMap<>();
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        while (opcao != 11) {

            System.out.println("1-  Importar Contatos");
            System.out.println("2-  Exportar Contatos");
            System.out.println("3-  Inserir Contato");
            System.out.println("4-  Remover Contato usando o Número de Telefone");
            System.out.println("5-  Remover Contato usando o Nome pessoal");
            System.out.println("6-  Localizar Contato usando o Nome pessoal");
            System.out.println("7-  Localizar Contato usando o Número de telefone");
            System.out.println("8-  Listar todos os contatos");
            System.out.println("9-  Realizar chamada");
            System.out.println("10- Limpar Agenda");
            System.out.println("11- Sair da Agenda");
            System.out.print("Escolha uma opção: ");
            
          
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcao) {
                case 1:
                    importarContatos();
                    
                    break;
                case 2:
                exportarContatos();
                    break;
                case 3:
                inserirContato(scanner);
                    break;
                case 4:
                removerPorTelefone(scanner);
                    break;
                case 5:
                removerPorNome(scanner);
                    break;
                case 6:
                localizarPorNome(scanner);
                    break;
                case 7:
                localizarPorTelefone(scanner);
                    break;
                case 8:
                    listarContatos();
                    break;
                case 9:
                realizarChamada(scanner);
                    break;
                case 10:
                limparAgenda();
                    break;
                case 11:
                    System.out.println("Saindo da agenda...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        scanner.close();
    }
    public static void importarContatos(){
             try{
        InputStream inputStream = new FileInputStream("src/Contatos.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            String[] dados = linha.split("@");
            if (dados.length == 3) {
                String nome = dados[0].trim();
                String telefone = dados[1].trim();
                String endereco = dados[2].trim();

            
                Contato contato = new Contato(nome, telefone, endereco);

                
                contatos.put(nome, contato);
            } else {
                System.out.println("Linha inválida: " + linha);
            }
        }
        bufferedReader.close();
    }
    catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
        }
        catch (IOException e) {
            System.out.println("Erro ao ler o arquivo!");
            e.printStackTrace();
        }
}
public static void exportarContatos(){
    try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Contatos.txt"));

            
            for (Contato contato : contatos.values()) {
                writer.write(contato.getNome() + "@" + contato.getTelefone() + "@" + contato.getEndereco());
                writer.newLine(); 
            }

            writer.close();
            System.out.println("Contatos exportados com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo!");
            e.printStackTrace();
        }
    }
        public static void inserirContato(Scanner scanner) {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();
            
            System.out.print("Digite o email: ");
            String email = scanner.nextLine();
        
            
            Contato contato = new Contato(nome, telefone, email);
        
            
            contatos.put(nome, contato);
            
            System.out.println("Contato inserido com sucesso!");
        }
        
    
        public static void removerPorTelefone(Scanner scanner){
            System.out.println("digite um telefone: ");
            String telefone = scanner.nextLine();
            String nomeARemover = null;

            
            for (Contato contato: contatos.values()){
                if(contato.getTelefone().equals(telefone)){
                    nomeARemover = contato.getNome();
                    break;
                }
            }
            if(nomeARemover != null){
                contatos.remove(nomeARemover);
                System.out.println("Contato removido");
            }
            else{
                System.out.println("numero invalido");
            }
        }

        public static void removerPorNome(Scanner scanner){
            System.out.println("digite o nome: ");
            String nome = scanner.nextLine();

            for(Contato contato: contatos.values()){
                if(contato.getNome().equals(nome)){
                    contatos.remove(nome);
                    break;
                }
            }
        }

        public static void localizarPorNome(Scanner scanner){
            System.out.println("digite o nome: ");
            String nome = scanner.nextLine();

            Contato contato = contatos.get(nome);

            if(contato != null){
                System.out.println(contato);
            }
            else{
                System.out.println("contato nao encontrado");
            }
        }


        public static void localizarPorTelefone(Scanner scanner){
            System.out.println("digite o telefone: ");
            String telefone = scanner.nextLine();

            for(Contato contato:contatos.values()){
                if(contato.getTelefone().equals(telefone)){
                    System.out.println(contato);
                    return;
                }
            }
        }
public static void listarContatos() {
    if (contatos.isEmpty()) {
        System.out.println("Nenhum contato na agenda.");
    } else {
        for (String nome : contatos.keySet()) {
            System.out.println(contatos.get(nome));
        }
    }
}


public static void realizarChamada(Scanner scanner){
    System.out.print("Digite o telefone: ");
    String telefone = scanner.nextLine();

    boolean encontrado = false;
    for (Contato contato : contatos.values()) {
        if (contato.getTelefone().equals(telefone)) {
            System.out.println("Realizando chamada para " + contato.getNome() + " no número " + contato.getTelefone() + "...");
            encontrado = true;
            break;
        }
    }
}

public static void limparAgenda(){
    contatos.clear();
    System.out.println("agenda limpa");
}


}
