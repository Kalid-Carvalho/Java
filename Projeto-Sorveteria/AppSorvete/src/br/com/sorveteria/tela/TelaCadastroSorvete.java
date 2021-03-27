package br.com.sorveteria.tela;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import br.com.sorveteria.dal.ModuloConexao;
import javax.swing.JOptionPane;

public class TelaCadastroSorvete extends javax.swing.JInternalFrame {

    /*Criando variaveis especiais para conexão com o banco de dados
      PreparedStatement e ResultSet são frameworks do pacote java.sql
      e serve para preparar e executar as instruções sql
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCadastroSorvete() {
        initComponents();

        conexao = ModuloConexao.conector();
    }

    private void consultar() {
        String sql = "Select * from tb_sorvetes where codigo_sorvete =?";
        try {
            //setando a interrogação da query
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtSorvID.getText());
            rs = pst.executeQuery();
            //if else para caso consiga retornar a query corretamente ou caso não consiga retornar a query
            if (rs.next()) {
                //prenche os campos da tela cadastro de usuário
                txtSorvDescricao.setText(rs.getString(2));
                txtSorvPreco.setText(rs.getString(3));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado !");
                //as linhas abaixo "Limpam" os campos
                txtSorvDescricao.setText(null);
                txtSorvPreco.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadastroSorvetes = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        txtSorvDescricao = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSorvID = new javax.swing.JTextField();
        btnSorvAdicionar = new javax.swing.JButton();
        btnSorvProcurar = new javax.swing.JButton();
        bntSorvAlterar = new javax.swing.JButton();
        btnSorvExcluir = new javax.swing.JButton();
        txtSorvPreco = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro Sorvetes");

        lblDescricao.setText("Descrição");

        lblPreco.setText("Preço:");

        jLabel1.setText("ID:");

        btnSorvAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/insert.png"))); // NOI18N
        btnSorvAdicionar.setToolTipText("Adicionar usuário");
        btnSorvAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSorvAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));

        btnSorvProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/read.png"))); // NOI18N
        btnSorvProcurar.setToolTipText("Procurar usuário");
        btnSorvProcurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSorvProcurar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSorvProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSorvProcurarActionPerformed(evt);
            }
        });

        bntSorvAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/update.png"))); // NOI18N
        bntSorvAlterar.setToolTipText("Alterar Usuário");
        bntSorvAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntSorvAlterar.setPreferredSize(new java.awt.Dimension(80, 80));

        btnSorvExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/imagens/delete.png"))); // NOI18N
        btnSorvExcluir.setToolTipText("Remover usuário");
        btnSorvExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSorvExcluir.setPreferredSize(new java.awt.Dimension(80, 80));

        try {
            txtSorvPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanelCadastroSorvetesLayout = new javax.swing.GroupLayout(jPanelCadastroSorvetes);
        jPanelCadastroSorvetes.setLayout(jPanelCadastroSorvetesLayout);
        jPanelCadastroSorvetesLayout.setHorizontalGroup(
            jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                .addGroup(jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(lblPreco)
                            .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSorvDescricao)
                            .addComponent(txtSorvPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                            .addComponent(txtSorvID, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnSorvAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnSorvProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(bntSorvAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnSorvExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanelCadastroSorvetesLayout.setVerticalGroup(
            jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(txtSorvID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSorvDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSorvPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSorvExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSorvAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSorvProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSorvAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadastroSorvetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCadastroSorvetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 610, 495);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSorvProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSorvProcurarActionPerformed
        consultar();
    }//GEN-LAST:event_btnSorvProcurarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSorvAlterar;
    private javax.swing.JButton btnSorvAdicionar;
    private javax.swing.JButton btnSorvExcluir;
    private javax.swing.JButton btnSorvProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelCadastroSorvetes;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JTextField txtSorvDescricao;
    private javax.swing.JTextField txtSorvID;
    private javax.swing.JFormattedTextField txtSorvPreco;
    // End of variables declaration//GEN-END:variables
}
