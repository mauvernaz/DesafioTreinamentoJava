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
        ArrayList<String> dados = new ArrayList<>();
        dados = ManipuladorCSV.dadosAluno(numMatricula);
        for(String campo : dados){
            System.out.println(campo);
        }

        //verificar regularidade
        ManipuladorCSV.verificarRegularidade(dados);
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


        //criar uffmail

        //confirmar criação uffmail

        //"enviar sms"
    }
}