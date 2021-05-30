
package WebService;

import Classes.Questao_Desafio;
import Servicos.JSONObject;
import Servicos.Utilitarios;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;


public class Questao_DesafioWebDAO {
    
    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    
    public void AdicionaQuestaoDesafio(Questao_Desafio qd){
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link+"/questao_desafio/adicionarQuestaoDesafio.php?"
                    +"&Corpo_Questao="
                    +u.correrstring(URLEncoder.encode(qd.getCorpo_Questao(),"UTF-8"))+"&Gabarito="
                    +u.correrstring(URLEncoder.encode(qd.getGabarito(),"UTF-8")));
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoInput(true);  
            connection.setDoOutput(true);
            connection.connect();
             try (OutputStream outputStream = connection.getOutputStream()) {
                 JSONObject jObject  = new JSONObject(u.readResponse(connection));
                 //System.out.println(u.readResponse(connection));
                 if(jObject.getBoolean("Resultado")){
                 //JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
                 }else{
                 //JOptionPane.showMessageDialog(null,"Erro!");
                 }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
            System.out.println(ex);
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"Erro: "+ex);
            System.out.println(ex);
        }finally{
            connection.disconnect();
        }
   
    }
    
    public int BuscarUltimoId(){
        HttpURLConnection connection = null;
        int retorno = 0;
        try {
            URL url = new URL(link+"/questao_desafio/buscarUltimoId.php?");
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);  
            connection.setDoOutput(true);
            connection.connect();
             try (OutputStream outputStream = connection.getOutputStream()) {
                 JSONObject jObject  = new JSONObject(u.readResponse(connection));
                 if(jObject.getBoolean("Resultado")){
                 retorno = jObject.getInt("ID");
                 }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
            System.out.println(ex);
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null,"Erro: "+ex);
            System.out.println(ex);
        }finally{
            connection.disconnect();
        }
        return retorno;
    }
    
    public int BuscarQuestaoDesafio(int idQuestao_Desafio, Questao_Desafio qd) {
        HttpURLConnection connection = null;
        int retorno = 0;
        try {
            URL url = new URL(link + "questao_desafio/buscarQuestaoDesafio.php?"
            + "idQuestao_Desafio=" + u.correrstring(URLEncoder.encode(String.valueOf(idQuestao_Desafio), "UTF-8"))
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
                qd.setIdQuestao_Desafio(jObject.getInt("idQuestao_Desafio"));
                qd.setCorpo_Questao(jObject.getString("Corpo_Questao"));
                qd.setGabarito(jObject.getString("Gabarito"));
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
    
}
