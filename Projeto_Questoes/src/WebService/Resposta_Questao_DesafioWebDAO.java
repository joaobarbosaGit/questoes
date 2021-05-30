package WebService;

import Classes.Resposta;
import Classes.Resposta_Questao_Desafio;
import Servicos.JSONObject;
import Servicos.Utilitarios;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

public class Resposta_Questao_DesafioWebDAO {

    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    public void AdicionaRespostaQuestaoDesafio(Resposta_Questao_Desafio rqd) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "/resposta_questao_desafio/adicionarRespostaQuestaoDesafio.php?"
                    + "Corpo_Resposta=" + u.correrstring(URLEncoder.encode(rqd.getCorpo_Resposta(), "UTF-8"))
                    + "&Nota_Questao_Desafio=" + u.correrstring(URLEncoder.encode(String.valueOf(rqd.getNota_Questao_Desafio()), "UTF-8"))
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
                if (jObject.getBoolean("Resultado")) {
                    //JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                } else {
                    //JOptionPane.showMessageDialog(null, "Erro!");
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

    public int BuscarUltimoId() {
        HttpURLConnection connection = null;
        int retorno = 0;
        try {
            URL url = new URL(link + "/resposta_questao_desafio/buscarUltimoId.php?");
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
    
    public int BuscarRespostaDesafio(int idResposta_Questao_Desafio, Resposta_Questao_Desafio rqd) {
        
        HttpURLConnection connection = null;
        int retorno = 0;
        try {
            URL url = new URL(link + "resposta_questao_desafio/buscarRespostaQuestaoDesafio.php?"
            + "idResposta_Questao_Desafio=" + u.correrstring(URLEncoder.encode(String.valueOf(idResposta_Questao_Desafio), "UTF-8"))
            );
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject jObject = new JSONObject(u.readResponse(connection));
                rqd.setIdResposta_Questao_Desafio(jObject.getInt("idResposta_Questao_Desafio"));
                rqd.setCorpo_Resposta(URLDecoder.decode(jObject.getString("Corpo_Resposta"),"UTF-8"));
                rqd.setNota_Questao_Desafio(URLDecoder.decode(jObject.getString("Nota_Questao_Desafio"),"UTF-8"));

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
    
    public void AtualizarResposta(Resposta_Questao_Desafio rqd) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "resposta_questao_desafio/atualizarRespostaQuestaoDesafio.php?"
                    + "idResposta_Questao_Desafio=" + rqd.getIdResposta_Questao_Desafio()
                    + "&Corpo_Resposta=" + u.correrstring(URLEncoder.encode(rqd.getCorpo_Resposta(), "UTF-8"))
                    + "&Nota_Questao_Desafio=" + u.correrstring(URLEncoder.encode(String.valueOf(rqd.getNota_Questao_Desafio()), "UTF-8")));
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
                if (jObject.getBoolean("Resultado")) {
                    //JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                } else {
                    //JOptionPane.showMessageDialog(null, "Erro!");
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

}
