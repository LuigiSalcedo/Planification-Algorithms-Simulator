package planificationalgorithms.views;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import planificationalgorithms.models.Process;
import planificationalgorithms.controllers.ProcessesController;

/**
 *
 * @author Luigi Salcedo
 */
public class MainView extends javax.swing.JFrame {
    private static ProcessesController controller;
    
    public MainView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        algorithmLabel = new javax.swing.JLabel();
        algorithmValue = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTable = new javax.swing.JTable();
        inputLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTable = new javax.swing.JTable();
        inputLabel1 = new javax.swing.JLabel();
        executeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titlePanel.setBackground(new java.awt.Color(51, 51, 51));

        titleLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Planification Algorithm Simulator");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        algorithmLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        algorithmLabel.setText("Algorithm:");

        algorithmValue.setBackground(new java.awt.Color(204, 204, 204));
        algorithmValue.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        algorithmValue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIFO", "SJF", "SRTF", "PRIORITY" }));
        algorithmValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        inputTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        inputTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        inputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Process name", "Time of arrival", "Time of CPU", "Priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(inputTable);

        inputLabel.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        inputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inputLabel.setText("Input");

        outputTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        outputTable.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        outputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Process name", "Time of start", "Time of end", "Time waiting"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(outputTable);

        inputLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        inputLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inputLabel1.setText("Output");

        executeButton.setBackground(new java.awt.Color(215, 224, 244));
        executeButton.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        executeButton.setText("Execute");
        executeButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(algorithmLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(algorithmValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(executeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(inputLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algorithmLabel)
                    .addComponent(algorithmValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(executeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLabel1)
                    .addComponent(inputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void executeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeButtonActionPerformed
      HashMap<Integer, Process> timeline = new HashMap<>();
      var model = inputTable.getModel();
      
      for(int i = 0; i < 11; i++) {
          if(model.getValueAt(i, 0) == null) {
              continue;
          }
          if(((String)(model.getValueAt(i, 0))).isEmpty()) {
              continue;
          }
          if(timeline.containsKey((Integer)model.getValueAt(i, 1))) {
              JOptionPane.showMessageDialog(null, 
                      "Two process can not arrive at the same time.",
                      "Monoprocessor constrain violation.",
                      JOptionPane.ERROR_MESSAGE);
              return;
          }
          timeline.put((Integer)model.getValueAt(i, 1), new Process(
                  (String)model.getValueAt(i, 0),
                  (Integer)model.getValueAt(i, 1),
                  (Integer)model.getValueAt(i, 2),
                  (Integer)model.getValueAt(i, 3)
          ));
      }
      if(timeline.size() <= 1) {
          JOptionPane.showMessageDialog(null, 
                  "To execute an algorithm You should put at least two process.",
                  "Not enought data.",
                  JOptionPane.WARNING_MESSAGE);
          return;
      }
      
      List<Process> result = null;
      controller = new ProcessesController(timeline);
      switch(algorithmValue.getSelectedIndex()) {
          case 0 -> result = controller.FIFOAlgorithm();
          case 1 -> result = controller.SJFAlgorithm();
          case 2 -> result = controller.SRTFAlgorithm();
          case 3 -> result = controller.PriorityAlgorithm();
          default -> {
              JOptionPane.showMessageDialog(null, 
                      "The algorithm doesn't look like a valid algorithm.",
                      "Algorithm not found.",
                      JOptionPane.ERROR_MESSAGE);
              return;
          }
      }
      
      result.sort(Comparator.comparing(Process::getNombre));
      
      model = outputTable.getModel();

      for(int i = 0; i < result.size(); i++) {
          model.setValueAt(result.get(i).getNombre(), i, 0);
          model.setValueAt(result.get(i).gettInicio().toString().replaceAll("[[|]]", ""), i, 1);
          model.setValueAt(result.get(i).gettFinalizacion().toString(), i, 2);
          model.setValueAt(result.get(i).gettEspera(), i, 3);
      }
      
      for(int i = result.size(); i < 11; i++) {
          model.setValueAt("", i, 0);
          model.setValueAt("", i, 1);
          model.setValueAt("", i, 2);
          model.setValueAt("", i, 3);
      }
        
      outputTable.setModel(model);
      
      float r = 0;
      for(Process p : result) {
          r += p.gettEspera();
      }
      r /= result.size();
      
      JOptionPane.showMessageDialog(null, "Average waiting time: " + r, "Results", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_executeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel algorithmLabel;
    private javax.swing.JComboBox<String> algorithmValue;
    private javax.swing.JButton executeButton;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JLabel inputLabel1;
    private javax.swing.JTable inputTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable outputTable;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
