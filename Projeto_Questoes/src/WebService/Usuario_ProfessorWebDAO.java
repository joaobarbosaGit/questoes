package WebService;

import Servicos.JSONObject;
import Classes.Usuario_Professor;
import Servicos.Utilitarios;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

public class Usuario_ProfessorWebDAO {

    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    public boolean VerificaUsuario(String email) {
        HttpURLConnection connection = null;
        boolean retorno = false;
        int result;
        try {
            URL url = new URL(link + "/usuario_professor/verificarusuarioprofessor.php?email=" + u.correrstring(email));
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

    public void LoginUsuarioProfessor(Usuario_Professor up, String email) {
       
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "/usuario_professor/loginusuarioprofessor.php?email=" + email);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("POST");
            connection.connect();
            try (OutputStream outputStream = connection.getOutputStream()) {
                JSONObject json = new JSONObject(u.readResponse(connection));
                up.setIdUsuario_Professor(json.getInt("idUsuario_Professor"));
                up.setNome_Professor(json.getString("Nome_Professor"));
                up.setEmail(json.getString("Email"));
                up.setSenha(json.getString("Senha"));
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
