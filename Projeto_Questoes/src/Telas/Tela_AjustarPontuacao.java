package Telas;

import Classes.Equipe;
import Classes.Questao;
import Classes.Resposta;
import Classes.Resposta_Questao_Desafio;
import Classes.Usuario_Aluno;
import Classes.Usuario_Token;
import Servicos.ContagemPontos;
import Servicos.Utilitarios;
import WebService.EquipeWebDAO;
import WebService.QuestaoWebDAO;
import WebService.RespostaWebDAO;
import WebService.Resposta_Questao_DesafioWebDAO;
import WebService.Usuario_AlunoWebDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Tela_AjustarPontuacao extends javax.swing.JDialog {

    EquipeWebDAO ewdao = new EquipeWebDAO();
    QuestaoWebDAO qwdao = new QuestaoWebDAO();
    RespostaWebDAO rwdao = new RespostaWebDAO();
    Resposta_Questao_DesafioWebDAO rqdwdao = new Resposta_Questao_DesafioWebDAO();
    Usuario_AlunoWebDAO uawdao = new Usuario_AlunoWebDAO();
    Usuario_Aluno ua = new Usuario_Aluno();
    Usuario_Token ut = Usuario_Token.getInstance();
    ArrayList<Integer> listaIdEquipes = new ArrayList<>();
    ArrayList<Questao> listaQuestoes = new ArrayList<>();
    ArrayList<Resposta> listaResposta = new ArrayList<>();
    ArrayList<Resposta_Questao_Desafio> listaResposta_Questao_Desafio = new ArrayList<>();
    Utilitarios u = new Utilitarios();
    Equipe equipe = new Equipe();
    ContagemPontos cp = new ContagemPontos();
    boolean VerificarPontuacaoQuestoes = false;
    boolean VerificarPontuacaoRespostas = false;
    boolean VerificarPontuacaoDesafio = false;


    public void PopularCBEquipes() {

        listaIdEquipes.clear();

        try {
            DefaultComboBoxModel theModel = (DefaultComboBoxModel) cb_equipe.getModel();
            theModel.removeAllElements();
            cb_equipe.setSelectedIndex(-1);
            cb_equipe.setSelectedItem(null);

            Equipe e;
            for (int idEquipe : uawdao.ListaEquipesId(ut.getRodada_idRodada())) {
                e = new Equipe();
                ewdao.BuscarEquipe(e, idEquipe);
                listaIdEquipes.add(e.getIdEquipe());
                cb_equipe.addItem(e);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void BloquearCampos() {

        u.bloqueiapainel(jp_pontuacao);
        u.bloqueiapainel(jp_questoes);
        u.bloqueiapainel(jp_respostas);
        u.bloqueiapainel(jp_desafio);
        tf_qst01.setEditable(false);
        tf_qst02.setEditable(false);
        tf_qst03.setEditable(false);
        tf_qst04.setEditable(false);
        tf_qst05.setEditable(false);
        tf_qst06.setEditable(false);
        tf_qst07.setEditable(false);
        tf_qst08.setEditable(false);
        tf_qst09.setEditable(false);
        tf_qst10.setEditable(false);
        tf_rsp01.setEditable(false);
        tf_rsp02.setEditable(false);
        tf_rsp03.setEditable(false);
        tf_rsp04.setEditable(false);
        tf_rsp05.setEditable(false);
        tf_rsp06.setEditable(false);
        tf_rsp07.setEditable(false);
        tf_rsp08.setEditable(false);
        tf_rsp09.setEditable(false);
        tf_rsp10.setEditable(false);
        tf_rspdesafio01.setEditable(false);
        tf_rspdesafio02.setEditable(false);
        tf_rspdesafio03.setEditable(false);
        tf_pontuacaototalquestoes.setEditable(false);
        tf_pontuacaototalrespostas.setEditable(false);
        tf_pontuacaototaldesafio.setEditable(false);
        jftf_pontuacaoquestoes.setEditable(false);
        jftf_pontuacaorespostas.setEditable(false);
        jftf_pontuacaodesafio.setEditable(false);
        ta_pontuacao.setEnabled(false);

    }

    public void AvancarQuestoes() {

        ewdao.BuscarEquipe(equipe, listaIdEquipes.get(cb_equipe.getSelectedIndex()));
        if (equipe.getIsQuestionario() == 1) {
            u.liberapainel(jp_questoes);
            u.bloqueiapainel(jp_equipe);
            VerificarAvaliacaoQuestoes();
            VerificarPontuacaoQuestoes = true;
            cb_qst01ItemStateChanged(null);
            cb_qst02ItemStateChanged(null);
            cb_qst03ItemStateChanged(null);
            cb_qst04ItemStateChanged(null);
            cb_qst05ItemStateChanged(null);
            cb_qst06ItemStateChanged(null);
            cb_qst07ItemStateChanged(null);
            cb_qst08ItemStateChanged(null);
            cb_qst09ItemStateChanged(null);
            cb_qst10ItemStateChanged(null);
        } else {
            JOptionPane.showMessageDialog(null, "Equipe não Enviou o Questionario!");
            u.liberapainel(jp_questoes);
            u.bloqueiapainel(jp_equipe);
            cb_qst01.setEnabled(false);
            cb_qst02.setEnabled(false);
            cb_qst03.setEnabled(false);
            cb_qst04.setEnabled(false);
            cb_qst05.setEnabled(false);
            cb_qst06.setEnabled(false);
            cb_qst07.setEnabled(false);
            cb_qst08.setEnabled(false);
            cb_qst09.setEnabled(false);
            cb_qst10.setEnabled(false);
        }
    }

    public void AvancarRespostas() {

        if (equipe.getIsResposta() == 1) {
            u.liberapainel(jp_respostas);
            VerificarNotaRespostas();
            VerificarPontuacaoRespostas = true;
            cb_rsp01ItemStateChanged(null);
            cb_rsp02ItemStateChanged(null);
            cb_rsp03ItemStateChanged(null);
            cb_rsp04ItemStateChanged(null);
            cb_rsp05ItemStateChanged(null);
            cb_rsp06ItemStateChanged(null);
            cb_rsp07ItemStateChanged(null);
            cb_rsp08ItemStateChanged(null);
            cb_rsp09ItemStateChanged(null);
            cb_rsp10ItemStateChanged(null);

        } else {
            JOptionPane.showMessageDialog(null, "Equipe não Respodeu o Questionario!");
            u.liberapainel(jp_respostas);
            cb_rsp01.setEnabled(false);
            cb_rsp02.setEnabled(false);
            cb_rsp03.setEnabled(false);
            cb_rsp04.setEnabled(false);
            cb_rsp05.setEnabled(false);
            cb_rsp06.setEnabled(false);
            cb_rsp07.setEnabled(false);
            cb_rsp08.setEnabled(false);
            cb_rsp09.setEnabled(false);
            cb_rsp10.setEnabled(false);
        }
    }

    public void AvancarDesafio() {

            if (equipe.getIsDesafio()== 1) {
            u.liberapainel(jp_desafio);
            VerificarAvaliacaoDesafio();
            VerificarPontuacaoDesafio = true;
            cb_rspdesafio1ItemStateChanged(null);
            cb_rspdesafio2ItemStateChanged(null);
            cb_rspdesafio3ItemStateChanged(null);

        } else {
            JOptionPane.showMessageDialog(null, "Equipe não Respondeu o Desafio!");
            u.liberapainel(jp_desafio);
            cb_rspdesafio1.setEnabled(false);
            cb_rspdesafio2.setEnabled(false);
            cb_rspdesafio3.setEnabled(false);
        }
    }

    public void VerificarAvaliacaoQuestoes() {

        Questao q;
        listaQuestoes.clear();

        //VERIFICAR QUALIFICACAO QUESTAO 01
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe01(), q);
        cb_qst01.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 02
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe02(), q);
        cb_qst02.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 03
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe03(), q);
        cb_qst03.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 04
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe04(), q);
        cb_qst04.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 05
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe05(), q);
        cb_qst05.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 06
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe06(), q);
        cb_qst06.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 07
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe07(), q);
        cb_qst07.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 08
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe08(), q);
        cb_qst08.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 09
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe09(), q);
        cb_qst09.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

        //VERIFICAR QUALIFICACAO QUESTAO 10
        q = new Questao();
        qwdao.BuscarQuestao(equipe.getIdQuestao_Equipe10(), q);
        cb_qst10.setSelectedIndex(cp.VerificarQualificacaoQuestao(q.getQualificacao_Questao()));
        listaQuestoes.add(q);

    }

    public void VerificarNotaRespostas() {

        Resposta r;
        listaResposta.clear();

        //VERIFICAR NOTA RESPOSTA 01
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe01(), r);
        cb_rsp01.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 02
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe02(), r);
        cb_rsp02.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 03
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe03(), r);
        cb_rsp03.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 04
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe04(), r);
        cb_rsp04.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 05
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe05(), r);
        cb_rsp05.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 06
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe06(), r);
        cb_rsp06.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 07
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe07(), r);
        cb_rsp07.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 08
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe08(), r);
        cb_rsp08.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 09
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe09(), r);
        cb_rsp09.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

        //VERIFICAR NOTA RESPOSTA 10
        r = new Resposta();
        rwdao.BuscarResposta(equipe.getIdResposta_Equipe10(), r);
        cb_rsp10.setSelectedIndex(cp.VerificarCorrecaoResposta(r.getNota_Resposta()));
        listaResposta.add(r);

    }
    
    public void VerificarAvaliacaoDesafio() {

        Resposta_Questao_Desafio rqd;
        listaResposta_Questao_Desafio.clear();

        //VERIFICAR NOTA RESPOSTA_QUESTAO_DESAFIO 01
        rqd = new Resposta_Questao_Desafio();
        rqdwdao.BuscarRespostaDesafio(equipe.getIdResposta_Desafio01(), rqd);
        cb_rspdesafio1.setSelectedIndex(cp.VerificarCorrecaoResposta(rqd.getNota_Questao_Desafio()));
        listaResposta_Questao_Desafio.add(rqd);

        //VERIFICAR NOTA RESPOSTA_QUESTAO_DESAFIO 02
        rqd = new Resposta_Questao_Desafio();
        rqdwdao.BuscarRespostaDesafio(equipe.getIdResposta_Desafio02(), rqd);
        cb_rspdesafio2.setSelectedIndex(cp.VerificarCorrecaoResposta(rqd.getNota_Questao_Desafio()));
        listaResposta_Questao_Desafio.add(rqd);

        //VERIFICAR NOTA RESPOSTA_QUESTAO_DESAFIO 03
        rqd = new Resposta_Questao_Desafio();
        rqdwdao.BuscarRespostaDesafio(equipe.getIdResposta_Desafio03(), rqd);
        cb_rspdesafio3.setSelectedIndex(cp.VerificarCorrecaoResposta(rqd.getNota_Questao_Desafio()));
        listaResposta_Questao_Desafio.add(rqd);

    }

    public void SomarPontuacaoQuestoes() {
        int soma = 0;
        soma += Integer.parseInt(tf_qst01.getText());
        soma += Integer.parseInt(tf_qst02.getText());
        soma += Integer.parseInt(tf_qst03.getText());
        soma += Integer.parseInt(tf_qst04.getText());
        soma += Integer.parseInt(tf_qst05.getText());
        soma += Integer.parseInt(tf_qst06.getText());
        soma += Integer.parseInt(tf_qst07.getText());
        soma += Integer.parseInt(tf_qst08.getText());
        soma += Integer.parseInt(tf_qst09.getText());
        soma += Integer.parseInt(tf_qst10.getText());
        tf_pontuacaototalquestoes.setText(String.valueOf(soma));
    }
    
    public void SomarPontuacaoRespostas() {
        int soma = 0;
        soma += Integer.parseInt(tf_rsp01.getText());
        soma += Integer.parseInt(tf_rsp02.getText());
        soma += Integer.parseInt(tf_rsp03.getText());
        soma += Integer.parseInt(tf_rsp04.getText());
        soma += Integer.parseInt(tf_rsp05.getText());
        soma += Integer.parseInt(tf_rsp06.getText());
        soma += Integer.parseInt(tf_rsp07.getText());
        soma += Integer.parseInt(tf_rsp08.getText());
        soma += Integer.parseInt(tf_rsp09.getText());
        soma += Integer.parseInt(tf_rsp10.getText());
        tf_pontuacaototalrespostas.setText(String.valueOf(soma));
    }
    
    public void SomarPontuacaoDesafio() {
        int soma = 0;
        soma += Integer.parseInt(tf_rspdesafio01.getText());
        soma += Integer.parseInt(tf_rspdesafio02.getText());
        soma += Integer.parseInt(tf_rspdesafio03.getText());
        tf_pontuacaototaldesafio.setText(String.valueOf(soma));
    }

    public void VoltarPainelEquipes() {

        VerificarPontuacaoQuestoes = false;
        VerificarPontuacaoRespostas = false;
        VerificarPontuacaoDesafio = false;
        u.bloqueiapainel(jp_questoes);
        u.bloqueiapainel(jp_respostas);
        u.bloqueiapainel(jp_desafio);
        u.bloqueiapainel(jp_pontuacao);
        u.liberapainel(jp_equipe);
        cb_qst01.setSelectedIndex(0);
        cb_qst02.setSelectedIndex(0);
        cb_qst03.setSelectedIndex(0);
        cb_qst04.setSelectedIndex(0);
        cb_qst05.setSelectedIndex(0);
        cb_qst06.setSelectedIndex(0);
        cb_qst07.setSelectedIndex(0);
        cb_qst08.setSelectedIndex(0);
        cb_qst09.setSelectedIndex(0);
        cb_qst10.setSelectedIndex(0);
        cb_rsp01.setSelectedIndex(0);
        cb_rsp02.setSelectedIndex(0);
        cb_rsp03.setSelectedIndex(0);
        cb_rsp04.setSelectedIndex(0);
        cb_rsp05.setSelectedIndex(0);
        cb_rsp06.setSelectedIndex(0);
        cb_rsp07.setSelectedIndex(0);
        cb_rsp08.setSelectedIndex(0);
        cb_rsp09.setSelectedIndex(0);
        cb_rsp10.setSelectedIndex(0);
        cb_rspdesafio1.setSelectedIndex(0);
        cb_rspdesafio2.setSelectedIndex(0);
        cb_rspdesafio3.setSelectedIndex(0);
        ZerarValoresPontuacao();
    }

    public void ZerarValoresPontuacao() {

        tf_qst01.setText("0");
        tf_qst02.setText("0");
        tf_qst03.setText("0");
        tf_qst04.setText("0");
        tf_qst05.setText("0");
        tf_qst06.setText("0");
        tf_qst07.setText("0");
        tf_qst08.setText("0");
        tf_qst09.setText("0");
        tf_qst10.setText("0");
        tf_rsp01.setText("0");
        tf_rsp02.setText("0");
        tf_rsp03.setText("0");
        tf_rsp04.setText("0");
        tf_rsp05.setText("0");
        tf_rsp06.setText("0");
        tf_rsp07.setText("0");
        tf_rsp08.setText("0");
        tf_rsp09.setText("0");
        tf_rsp10.setText("0");
        tf_rspdesafio01.setText("0");
        tf_rspdesafio02.setText("0");
        tf_rspdesafio03.setText("0");
        tf_pontuacaototalquestoes.setText("0");
        tf_pontuacaototalrespostas.setText("0");
        tf_pontuacaototaldesafio.setText("0");

    }

    public Tela_AjustarPontuacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        PopularCBEquipes();
        BloquearCampos();
        ZerarValoresPontuacao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_equipe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_equipe = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jftf_pontuacaoquestoes = new javax.swing.JFormattedTextField();
        jftf_pontuacaorespostas = new javax.swing.JFormattedTextField();
        jftf_pontuacaodesafio = new javax.swing.JFormattedTextField();
        jftf_pontuacaototal = new javax.swing.JFormattedTextField();
        bt_avancar1 = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        cb_alterarpontuacaorespostas = new javax.swing.JCheckBox();
        cb_alterarpontuacaoquestoes = new javax.swing.JCheckBox();
        cb_alterarpontuacaodesafio = new javax.swing.JCheckBox();
        jp_pontuacao = new javax.swing.JPanel();
        ta_pontuacao = new javax.swing.JTabbedPane();
        jp_questoes = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb_qst01 = new javax.swing.JComboBox<>();
        cb_qst02 = new javax.swing.JComboBox<>();
        cb_qst03 = new javax.swing.JComboBox<>();
        cb_qst04 = new javax.swing.JComboBox<>();
        cb_qst05 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cb_qst06 = new javax.swing.JComboBox<>();
        cb_qst07 = new javax.swing.JComboBox<>();
        cb_qst08 = new javax.swing.JComboBox<>();
        cb_qst09 = new javax.swing.JComboBox<>();
        cb_qst10 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        tf_pontuacaototalquestoes = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        tf_qst01 = new javax.swing.JTextField();
        tf_qst02 = new javax.swing.JTextField();
        tf_qst03 = new javax.swing.JTextField();
        tf_qst04 = new javax.swing.JTextField();
        tf_qst05 = new javax.swing.JTextField();
        tf_qst06 = new javax.swing.JTextField();
        tf_qst07 = new javax.swing.JTextField();
        tf_qst08 = new javax.swing.JTextField();
        tf_qst10 = new javax.swing.JTextField();
        tf_qst09 = new javax.swing.JTextField();
        bt_avancar2 = new javax.swing.JButton();
        bt_voltar1 = new javax.swing.JButton();
        jp_respostas = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cb_rsp01 = new javax.swing.JComboBox<>();
        cb_rsp02 = new javax.swing.JComboBox<>();
        cb_rsp03 = new javax.swing.JComboBox<>();
        cb_rsp04 = new javax.swing.JComboBox<>();
        cb_rsp05 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cb_rsp06 = new javax.swing.JComboBox<>();
        cb_rsp07 = new javax.swing.JComboBox<>();
        cb_rsp08 = new javax.swing.JComboBox<>();
        cb_rsp09 = new javax.swing.JComboBox<>();
        cb_rsp10 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        tf_pontuacaototalrespostas = new javax.swing.JFormattedTextField();
        jSeparator2 = new javax.swing.JSeparator();
        tf_rsp01 = new javax.swing.JTextField();
        tf_rsp02 = new javax.swing.JTextField();
        tf_rsp03 = new javax.swing.JTextField();
        tf_rsp04 = new javax.swing.JTextField();
        tf_rsp05 = new javax.swing.JTextField();
        tf_rsp06 = new javax.swing.JTextField();
        tf_rsp07 = new javax.swing.JTextField();
        tf_rsp08 = new javax.swing.JTextField();
        tf_rsp10 = new javax.swing.JTextField();
        tf_rsp09 = new javax.swing.JTextField();
        bt_avancar3 = new javax.swing.JButton();
        bt_voltar2 = new javax.swing.JButton();
        jp_desafio = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        tf_pontuacaototaldesafio = new javax.swing.JFormattedTextField();
        tf_rspdesafio01 = new javax.swing.JTextField();
        tf_rspdesafio02 = new javax.swing.JTextField();
        tf_rspdesafio03 = new javax.swing.JTextField();
        bt_salvar = new javax.swing.JButton();
        bt_voltar3 = new javax.swing.JButton();
        cb_rspdesafio1 = new javax.swing.JComboBox<>();
        cb_rspdesafio3 = new javax.swing.JComboBox<>();
        cb_rspdesafio2 = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jp_equipe.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Equipe:");

        cb_equipe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_equipeItemStateChanged(evt);
            }
        });

        jLabel2.setText("Nome da Equipe:");

        jLabel3.setText("Pontuação Questões:");

        jLabel4.setText("Pontuação Respostas:");

        jLabel5.setText("Pontuação Desafio:");

        jLabel6.setText("Potuação Total:");

        jftf_pontuacaoquestoes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jftf_pontuacaorespostas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jftf_pontuacaodesafio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        bt_avancar1.setText("AVANÇAR");
        bt_avancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar1ActionPerformed(evt);
            }
        });

        bt_cancelar.setText("CANCELAR");

        cb_alterarpontuacaorespostas.setText("Alterar");
        cb_alterarpontuacaorespostas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_alterarpontuacaorespostasActionPerformed(evt);
            }
        });

        cb_alterarpontuacaoquestoes.setText("Alterar");
        cb_alterarpontuacaoquestoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_alterarpontuacaoquestoesActionPerformed(evt);
            }
        });

        cb_alterarpontuacaodesafio.setText("Alterar");
        cb_alterarpontuacaodesafio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_alterarpontuacaodesafioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_equipeLayout = new javax.swing.GroupLayout(jp_equipe);
        jp_equipe.setLayout(jp_equipeLayout);
        jp_equipeLayout.setHorizontalGroup(
            jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_equipeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jp_equipeLayout.createSequentialGroup()
                        .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_equipeLayout.createSequentialGroup()
                                .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jftf_pontuacaototal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jftf_pontuacaodesafio, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jftf_pontuacaorespostas, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jftf_pontuacaoquestoes, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_alterarpontuacaorespostas)
                                    .addComponent(cb_alterarpontuacaoquestoes)
                                    .addComponent(cb_alterarpontuacaodesafio)))
                            .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cb_equipe, 0, 142, Short.MAX_VALUE)
                                .addComponent(tf_nome))))
                    .addGroup(jp_equipeLayout.createSequentialGroup()
                        .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(bt_avancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jp_equipeLayout.setVerticalGroup(
            jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_equipeLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_equipeLayout.createSequentialGroup()
                        .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_equipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jftf_pontuacaoquestoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_alterarpontuacaoquestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jftf_pontuacaorespostas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_alterarpontuacaorespostas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jftf_pontuacaodesafio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cb_alterarpontuacaodesafio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jftf_pontuacaototal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_equipeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_avancar1)
                    .addComponent(bt_cancelar))
                .addGap(23, 23, 23))
        );

        jp_pontuacao.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setText("Qst 01:");

        jLabel8.setText("Qst 02:");

        jLabel9.setText("Qst 03:");

        jLabel10.setText("Qst 04:");

        jLabel11.setText("Qst 05:");

        cb_qst01.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst01.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst01ItemStateChanged(evt);
            }
        });

        cb_qst02.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst02.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst02ItemStateChanged(evt);
            }
        });

        cb_qst03.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst03.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst03ItemStateChanged(evt);
            }
        });

        cb_qst04.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst04.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst04ItemStateChanged(evt);
            }
        });

        cb_qst05.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst05.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst05ItemStateChanged(evt);
            }
        });

        jLabel12.setText("Qst 06:");

        jLabel13.setText("Qst 07:");

        jLabel14.setText("Qst 08:");

        jLabel15.setText("Qst 09:");

        jLabel16.setText("Qst 10:");

        cb_qst06.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst06.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst06ItemStateChanged(evt);
            }
        });

        cb_qst07.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst07.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst07ItemStateChanged(evt);
            }
        });

        cb_qst08.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst08.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst08ItemStateChanged(evt);
            }
        });

        cb_qst09.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst09.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst09ItemStateChanged(evt);
            }
        });

        cb_qst10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INRRELEVANTE", "POUCO RELEVANTE", "RELEVANTE", "MUITO RELEVANTE", "EXTREMAMENTE RELEVANTE" }));
        cb_qst10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_qst10ItemStateChanged(evt);
            }
        });

        jLabel17.setText("Pontuação Total:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avancar2.setText("AVANÇAR");
        bt_avancar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar2ActionPerformed(evt);
            }
        });

        bt_voltar1.setText("VOLTAR");
        bt_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_questoesLayout = new javax.swing.GroupLayout(jp_questoes);
        jp_questoes.setLayout(jp_questoesLayout);
        jp_questoesLayout.setHorizontalGroup(
            jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_questoesLayout.createSequentialGroup()
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_qst01, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_qst03, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_qst04, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_qst05, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_qst02, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_qst04)
                            .addComponent(tf_qst02, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_qst01, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_qst03, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_qst05, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_questoesLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_pontuacaototalquestoes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jp_questoesLayout.createSequentialGroup()
                        .addComponent(bt_voltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_avancar2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_questoesLayout.createSequentialGroup()
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_qst06, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_qst07, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_qst08, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_qst09, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_qst10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_qst07, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst06, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst08, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst09, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        jp_questoesLayout.setVerticalGroup(
            jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_questoesLayout.createSequentialGroup()
                .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_questoesLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cb_qst01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(cb_qst06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cb_qst02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(cb_qst07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cb_qst03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(cb_qst08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cb_qst04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(cb_qst09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cb_qst05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(cb_qst10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_qst10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(jp_questoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_questoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tf_pontuacaototalquestoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_avancar2)
                    .addComponent(bt_voltar1))
                .addContainerGap())
        );

        ta_pontuacao.addTab("Questões", jp_questoes);

        jLabel18.setText("Rsp 01:");

        jLabel19.setText("Rsp 02:");

        jLabel20.setText("Rsp 03:");

        jLabel21.setText("Rsp 04:");

        jLabel22.setText("Rsp 05:");

        cb_rsp01.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp01.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp01ItemStateChanged(evt);
            }
        });

        cb_rsp02.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp02.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp02ItemStateChanged(evt);
            }
        });

        cb_rsp03.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp03.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp03ItemStateChanged(evt);
            }
        });

        cb_rsp04.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp04.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp04ItemStateChanged(evt);
            }
        });

        cb_rsp05.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp05.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp05ItemStateChanged(evt);
            }
        });

        jLabel23.setText("Rsp 06:");

        jLabel24.setText("Rsp 07:");

        jLabel25.setText("Rsp 08:");

        jLabel26.setText("Rsp 09:");

        jLabel27.setText("Rsp 10:");

        cb_rsp06.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp06.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp06ItemStateChanged(evt);
            }
        });

        cb_rsp07.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp07.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp07ItemStateChanged(evt);
            }
        });

        cb_rsp08.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp08.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp08ItemStateChanged(evt);
            }
        });

        cb_rsp09.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp09.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp09ItemStateChanged(evt);
            }
        });

        cb_rsp10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rsp10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rsp10ItemStateChanged(evt);
            }
        });

        jLabel28.setText("Pontuação Total:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bt_avancar3.setText("AVANÇAR");
        bt_avancar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avancar3ActionPerformed(evt);
            }
        });

        bt_voltar2.setText("VOLTAR");
        bt_voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_respostasLayout = new javax.swing.GroupLayout(jp_respostas);
        jp_respostas.setLayout(jp_respostasLayout);
        jp_respostasLayout.setHorizontalGroup(
            jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_respostasLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_respostasLayout.createSequentialGroup()
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_rsp01, 0, 147, Short.MAX_VALUE)
                            .addComponent(cb_rsp03, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_rsp04, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_rsp05, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_rsp02, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_rsp04)
                            .addComponent(tf_rsp02, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_rsp01, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_rsp03, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_rsp05, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jp_respostasLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_pontuacaototalrespostas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_respostasLayout.createSequentialGroup()
                        .addComponent(bt_voltar2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(bt_avancar3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_respostasLayout.createSequentialGroup()
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_rsp06, 0, 147, Short.MAX_VALUE)
                            .addComponent(cb_rsp08, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_rsp09, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_rsp10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_rsp07, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_rsp07, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp06, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp08, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp09, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        jp_respostasLayout.setVerticalGroup(
            jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_respostasLayout.createSequentialGroup()
                .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_respostasLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(cb_rsp01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(cb_rsp06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cb_rsp02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(cb_rsp07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cb_rsp03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(cb_rsp08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cb_rsp04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(cb_rsp09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(cb_rsp05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(cb_rsp10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rsp10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(jp_respostasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_respostasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(tf_pontuacaototalrespostas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_avancar3)
                    .addComponent(bt_voltar2))
                .addContainerGap())
        );

        ta_pontuacao.addTab("Respostas", jp_respostas);

        jLabel29.setText("Qst Desafio 01:");

        jLabel30.setText("Qst Desafio 02:");

        jLabel31.setText("Qst Desafio 03:");

        jLabel39.setText("Pontuação Total:");

        bt_salvar.setText("SALVAR");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_voltar3.setText("VOLTAR");
        bt_voltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltar3ActionPerformed(evt);
            }
        });

        cb_rspdesafio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rspdesafio1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rspdesafio1ItemStateChanged(evt);
            }
        });

        cb_rspdesafio3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rspdesafio3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rspdesafio3ItemStateChanged(evt);
            }
        });

        cb_rspdesafio2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Resposta", "Resposta Errada", "Resposta Incompleta", "Resposta Correta" }));
        cb_rspdesafio2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_rspdesafio2ItemStateChanged(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jp_desafioLayout = new javax.swing.GroupLayout(jp_desafio);
        jp_desafio.setLayout(jp_desafioLayout);
        jp_desafioLayout.setHorizontalGroup(
            jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_desafioLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30))
                        .addComponent(jLabel29))
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_desafioLayout.createSequentialGroup()
                        .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cb_rspdesafio2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_rspdesafio1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_rspdesafio3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_rspdesafio02, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rspdesafio01, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rspdesafio03, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tf_pontuacaototaldesafio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(bt_voltar3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jp_desafioLayout.setVerticalGroup(
            jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_desafioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_desafioLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_salvar)
                            .addComponent(bt_voltar3)))
                    .addComponent(jSeparator4))
                .addContainerGap())
            .addGroup(jp_desafioLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(tf_rspdesafio01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_rspdesafio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(tf_rspdesafio02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_rspdesafio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(tf_rspdesafio03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_rspdesafio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_desafioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(tf_pontuacaototaldesafio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 74, Short.MAX_VALUE))
        );

        ta_pontuacao.addTab("Desafio", jp_desafio);

        javax.swing.GroupLayout jp_pontuacaoLayout = new javax.swing.GroupLayout(jp_pontuacao);
        jp_pontuacao.setLayout(jp_pontuacaoLayout);
        jp_pontuacaoLayout.setHorizontalGroup(
            jp_pontuacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_pontuacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ta_pontuacao)
                .addContainerGap())
        );
        jp_pontuacaoLayout.setVerticalGroup(
            jp_pontuacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_pontuacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ta_pontuacao)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_equipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_pontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jp_pontuacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_equipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_equipeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_equipeItemStateChanged
        if (cb_equipe.getItemCount() > 0 && listaIdEquipes.size() > 0) {
            Equipe e = new Equipe();
            ewdao.BuscarEquipe(e, listaIdEquipes.get(cb_equipe.getSelectedIndex()));
            tf_nome.setText(e.getNomeEquipe());
            jftf_pontuacaoquestoes.setText(String.valueOf(e.getPontuacao_Questoes()));
            jftf_pontuacaorespostas.setText(String.valueOf(e.getPontuacao_Respostas()));
            jftf_pontuacaodesafio.setText(String.valueOf(e.getPontuacao_Desafios()));
            jftf_pontuacaototal.setText(String.valueOf(e.getPontuacao_Questoes() + e.getPontuacao_Respostas() + e.getPontuacao_Desafios()));

        }
    }//GEN-LAST:event_cb_equipeItemStateChanged

    private void cb_alterarpontuacaoquestoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_alterarpontuacaoquestoesActionPerformed
        if (cb_alterarpontuacaoquestoes.isSelected()) {
            jftf_pontuacaoquestoes.setEditable(true);
        } else {
            jftf_pontuacaoquestoes.setEditable(false);
        }
    }//GEN-LAST:event_cb_alterarpontuacaoquestoesActionPerformed

    private void cb_alterarpontuacaorespostasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_alterarpontuacaorespostasActionPerformed
        if (cb_alterarpontuacaorespostas.isSelected()) {
            jftf_pontuacaorespostas.setEditable(true);
        } else {
            jftf_pontuacaorespostas.setEditable(false);
        }
    }//GEN-LAST:event_cb_alterarpontuacaorespostasActionPerformed

    private void cb_alterarpontuacaodesafioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_alterarpontuacaodesafioActionPerformed
        if (cb_alterarpontuacaodesafio.isSelected()) {
            jftf_pontuacaodesafio.setEditable(true);
        } else {
            jftf_pontuacaodesafio.setEditable(false);
        }
    }//GEN-LAST:event_cb_alterarpontuacaodesafioActionPerformed

    private void bt_avancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar1ActionPerformed
        AvancarQuestoes();
        AvancarRespostas();
        AvancarDesafio();
    }//GEN-LAST:event_bt_avancar1ActionPerformed

    private void cb_qst01ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst01ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst01.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst01.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst01ItemStateChanged

    private void cb_qst02ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst02ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst02.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst02.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst02ItemStateChanged

    private void cb_qst03ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst03ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst03.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst03.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst03ItemStateChanged

    private void cb_qst04ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst04ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst04.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst04.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst04ItemStateChanged

    private void cb_qst05ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst05ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst05.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst05.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst05ItemStateChanged

    private void cb_qst06ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst06ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst06.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst06.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst06ItemStateChanged

    private void cb_qst07ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst07ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst07.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst07.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst07ItemStateChanged

    private void cb_qst08ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst08ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst08.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst08.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst08ItemStateChanged

    private void cb_qst09ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst09ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst09.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst09.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst09ItemStateChanged

    private void cb_qst10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_qst10ItemStateChanged
        if (VerificarPontuacaoQuestoes) {
            tf_qst10.setText(String.valueOf(cp.VerificarPontuacaoQualificacaoQuestao(cb_qst10.getSelectedItem().toString())));
            SomarPontuacaoQuestoes();
        }
    }//GEN-LAST:event_cb_qst10ItemStateChanged

    private void cb_rsp01ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp01ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp01.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp01.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp01ItemStateChanged

    private void cb_rsp02ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp02ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp02.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp02.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp02ItemStateChanged

    private void cb_rsp03ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp03ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp03.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp03.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp03ItemStateChanged

    private void cb_rsp04ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp04ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp04.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp04.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp04ItemStateChanged

    private void cb_rsp05ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp05ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp05.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp05.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp05ItemStateChanged

    private void cb_rsp06ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp06ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp06.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp06.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp06ItemStateChanged

    private void cb_rsp07ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp07ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp07.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp07.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp07ItemStateChanged

    private void cb_rsp08ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp08ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp08.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp08.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp08ItemStateChanged

    private void cb_rsp09ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp09ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp09.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp09.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp09ItemStateChanged

    private void cb_rsp10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rsp10ItemStateChanged
        if (VerificarPontuacaoRespostas) {
            tf_rsp10.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rsp10.getSelectedItem().toString())));
            SomarPontuacaoRespostas();
        }
    }//GEN-LAST:event_cb_rsp10ItemStateChanged

    private void cb_rspdesafio1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rspdesafio1ItemStateChanged
        if (VerificarPontuacaoDesafio) {
            tf_rspdesafio01.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rspdesafio1.getSelectedItem().toString())));
            SomarPontuacaoDesafio();
        }
    }//GEN-LAST:event_cb_rspdesafio1ItemStateChanged

    private void cb_rspdesafio2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rspdesafio2ItemStateChanged
        if (VerificarPontuacaoDesafio) {
            tf_rspdesafio02.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rspdesafio2.getSelectedItem().toString())));
            SomarPontuacaoDesafio();
        }
    }//GEN-LAST:event_cb_rspdesafio2ItemStateChanged

    private void cb_rspdesafio3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_rspdesafio3ItemStateChanged
        if (VerificarPontuacaoDesafio) {
            tf_rspdesafio03.setText(String.valueOf(cp.VerificarPontuacaoResposta(cb_rspdesafio3.getSelectedItem().toString())));
            SomarPontuacaoDesafio();
        }
    }//GEN-LAST:event_cb_rspdesafio3ItemStateChanged

    private void bt_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar1ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja Voltar?", "Voltar", 2) == 0) {
            VoltarPainelEquipes();
        }
    }//GEN-LAST:event_bt_voltar1ActionPerformed

    private void bt_avancar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar2ActionPerformed
        ta_pontuacao.setEnabledAt(0, false);
        ta_pontuacao.setEnabledAt(1, true);
        ta_pontuacao.setSelectedIndex(1);
    }//GEN-LAST:event_bt_avancar2ActionPerformed

    private void bt_voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar2ActionPerformed
        ta_pontuacao.setEnabledAt(1, false);
        ta_pontuacao.setEnabledAt(0, true);
        ta_pontuacao.setSelectedIndex(0);
    }//GEN-LAST:event_bt_voltar2ActionPerformed

    private void bt_avancar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avancar3ActionPerformed
        ta_pontuacao.setEnabledAt(1, false);
        ta_pontuacao.setEnabledAt(2, true);
        ta_pontuacao.setSelectedIndex(2);
    }//GEN-LAST:event_bt_avancar3ActionPerformed

    private void bt_voltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltar3ActionPerformed
        ta_pontuacao.setEnabledAt(2, false);
        ta_pontuacao.setEnabledAt(1, true);
        ta_pontuacao.setSelectedIndex(1);
    }//GEN-LAST:event_bt_voltar3ActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        
        //QUESTOES
        if(VerificarPontuacaoQuestoes){
        Questao questao;
        
        //ATUALIZAR QUESTOES 01
        questao = listaQuestoes.get(0);
        questao.setQualificacao_Questao(cb_qst01.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 02
        questao = listaQuestoes.get(1);
        questao.setQualificacao_Questao(cb_qst02.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 03
        questao = listaQuestoes.get(2);
        questao.setQualificacao_Questao(cb_qst03.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 04
        questao = listaQuestoes.get(3);
        questao.setQualificacao_Questao(cb_qst04.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 05
        questao = listaQuestoes.get(4);
        questao.setQualificacao_Questao(cb_qst05.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 06
        questao = listaQuestoes.get(5);
        questao.setQualificacao_Questao(cb_qst06.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 07
        questao = listaQuestoes.get(6);
        questao.setQualificacao_Questao(cb_qst07.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 08
        questao = listaQuestoes.get(7);
        questao.setQualificacao_Questao(cb_qst08.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 09
        questao = listaQuestoes.get(8);
        questao.setQualificacao_Questao(cb_qst09.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        //ATUALIZAR QUESTOES 10
        questao = listaQuestoes.get(9);
        questao.setQualificacao_Questao(cb_qst10.getSelectedItem().toString());
        qwdao.AtualizarQuestao(questao);
        
        equipe.setPontuacao_Questoes(Integer.parseInt(tf_pontuacaototalquestoes.getText()));
        }
        
        //RESPOSTAS
        
        if(VerificarPontuacaoRespostas){
        Resposta resposta;
        
        //ATUALIZAR RESPOSTA 01
        resposta = listaResposta.get(0);
        resposta.setNota_Resposta(cb_rsp01.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 02
        resposta = listaResposta.get(1);
        resposta.setNota_Resposta(cb_rsp02.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 03
        resposta = listaResposta.get(2);
        resposta.setNota_Resposta(cb_rsp03.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 04
        resposta = listaResposta.get(3);
        resposta.setNota_Resposta(cb_rsp04.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 05
        resposta = listaResposta.get(4);
        resposta.setNota_Resposta(cb_rsp05.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 06
        resposta = listaResposta.get(5);
        resposta.setNota_Resposta(cb_rsp06.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 07
        resposta = listaResposta.get(6);
        resposta.setNota_Resposta(cb_rsp07.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 08
        resposta = listaResposta.get(7);
        resposta.setNota_Resposta(cb_rsp08.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 09
        resposta = listaResposta.get(8);
        resposta.setNota_Resposta(cb_rsp09.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        //ATUALIZAR RESPOSTA 10
        resposta = listaResposta.get(9);
        resposta.setNota_Resposta(cb_rsp10.getSelectedItem().toString());
        rwdao.AtualizarResposta(resposta);
        
        equipe.setPontuacao_Respostas(Integer.parseInt(tf_pontuacaototalrespostas.getText()));
        }
        
        if(VerificarPontuacaoDesafio){
        //RESPOSTA_QUESTAO_DESAFIO
        
         Resposta_Questao_Desafio resposta_questao_desafio;
        
        //ATUALIZAR RESPOSTA_QUESTAO_DESAFIO 01
        resposta_questao_desafio = listaResposta_Questao_Desafio.get(0);
        resposta_questao_desafio.setNota_Questao_Desafio(cb_rspdesafio1.getSelectedItem().toString());
        rqdwdao.AtualizarResposta(resposta_questao_desafio);
        
        //ATUALIZAR RESPOSTA_QUESTAO_DESAFIO 02
        resposta_questao_desafio = listaResposta_Questao_Desafio.get(1);
        resposta_questao_desafio.setNota_Questao_Desafio(cb_rspdesafio2.getSelectedItem().toString());
        rqdwdao.AtualizarResposta(resposta_questao_desafio);
        
        //ATUALIZAR RESPOSTA_QUESTAO_DESAFIO 03
        resposta_questao_desafio = listaResposta_Questao_Desafio.get(2);
        resposta_questao_desafio.setNota_Questao_Desafio(cb_rspdesafio3.getSelectedItem().toString());
        rqdwdao.AtualizarResposta(resposta_questao_desafio);
        
        equipe.setPontuacao_Desafios(Integer.parseInt(tf_pontuacaototaldesafio.getText()));
        }
        
        ewdao.AtualizarPontuacaoEquipe(equipe);
        
        JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        VoltarPainelEquipes();
        ta_pontuacao.setEnabledAt(2, false);
        ta_pontuacao.setEnabledAt(0, true);
        ta_pontuacao.setSelectedIndex(0);
        PopularCBEquipes();
        
    }//GEN-LAST:event_bt_salvarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_AjustarPontuacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_AjustarPontuacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_AjustarPontuacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_AjustarPontuacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela_AjustarPontuacao dialog = new Tela_AjustarPontuacao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_avancar1;
    private javax.swing.JButton bt_avancar2;
    private javax.swing.JButton bt_avancar3;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton bt_voltar1;
    private javax.swing.JButton bt_voltar2;
    private javax.swing.JButton bt_voltar3;
    private javax.swing.JCheckBox cb_alterarpontuacaodesafio;
    private javax.swing.JCheckBox cb_alterarpontuacaoquestoes;
    private javax.swing.JCheckBox cb_alterarpontuacaorespostas;
    private javax.swing.JComboBox<Object> cb_equipe;
    private javax.swing.JComboBox<String> cb_qst01;
    private javax.swing.JComboBox<String> cb_qst02;
    private javax.swing.JComboBox<String> cb_qst03;
    private javax.swing.JComboBox<String> cb_qst04;
    private javax.swing.JComboBox<String> cb_qst05;
    private javax.swing.JComboBox<String> cb_qst06;
    private javax.swing.JComboBox<String> cb_qst07;
    private javax.swing.JComboBox<String> cb_qst08;
    private javax.swing.JComboBox<String> cb_qst09;
    private javax.swing.JComboBox<String> cb_qst10;
    private javax.swing.JComboBox<String> cb_rsp01;
    private javax.swing.JComboBox<String> cb_rsp02;
    private javax.swing.JComboBox<String> cb_rsp03;
    private javax.swing.JComboBox<String> cb_rsp04;
    private javax.swing.JComboBox<String> cb_rsp05;
    private javax.swing.JComboBox<String> cb_rsp06;
    private javax.swing.JComboBox<String> cb_rsp07;
    private javax.swing.JComboBox<String> cb_rsp08;
    private javax.swing.JComboBox<String> cb_rsp09;
    private javax.swing.JComboBox<String> cb_rsp10;
    private javax.swing.JComboBox<String> cb_rspdesafio1;
    private javax.swing.JComboBox<String> cb_rspdesafio2;
    private javax.swing.JComboBox<String> cb_rspdesafio3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JFormattedTextField jftf_pontuacaodesafio;
    private javax.swing.JFormattedTextField jftf_pontuacaoquestoes;
    private javax.swing.JFormattedTextField jftf_pontuacaorespostas;
    private javax.swing.JFormattedTextField jftf_pontuacaototal;
    private javax.swing.JPanel jp_desafio;
    private javax.swing.JPanel jp_equipe;
    private javax.swing.JPanel jp_pontuacao;
    private javax.swing.JPanel jp_questoes;
    private javax.swing.JPanel jp_respostas;
    private javax.swing.JTabbedPane ta_pontuacao;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JFormattedTextField tf_pontuacaototaldesafio;
    private javax.swing.JFormattedTextField tf_pontuacaototalquestoes;
    private javax.swing.JFormattedTextField tf_pontuacaototalrespostas;
    private javax.swing.JTextField tf_qst01;
    private javax.swing.JTextField tf_qst02;
    private javax.swing.JTextField tf_qst03;
    private javax.swing.JTextField tf_qst04;
    private javax.swing.JTextField tf_qst05;
    private javax.swing.JTextField tf_qst06;
    private javax.swing.JTextField tf_qst07;
    private javax.swing.JTextField tf_qst08;
    private javax.swing.JTextField tf_qst09;
    private javax.swing.JTextField tf_qst10;
    private javax.swing.JTextField tf_rsp01;
    private javax.swing.JTextField tf_rsp02;
    private javax.swing.JTextField tf_rsp03;
    private javax.swing.JTextField tf_rsp04;
    private javax.swing.JTextField tf_rsp05;
    private javax.swing.JTextField tf_rsp06;
    private javax.swing.JTextField tf_rsp07;
    private javax.swing.JTextField tf_rsp08;
    private javax.swing.JTextField tf_rsp09;
    private javax.swing.JTextField tf_rsp10;
    private javax.swing.JTextField tf_rspdesafio01;
    private javax.swing.JTextField tf_rspdesafio02;
    private javax.swing.JTextField tf_rspdesafio03;
    // End of variables declaration//GEN-END:variables
}
