import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ManipuladorCSV {
    private static final String PATH_ALUNOS = "src/alunos.csv";
    public static GeradorUFFMail geradorUFFMail = new GeradorUFFMail();

    //arraylist buscador de informações
    public static ArrayList<String> dadosAluno(String matricula){
        ArrayList<String> dados = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH_ALUNOS));
            String linha;
            while((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if(campos.length > 1 && campos[1].equals(matricula)){
                    dados.addAll(Arrays.asList(campos));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dados;
    };

    public static ArrayList<String> verificarRegularidade(ArrayList<String> dadosAluno) throws Exception {
        //verifica status
        //get(index) pela possibilidade de mudança na ordem dos campos no aluno.csv
        if (!dadosAluno.get(5).equals("Ativo")) {
            throw new Exception("Você precisa de uma matrícula ativa para criar um UFFmail.");
        }

        if (!dadosAluno.get(4).isEmpty()) {
            throw new Exception("Você já possui um UFFmail: " + dadosAluno.get(4));
        }

        String nomeCompleto = dadosAluno.get(0);
        ArrayList<String> opcoes = geradorUFFMail.gerarUFFMail(nomeCompleto);

        String nome = dadosAluno.get(0).split(" ")[0];
        System.out.println(nome + ", por favor escolha uma das opções abaixo para o seu UFFMail");

        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + " - " + opcoes.get(i));
        }

        return opcoes;
    }


}
