
package Servicos;

import Classes.Equipe;
import Classes.Questao;
import Classes.Resposta;
import Classes.Resposta_Questao_Desafio;
import WebService.EquipeWebDAO;
import WebService.Questao_DesafioWebDAO;
import WebService.RespostaWebDAO;
import WebService.Resposta_Questao_DesafioWebDAO;
import java.util.ArrayList;

public class ContagemPontos {
    
    EquipeWebDAO ewdao = new EquipeWebDAO();
    Questao_DesafioWebDAO qdwdao = new Questao_DesafioWebDAO();
    Resposta_Questao_DesafioWebDAO rqdwdao = new Resposta_Questao_DesafioWebDAO();
    RespostaWebDAO rwdao = new RespostaWebDAO();
    
    public void ContarPotuacaoQualificacaoQuestoes(ArrayList<Questao> listaQuestoes, Equipe e){
        
        int PotuacaoQuestao = 0;
        Questao q;
        
        //QUALIFICAÇÃO QUESTÃO 01
        q = listaQuestoes.get(0);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 02
        q = listaQuestoes.get(1);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 03
        q = listaQuestoes.get(2);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 04
        q = listaQuestoes.get(3);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 05
        q = listaQuestoes.get(4);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 06
        q = listaQuestoes.get(5);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 07
        q = listaQuestoes.get(6);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 08
        q = listaQuestoes.get(7);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 09
        q = listaQuestoes.get(8);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        //QUALIFICAÇÃO QUESTÃO 10
        q = listaQuestoes.get(9);
        PotuacaoQuestao += VerificarPontuacaoQualificacaoQuestao(q.getQualificacao_Questao());
        
        e.setPontuacao_Questoes(PotuacaoQuestao);
        ewdao.AtualizarPontuacaoEquipe(e);
    }
    
    public int VerificarPontuacaoQualificacaoQuestao(String qualificacao){
        
        int retorno = 0;
        
        switch (qualificacao) {
            case "INRRELEVANTE":
                retorno -= 10;
            break;
            
            case "POUCO RELEVANTE":
                retorno -= 5;
            break;
            
            case "RELEVANTE":
                retorno += 0;
            break;
            
            case "MUITO RELEVANTE":
                retorno += 5;
            break;
            
            case "EXTREMAMENTE RELEVANTE":
                retorno += 10;
            break;
            
            case "SEM CONTEUDO": 
                retorno += 0;
            break;
        }
        
        return retorno;
    }
    
    public int VerificarQualificacaoQuestao(String qualificacao){
        
        int retorno = 0;
        
        switch (qualificacao) {
            case "INRRELEVANTE":
                retorno = 0;
            break;
            
            case "POUCO RELEVANTE":
                retorno = 1;
            break;
            
            case "RELEVANTE":
                retorno = 2;
            break;
            
            case "MUITO RELEVANTE":
                retorno = 3;
            break;
            
            case "EXTREMAMENTE RELEVANTE":
                retorno = 4;
            break;
            
            case "SEM CONTEUDO": 
                retorno = 0;
            break;
        }
        
        return retorno;
    }
    
    public int VerificarPontuacaoResposta(String corecao){

        int retorno = 0;
        switch (corecao) {
            case "Sem Resposta":
                retorno -= 5;
                break;
            case "Resposta Errada":
                retorno += 0;
                break;
            case "Resposta Incompleta":
                retorno += 5;
                break;
            case "Resposta Correta":
                retorno += 10;
                break;
            default:
                retorno += 0;
                break;
        }
        return retorno;
    }
    
    public int VerificarCorrecaoResposta(String corecao){

        int retorno = 0;
        switch (corecao) {
            case "Sem Resposta":
                retorno = 0;
                break;
            case "Resposta Errada":
                retorno = 1;
                break;
            case "Resposta Incompleta":
                retorno = 2;
                break;
            case "Resposta Correta":
                retorno = 3;
                break;
            default:
                retorno = 0;
                break;
        }
        return retorno;
    }
    
    public void ContarPontuacaoRespostas(Equipe e){
        
        int PotuacaoRespostas = 0;
        Resposta r;
        
        //RESPOSTA 01
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe01(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 02
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe02(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 03
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe03(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 04
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe04(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 05
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe05(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 06
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe06(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 07
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe07(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 08
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe08(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 09
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe09(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        //RESPOSTA 10
        r = new Resposta();
        rwdao.BuscarResposta(e.getIdResposta_Equipe10(), r);
        PotuacaoRespostas += VerificarPontuacaoResposta(r.getNota_Resposta());
        
        e.setPontuacao_Respostas(PotuacaoRespostas);
        ewdao.AtualizarPontuacaoEquipe(e);
        
    }
    
    public void ContarPontuacaoRespostasDesafio(Equipe e){
        
        int PotuacaoRespostasDesafio = 0;
        Resposta_Questao_Desafio rqd;
        
        //RESPOTA DESAFIO 01
        rqd = new Resposta_Questao_Desafio();
        rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio01(), rqd);
        PotuacaoRespostasDesafio += VerificarPontuacaoResposta(rqd.getNota_Questao_Desafio());
        
        //RESPOTA DESAFIO 02
        rqd = new Resposta_Questao_Desafio();
        rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio02(), rqd);
        PotuacaoRespostasDesafio +=VerificarPontuacaoResposta(rqd.getNota_Questao_Desafio());
        
        //RESPOTA DESAFIO 03
        rqd = new Resposta_Questao_Desafio();
        rqdwdao.BuscarRespostaDesafio(e.getIdResposta_Desafio03(), rqd);
        PotuacaoRespostasDesafio += VerificarPontuacaoResposta(rqd.getNota_Questao_Desafio());
        
        e.setPontuacao_Desafios(PotuacaoRespostasDesafio);
        ewdao.AtualizarPontuacaoEquipe(e);
    }
    
    
    
}
