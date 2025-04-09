import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GeradorUFFMail {
    private ArrayList<String> opcoesUFFMails = new ArrayList<>();

    public ArrayList<String> getOpcoesUFFMails() {return opcoesUFFMails;}
    public void setOpcoesUFFMails(ArrayList<String> opcoesUFFMails){this.opcoesUFFMails = opcoesUFFMails;}

    public static ArrayList<String> gerarUFFMail(Aluno dadosAluno){
        ArrayList<String> opcoesUFFmail = new ArrayList<>();
        String nomeCompleto = dadosAluno.getNomeCompleto();
        String[] nomeSeparado = nomeCompleto.toLowerCase().split(" ");

        String nomePrimeiro = nomeSeparado[0];
        String nomeUltimo = nomeSeparado[nomeSeparado.length - 1];

        if(nomeSeparado.length < 2){
            return opcoesUFFmail;
        }

        opcoesUFFmail.add(nomePrimeiro + "_" + nomeUltimo + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro + nomeUltimo + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro.charAt(0) + nomeUltimo + "@id.uff.br");

        if(nomeSeparado.length > 2) {
            String iniciaisMeio = "";
            for (int i = 1; i < nomeSeparado.length - 1; i++) {
                iniciaisMeio += nomeSeparado[i].charAt(0);
            }
            opcoesUFFmail.add(nomePrimeiro + iniciaisMeio + nomeUltimo + "@id.uff.br");
            opcoesUFFmail.add(nomePrimeiro.charAt(0) + iniciaisMeio + nomeUltimo + "@id.uff.br");
        }

        Set<String> removeDuplicata = new HashSet<>(opcoesUFFmail);
        ArrayList<String> opcoesSemDuplicata = new ArrayList<>(removeDuplicata);

        return opcoesSemDuplicata;
    }

    public static ArrayList<String> exibirUFFMails(){
        ArrayList<String> opcoes = gerarUFFMail(ManipuladorCSV.aluno);
        String nome = ManipuladorCSV.aluno.getNomeCompleto().split(" ")[0];
        System.out.println(nome + ", por favor escolha uma das opções abaixo para o seu UFFMail");
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + " - " + opcoes.get(i));
        }
        return opcoes;
    }
}