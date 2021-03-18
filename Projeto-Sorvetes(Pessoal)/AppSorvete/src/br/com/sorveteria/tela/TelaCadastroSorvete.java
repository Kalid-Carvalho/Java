/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.tela;

import java.awt.Dimension;

/**
 *
 * @author KCSilva
 */
public class TelaCadastroSorvete extends javax.swing.JInternalFrame {

    /**
     * Creates new form telaCadastroSorvete
     */
    public TelaCadastroSorvete() {
        initComponents();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadastroSorvetes = new javax.swing.JPanel();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastro Sorvetes");

        lblDescricao.setText("Descrição");

        lblPreco.setText("Preço:");

        btnSalvar.setText("Salvar");

        lblQuantidade.setText("Quantidade:");

        javax.swing.GroupLayout jPanelCadastroSorvetesLayout = new javax.swing.GroupLayout(jPanelCadastroSorvetes);
        jPanelCadastroSorvetes.setLayout(jPanelCadastroSorvetesLayout);
        jPanelCadastroSorvetesLayout.setHorizontalGroup(
            jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantidade)
                            .addComponent(lblPreco)
                            .addComponent(lblDescricao)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCadastroSorvetesLayout.setVerticalGroup(
            jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPreco)
                .addGroup(jPanelCadastroSorvetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addContainerGap())
                    .addGroup(jPanelCadastroSorvetesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadastroSorvetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCadastroSorvetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanelCadastroSorvetes;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
