package WebService;

import Classes.Recurso;
import Servicos.JSONArray;
import Servicos.JSONObject;
import Servicos.Utilitarios;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RecursoWebDAO {

    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    public void AdicionaRecurso(Recurso r) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "recurso/adicionarRecurso.php?"
                    + "Objeto=" + u.correrstring(URLEncoder.encode(r.getObjeto(), "UTF-8"))
                    + "&Causa=" + u.correrstring(URLEncoder.encode(r.getCausa(), "UTF-8"))
                    + "&Deferimento=" + u.correrstring(URLEncoder.encode(r.getDeferimento(), "UTF-8"))
                    + "&Situacao=" + r.getSituacao()
                    + "&Rodada_idRodada=" + r.getRodada_idRodada()
                    + "&Equipe_idEquipe=" + r.getEquipe_idEquipe()

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
                    JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
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
    
    public void AtualizarRecurso(Recurso r) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "recurso/atualizarRecurso.php?"
                    + "idRecurso=" + r.getIdRecurso()
                    + "&Objeto=" + u.correrstring(URLEncoder.encode(r.getObjeto(), "UTF-8"))
                    + "&Causa=" + u.correrstring(URLEncoder.encode(r.getCausa(), "UTF-8"))
                    + "&Deferimento=" + u.correrstring(URLEncoder.encode(r.getDeferimento(), "UTF-8"))
                    + "&Situacao=" + r.getSituacao()
                    + "&Rodada_idRodada=" + r.getRodada_idRodada()
                    + "&Equipe_idEquipe=" + r.getEquipe_idEquipe()
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
                    JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
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
    
    public int BuscarQuestao(int idRecurso, Recurso r) {
        HttpURLConnection connection = null;
        int retorno = 0;
        try {
            URL url = new URL(link + "recurso/buscarRecurso.php?"
            + "idRecurso=" + u.correrstring(URLEncoder.encode(String.valueOf(idRecurso), "UTF-8"))
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
                r.setIdRecurso(jObject.getInt("idRecurso"));
                r.setObjeto(URLDecoder.decode(jObject.getString("Objeto"),"UTF-8"));
                r.setCausa(jObject.getString("Causa"));
                r.setDeferimento(jObject.getString("Deferimento"));
                r.setSituacao(jObject.getInt("Situacao"));
                r.setRodada_idRodada(jObject.getInt("Rodada_idRodada"));
                r.setEquipe_idEquipe(jObject.getInt("Equipe_idEquipe"));

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
    
    public ArrayList<Recurso> ListaRecursoIdRodada(int Rodada_idRodada) throws IOException {
        ArrayList<Recurso> listaRecursos = new ArrayList<>();
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "recurso/listarRecursoIdRodada.php?Rodada_idRodada=" + Rodada_idRodada);
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
                    Recurso r = new Recurso();
                    jsonobject = (JSONObject) json.get(i);
                    r.setIdRecurso(jsonobject.getInt("idRecurso"));
                    r.setObjeto(jsonobject.getString("Objeto"));
                    r.setCausa(jsonobject.getString("Causa"));
                    r.setDeferimento(jsonobject.getString("Deferimento"));
                    r.setSituacao(jsonobject.getInt("Situacao"));
                    r.setRodada_idRodada(jsonobject.getInt("Rodada_idRodada"));
                    r.setEquipe_idEquipe(jsonobject.getInt("Equipe_idEquipe"));
                    listaRecursos.add(r);
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return listaRecursos;
    }
    
    public ArrayList<Recurso> ListaRecursoIdEquipe(int Equipe_idEquipe) throws IOException {
        ArrayList<Recurso> listaRecursos = new ArrayList<>();
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "recurso/listarRecursoIdEquipe.php?Equipe_idEquipe=" + Equipe_idEquipe);
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
                    Recurso r = new Recurso();
                    jsonobject = (JSONObject) json.get(i);
                    r.setIdRecurso(jsonobject.getInt("idRecurso"));
                    r.setObjeto(jsonobject.getString("Objeto"));
                    r.setCausa(jsonobject.getString("Causa"));
                    r.setDeferimento(jsonobject.getString("Deferimento"));
                    r.setSituacao(jsonobject.getInt("Situacao"));
                    r.setRodada_idRodada(jsonobject.getInt("Rodada_idRodada"));
                    r.setEquipe_idEquipe(jsonobject.getInt("Equipe_idEquipe"));
                    listaRecursos.add(r);
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return listaRecursos;
    }

}
