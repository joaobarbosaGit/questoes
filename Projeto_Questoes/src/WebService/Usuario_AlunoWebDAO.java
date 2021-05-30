package WebService;

import Servicos.JSONObject;
import Classes.Usuario_Aluno;
import Servicos.Utilitarios;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

public class Usuario_AlunoWebDAO {

    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    public boolean VerificaUsuario(String email) {
        
        HttpURLConnection connection = null;
        boolean retorno = false;
        int result;
        try {
            URL url = new URL(link + "/usuario_aluno/verificarusuarioaluno.php?email=" + u.correrstring(email));
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject json = new JSONObject(u.readResponse(connection));
                result = json.getInt("Retorno");
                if (result == 1) {
                    retorno = true;
                }
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            connection.disconnect();
        }
        return retorno;
    }

    public void LoginUsuarioAluno(Usuario_Aluno ua, String email) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "/usuario_aluno/loginusuarioaluno.php?email=" + email);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("POST");
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject json = new JSONObject(u.readResponse(connection));
                ua.setIdUsuario_Aluno(json.getInt("idUsuario_Aluno"));
                ua.setUsuario(json.getString("Usuario"));
                ua.setSenha(json.getString("Senha"));
                ua.setEmail(json.getString("Email"));
                ua.setEquipe_idEquipe(json.getInt("Equipe_idEquipe"));
                ua.setRodada_idRodada(json.getInt("Rodada_idRodada"));
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        } finally {
            connection.disconnect();
        }

    }

    public void AdicionarUsuarioAluno(Usuario_Aluno ua) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "/usuario_aluno/adicionarusuarioaluno.php?"
                    + "Usuario=" + u.correrstring(URLEncoder.encode(ua.getUsuario(), "UTF-8"))
                    + "&Senha=" + u.correrstring(URLEncoder.encode(ua.getSenha(), "UTF-8"))
                    + "&Email=" + u.correrstring(URLEncoder.encode(ua.getEmail(), "UTF-8"))
                    + "&Equipe_idEquipe=" + u.correrstring(URLEncoder.encode(String.valueOf(ua.getEquipe_idEquipe()), "UTF-8"))
                    + "&Rodada_idRodada=" + u.correrstring(URLEncoder.encode(String.valueOf(ua.getRodada_idRodada()), "UTF-8"))
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

}
