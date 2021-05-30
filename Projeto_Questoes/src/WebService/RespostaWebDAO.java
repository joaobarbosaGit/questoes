
package WebService;

import Classes.Questao;
import Classes.Resposta;
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


public class RespostaWebDAO {
    
    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    public void AdicionaResposta(Resposta r) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "/resposta/adicionarResposta.php?"
                    + "Corpo_Resposta=" + u.correrstring(URLEncoder.encode(r.getCorpo_Resposta(), "UTF-8"))
                    + "&Nota_Resposta=" + u.correrstring(URLEncoder.encode(String.valueOf(r.getNota_Resposta()), "UTF-8"))
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
            URL url = new URL(link + "/resposta/buscarUltimoId.php?");
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
    
    public int BuscarResposta(int idResposta, Resposta r) {
        
        HttpURLConnection connection = null;
        int retorno = 0;
        try {
            URL url = new URL(link + "resposta/buscarResposta.php?"
            + "idResposta=" + u.correrstring(URLEncoder.encode(String.valueOf(idResposta), "UTF-8"))
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
                r.setIdResposta(jObject.getInt("idResposta"));
                r.setCorpo_Resposta(URLDecoder.decode(jObject.getString("Corpo_Resposta"),"UTF-8"));
                r.setNota_Resposta(jObject.getString("Nota_Resposta"));

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
    
    public void AtualizarResposta(Resposta r) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "resposta/atualizarResposta.php?"
                    + "idResposta=" + r.getIdResposta()
                    + "&Corpo_Resposta=" + u.correrstring(URLEncoder.encode(r.getCorpo_Resposta(), "UTF-8"))
                    + "&Nota_Resposta=" + u.correrstring(URLEncoder.encode(String.valueOf(r.getNota_Resposta()), "UTF-8")));
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
