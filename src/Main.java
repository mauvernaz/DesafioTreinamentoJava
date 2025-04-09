import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //requisitar matricula do aluno manualmente
        System.out.println("Para criação do UFFmail, informe sua matrícula:");
        String numMatricula = scanner.nextLine();

        //reunir dados do aluno pela matricula
        Aluno dados = ManipuladorCSV.dadosAluno(numMatricula);
        if (!Objects.equals(dados.getMatricula(), numMatricula)) {
            System.out.println("Matrícula não encontrada.");
        }

        //exibir opcoes de uffmail se possível/regular
        ArrayList<String> opcoes = null;
        try {
            if(ManipuladorCSV.verificarRegularidade(dados)){
                opcoes = GeradorUFFMail.exibirUFFMails();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        //receber escolha do aluno e confirmar criação e sms
        if (opcoes != null && !opcoes.isEmpty()) {
            int escolha = scanner.nextInt();

            if (escolha > 0 && escolha <= opcoes.size()) {
                String uffmailEscolhido = opcoes.get(escolha - 1);
                System.out.println("A criação de seu email (" + uffmailEscolhido + ") será feita nos próximos minutos." +
                "\nUm SMS foi enviado para " + dados.getTelefone() + " com a sua senha de acesso.");
            } else {
                System.out.println("Opção inválida");
            }
        }
    }
}