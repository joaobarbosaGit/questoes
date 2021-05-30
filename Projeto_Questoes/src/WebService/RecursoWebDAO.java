package WebService;

import Classes.Recurso;
import Servicos.JSONObject;
import Servicos.Utilitarios;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

public class RecursoWebDAO {

    private String link = Utilitarios.Link;
    Utilitarios u = new Utilitarios();

    public void AdicionaRecurso(Recurso r) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(link + "recurso/adicionarRecurso.php?"
                    + "Objeto=" + u.correrstring(URLEncoder.encode(r.getObjeto(), "UTF-8"))
                    + "Causa=" + u.correrstring(URLEncoder.encode(r.getCausa(), "UTF-8"))
                    + "Deferimento=" + u.correrstring(URLEncoder.encode(r.getDeferimento(), "UTF-8"))
                    + "Situacao=" + r.getSituacao()
                    + "Rodada_idRodada=" + r.getRodada_idRodada()
                    + "Equipe_idEquipe=" + r.getEquipe_idEquipe()

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
