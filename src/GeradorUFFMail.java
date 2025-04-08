import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GeradorUFFMail {

    public ArrayList<String> gerarUFFMail(String nomeCompleto){
        ArrayList<String> opcoesUFFmail = new ArrayList<>();
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
    }