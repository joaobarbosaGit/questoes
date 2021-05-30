package WebService;

import Classes.Questao;
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

public class QuestaoWebDAO {

    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    public void AdicionaQuestao(Questao q) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "questao/adicionarQuestao.php?"
                    + "Corpo_Questao=" + u.correrstring(URLEncoder.encode(q.getCorpo_Questao(), "UTF-8"))
                    + "&Gabarito=" + u.correrstring(URLEncoder.encode(String.valueOf(q.getGabarito()), "UTF-8"))
                    + "&Qualificacao_Questao=" + u.correrstring(URLEncoder.encode(String.valueOf(q.getQualificacao_Questao()), "UTF-8"))
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
            URL url = new URL(link + "questao/buscarUltimoId.php?");
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
    
    public int BuscarQuestao(int idQuestao, Questao q) {
        HttpURLConnection connection = null;
        int retorno = 0;
        try {
            URL url = new URL(link + "questao/buscarQuestao.php?"
            + "idQuestao=" + u.correrstring(URLEncoder.encode(String.valueOf(idQuestao), "UTF-8"))
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
                q.setIdQuestao(jObject.getInt("idQuestao"));
                q.setCorpo_Questao(URLDecoder.decode(jObject.getString("Corpo_Questao"),"UTF-8"));
                q.setGabarito(jObject.getString("Gabarito"));
                q.setQualificacao_Questao(jObject.getString("Qualificacao_Questao"));

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
    
    public void AtualizarQuestao(Questao q) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "questao/atualizarQuestao.php?"
                    + "idQuestao=" + q.getIdQuestao()
                    + "&Corpo_Questao=" + u.correrstring(URLEncoder.encode(q.getCorpo_Questao(), "UTF-8"))
                    + "&Gabarito=" + u.correrstring(URLEncoder.encode(String.valueOf(q.getGabarito()), "UTF-8"))
                    + "&Qualificacao_Questao=" + (URLEncoder.encode(u.correrstring(String.valueOf(q.getQualificacao_Questao())), "UTF-8")));
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
