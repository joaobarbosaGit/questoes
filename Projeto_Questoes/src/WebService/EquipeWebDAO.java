package WebService;

import Classes.Equipe;
import Servicos.JSONArray;
import Servicos.JSONObject;
import Servicos.Utilitarios;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EquipeWebDAO {

    private final String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    public void AdicionaEquipe(Equipe e) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "equipe/adicionarEquipe.php?"
                    + "Nome_Equipe=" + u.correrstring(URLEncoder.encode(e.getNomeEquipe(), "UTF-8"))
                    + "&Equipe_Para_Resposta=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getEquipe_Para_Resposta()), "UTF-8"))
                    + "&Equipe_Que_Resposta=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getEquipe_Que_Resposta()), "UTF-8"))
                    + "&Pontuacao_Questoes=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getPontuacao_Questoes()), "UTF-8"))
                    + "&Pontuacao_Respostas=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getPontuacao_Respostas()), "UTF-8"))
                    + "&Pontuacao_Desafios=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getPontuacao_Desafios()), "UTF-8"))
                    + "&isQuestionario=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIsQuestionario()), "UTF-8"))
                    + "&isResposta=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIsResposta()), "UTF-8"))
                    + "&isDesafio=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIsDesafio()), "UTF-8"))
                    + "&idQuestao_Equipe01=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe01()), "UTF-8"))
                    + "&idQuestao_Equipe02=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe02()), "UTF-8"))
                    + "&idQuestao_Equipe03=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe03()), "UTF-8"))
                    + "&idQuestao_Equipe04=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe04()), "UTF-8"))
                    + "&idQuestao_Equipe05=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe05()), "UTF-8"))
                    + "&idQuestao_Equipe06=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe06()), "UTF-8"))
                    + "&idQuestao_Equipe07=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe07()), "UTF-8"))
                    + "&idQuestao_Equipe08=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe08()), "UTF-8"))
                    + "&idQuestao_Equipe09=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe09()), "UTF-8"))
                    + "&idQuestao_Equipe10=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Equipe10()), "UTF-8"))
                    + "&idResposta_Equipe01=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe01()), "UTF-8"))
                    + "&idResposta_Equipe02=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe02()), "UTF-8"))
                    + "&idResposta_Equipe03=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe03()), "UTF-8"))
                    + "&idResposta_Equipe04=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe04()), "UTF-8"))
                    + "&idResposta_Equipe05=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe05()), "UTF-8"))
                    + "&idResposta_Equipe06=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe06()), "UTF-8"))
                    + "&idResposta_Equipe07=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe07()), "UTF-8"))
                    + "&idResposta_Equipe08=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe08()), "UTF-8"))
                    + "&idResposta_Equipe09=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe09()), "UTF-8"))
                    + "&idResposta_Equipe10=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Equipe10()), "UTF-8"))
                    + "&idQuestao_Desafio01=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Desafio01()), "UTF-8"))
                    + "&idQuestao_Desafio02=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Desafio02()), "UTF-8"))
                    + "&idQuestao_Desafio03=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdQuestao_Desafio03()), "UTF-8"))
                    + "&idResposta_Desafio01=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Desafio01()), "UTF-8"))
                    + "&idResposta_Desafio02=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Desafio02()), "UTF-8"))
                    + "&idResposta_Desafio03=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIdResposta_Desafio03()), "UTF-8"))
            );
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject jObject = new JSONObject(u.readResponse(connection));
                //System.out.println(u.readResponse(connection));
                if (jObject.getBoolean("Resultado")) {
                    //JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
                } else {
                    //JOptionPane.showMessageDialog(null,"Erro!");
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } finally {
            connection.disconnect();
        }

    }
    
    public void AtualizarPontuacaoEquipe(Equipe e) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "equipe/atualizarPontuacaoEquipe.php?"
                    + "idEquipe=" + e.getIdEquipe()
                    + "&Pontuacao_Questoes=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getPontuacao_Questoes()), "UTF-8"))
                    + "&Pontuacao_Respostas=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getPontuacao_Respostas()), "UTF-8"))
                    + "&Pontuacao_Desafios=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getPontuacao_Desafios()), "UTF-8"))
            );
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject jObject = new JSONObject(u.readResponse(connection));
                //System.out.println(u.readResponse(connection));
                if (jObject.getBoolean("Resultado")) {
                    //JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
                } else {
                    //JOptionPane.showMessageDialog(null,"Erro!");
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } finally {
            connection.disconnect();
        }

    }
    
    public void AtualizarStatusEquipe(Equipe e) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "equipe/atualizarStatusEquipe.php?"
                    + "idEquipe=" + e.getIdEquipe()
                    + "&isQuestionario=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIsQuestionario()), "UTF-8"))
                    + "&isResposta=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIsResposta()), "UTF-8"))
                    + "&isDesafio=" + u.correrstring(URLEncoder.encode(String.valueOf(e.getIsDesafio()), "UTF-8"))
            );
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject jObject = new JSONObject(u.readResponse(connection));
                //System.out.println(u.readResponse(connection));
                if (jObject.getBoolean("Resultado")) {
                    //JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
                } else {
                    //JOptionPane.showMessageDialog(null,"Erro!");
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } finally {
            connection.disconnect();
        }

    }
    
    public void AtualizarNomeEquipe(Equipe e) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "equipe/atualizarNomeEquipe.php?"
                    + "idEquipe=" + e.getIdEquipe()
                    + "&Nome_Equipe=" + u.correrstring(URLEncoder.encode(e.getNomeEquipe(), "UTF-8"))
            );
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
//                JSONObject jObject = new JSONObject(u.readResponse(connection));
                //System.out.println(u.readResponse(connection));
