
package Servicos;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;



public class FormatarDatas {
    
    public String FormatarData(JDateChooser jdata){
         SimpleDateFormat dataformatada = new SimpleDateFormat("yyyy-MM-dd");
         return dataformatada.format(jdata.getDate());
               } 
    public String FormatarDataBrasil(String data, JDateChooser jdata){
         SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
         return data = dataformatada.format(jdata.getDate());
               } 
    public String FormatarDataBrasil(String Data){
         String[] datas = Data.split("-");
         String dataformatada = datas[2]+"/"+datas[1]+"/"+datas[0];
         return dataformatada;
               } 
   
}
