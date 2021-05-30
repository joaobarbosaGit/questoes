package Classes;


public class Usuario_Aluno {
    private int idUsuario_Aluno;
    private String Usuario;
    private String Senha;
    private String Email;
    private int Equipe_idEquipe;
    private int Rodada_idRodada;

    public int getIdUsuario_Aluno() {
        return idUsuario_Aluno;
    }

    public void setIdUsuario_Aluno(int idUsuario_Aluno) {
        this.idUsuario_Aluno = idUsuario_Aluno;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getEquipe_idEquipe() {
        return Equipe_idEquipe;
    }

    public void setEquipe_idEquipe(int Equipe_idEquipe) {
        this.Equipe_idEquipe = Equipe_idEquipe;
    }

    public int getRodada_idRodada() {
        return Rodada_idRodada;
    }

    public void setRodada_idRodada(int Rodada_idRodada) {
        this.Rodada_idRodada = Rodada_idRodada;
    }
    
}
