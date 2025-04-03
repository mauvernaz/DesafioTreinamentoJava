import java.util.ArrayList;

public class GeradorUFFMail {
    public static ArrayList<String> gerarUFFMail(String matricula){
        String nomeCompleto = ManipuladorCSV.dadosAluno(matricula).get(0).toLowerCase();
        String[] nomeSeparado = nomeCompleto.split(" ");
        ArrayList<String> opcoesUFFmail = new ArrayList<>();
        String nomePrimeiro = nomeSeparado[0];
        String nomeMeio = nomeSeparado[1]; //considerando que sempre serão três nomes
        String nomeUltimo = nomeSeparado[2];

        opcoesUFFmail.add(nomePrimeiro + "_" + nomeUltimo + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro + nomeMeio.toCharArray()[0] + nomeUltimo.toCharArray()[1] + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro + nomeUltimo + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro.toCharArray()[0] + nomeUltimo + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro.toCharArray()[0] + nomeMeio.toCharArray()[0] + nomeUltimo + "@id.uff.br");

        return opcoesUFFmail;
    }

    public static void exibirOpcoesUFFMail(ArrayList<String> opcoesUFFmail){}
}
