package br.com.sorveteria.tela;

import java.awt.Desktop;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;


public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        menuVendasSorvete = new javax.swing.JMenuBar();
        menModulo = new javax.swing.JMenu();
        menModuloCadastroUsuario = new javax.swing.JMenuItem();
        menModuloCadastrarCliente = new javax.swing.JMenuItem();
        menModuloCadastrarSorvete = new javax.swing.JMenuItem();
        menModuloVenderSorvetes = new javax.swing.JMenuItem();
        menRelatorio = new javax.swing.JMenu();
        menRelatorioSorvete = new javax.swing.JMenuItem();
        menRelatorioCliente = new javax.swing.JMenuItem();
        menAjuda = new javax.swing.JMenu();
        menAjudaSobre = new javax.swing.JMenuItem();
        menOpcoes = new javax.swing.JMenu();
        menOpcoesSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sorveteria - Tela Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(610, 495));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblUsuario.setText("Usuário");

        lblData.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblData.setText("Data");

        menModulo.setText("Módulos");
        menModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menModuloActionPerformed(evt);
            }
        });

        menModuloCadastroUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        menModuloCadastroUsuario.setText("Usuário");
        menModuloCadastroUsuario.setEnabled(false);
        menModuloCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menModuloCadastroUsuarioActionPerformed(evt);
            }
        });
        menModulo.add(menModuloCadastroUsuario);

        menModuloCadastrarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menModuloCadastrarCliente.setText("Cliente");
        menModuloCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menModuloCadastrarClienteActionPerformed(evt);
            }
        });
        menModulo.add(menModuloCadastrarCliente);

        menModuloCadastrarSorvete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menModuloCadastrarSorvete.setText("Sorvete");
        menModuloCadastrarSorvete.setEnabled(false);
        menModuloCadastrarSorvete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menModuloCadastrarSorveteActionPerformed(evt);
            }
        });
        menModulo.add(menModuloCadastrarSorvete);

        menModuloVenderSorvetes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.SHIFT_MASK));
        menModuloVenderSorvetes.setText("Vender Sorvete");
        menModulo.add(menModuloVenderSorvetes);

        menuVendasSorvete.add(menModulo);

        menRelatorio.setText("Relatório");

        menRelatorioSorvete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        menRelatorioSorvete.setText("Sorvete");
        menRelatorioSorvete.setEnabled(false);
        menRelatorio.add(menRelatorioSorvete);

        menRelatorioCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        menRelatorioCliente.setText("Cliente");
        menRelatorioCliente.setEnabled(false);
        menRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelatorioClienteActionPerformed(evt);
            }
        });
        menRelatorio.add(menRelatorioCliente);

        menuVendasSorvete.add(menRelatorio);

        menAjuda.setText("Ajuda");

        menAjudaSobre.setText("Sobre");
        menAjudaSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAjudaSobreActionPerformed(evt);
            }
        });
        menAjuda.add(menAjudaSobre);

        menuVendasSorvete.add(menAjuda);

        menOpcoes.setText("Opções");

        menOpcoesSair.setText("Sair");
        menOpcoesSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpcoesSairActionPerformed(evt);
            }
        });
        menOpcoes.add(menOpcoesSair);

        menuVendasSorvete.add(menOpcoes);

        setJMenuBar(menuVendasSorvete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblData))
                .addGap(0, 94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(lblData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(805, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menModuloCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menModuloCadastrarClienteActionPerformed
        // Criando variavel de referencia telaCadUser
        TelaCadastroCliente telaCadUser = new TelaCadastroCliente();
        // Adicionando telaCadUser ao Painel da area de trabalho
        jDesktopPane1.add(telaCadUser);
        // Mostrando a tela de cadastro ao clicar em cadastrar cliente.
        telaCadUser.setVisible(true);
    }//GEN-LAST:event_menModuloCadastrarClienteActionPerformed

    private void menModuloCadastrarSorveteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menModuloCadastrarSorveteActionPerformed
        TelaCadastroSorvete telaCadSorvete = new TelaCadastroSorvete();
        jDesktopPane1.add(telaCadSorvete);
        telaCadSorvete.setVisible(true);
    }//GEN-LAST:event_menModuloCadastrarSorveteActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //Botando data para aparecer automatico quando iniciar o sistema
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void menRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelatorioClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menRelatorioClienteActionPerformed

    private void menOpcoesSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpcoesSairActionPerformed
        //Exibe uma caixa de diálogo
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção !", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menOpcoesSairActionPerformed

    private void menModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menModuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menModuloActionPerformed

    private void menAjudaSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAjudaSobreActionPerformed
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_menAjudaSobreActionPerformed

    private void menModuloCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menModuloCadastroUsuarioActionPerformed
        TelaCadastroUsuario telaCadUser = new TelaCadastroUsuario();
        telaCadUser.setVisible(true);
        jDesktopPane1.add(telaCadUser);
    }//GEN-LAST:event_menModuloCadastroUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAjuda;
    private javax.swing.JMenuItem menAjudaSobre;
    private javax.swing.JMenu menModulo;
    private javax.swing.JMenuItem menModuloCadastrarCliente;
    public static javax.swing.JMenuItem menModuloCadastrarSorvete;
    public static javax.swing.JMenuItem menModuloCadastroUsuario;
    private javax.swing.JMenuItem menModuloVenderSorvetes;
    private javax.swing.JMenu menOpcoes;
    private javax.swing.JMenuItem menOpcoesSair;
    private javax.swing.JMenu menRelatorio;
    public static javax.swing.JMenuItem menRelatorioCliente;
    public static javax.swing.JMenuItem menRelatorioSorvete;
    private javax.swing.JMenuBar menuVendasSorvete;
    // End of variables declaration//GEN-END:variables
}
