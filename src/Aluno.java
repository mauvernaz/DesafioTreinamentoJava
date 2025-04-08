public class Aluno {
    private String nomeCompleto;
    private String matricula;
    private String telefone;
    private String email;
    private String uffmail;
    private String statusAtividade;

//    public Aluno(String nomeCompleto, String matricula, String telefone, String email, String uffmail, String statusAtividade) {
//        this.nomeCompleto = nomeCompleto;
//        this.matricula = matricula;
//        this.telefone = telefone;
//        this.email = email;
//        this.uffmail = uffmail;
//        this.statusAtividade = statusAtividade;
//    }

    //getters
    public String getNomeCompleto() {return nomeCompleto;}
    public String getMatricula() {return matricula;}
    public String getTelefone() {return telefone;}
    public String getEmail() {return email;}
    public String getUffmail() {return uffmail;}
    public String getStatusAtividade() {return statusAtividade;}
    //setters
    public void setNomeCompleto(String nomeCompleto) {this.nomeCompleto=nomeCompleto;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setEmail(String email) {this.email = email;}
    public void setUffmail(String uffmail) {this.uffmail = uffmail;}
    public void setStatusAtividade(String statusAtividade) {this.statusAtividade=statusAtividade;}
}
