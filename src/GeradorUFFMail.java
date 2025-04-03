import java.util.ArrayList;

public class GeradorUFFMail {

    public ArrayList<String> gerarUFFMail(String nomeCompleto){
        ArrayList<String> opcoesUFFmail = new ArrayList<>();
        String[] nomeSeparado = nomeCompleto.toLowerCase().split(" ");

        String nomePrimeiro = nomeSeparado[0];
        String nomeMeio = nomeSeparado[1]; //considerando que sempre serão três nomes
        String nomeUltimo = nomeSeparado[2];

        opcoesUFFmail.add(nomePrimeiro + "_" + nomeUltimo + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro + nomeMeio.charAt(0) + nomeUltimo.charAt(0) + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro + nomeUltimo + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro.charAt(0) + nomeUltimo + "@id.uff.br");
        opcoesUFFmail.add(nomePrimeiro.charAt(0) + nomeMeio.charAt(0) + nomeUltimo + "@id.uff.br");

        return opcoesUFFmail;
    }
    }