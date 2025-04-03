import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //informar matrícula
        System.out.println("Para criação do UFFmail, informe sua matrícula:");
        String numMatricula = scanner.nextLine();
        System.out.println(numMatricula);

        //autenticar
        ArrayList<String> dados = ManipuladorCSV.dadosAluno(numMatricula);
        if (dados.isEmpty()) {
            System.out.println("Matrícula não encontrada.");
        }
        for (String campo : dados) {
            System.out.println(campo);
        }

        //verificar regularidade
        //ManipuladorCSV.verificarRegularidade(dados);
        //informar inatividade
        //informar existencia

        //gerar opções uffmail
//        ArrayList<String> opcoes = GeradorUFFMail.gerarUFFMail(numMatricula);
//        int i = 1;
//        for(String uffmail : opcoes) {
//            System.out.print(i + " - ");
//            System.out.println(uffmail);
//            i++;
//        }

        //escolher opção uffmail
        ArrayList<String> opcoes = null;
        try {
            opcoes = ManipuladorCSV.verificarRegularidade(dados);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        if (opcoes != null && !opcoes.isEmpty()) {
            int escolha = scanner.nextInt();

            if (escolha > 0 && escolha <= opcoes.size()) {
                String uffmailEscolhido = opcoes.get(escolha - 1);
                System.out.println("A criação de seu email (" + uffmailEscolhido + ") será feita nos próximos minutos." +
                "\nUm SMS foi enviado para " + dados.get(2) + " com a sua senha de acesso.");
            } else {
                System.out.println("Opção inválida");
            }

            //criar uffmail

            //confirmar criação uffmail

            //"enviar sms"
        }
    }
}