//                if (jObject.getBoolean("Resultado")) {
//                    JOptionPane.showMessageDialog(null,"Atualizado com Sucesso!");
//                } else {
//                    JOptionPane.showMessageDialog(null,"Erro!");
//                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } finally {
            connection.disconnect();
        }

    }

    public int BuscarUltimoId() {

        HttpURLConnection connection = null;
        int retorno = 0;
        try {
            URL url = new URL(link + "equipe/buscarUltimoId.php?");
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject jObject = new JSONObject(u.readResponse(connection));
                if (jObject.getBoolean("Resultado")) {
                    retorno = jObject.getInt("ID");
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
            System.out.println(ex);
        } finally {
            connection.disconnect();
        }
        return retorno;
    }

    public void BuscarEquipe(Equipe e, int idEquipe) {

        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "equipe/buscarEquipe.php?"
                    + "idEquipe=" + u.correrstring(URLEncoder.encode(String.valueOf(idEquipe), "UTF-8")));
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject json = new JSONObject(u.readResponse(connection));
                e.setIdEquipe(json.getInt("idEquipe"));
                e.setNomeEquipe(json.getString("Nome_Equipe"));
                e.setEquipe_Para_Resposta(json.getInt("Equipe_Para_Resposta"));
                e.setEquipe_Que_Resposta(json.getInt("Equipe_Que_Resposta"));
                e.setPontuacao_Questoes(json.getInt("Pontuacao_Questoes"));
                e.setPontuacao_Respostas(json.getInt("Pontuacao_Respostas"));
                e.setPontuacao_Desafios(json.getInt("Pontuacao_Desafios"));
                e.setIsQuestionario(json.getInt("isQuestionario"));
                e.setIsResposta(json.getInt("isResposta"));
                e.setIsDesafio(json.getInt("isDesafio"));
                e.setIdQuestao_Equipe01(json.getInt("idQuestao_Equipe01"));
                e.setIdQuestao_Equipe02(json.getInt("idQuestao_Equipe02"));
                e.setIdQuestao_Equipe03(json.getInt("idQuestao_Equipe03"));
                e.setIdQuestao_Equipe04(json.getInt("idQuestao_Equipe04"));
                e.setIdQuestao_Equipe05(json.getInt("idQuestao_Equipe05"));
                e.setIdQuestao_Equipe06(json.getInt("idQuestao_Equipe06"));
                e.setIdQuestao_Equipe07(json.getInt("idQuestao_Equipe07"));
                e.setIdQuestao_Equipe08(json.getInt("idQuestao_Equipe08"));
                e.setIdQuestao_Equipe09(json.getInt("idQuestao_Equipe09"));
                e.setIdQuestao_Equipe10(json.getInt("idQuestao_Equipe10"));
                e.setIdResposta_Equipe01(json.getInt("idResposta_Equipe01"));
                e.setIdResposta_Equipe02(json.getInt("idResposta_Equipe02"));
                e.setIdResposta_Equipe03(json.getInt("idResposta_Equipe03"));
                e.setIdResposta_Equipe04(json.getInt("idResposta_Equipe04"));
                e.setIdResposta_Equipe05(json.getInt("idResposta_Equipe05"));
                e.setIdResposta_Equipe06(json.getInt("idResposta_Equipe06"));
                e.setIdResposta_Equipe07(json.getInt("idResposta_Equipe07"));
                e.setIdResposta_Equipe08(json.getInt("idResposta_Equipe08"));
                e.setIdResposta_Equipe09(json.getInt("idResposta_Equipe09"));
                e.setIdResposta_Equipe10(json.getInt("idResposta_Equipe10"));
                e.setIdQuestao_Desafio01(json.getInt("idQuestao_Desafio01"));
                e.setIdQuestao_Desafio02(json.getInt("idQuestao_Desafio02"));
                e.setIdQuestao_Desafio03(json.getInt("idQuestao_Desafio03"));
                e.setIdResposta_Desafio01(json.getInt("idResposta_Desafio01"));
                e.setIdResposta_Desafio02(json.getInt("idResposta_Desafio02"));
                e.setIdResposta_Desafio03(json.getInt("idResposta_Desafio03"));
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            connection.disconnect();
        }

    }


}
