import java.io.*;

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
    public static boolean verificarRegularidade(Aluno dadosAluno) throws Exception {
        //get(index) pela possibilidade de mudança na ordem dos campos no aluno.csv
        if (!dadosAluno.getStatusAtividade().equals("Ativo")) {
            throw new Exception("Você precisa de uma matrícula ativa para criar um UFFmail.");
        }
        if (!dadosAluno.getUffmail().isEmpty()) {
            throw new Exception("Você já possui um UFFmail: " + dadosAluno.getUffmail());
        }
        return true;
    }
}