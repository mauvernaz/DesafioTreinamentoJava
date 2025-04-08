import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ManipuladorCSV {
    private static final String PATH_ALUNOS = "src/alunos.csv";
    public static GeradorUFFMail geradorUFFMail = new GeradorUFFMail();
    public static Aluno aluno = new Aluno();

    //buscador de informações em aluno.csv pela matricula
    public static Aluno dadosAluno(String matricula){
        //ArrayList<String> dados = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH_ALUNOS));
            String linha;
            while((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if(campos.length > 1 && campos[1].equals(matricula)){
                    //dados.addAll(Arrays.asList(campos));
                    aluno.setNomeCompleto(campos[0]);
                    aluno.setMatricula(campos[1]);
                    aluno.setTelefone(campos[2]);
                    aluno.setEmail(campos[3]);
                    aluno.setUffmail(campos[4]);
                    aluno.setStatusAtividade(campos[5]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    };

    //verificador das informações buscadas para checar existência de uffmail e status de atividade
    //função boolean ou integer com switch case?
    public static ArrayList<String> verificarRegularidade(Aluno dadosAluno) throws Exception {
        //get(index) pela possibilidade de mudança na ordem dos campos no aluno.csv
        if (!dadosAluno.getStatusAtividade().equals("Ativo")) {
            throw new Exception("Você precisa de uma matrícula ativa para criar um UFFmail."); //return false
        }

        if (!dadosAluno.getUffmail().isEmpty()) {
            throw new Exception("Você já possui um UFFmail: " + dadosAluno.getUffmail()); // return false
        }

        //outro que recebe boolean
        String nomeCompleto = dadosAluno.getNomeCompleto();
        ArrayList<String> opcoes = geradorUFFMail.gerarUFFMail(nomeCompleto);

        String nome = dadosAluno.getNomeCompleto().split(" ")[0];
        System.out.println(nome + ", por favor escolha uma das opções abaixo para o seu UFFMail");

        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + " - " + opcoes.get(i));
        }
        return opcoes; //true
    }

    //função que recebe o verificarRegularidade
//    public static ArrayList<String> informarRegularidade(Integer caso){
//    switch(caso) {
//        case 1:
//            System.out.println("Você precisa de uma matrícula ativa para criar um UFFmail");
//            break;
//        case 2:
//            System.out.println("Você já possui um UFFmail");
//            break;
//        default:
//
//    }
//
//    }
}