
package Classes;


public class Recurso {
    
    private int IdRecurso;
    private String Objeto;
    private String Causa;
    private String Deferimento;
    private int Situacao;
    private int Rodada_idRodada;
    private int Equipe_idEquipe;

    public int getIdRecurso() {
        return IdRecurso;
    }

    public void setIdRecurso(int IdRecurso) {
        this.IdRecurso = IdRecurso;
    }

    public String getObjeto() {
        return Objeto;
    }

    public void setObjeto(String Objeto) {
        this.Objeto = Objeto;
    }

    public String getCausa() {
        return Causa;
    }

    public void setCausa(String Causa) {
        this.Causa = Causa;
    }

    public String getDeferimento() {
        return Deferimento;
    }

    public void setDeferimento(String Deferimento) {
        this.Deferimento = Deferimento;
    }

    public int getSituacao() {
        return Situacao;
    }

    public void setSituacao(int Situacao) {
        this.Situacao = Situacao;
    }

    public int getRodada_idRodada() {
        return Rodada_idRodada;
    }

    public void setRodada_idRodada(int Rodada_idRodada) {
        this.Rodada_idRodada = Rodada_idRodada;
    }

    public int getEquipe_idEquipe() {
        return Equipe_idEquipe;
    }

    public void setEquipe_idEquipe(int Equipe_idEquipe) {
        this.Equipe_idEquipe = Equipe_idEquipe;
    }
    
    
    
}
