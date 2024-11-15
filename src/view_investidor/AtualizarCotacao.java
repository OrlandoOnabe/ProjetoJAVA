/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view_investidor;

import controller_investidor.ControllerCotacao_Investidor;
import javax.swing.JRadioButton;

/**
 *
 * @author xblak
 */
public class AtualizarCotacao extends javax.swing.JFrame {

    /**
     * Creates new form AtualizarCotacao
     */
    public AtualizarCotacao() {
        initComponents();
        c = new ControllerCotacao_Investidor(this);
    }

    public JRadioButton getBtBitcoin() {
        return btBitcoin;
    }

    public void setBtBitcoin(JRadioButton btBitcoin) {
        this.btBitcoin = btBitcoin;
    }

    public JRadioButton getBtEthereum() {
        return btEthereum;
    }

    public void setBtEthereum(JRadioButton btEthereum) {
        this.btEthereum = btEthereum;
    }

    public JRadioButton getBtRipple() {
        return btRipple;
    }

    public void setBtRipple(JRadioButton btRipple) {
        this.btRipple = btRipple;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btRipple = new javax.swing.JRadioButton();
        btEthereum = new javax.swing.JRadioButton();
        btBitcoin = new javax.swing.JRadioButton();
        btAtualizar = new javax.swing.JButton();
        btMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btRipple.setText("Ripple");

        btEthereum.setText("Ethereum");

        btBitcoin.setText("Bitcoin");

        btAtualizar.setText("ATUALIZAR");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btMenu.setText("MENU");
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btBitcoin)
                            .addComponent(btEthereum)
                            .addComponent(btRipple)
                            .addComponent(btAtualizar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btMenu)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btMenu)
                .addGap(25, 25, 25)
                .addComponent(btBitcoin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRipple)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEthereum)
                .addGap(56, 56, 56)
                .addComponent(btAtualizar)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        c.atualizaCotacao();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        Menu_Investidor mi = new Menu_Investidor();
        this.setVisible(false);
        mi.setVisible(true);
    }//GEN-LAST:event_btMenuActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AtualizarCotacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AtualizarCotacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AtualizarCotacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AtualizarCotacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AtualizarCotacao().setVisible(true);
//            }
//        });
//    }
    private ControllerCotacao_Investidor c;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JRadioButton btBitcoin;
    private javax.swing.JRadioButton btEthereum;
    private javax.swing.JButton btMenu;
    private javax.swing.JRadioButton btRipple;
    // End of variables declaration//GEN-END:variables
}
