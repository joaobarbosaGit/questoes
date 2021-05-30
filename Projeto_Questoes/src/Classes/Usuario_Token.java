
package Classes;


public class Usuario_Token {
    
    private int Id;
    private String Nome;
    private String Senha;
    private String Email;
    private int Equipe_idEquipe;
    private int Rodada_idRodada;
    private String Tipo;

     private static Usuario_Token instance;
    private Usuario_Token() {}

      public static Usuario_Token getInstance() {
        if (instance == null)
            instance = new Usuario_Token();
        return instance;
    }
    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
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
