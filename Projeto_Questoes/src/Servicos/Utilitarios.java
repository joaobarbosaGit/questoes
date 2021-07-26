package Servicos;

import java.awt.Component;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.text.Normalizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import javax.swing.JPanel;

public class Utilitarios {
    
    final long TEMPO = (1000 * 60);
    public static String Link = "https://joaolucasribeirobarbosa.com.br/questoes/";

    public boolean VerificaConexão() {
        boolean retorno = false;
        try {
            java.net.URL mandarMail = new java.net.URL("https://www.joaolucasribeirobarbosa.com.br/");
            java.net.URLConnection conn = mandarMail.openConnection();
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) conn;
            httpConn.connect();
            int x = httpConn.getResponseCode();
            if (x == 200) {
                retorno = true;
            }
        } catch (java.net.MalformedURLException urlmal) {
        } catch (java.io.IOException ioexcp) {
        }
        return retorno;
    }

    public void RepeteMetodoConexão() {

        Timer timer = null;
        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask() {
                public void run() {
                    try {
                        VerificaConexão();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.scheduleAtFixedRate(tarefa, 0, TEMPO);
        }
    }

    public String TiraAcento(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public String readResponse(HttpURLConnection request) throws IOException {
        ByteArrayOutputStream os;
        try (InputStream is = request.getInputStream()) {
            os = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
        }
        return new String(os.toByteArray());
    }

    public String correrstring(String s) {
        String a = s;
        a = a.replaceAll(" ", "+");
        return a;
    }
    
    public int VerificaBoleano (boolean boleano){
    int retorno =0;
    if(boleano==true){
        retorno = 1;
    }
    return retorno;
}
    
    public boolean VerificaBoleano (int numero){
    boolean retorno =false;
    if(numero==1){
        retorno = true;
    }
    return retorno;
}
    
    public void bloqueiapainel(JPanel painel){
           for (Component cp : painel.getComponents()) { 
               cp.setEnabled(false);
           }       
    }
    
    public void liberapainel(JPanel painel){
          for (Component cp : painel.getComponents()) { 
               cp.setEnabled(true);
           }
    }
    
    public String VerificarSituacaoRecurso(int situacao){
        String retorno;
        
        switch (situacao) {
            case 0:
                retorno  =  "Em Análise";
                break;
                
            case 1:
                retorno  =  "Deferido";
                break;
                
            case 2:
                retorno  =  "Indeferido";
                break;
                
            default:
                retorno  =  "Em Análise";
                break;
                
        }
        
        return retorno;
    }
    
    public int VerificarDeferimento(String deferimento){
        int retorno;
        
        switch (deferimento){
            case "Em Análise":
                retorno = 0;
                break;
                
            case "Deferido":
                retorno = 1;
                break;
                
            case "Indeferido":
                retorno = 2;
                break;

            default:
                retorno = 0;
                break;
        }
        return retorno;
    }

}
