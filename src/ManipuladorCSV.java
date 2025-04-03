import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ManipuladorCSV {
    private static final String PATH_ALUNOS = "src/alunos.csv";

    //arraylist buscador de informações
    public static ArrayList<String> dadosAluno(String matricula){
        ArrayList<String> dados = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH_ALUNOS));
            String linha;
            while((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if(campos[1].equals(matricula)){
                    dados.addAll(Arrays.asList(campos));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dados;
    };

    public static void verificarRegularidade(ArrayList<String> dadosAluno){
        //verifica status
        //get(index) pela possibilidade de mudança na ordem dos campos no aluno.csv
        if(dadosAluno.get(5).equals("Ativo")){
            if(dadosAluno.get(4) == null){
                ArrayList<String> opcoes = GeradorUFFMail.gerarUFFMail(dadosAluno.get(1) /*matricula*/);
                System.out.println(", por favor escolha uma das opções abaixo para o seu UFFMail");
                int i = 1;
                for(String uffmail : opcoes) {
                    System.out.print(i + " - ");
                    System.out.println(uffmail);
                    i++;
                }
            }else System.out.println("Você já possui um UFFmail: " + dadosAluno.get(4));
        }else System.out.println("Você precisa de uma matrícula ativa para criar um UFFmail.");
    }


}
