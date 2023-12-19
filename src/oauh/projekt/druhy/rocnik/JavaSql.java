package oauh.projekt.druhy.rocnik;

import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;

public class JavaSql extends javax.swing.JFrame {
    Connection con = null;
    Statement stat = null;
    ResultSet resSet = null;
    private String databaseName ;
    private String tableName;

    public JavaSql(String databaseName, String tableName){
        this.databaseName = databaseName;
        this.tableName = tableName;
        initComponents();
        SelectAll();
        setVisible(true);

    }
    private void SelectAll(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.databaseName, "root", "");
            stat = con.createStatement();
            resSet = stat.executeQuery(("Select * from " + this.tableName));
            table.setModel(DbUtils.resultSetToTableModel(resSet));
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        SurnameTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "First Name", "Last Name"
            }
        ));

        jScrollPane1.setViewportView(table);

        jLabel1.setText("id");

        jLabel2.setText("First name");

        jLabel3.setText("Last name");

        idTxt.setText("");
        idTxt.setPreferredSize(new Dimension(100, 20));

        nameTxt.setText("");
        nameTxt.setPreferredSize(new Dimension(100, 20));

        SurnameTxt.setText("");
        SurnameTxt.setPreferredSize(new Dimension(100, 20));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SurnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SurnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private boolean isIdInDatabase(String id) throws SQLException {
        String query = ("SELECT COUNT(*) FROM " + this.tableName + " WHERE id = ?");
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = idTxt.getText();
            String name = nameTxt.getText();
            String surname = SurnameTxt.getText();

            if (!isIdInDatabase(id)) {
                PreparedStatement add = con.prepareStatement(("INSERT INTO " + this.tableName + " VALUES (?, ?, ?)"));
                add.setString(1, id);
                add.setString(2, name);
                add.setString(3, surname);
                int row = add.executeUpdate();
                SelectAll();
            } else {
                JOptionPane.showMessageDialog(null, "This id is already used. Try a different one.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        SelectAll();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            String sql="update " + this.tableName + " set first_name = '"+nameTxt.getText()+"'"+", last_name = '"+SurnameTxt.getText()+"'"+"where id = "+idTxt.getText();
            Statement update = con.createStatement();
            update.executeUpdate(sql);
        } catch (SQLException E) {
            throw new RuntimeException();
        }
        SelectAll();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String sql=("Delete from " + this.tableName + " where id ="+idTxt.getText());
            Statement add= con.createStatement();
            add.executeUpdate(sql);
            idTxt.setText("");
            nameTxt.setText("");
            SurnameTxt.setText("");
        }
        catch (SQLException E){
            throw new RuntimeException();
        }
        SelectAll();
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField SurnameTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTable table;
    // End of variables declaration
}
