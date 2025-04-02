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

    public static boolean verificarRegularidade(ArrayList<String> dadosAluno){
        //verifica status
        //get(index) pela possibilidade de mudança na ordem dos campos no aluno.csv
        if(dadosAluno.get(5) == "Inativo"){
            return false;
        }
        if(dadosAluno.get(4) == null){
            return false;
        }else{
            return true;
        }
    }


}
