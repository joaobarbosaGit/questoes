
package WebService;

import Classes.Rodada;
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


public class RodadaWebDAO {
    
    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();
    
    public void AdicionaRodada(Rodada r){
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link+"rodada/adicionarRodada.php?"
                    +"Descricao="+u.correrstring(URLEncoder.encode(r.getDescricao(),"UTF-8"))
                    +"&Material="+u.correrstring(URLEncoder.encode(r.getMaterial(),"UTF-8"))
                    +"&Quantidade_Times="+u.correrstring(URLEncoder.encode(String.valueOf(r.getQuantidade_Times()),"UTF-8"))
                    +"&Data_Fase1="+u.correrstring(URLEncoder.encode(r.getData_Fase1(),"UTF-8"))
                    +"&Data_Fase2="+u.correrstring(URLEncoder.encode(r.getData_Fase2(),"UTF-8"))
                    +"&Data_Fase3="+u.correrstring(URLEncoder.encode(r.getData_Fase3(),"UTF-8"))
                    +"&Data_Fase4="+u.correrstring(URLEncoder.encode(r.getData_Fase4(),"UTF-8"))
                    +"&Data_Fase5="+u.correrstring(URLEncoder.encode(r.getData_Fase5(),"UTF-8"))
                    +"&Data_Fase6="+u.correrstring(URLEncoder.encode(r.getData_Fase6(),"UTF-8"))
                    +"&Usuario_Professor_idUsuario_Professor="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdUsuario_Professor()),"UTF-8"))
                    +"&idQuestao_Desafio01="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio01()),"UTF-8"))
                    +"&idQuestao_Desafio02="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio02()),"UTF-8"))
                    +"&idQuestao_Desafio03="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio03()),"UTF-8"))
                    +"&idQuestao_Desafio04="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio04()),"UTF-8"))
                    +"&idQuestao_Desafio05="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio05()),"UTF-8"))
                    +"&idQuestao_Desafio06="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio06()),"UTF-8"))
                    +"&idQuestao_Desafio07="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio07()),"UTF-8"))
                    +"&idQuestao_Desafio08="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio08()),"UTF-8"))
                    +"&idQuestao_Desafio09="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio09()),"UTF-8"))
                    +"&idQuestao_Desafio10="+u.correrstring(URLEncoder.encode(String.valueOf(r.getIdQuestao_Desafio10()),"UTF-8")));
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
    
    public void AtualizarRodada(Rodada r){
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link+"rodada/atualizarRodada.php?"
                    +"idRodada="+r.getIdRodada()
                    +"&Descricao="+u.correrstring(URLEncoder.encode(r.getDescricao(),"UTF-8"))
                    +"&Material="+u.correrstring(URLEncoder.encode(r.getMaterial(),"UTF-8"))
                    +"&Quantidade_Times="+u.correrstring(URLEncoder.encode(String.valueOf(r.getQuantidade_Times()),"UTF-8"))
                    +"&Data_Fase1="+u.correrstring(URLEncoder.encode(r.getData_Fase1(),"UTF-8"))
                    +"&Data_Fase2="+u.correrstring(URLEncoder.encode(r.getData_Fase2(),"UTF-8"))
                    +"&Data_Fase3="+u.correrstring(URLEncoder.encode(r.getData_Fase3(),"UTF-8"))
                    +"&Data_Fase4="+u.correrstring(URLEncoder.encode(r.getData_Fase4(),"UTF-8"))
                    +"&Data_Fase5="+u.correrstring(URLEncoder.encode(r.getData_Fase5(),"UTF-8"))
                    +"&Data_Fase6="+u.correrstring(URLEncoder.encode(r.getData_Fase6(),"UTF-8"))
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
            URL url = new URL(link+"rodada/buscarUltimoId.php?");
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
    
    public boolean verificarSeExisteRodada(int idUsuarioProfessor){
        HttpURLConnection connection = null;
        boolean retorno = false;
        try {
            URL url = new URL(link+"rodada/verificarSeExisteRodada.php?"
            +"&Usuario_Professor_idUsuario_Professor="+u.correrstring(String.valueOf(idUsuarioProfessor))
            );
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
                 retorno = true;
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
    
    public void BuscarRodada(Rodada r, int idRodada){
        
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "rodada/buscarRodada.php?"
                    + "idRodada=" + u.correrstring(URLEncoder.encode(String.valueOf(idRodada), "UTF-8")));
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject json = new JSONObject(u.readResponse(connection));
                r.setIdRodada(json.getInt("idRodada"));
                r.setDescricao(json.getString("Descricao"));
                r.setMaterial(json.getString("Material"));
                r.setQuantidade_Times(json.getInt("Quantidade_Times"));
                r.setData_Fase1(json.getString("Data_Fase1"));
                r.setData_Fase2(json.getString("Data_Fase2"));
                r.setData_Fase3(json.getString("Data_Fase3"));
                r.setData_Fase4(json.getString("Data_Fase4"));
                r.setData_Fase5(json.getString("Data_Fase5"));
                r.setData_Fase6(json.getString("Data_Fase6"));
                r.setIdQuestao_Desafio01(json.getInt("idQuestao_Desafio01"));
                r.setIdQuestao_Desafio02(json.getInt("idQuestao_Desafio02"));
                r.setIdQuestao_Desafio03(json.getInt("idQuestao_Desafio03"));
                r.setIdQuestao_Desafio04(json.getInt("idQuestao_Desafio04"));
                r.setIdQuestao_Desafio05(json.getInt("idQuestao_Desafio05"));
                r.setIdQuestao_Desafio06(json.getInt("idQuestao_Desafio06"));
                r.setIdQuestao_Desafio07(json.getInt("idQuestao_Desafio07"));
                r.setIdQuestao_Desafio08(json.getInt("idQuestao_Desafio08"));
                r.setIdQuestao_Desafio09(json.getInt("idQuestao_Desafio09"));
                r.setIdQuestao_Desafio10(json.getInt("idQuestao_Desafio10"));
                
                
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            connection.disconnect();
        }
        
    }
    
    public ArrayList<Rodada> ListaRodadaUsuario_Professor(int Usuario_Professor_idUsuario_Professor) throws IOException {
        ArrayList<Rodada> listaRodada = new ArrayList<>();
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "/rodada/listarRodadaUsuarioProfessor.php?Usuario_Professor_idUsuario_Professor=" + Usuario_Professor_idUsuario_Professor);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONArray json = new JSONArray(u.readResponse(connection));
                JSONObject jsonobject = new JSONObject();
                for (int i = 0; i < json.length(); i++) {
                    jsonobject = (JSONObject) json.get(i);
                    Rodada r = new Rodada();
                    r.setIdRodada(jsonobject.getInt("idRodada"));
                    r.setDescricao(jsonobject.getString("Descricao"));
                    r.setMaterial(jsonobject.getString("Material"));
                    r.setQuantidade_Times(jsonobject.getInt("Quantidade_Times"));
                    r.setData_Fase1(jsonobject.getString("Data_Fase1"));
                    r.setData_Fase2(jsonobject.getString("Data_Fase2"));
                    r.setData_Fase3(jsonobject.getString("Data_Fase3"));
                    r.setData_Fase4(jsonobject.getString("Data_Fase4"));
                    r.setData_Fase5(jsonobject.getString("Data_Fase5"));
                    r.setData_Fase6(jsonobject.getString("Data_Fase6"));
                    r.setIdUsuario_Professor(jsonobject.getInt("Usuario_Professor_idUsuario_Professor"));
                    r.setIdQuestao_Desafio01(jsonobject.getInt("idQuestao_Desafio01"));
                    r.setIdQuestao_Desafio02(jsonobject.getInt("idQuestao_Desafio02"));
                    r.setIdQuestao_Desafio03(jsonobject.getInt("idQuestao_Desafio03"));
                    r.setIdQuestao_Desafio04(jsonobject.getInt("idQuestao_Desafio04"));
                    r.setIdQuestao_Desafio05(jsonobject.getInt("idQuestao_Desafio05"));
                    r.setIdQuestao_Desafio06(jsonobject.getInt("idQuestao_Desafio06"));
                    r.setIdQuestao_Desafio07(jsonobject.getInt("idQuestao_Desafio07"));
                    r.setIdQuestao_Desafio08(jsonobject.getInt("idQuestao_Desafio08"));
                    r.setIdQuestao_Desafio09(jsonobject.getInt("idQuestao_Desafio09"));
                    r.setIdQuestao_Desafio10(jsonobject.getInt("idQuestao_Desafio10"));
                    listaRodada.add(r);
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return listaRodada;
    }
    
}
