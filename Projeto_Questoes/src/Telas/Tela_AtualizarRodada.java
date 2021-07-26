
package Telas;

import Classes.Questao_Desafio;
import Classes.Rodada;
import Classes.Usuario_Token;
import Servicos.FormatarDatas;
import Servicos.Utilitarios;
import WebService.Questao_DesafioWebDAO;
import WebService.RodadaWebDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Tela_AtualizarRodada extends javax.swing.JDialog {

    RodadaWebDAO rwdao = new RodadaWebDAO();
    Usuario_Token ut = Usuario_Token.getInstance();
    FormatarDatas fd = new FormatarDatas();
    Questao_DesafioWebDAO qdwdao = new Questao_DesafioWebDAO();
    Utilitarios u = new Utilitarios();
    ArrayList<Questao_Desafio> listaQuestoes = new ArrayList<>();
    Rodada rodada = new Rodada();
    String Data1 = "";
    String Data2 = "";
    String Data3 = "";
    String Data4 = "";
    String Data5 = "";
    String Data6 = "";
    boolean eventoClickTabela = true;
    
    public void ListarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) ta_rodada.getModel();
        modelo.setNumRows(0);
        ta_rodada.getTableHeader().setReorderingAllowed(false); 

        try {

            for (Rodada r : rwdao.ListaRodadaUsuario_Professor(ut.getId())) {
               

                modelo.addRow(new Object[]{
                    r.getIdRodada(),
                    r.getDescricao(),
                    r.getMaterial(),
                    r.getQuantidade_Times(),
                    fd.FormatarDataBrasil(r.getData_Fase1()),
                    fd.FormatarDataBrasil(r.getData_Fase2()),
                    fd.FormatarDataBrasil(r.getData_Fase3()),
                    fd.FormatarDataBrasil(r.getData_Fase4()),
                    fd.FormatarDataBrasil(r.getData_Fase5()),
                    fd.FormatarDataBrasil(r.getData_Fase6())
                });

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        eventoClickTabela = true;
    }
    
    public void LimparCampos(){
        
        tf_descricao.setText("");
        tf_material.setText("");
        tf_quantidadetimes.setText("");
        dc_fase01.setDate(null);
        dc_fase02.setDate(null);
        dc_fase03.setDate(null);
        dc_fase04.setDate(null);
        dc_fase05.setDate(null);
        dc_fase06.setDate(null);
        
    }
    
    public void BloquearPaineis() {
        
        u.bloqueiapainel(painel_qst1);
        u.bloqueiapainel(painel_qst2);
        u.bloqueiapainel(painel_qst3);
        u.bloqueiapainel(painel_qst4);
        u.bloqueiapainel(painel_qst5);
        u.bloqueiapainel(painel_qst6);
        u.bloqueiapainel(painel_qst7);
        u.bloqueiapainel(painel_qst8);
        u.bloqueiapainel(painel_qst9);
        u.bloqueiapainel(painel_qst10);
        u.bloqueiapainel(jp_dados);
        ta_questoes.setEnabled(false);
        
        ta_questaodesafio1.setEditable(false);
        ta_questaodesafio2.setEditable(false);
        ta_questaodesafio3.setEditable(false);
        ta_questaodesafio4.setEditable(false);
        ta_questaodesafio5.setEditable(false);
        ta_questaodesafio6.setEditable(false);
        ta_questaodesafio7.setEditable(false);
        ta_questaodesafio8.setEditable(false);
        ta_questaodesafio9.setEditable(false);
        ta_questaodesafio10.setEditable(false);
        ta_gabarito1.setEditable(false);
        ta_gabarito2.setEditable(false);
        ta_gabarito3.setEditable(false);
        ta_gabarito4.setEditable(false);
        ta_gabarito5.setEditable(false);
        ta_gabarito6.setEditable(false);
        ta_gabarito7.setEditable(false);
        ta_gabarito8.setEditable(false);
        ta_gabarito9.setEditable(false);
        ta_gabarito10.setEditable(false);
        
        ta_questaodesafio1.setText("");
        ta_gabarito1.setText("");
        ta_questaodesafio2.setText("");
        ta_gabarito2.setText("");
        ta_questaodesafio3.setText("");
        ta_gabarito3.setText("");
        ta_questaodesafio4.setText("");
        ta_gabarito4.setText("");
        ta_questaodesafio5.setText("");
        ta_gabarito5.setText("");
        ta_questaodesafio6.setText("");
        ta_gabarito6.setText("");
        ta_questaodesafio7.setText("");
        ta_gabarito7.setText("");
        ta_questaodesafio8.setText("");
        ta_gabarito8.setText("");
        ta_questaodesafio9.setText("");
        ta_gabarito9.setText("");
        ta_questaodesafio10.setText("");
        ta_gabarito10.setText("");
        
    }
        
    public void AvancarDados() {

        ta_rodada.setEnabled(false);
        u.liberapainel(jp_dados);
        eventoClickTabela = false;
    }
    
    public void AvancarQuestoes() {

        u.liberapainel(painel_qst1);
        u.liberapainel(painel_qst2);
        u.liberapainel(painel_qst3);
        u.liberapainel(painel_qst4);
        u.liberapainel(painel_qst5);
        u.liberapainel(painel_qst6);
        u.liberapainel(painel_qst7);
        u.liberapainel(painel_qst8);
        u.liberapainel(painel_qst9);
        u.liberapainel(painel_qst10);
        u.bloqueiapainel(jp_dados);
        
        ta_questaodesafio1.setEditable(true);
        ta_questaodesafio2.setEditable(true);
        ta_questaodesafio3.setEditable(true);
        ta_questaodesafio4.setEditable(true);
        ta_questaodesafio5.setEditable(true);
        ta_questaodesafio6.setEditable(true);
        ta_questaodesafio7.setEditable(true);
        ta_questaodesafio8.setEditable(true);
        ta_questaodesafio9.setEditable(true);
        ta_questaodesafio10.setEditable(true);
        ta_gabarito1.setEditable(true);
        ta_gabarito2.setEditable(true);
        ta_gabarito3.setEditable(true);
        ta_gabarito4.setEditable(true);
        ta_gabarito5.setEditable(true);
        ta_gabarito6.setEditable(true);
        ta_gabarito7.setEditable(true);
        ta_gabarito8.setEditable(true);
        ta_gabarito9.setEditable(true);
        ta_gabarito10.setEditable(true);
        
        
        Questao_Desafio qd;
                
        //QUESTAO 01
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio01(), qd);
        ta_questaodesafio1.setText(qd.getCorpo_Questao());
        ta_gabarito1.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 02
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio02(), qd);
        ta_questaodesafio2.setText(qd.getCorpo_Questao());
        ta_gabarito2.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 03
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio03(), qd);
        ta_questaodesafio3.setText(qd.getCorpo_Questao());
        ta_gabarito3.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 04
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio04(), qd);
        ta_questaodesafio4.setText(qd.getCorpo_Questao());
        ta_gabarito4.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 05
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio05(), qd);
        ta_questaodesafio5.setText(qd.getCorpo_Questao());
        ta_gabarito5.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 06
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio06(), qd);
        ta_questaodesafio6.setText(qd.getCorpo_Questao());
        ta_gabarito6.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 07
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio07(), qd);
        ta_questaodesafio7.setText(qd.getCorpo_Questao());
        ta_gabarito7.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 08
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio08(), qd);
        ta_questaodesafio8.setText(qd.getCorpo_Questao());
        ta_gabarito8.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 09
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio09(), qd);
        ta_questaodesafio9.setText(qd.getCorpo_Questao());
        ta_gabarito9.setText(qd.getGabarito());
        listaQuestoes.add(qd);

        //QUESTAO 10
        qd = new Questao_Desafio();
        qdwdao.BuscarQuestaoDesafio(rodada.getIdQuestao_Desafio10(), qd);
        ta_questaodesafio10.setText(qd.getCorpo_Questao());
        ta_gabarito10.setText(qd.getGabarito());
        listaQuestoes.add(qd);
                

    }
    
    public void VoltarQuestoes(){
        
        ta_questaodesafio1.setText("");
        ta_gabarito1.setText("");
        ta_questaodesafio2.setText("");
        ta_gabarito2.setText("");
        ta_questaodesafio3.setText("");
        ta_gabarito3.setText("");
        ta_questaodesafio4.setText("");
        ta_gabarito4.setText("");
        ta_questaodesafio5.setText("");
        ta_gabarito5.setText("");
        ta_questaodesafio6.setText("");
        ta_gabarito6.setText("");
        ta_questaodesafio7.setText("");
        ta_gabarito7.setText("");
        ta_questaodesafio8.setText("");
        ta_gabarito8.setText("");
        ta_questaodesafio9.setText("");
        ta_gabarito9.setText("");
        ta_questaodesafio10.setText("");
        ta_gabarito10.setText("");
        BloquearPaineis();
        u.liberapainel(jp_dados);
        
    }
    
    public void RecuperarDatas() {

        FormatarDatas fd = new FormatarDatas();
        Data1 = fd.FormatarData(dc_fase01);
        Data2 = fd.FormatarData(dc_fase02);
        Data3 = fd.FormatarData(dc_fase03);
        Data4 = fd.FormatarData(dc_fase04);
        Data5 = fd.FormatarData(dc_fase05);
        Data6 = fd.FormatarData(dc_fase06);

    }
    
    public Tela_AtualizarRodada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ListarTabela();
        tf_quantidadetimes.setEditable(false);
        BloquearPaineis();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp_rodada = new javax.swing.JScrollPane();
        ta_rodada = new javax.swing.JTable();
        jp_dados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_descricao = new javax.swing.JTextField();
        tf_material = new javax.swing.JTextField();
        tf_quantidadetimes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dc_fase01 = new com.toedter.calendar.JDateChooser();
        dc_fase02 = new com.toedter.calendar.JDateChooser();
        dc_fase04 = new com.toedter.calendar.JDateChooser();
        dc_fase05 = new com.toedter.calendar.JDateChooser();
        dc_fase06 = new com.toedter.calendar.JDateChooser();
        dc_fase03 = new com.toedter.calendar.JDateChooser();
        bt_avancarquestoes = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        ta_questoes = new javax.swing.JTabbedPane();
        painel_qst1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        ta_questaodesafio1 = new javax.swing.JTextArea();
        bt_voltar1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        ta_gabarito1 = new javax.swing.JTextArea();
        jSeparator7 = new javax.swing.JSeparator();
        bt_avançar1 = new javax.swing.JButton();
        painel_qst2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        ta_questaodesafio2 = new javax.swing.JTextArea();
        bt_voltar2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ta_gabarito2 = new javax.swing.JTextArea();
        jSeparator8 = new javax.swing.JSeparator();
        bt_avançar2 = new javax.swing.JButton();
        painel_qst3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        ta_questaodesafio3 = new javax.swing.JTextArea();
        bt_voltar3 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        ta_gabarito3 = new javax.swing.JTextArea();
        jSeparator11 = new javax.swing.JSeparator();
        bt_avançar3 = new javax.swing.JButton();
        painel_qst4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        ta_questaodesafio4 = new javax.swing.JTextArea();
        bt_voltar4 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        ta_gabarito4 = new javax.swing.JTextArea();
        jSeparator12 = new javax.swing.JSeparator();
        bt_avançar4 = new javax.swing.JButton();
        painel_qst5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        ta_questaodesafio5 = new javax.swing.JTextArea();
        bt_voltar5 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        ta_gabarito5 = new javax.swing.JTextArea();
        jSeparator13 = new javax.swing.JSeparator();
        bt_avançar5 = new javax.swing.JButton();
        painel_qst6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        ta_questaodesafio6 = new javax.swing.JTextArea();
        bt_voltar6 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        ta_gabarito6 = new javax.swing.JTextArea();
        jSeparator14 = new javax.swing.JSeparator();
        bt_avançar6 = new javax.swing.JButton();
        painel_qst7 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        ta_questaodesafio7 = new javax.swing.JTextArea();
        bt_voltar7 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        ta_gabarito7 = new javax.swing.JTextArea();
        jSeparator15 = new javax.swing.JSeparator();
        bt_avançar7 = new javax.swing.JButton();
        painel_qst8 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        ta_questaodesafio8 = new javax.swing.JTextArea();
        bt_voltar8 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        ta_gabarito8 = new javax.swing.JTextArea();
        jSeparator16 = new javax.swing.JSeparator();
        bt_avançar8 = new javax.swing.JButton();
        painel_qst9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        ta_questaodesafio9 = new javax.swing.JTextArea();
        bt_voltar9 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        ta_gabarito9 = new javax.swing.JTextArea();
        jSeparator17 = new javax.swing.JSeparator();
        bt_avançar9 = new javax.swing.JButton();
        painel_qst10 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        ta_questaodesafio10 = new javax.swing.JTextArea();
        bt_voltar10 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        ta_gabarito10 = new javax.swing.JTextArea();
        jSeparator18 = new javax.swing.JSeparator();
        bt_atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        sp_rodada.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        sp_rodada.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ta_rodada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Material", "Qt Times", "Data Fase 01", "Data Fase 02", "Data Fase 03", "Data Fase 04", "Data Fase 05", "Data Fase 06"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ta_rodada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ta_rodadaMouseClicked(evt);
            }
        });
        sp_rodada.setViewportView(ta_rodada);
        if (ta_rodada.getColumnModel().getColumnCount() > 0) {
            ta_rodada.getColumnModel().getColumn(0).setMinWidth(40);
            ta_rodada.getColumnModel().getColumn(0).setPreferredWidth(40);
            ta_rodada.getColumnModel().getColumn(0).setMaxWidth(40);
            ta_rodada.getColumnModel().getColumn(3).setPreferredWidth(60);
            ta_rodada.getColumnModel().getColumn(3).setMaxWidth(60);
            ta_rodada.getColumnModel().getColumn(4).setPreferredWidth(90);
            ta_rodada.getColumnModel().getColumn(4).setMaxWidth(90);
            ta_rodada.getColumnModel().getColumn(5).setPreferredWidth(90);
            ta_rodada.getColumnModel().getColumn(5).setMaxWidth(90);
            ta_rodada.getColumnModel().getColumn(6).setPreferredWidth(90);
            ta_rodada.getColumnModel().getColumn(6).setMaxWidth(90);
            ta_rodada.getColumnModel().getColumn(7).setPreferredWidth(90);
            ta_rodada.getColumnModel().getColumn(7).setMaxWidth(90);
            ta_rodada.getColumnModel().getColumn(8).setPreferredWidth(90);
            ta_rodada.getColumnModel().getColumn(8).setMaxWidth(90);
            ta_rodada.getColumnModel().getColumn(9).setPreferredWidth(90);
            ta_rodada.getColumnModel().getColumn(9).setMaxWidth(90);
        }

        jp_dados.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Descrição:");

        jLabel2.setText("Material:");

        jLabel3.setText("Qt Times:");

        jLabel4.setText("Data Fase 01:");

        jLabel5.setText("Data Fase 02:");

        jLabel6.setText("Data Fase 03:");

        jLabel7.setText("Data Fase 04:");

        jLabel8.setText("Data Fase 05:");

        jLabel9.setText("Data Fase 06:");

        dc_fase01.setDateFormatString("dd/MM/yyyy");

        dc_fase02.setDateFormatString("dd/MM/yyyy");

        dc_fase04.setDateFormatString("dd/MM/yyyy");

        dc_fase05.setDateFormatString("dd/MM/yyyy");

        dc_fase06.setDateFormatString("dd/MM/yyyy");

        dc_fase03.setDateFormatString("dd/MM/yyyy");

        bt_avancarquestoes.setText("AVANÇAR");
        bt_avancarquestoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancarquestoesActionPerformed(evt);
            }
        });

        bt_voltar.setText("VOLTAR");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_cancelar.setText("CANCELAR");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jp_dadosLayout = new javax.swing.GroupLayout(jp_dados);
        jp_dados.setLayout(jp_dadosLayout);
        jp_dadosLayout.setHorizontalGroup(
            jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_dadosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_quantidadetimes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_material)
                    .addComponent(tf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dc_fase01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dc_fase02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dc_fase03, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dc_fase04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dc_fase05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dc_fase06, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bt_avancarquestoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_voltar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );
        jp_dadosLayout.setVerticalGroup(
            jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_dadosLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_dadosLayout.createSequentialGroup()
                        .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dc_fase04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dc_fase05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dc_fase06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jp_dadosLayout.createSequentialGroup()
                        .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dc_fase01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dc_fase02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dc_fase03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jp_dadosLayout.createSequentialGroup()
                        .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(tf_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_dadosLayout.createSequentialGroup()
                                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(tf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)))
                        .addGap(41, 41, 41)
                        .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_quantidadetimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
            .addGroup(jp_dadosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(bt_cancelar)
                .addGap(18, 18, 18)
                .addComponent(bt_voltar)
                .addGap(18, 18, 18)
                .addComponent(bt_avancarquestoes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jp_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10)
                    .addComponent(jSeparator9))
                .addContainerGap())
        );

        ta_questoes.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        ta_questoes.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N

        painel_qst1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel18.setText("Questão Desafio 01:");

        ta_questaodesafio1.setColumns(20);
        ta_questaodesafio1.setLineWrap(true);
        ta_questaodesafio1.setRows(5);
        ta_questaodesafio1.setWrapStyleWord(true);
        jScrollPane9.setViewportView(ta_questaodesafio1);

        bt_voltar1.setText("VOLTAR");
        bt_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Gabarito:");

        ta_gabarito1.setColumns(20);
        ta_gabarito1.setLineWrap(true);
        ta_gabarito1.setRows(5);
        ta_gabarito1.setWrapStyleWord(true);
        jScrollPane10.setViewportView(ta_gabarito1);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar1.setText("AVANÇAR");
        bt_avançar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst1Layout = new javax.swing.GroupLayout(painel_qst1);
        painel_qst1.setLayout(painel_qst1Layout);
        painel_qst1Layout.setHorizontalGroup(
            painel_qst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(painel_qst1Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(painel_qst1Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst1Layout.setVerticalGroup(
            painel_qst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGroup(painel_qst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar1)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar1)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 01", painel_qst1);

        painel_qst2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel20.setText("Questão Desafio 02:");

        ta_questaodesafio2.setColumns(20);
        ta_questaodesafio2.setLineWrap(true);
        ta_questaodesafio2.setRows(5);
        ta_questaodesafio2.setWrapStyleWord(true);
        jScrollPane11.setViewportView(ta_questaodesafio2);

        bt_voltar2.setText("VOLTAR");
        bt_voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar2ActionPerformed(evt);
            }
        });

        jLabel21.setText("Gabarito:");

        ta_gabarito2.setColumns(20);
        ta_gabarito2.setLineWrap(true);
        ta_gabarito2.setRows(5);
        ta_gabarito2.setWrapStyleWord(true);
        jScrollPane12.setViewportView(ta_gabarito2);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar2.setText("AVANÇAR");
        bt_avançar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst2Layout = new javax.swing.GroupLayout(painel_qst2);
        painel_qst2.setLayout(painel_qst2Layout);
        painel_qst2Layout.setHorizontalGroup(
            painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(painel_qst2Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst2Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst2Layout.setVerticalGroup(
            painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar2)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar2)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 02", painel_qst2);

        painel_qst3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel22.setText("Questão Desafio 03:");

        ta_questaodesafio3.setColumns(20);
        ta_questaodesafio3.setLineWrap(true);
        ta_questaodesafio3.setRows(5);
        ta_questaodesafio3.setWrapStyleWord(true);
        jScrollPane13.setViewportView(ta_questaodesafio3);

        bt_voltar3.setText("VOLTAR");
        bt_voltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar3ActionPerformed(evt);
            }
        });

        jLabel23.setText("Gabarito:");

        ta_gabarito3.setColumns(20);
        ta_gabarito3.setLineWrap(true);
        ta_gabarito3.setRows(5);
        ta_gabarito3.setWrapStyleWord(true);
        jScrollPane14.setViewportView(ta_gabarito3);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar3.setText("AVANÇAR");
        bt_avançar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst3Layout = new javax.swing.GroupLayout(painel_qst3);
        painel_qst3.setLayout(painel_qst3Layout);
        painel_qst3Layout.setHorizontalGroup(
            painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(painel_qst3Layout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst3Layout.createSequentialGroup()
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst3Layout.setVerticalGroup(
            painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator11)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar3)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar3)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 03", painel_qst3);

        painel_qst4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel24.setText("Questão Desafio 04:");

        ta_questaodesafio4.setColumns(20);
        ta_questaodesafio4.setLineWrap(true);
        ta_questaodesafio4.setRows(5);
        ta_questaodesafio4.setWrapStyleWord(true);
        jScrollPane15.setViewportView(ta_questaodesafio4);

        bt_voltar4.setText("VOLTAR");
        bt_voltar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar4ActionPerformed(evt);
            }
        });

        jLabel25.setText("Gabarito:");

        ta_gabarito4.setColumns(20);
        ta_gabarito4.setLineWrap(true);
        ta_gabarito4.setRows(5);
        ta_gabarito4.setWrapStyleWord(true);
        jScrollPane16.setViewportView(ta_gabarito4);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar4.setText("AVANÇAR");
        bt_avançar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst4Layout = new javax.swing.GroupLayout(painel_qst4);
        painel_qst4.setLayout(painel_qst4Layout);
        painel_qst4Layout.setHorizontalGroup(
            painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(painel_qst4Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst4Layout.createSequentialGroup()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar4, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst4Layout.setVerticalGroup(
            painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator12)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar4)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar4)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 04", painel_qst4);

        painel_qst5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel26.setText("Questão Desafio 05:");

        ta_questaodesafio5.setColumns(20);
        ta_questaodesafio5.setLineWrap(true);
        ta_questaodesafio5.setRows(5);
        ta_questaodesafio5.setWrapStyleWord(true);
        jScrollPane17.setViewportView(ta_questaodesafio5);

        bt_voltar5.setText("VOLTAR");
        bt_voltar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar5ActionPerformed(evt);
            }
        });

        jLabel27.setText("Gabarito:");

        ta_gabarito5.setColumns(20);
        ta_gabarito5.setLineWrap(true);
        ta_gabarito5.setRows(5);
        ta_gabarito5.setWrapStyleWord(true);
        jScrollPane18.setViewportView(ta_gabarito5);

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar5.setText("AVANÇAR");
        bt_avançar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst5Layout = new javax.swing.GroupLayout(painel_qst5);
        painel_qst5.setLayout(painel_qst5Layout);
        painel_qst5Layout.setHorizontalGroup(
            painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(painel_qst5Layout.createSequentialGroup()
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(painel_qst5Layout.createSequentialGroup()
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar5, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst5Layout.setVerticalGroup(
            painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator13)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar5)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar5)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 05", painel_qst5);

        painel_qst6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel28.setText("Questão Desafio 06");

        ta_questaodesafio6.setColumns(20);
        ta_questaodesafio6.setLineWrap(true);
        ta_questaodesafio6.setRows(5);
        ta_questaodesafio6.setWrapStyleWord(true);
        jScrollPane19.setViewportView(ta_questaodesafio6);

        bt_voltar6.setText("VOLTAR");
        bt_voltar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar6ActionPerformed(evt);
            }
        });

        jLabel29.setText("Gabarito:");

        ta_gabarito6.setColumns(20);
        ta_gabarito6.setLineWrap(true);
        ta_gabarito6.setRows(5);
        ta_gabarito6.setWrapStyleWord(true);
        jScrollPane20.setViewportView(ta_gabarito6);

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar6.setText("AVANÇAR");
        bt_avançar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst6Layout = new javax.swing.GroupLayout(painel_qst6);
        painel_qst6.setLayout(painel_qst6Layout);
        painel_qst6Layout.setHorizontalGroup(
            painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(painel_qst6Layout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst6Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst6Layout.createSequentialGroup()
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar6, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst6Layout.setVerticalGroup(
            painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator14)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar6)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar6)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 06", painel_qst6);

        painel_qst7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel30.setText("Questão Desafio 07:");

        ta_questaodesafio7.setColumns(20);
        ta_questaodesafio7.setLineWrap(true);
        ta_questaodesafio7.setRows(5);
        ta_questaodesafio7.setWrapStyleWord(true);
        jScrollPane21.setViewportView(ta_questaodesafio7);

        bt_voltar7.setText("VOLTAR");
        bt_voltar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar7ActionPerformed(evt);
            }
        });

        jLabel31.setText("Gabarito:");

        ta_gabarito7.setColumns(20);
        ta_gabarito7.setLineWrap(true);
        ta_gabarito7.setRows(5);
        ta_gabarito7.setWrapStyleWord(true);
        jScrollPane22.setViewportView(ta_gabarito7);

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar7.setText("AVANÇAR");
        bt_avançar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst7Layout = new javax.swing.GroupLayout(painel_qst7);
        painel_qst7.setLayout(painel_qst7Layout);
        painel_qst7Layout.setHorizontalGroup(
            painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(painel_qst7Layout.createSequentialGroup()
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(painel_qst7Layout.createSequentialGroup()
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar7, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst7Layout.setVerticalGroup(
            painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator15)
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar7)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar7)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 07", painel_qst7);

        painel_qst8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel32.setText("Questão Desafio 08:");

        ta_questaodesafio8.setColumns(20);
        ta_questaodesafio8.setLineWrap(true);
        ta_questaodesafio8.setRows(5);
        ta_questaodesafio8.setWrapStyleWord(true);
        jScrollPane23.setViewportView(ta_questaodesafio8);

        bt_voltar8.setText("VOLTAR");
        bt_voltar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar8ActionPerformed(evt);
            }
        });

        jLabel33.setText("Gabarito:");

        ta_gabarito8.setColumns(20);
        ta_gabarito8.setLineWrap(true);
        ta_gabarito8.setRows(5);
        ta_gabarito8.setWrapStyleWord(true);
        jScrollPane24.setViewportView(ta_gabarito8);

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar8.setText("AVANÇAR");
        bt_avançar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst8Layout = new javax.swing.GroupLayout(painel_qst8);
        painel_qst8.setLayout(painel_qst8Layout);
        painel_qst8Layout.setHorizontalGroup(
            painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(painel_qst8Layout.createSequentialGroup()
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst8Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst8Layout.createSequentialGroup()
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar8, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst8Layout.setVerticalGroup(
            painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator16)
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar8)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar8)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 08", painel_qst8);

        painel_qst9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel34.setText("Questão Desafio 09:");

        ta_questaodesafio9.setColumns(20);
        ta_questaodesafio9.setLineWrap(true);
        ta_questaodesafio9.setRows(5);
        ta_questaodesafio9.setWrapStyleWord(true);
        jScrollPane25.setViewportView(ta_questaodesafio9);

        bt_voltar9.setText("VOLTAR");
        bt_voltar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar9ActionPerformed(evt);
            }
        });

        jLabel35.setText("Gabarito:");

        ta_gabarito9.setColumns(20);
        ta_gabarito9.setLineWrap(true);
        ta_gabarito9.setRows(5);
        ta_gabarito9.setWrapStyleWord(true);
        jScrollPane26.setViewportView(ta_gabarito9);

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avançar9.setText("AVANÇAR");
        bt_avançar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançar9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst9Layout = new javax.swing.GroupLayout(painel_qst9);
        painel_qst9.setLayout(painel_qst9Layout);
        painel_qst9Layout.setHorizontalGroup(
            painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addGroup(painel_qst9Layout.createSequentialGroup()
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst9Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst9Layout.createSequentialGroup()
                        .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_avançar9, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst9Layout.setVerticalGroup(
            painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator17)
                            .addComponent(jScrollPane25, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar9)
                        .addGap(18, 18, 18)
                        .addComponent(bt_avançar9)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 09", painel_qst9);

        painel_qst10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel36.setText("Questão Desafio 10:");

        ta_questaodesafio10.setColumns(20);
        ta_questaodesafio10.setLineWrap(true);
        ta_questaodesafio10.setRows(5);
        ta_questaodesafio10.setWrapStyleWord(true);
        jScrollPane27.setViewportView(ta_questaodesafio10);

        bt_voltar10.setText("VOLTAR");
        bt_voltar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar10ActionPerformed(evt);
            }
        });

        jLabel37.setText("Gabarito:");

        ta_gabarito10.setColumns(20);
        ta_gabarito10.setLineWrap(true);
        ta_gabarito10.setRows(5);
        ta_gabarito10.setWrapStyleWord(true);
        jScrollPane28.setViewportView(ta_gabarito10);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_atualizar.setText("ATUALIZAR");
        bt_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_qst10Layout = new javax.swing.GroupLayout(painel_qst10);
        painel_qst10.setLayout(painel_qst10Layout);
        painel_qst10Layout.setHorizontalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_voltar10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painel_qst10Layout.setVerticalGroup(
            painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_qst10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_qst10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_qst10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator18)
                            .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jScrollPane28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_qst10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_voltar10)
                        .addGap(18, 18, 18)
                        .addComponent(bt_atualizar)
                        .addGap(45, 45, 45))))
        );

        ta_questoes.addTab("QST 10", painel_qst10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_rodada, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jp_dados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ta_questoes))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp_rodada, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ta_questoes, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ta_rodadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ta_rodadaMouseClicked
       if(eventoClickTabela){
        if (evt.getClickCount() == 2) {
            if (JOptionPane.showConfirmDialog(null, "Deseja Atualizar a Rodada: " + ta_rodada.getValueAt(ta_rodada.getSelectedRow(), 0).toString() + "?", "Atualizar", 2) == 0) {
                
                rwdao.BuscarRodada(rodada, Integer.parseInt(ta_rodada.getValueAt(ta_rodada.getSelectedRow(), 0).toString()));
                tf_descricao.setText(rodada.getDescricao());
                tf_material.setText(rodada.getMaterial());
                tf_quantidadetimes.setText(String.valueOf(rodada.getQuantidade_Times()));
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
                Date datafase01, datafase02, datafase03, datafase04, datafase05, datafase06;
                try {
                    datafase01 = formato.parse(rodada.getData_Fase1());
                    dc_fase01.setDate(datafase01);    
                    
                    datafase02 = formato.parse(rodada.getData_Fase2());
                    dc_fase02.setDate(datafase02);    
                    
                    datafase03 = formato.parse(rodada.getData_Fase3());
                    dc_fase03.setDate(datafase03);    
                    
                    datafase04 = formato.parse(rodada.getData_Fase4());
                    dc_fase04.setDate(datafase04);    
                    
                    datafase05 = formato.parse(rodada.getData_Fase5());
                    dc_fase05.setDate(datafase05);    
                    
                    datafase06 = formato.parse(rodada.getData_Fase6());
                    dc_fase06.setDate(datafase06);    
                    
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro!: "+ex);
                }

                AvancarDados();
            }
       }
       }
    }//GEN-LAST:event_ta_rodadaMouseClicked

    private void bt_avancarquestoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancarquestoesActionPerformed
        
        AvancarQuestoes();
        
    }//GEN-LAST:event_bt_avancarquestoesActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja Voltar?" , "Voltar", 2) == 0) {
           LimparCampos();
           tf_quantidadetimes.setEditable(false);
           BloquearPaineis();
           ListarTabela();
           ta_rodada.setEnabled(true);
       }     
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void bt_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atualizarActionPerformed
        
        if (JOptionPane.showConfirmDialog(null, "Deseja Atualizar?" , "Atualizar", 2) == 0) {
            RecuperarDatas();
            rodada.setDescricao(tf_descricao.getText());
            rodada.setMaterial(tf_material.getText());
            rodada.setData_Fase1(Data1);
            rodada.setData_Fase2(Data2);
            rodada.setData_Fase3(Data3);
            rodada.setData_Fase4(Data4);
            rodada.setData_Fase5(Data5);
            rodada.setData_Fase6(Data6);
            rwdao.AtualizarRodada(rodada);
            
            Questao_Desafio qd;
            
            //ATUALIZAR QUESTAO DESAFIO 01
            qd = listaQuestoes.get(0);
            qd.setCorpo_Questao(ta_questaodesafio1.getText());
            qd.setGabarito(ta_gabarito1.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 02
            qd = listaQuestoes.get(1);
            qd.setCorpo_Questao(ta_questaodesafio2.getText());
            qd.setGabarito(ta_gabarito2.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 03
            qd = listaQuestoes.get(2);
            qd.setCorpo_Questao(ta_questaodesafio3.getText());
            qd.setGabarito(ta_gabarito3.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 04
            qd = listaQuestoes.get(3);
            qd.setCorpo_Questao(ta_questaodesafio4.getText());
            qd.setGabarito(ta_gabarito4.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 05
            qd = listaQuestoes.get(4);
            qd.setCorpo_Questao(ta_questaodesafio5.getText());
            qd.setGabarito(ta_gabarito5.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 06
            qd = listaQuestoes.get(5);
            qd.setCorpo_Questao(ta_questaodesafio6.getText());
            qd.setGabarito(ta_gabarito6.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 07
            qd = listaQuestoes.get(6);
            qd.setCorpo_Questao(ta_questaodesafio7.getText());
            qd.setGabarito(ta_gabarito7.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 08
            qd = listaQuestoes.get(7);
            qd.setCorpo_Questao(ta_questaodesafio8.getText());
            qd.setGabarito(ta_gabarito8.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 09
            qd = listaQuestoes.get(8);
            qd.setCorpo_Questao(ta_questaodesafio9.getText());
            qd.setGabarito(ta_gabarito9.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            //ATUALIZAR QUESTAO DESAFIO 10
            qd = listaQuestoes.get(9);
            qd.setCorpo_Questao(ta_questaodesafio10.getText());
            qd.setGabarito(ta_gabarito10.getText());
            qdwdao.AtualizarQuestaoDesafio(qd);
            
            JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
            
            LimparCampos();
            tf_quantidadetimes.setEditable(false);
            BloquearPaineis();
            ListarTabela();
            ta_rodada.setEnabled(true);
        }
    }//GEN-LAST:event_bt_atualizarActionPerformed

    private void bt_voltar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar10ActionPerformed
        ta_questoes.setEnabledAt(9, false);
        ta_questoes.setEnabledAt(8, true);
        ta_questoes.setSelectedIndex(8);
    }//GEN-LAST:event_bt_voltar10ActionPerformed

    private void bt_avançar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar9ActionPerformed
        if (!ta_questaodesafio9.getText().equals("") && !ta_gabarito9.getText().equals("")) {
            ta_questoes.setEnabledAt(8, false);
            ta_questoes.setEnabledAt(8, true);
            ta_questoes.setSelectedIndex(9);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 09 ou Gabarito 09, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar9ActionPerformed

    private void bt_voltar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar9ActionPerformed
        ta_questoes.setEnabledAt(8, false);
        ta_questoes.setEnabledAt(7, true);
        ta_questoes.setSelectedIndex(7);
    }//GEN-LAST:event_bt_voltar9ActionPerformed

    private void bt_avançar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar8ActionPerformed
        if (!ta_questaodesafio8.getText().equals("") && !ta_gabarito8.getText().equals("")) {
            ta_questoes.setEnabledAt(7, false);
            ta_questoes.setEnabledAt(7, true);
            ta_questoes.setSelectedIndex(8);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 08 ou Gabarito 08, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar8ActionPerformed

    private void bt_voltar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar8ActionPerformed
        ta_questoes.setEnabledAt(7, false);
        ta_questoes.setEnabledAt(6, true);
        ta_questoes.setSelectedIndex(6);
    }//GEN-LAST:event_bt_voltar8ActionPerformed

    private void bt_avançar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar7ActionPerformed
        if (!ta_questaodesafio7.getText().equals("") && !ta_gabarito7.getText().equals("")) {
            ta_questoes.setEnabledAt(6, false);
            ta_questoes.setEnabledAt(6, true);
            ta_questoes.setSelectedIndex(7);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 07 ou Gabarito 07, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar7ActionPerformed

    private void bt_voltar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar7ActionPerformed
        ta_questoes.setEnabledAt(6, false);
        ta_questoes.setEnabledAt(5, true);
        ta_questoes.setSelectedIndex(5);
    }//GEN-LAST:event_bt_voltar7ActionPerformed

    private void bt_avançar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar6ActionPerformed
        if (!ta_questaodesafio6.getText().equals("") && !ta_gabarito6.getText().equals("")) {
            ta_questoes.setEnabledAt(5, false);
            ta_questoes.setEnabledAt(5, true);
            ta_questoes.setSelectedIndex(6);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 06 ou Gabarito 06, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar6ActionPerformed

    private void bt_voltar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar6ActionPerformed
        ta_questoes.setEnabledAt(5, false);
        ta_questoes.setEnabledAt(4, true);
        ta_questoes.setSelectedIndex(4);
    }//GEN-LAST:event_bt_voltar6ActionPerformed

    private void bt_avançar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar5ActionPerformed
        if (!ta_questaodesafio5.getText().equals("") && !ta_gabarito5.getText().equals("")) {
            ta_questoes.setEnabledAt(4, false);
            ta_questoes.setEnabledAt(4, true);
            ta_questoes.setSelectedIndex(5);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 05 ou Gabarito 05, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar5ActionPerformed

    private void bt_voltar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar5ActionPerformed
        ta_questoes.setEnabledAt(4, false);
        ta_questoes.setEnabledAt(3, true);
        ta_questoes.setSelectedIndex(3);
    }//GEN-LAST:event_bt_voltar5ActionPerformed

    private void bt_avançar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar4ActionPerformed
        if (!ta_questaodesafio4.getText().equals("") && !ta_gabarito4.getText().equals("")) {
            ta_questoes.setEnabledAt(3, false);
            ta_questoes.setEnabledAt(3, true);
            ta_questoes.setSelectedIndex(4);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 04 ou Gabarito 04, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar4ActionPerformed

    private void bt_voltar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar4ActionPerformed
        ta_questoes.setEnabledAt(3, false);
        ta_questoes.setEnabledAt(2, true);
        ta_questoes.setSelectedIndex(2);
    }//GEN-LAST:event_bt_voltar4ActionPerformed

    private void bt_avançar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar3ActionPerformed
        if (!ta_questaodesafio3.getText().equals("") && !ta_gabarito3.getText().equals("")) {
            ta_questoes.setEnabledAt(2, false);
            ta_questoes.setEnabledAt(2, true);
            ta_questoes.setSelectedIndex(3);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 03 ou Gabarito 03, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar3ActionPerformed

    private void bt_voltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar3ActionPerformed
        ta_questoes.setEnabledAt(2, false);
        ta_questoes.setEnabledAt(1, true);
        ta_questoes.setSelectedIndex(1);
    }//GEN-LAST:event_bt_voltar3ActionPerformed

    private void bt_avançar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar2ActionPerformed
        if (!ta_questaodesafio2.getText().equals("") && !ta_gabarito2.getText().equals("")) {
            ta_questoes.setEnabledAt(1, false);
            ta_questoes.setEnabledAt(2, true);
            ta_questoes.setSelectedIndex(2);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 02 ou Gabarito 02, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar2ActionPerformed

    private void bt_voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar2ActionPerformed
        ta_questoes.setEnabledAt(1, false);
        ta_questoes.setEnabledAt(0, true);
        ta_questoes.setSelectedIndex(0);
    }//GEN-LAST:event_bt_voltar2ActionPerformed

    private void bt_avançar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançar1ActionPerformed
        if (!ta_questaodesafio1.getText().equals("") && !ta_gabarito1.getText().equals("")) {
            ta_questoes.setEnabledAt(0, false);
            ta_questoes.setEnabledAt(1, true);
            ta_questoes.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(null, "Questão 01 ou Gabarito 01, não podem estar vazio!");
        }
    }//GEN-LAST:event_bt_avançar1ActionPerformed

    private void bt_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar1ActionPerformed
        VoltarQuestoes();
    }//GEN-LAST:event_bt_voltar1ActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
       if (JOptionPane.showConfirmDialog(null, "Deseja Cancelar?" , "Cancelar", 2) == 0) {
           LimparCampos();
           dispose();
       }
    }//GEN-LAST:event_bt_cancelarActionPerformed

    
    public static void main(String args[]) {
       
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_AtualizarRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_AtualizarRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_AtualizarRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_AtualizarRodada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_AtualizarRodada dialog = new Tela_AtualizarRodada(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_atualizar;
    private javax.swing.JButton bt_avancarquestoes;
    private javax.swing.JButton bt_avançar1;
    private javax.swing.JButton bt_avançar2;
    private javax.swing.JButton bt_avançar3;
    private javax.swing.JButton bt_avançar4;
    private javax.swing.JButton bt_avançar5;
    private javax.swing.JButton bt_avançar6;
    private javax.swing.JButton bt_avançar7;
    private javax.swing.JButton bt_avançar8;
    private javax.swing.JButton bt_avançar9;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JButton bt_voltar1;
    private javax.swing.JButton bt_voltar10;
    private javax.swing.JButton bt_voltar2;
    private javax.swing.JButton bt_voltar3;
    private javax.swing.JButton bt_voltar4;
    private javax.swing.JButton bt_voltar5;
    private javax.swing.JButton bt_voltar6;
    private javax.swing.JButton bt_voltar7;
    private javax.swing.JButton bt_voltar8;
    private javax.swing.JButton bt_voltar9;
    private com.toedter.calendar.JDateChooser dc_fase01;
    private com.toedter.calendar.JDateChooser dc_fase02;
    private com.toedter.calendar.JDateChooser dc_fase03;
    private com.toedter.calendar.JDateChooser dc_fase04;
    private com.toedter.calendar.JDateChooser dc_fase05;
    private com.toedter.calendar.JDateChooser dc_fase06;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel jp_dados;
    private javax.swing.JPanel painel_qst1;
    private javax.swing.JPanel painel_qst10;
    private javax.swing.JPanel painel_qst2;
    private javax.swing.JPanel painel_qst3;
    private javax.swing.JPanel painel_qst4;
    private javax.swing.JPanel painel_qst5;
    private javax.swing.JPanel painel_qst6;
    private javax.swing.JPanel painel_qst7;
    private javax.swing.JPanel painel_qst8;
    private javax.swing.JPanel painel_qst9;
    private javax.swing.JScrollPane sp_rodada;
    private javax.swing.JTextArea ta_gabarito1;
    private javax.swing.JTextArea ta_gabarito10;
    private javax.swing.JTextArea ta_gabarito2;
    private javax.swing.JTextArea ta_gabarito3;
    private javax.swing.JTextArea ta_gabarito4;
    private javax.swing.JTextArea ta_gabarito5;
    private javax.swing.JTextArea ta_gabarito6;
    private javax.swing.JTextArea ta_gabarito7;
    private javax.swing.JTextArea ta_gabarito8;
    private javax.swing.JTextArea ta_gabarito9;
    private javax.swing.JTextArea ta_questaodesafio1;
    private javax.swing.JTextArea ta_questaodesafio10;
    private javax.swing.JTextArea ta_questaodesafio2;
    private javax.swing.JTextArea ta_questaodesafio3;
    private javax.swing.JTextArea ta_questaodesafio4;
    private javax.swing.JTextArea ta_questaodesafio5;
    private javax.swing.JTextArea ta_questaodesafio6;
    private javax.swing.JTextArea ta_questaodesafio7;
    private javax.swing.JTextArea ta_questaodesafio8;
    private javax.swing.JTextArea ta_questaodesafio9;
    private javax.swing.JTabbedPane ta_questoes;
    private javax.swing.JTable ta_rodada;
    private javax.swing.JTextField tf_descricao;
    private javax.swing.JTextField tf_material;
    private javax.swing.JTextField tf_quantidadetimes;
    // End of variables declaration//GEN-END:variables
}
