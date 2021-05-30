package Servicos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";  
    private static final String URL = "jdbc:mysql://joaolucasribeirobarbosa.com.br/adabox28_bd_questoes";
    private static final String USUARIO = "adabox28_admin";
    private static final String SENHA = "net261015";
    
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
            
            } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro de conexão");
                throw new RuntimeException("Erro de Conexão: ",ex);
            }
} 
    public static void closeconexao(Connection con){
        
            try {
                if(con!=null){   
                con.close(); 
            }
            }
            catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }  
            }
    public static void closeconexao(Connection con,PreparedStatement stm){
        closeconexao(con);
            try {
                if(stm != null){
                    stm.close();
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }  
            }
    public static void closeconexao(Connection con,PreparedStatement stm, ResultSet rs){
             closeconexao(con, stm);
            try {
                if(rs!=null){   
                rs.close(); 
            }
            }
            catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }  
            }
    
}
