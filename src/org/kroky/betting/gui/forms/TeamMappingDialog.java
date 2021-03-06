/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kroky.betting.gui.forms;

import foxtrot.AsyncTask;
import foxtrot.AsyncWorker;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.log4j.Logger;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import org.kroky.betting.common.util.Utils;
import org.kroky.betting.db.DAO;
import org.kroky.betting.db.objects.TeamMapping;
import org.kroky.betting.gui.custom.EscapableDialog;
import org.kroky.betting.gui.custom.SortedComboBoxModel;
import org.kroky.betting.gui.custom.tables.EditableTable;
import org.kroky.betting.gui.custom.tables.TeamMappingsTableModel;

/**
 *
 * @author Kroky
 */
public class TeamMappingDialog extends EscapableDialog {

    /**
     * Creates new form TeamMappingDialog
     */
    public TeamMappingDialog(JDialog parent, boolean modal, Set<TeamMapping> newMappings) {
        super(parent, modal);
        this.parent = parent;
        manual = false;
        this.newMappings = newMappings;
        initComponents();
        additionalInit();
    }

    public TeamMappingDialog(JFrame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        manual = true;
        initComponents();
        additionalInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTeamMappingsTable = new javax.swing.JScrollPane();
        buttonAccept = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        cbCountry = new javax.swing.JComboBox();
        lblCountry = new javax.swing.JLabel();
        buttonCopy = new javax.swing.JButton();
        buttonAddRow = new javax.swing.JButton();
        buttonRemoveRow = new javax.swing.JButton();
        cbSport = new javax.swing.JComboBox();
        lblApplyForAll = new javax.swing.JLabel();
        lblSport = new javax.swing.JLabel();
        lblLeague = new javax.swing.JLabel();
        cbLeague = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Team Mappings");

        buttonAccept.setText("Accept");
        buttonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcceptActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        cbCountry.setEditable(true);
        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });

        lblCountry.setText("Country");

        buttonCopy.setText("Copy names");
        buttonCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCopyActionPerformed(evt);
            }
        });

        buttonAddRow.setText("Add new row");
        buttonAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddRowActionPerformed(evt);
            }
        });

        buttonRemoveRow.setText("Remove row");
        buttonRemoveRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveRowActionPerformed(evt);
            }
        });

        cbSport.setEditable(true);
        cbSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSportActionPerformed(evt);
            }
        });

        lblApplyForAll.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblApplyForAll.setText("Apply for all:");

        lblSport.setText("Sport");

        lblLeague.setText("League");

        cbLeague.setEditable(true);
        cbLeague.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLeagueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTeamMappingsTable)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAccept))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRemoveRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddRow))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblApplyForAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCountry, 0, 125, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSport, 0, 126, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLeague)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbLeague, 0, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonAccept, buttonCancel});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonAddRow, buttonCopy, buttonRemoveRow});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCountry)
                    .addComponent(cbSport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApplyForAll)
                    .addComponent(lblSport)
                    .addComponent(cbLeague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLeague))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddRow)
                    .addComponent(buttonRemoveRow)
                    .addComponent(buttonCopy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTeamMappingsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonAccept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcceptActionPerformed
        //<editor-fold defaultstate="collapsed" desc="...">
        TeamMappingsTableModel model = (TeamMappingsTableModel) teamMappingTable.getModel();
        mappingsToReturn.clear();
        Set<String> internalNames = new HashSet<String>();
        boolean valid = true;
        for (int i = 0; i < model.getRowCount(); i++) {
            String externalName = model.getValueAt(i, 0).toString();
            String internalName = model.getValueAt(i, 1).toString();
            String country = model.getValueAt(i, 2).toString();
            String sport = model.getValueAt(i, 3).toString();
            String league = model.getValueAt(i, 4).toString();
            if (Utils.isEmpty(externalName) || externalName.equals(NEW_MAPPING.getId().getExternalName())) {
                valid = false;
            } else if (Utils.isEmpty(internalName) || internalName.equals(NEW_MAPPING.getTeam().getName())) {
                valid = false;
            } else if (Utils.isEmpty(sport) || sport.equals(NEW_MAPPING.getId().getSport())) {
                valid = false;
            } else if (Utils.isEmpty(country) || country.equals(NEW_MAPPING.getId().getCountry())) {
                valid = false;
            }
            if (!valid) {
                break;
            }
            TeamMapping mapping = new TeamMapping(externalName, country, sport, league.equals(NEW_MAPPING.getLeague()) ? "" : league, internalName);
            if (mappingsToReturn.contains(mapping)) {
                JOptionPane.showMessageDialog(this, "Duplicate mapping:\n" + mapping, "Invalid data", JOptionPane.ERROR_MESSAGE);
                break;
            }
            if (!internalNames.add(internalName)) {
                int rv = JOptionPane.showConfirmDialog(this, "Duplicate internal name: " + internalName
                        + "Do you wish to continue?", "Possibly invalid data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (rv == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            mappingsToReturn.add(mapping);
        }
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Please fill in all values", "Invalid data", JOptionPane.ERROR_MESSAGE);
        } else {
            accepted = true;
            dispose();
        }
        //</editor-fold>
    }//GEN-LAST:event_buttonAcceptActionPerformed

    private void buttonCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCopyActionPerformed
        //<editor-fold defaultstate="collapsed" desc="...">
        TeamMappingsTableModel model = (TeamMappingsTableModel) teamMappingTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String name = model.getValueAt(i, 0).toString();
            Object nameInModel = model.getValueAt(i, 1);
            if (Utils.isEmpty(nameInModel) || nameInModel.equals(NEW_MAPPING.getTeam().getName())) {
                model.setValueAt(name, i, 1);
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_buttonCopyActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        //<editor-fold defaultstate="collapsed" desc="...">
        String country = (String) cbCountry.getSelectedItem();
        if (evt.getActionCommand().equals("comboBoxEdited")) {
            country = Utils.capitalizeFirstLetter(country);
            SortedComboBoxModel cmbModel = (SortedComboBoxModel) cbCountry.getModel();
            cmbModel.addElement(country);
        }
        TeamMappingsTableModel model = (TeamMappingsTableModel) teamMappingTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Object countryInModel = model.getValueAt(i, 2);
            if (manual || Utils.isEmpty(countryInModel) || countryInModel.equals(NEW_MAPPING.getCountry())) {
                model.setValueAt(country, i, 2);
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_cbCountryActionPerformed

    private void buttonAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddRowActionPerformed
        //<editor-fold defaultstate="collapsed" desc="...">
        TeamMappingsTableModel model = (TeamMappingsTableModel) teamMappingTable.getModel();
        String country = (String) cbCountry.getSelectedItem();
        String sport = (String) cbSport.getSelectedItem();
        String league = (String) cbLeague.getSelectedItem();
        model.addRow(new TeamMapping("<external name>", Utils.isEmpty(country) ? "<country>" : country, Utils.isEmpty(sport) ? "<sport>" : sport, Utils.isEmpty(league) ? "<league>" : league, "<internal name>"));
        if (model.getRowCount() == 1) {
            setTitle("Team Mappings (" + model.getRowCount() + " new team)");
        } else {
            setTitle("Team Mappings (" + model.getRowCount() + " new teams)");
        }
        //</editor-fold>
    }//GEN-LAST:event_buttonAddRowActionPerformed

    private void buttonRemoveRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveRowActionPerformed
        //<editor-fold defaultstate="collapsed" desc="...">
        TeamMappingsTableModel model = (TeamMappingsTableModel) teamMappingTable.getModel();
        ArrayList<TeamMapping> toRemove = new ArrayList<TeamMapping>();
        int[] selectedIndices = teamMappingTable.getSelectedRows();
        for (int index : selectedIndices) {
            TeamMapping mapping = model.getMapping(teamMappingTable.convertRowIndexToModel(index));
            toRemove.add(mapping);
        }
        for (TeamMapping teamMapping : toRemove) {
            model.remove(teamMapping);
        }
        if (model.getRowCount() == 0) {
            setTitle("Team Mappings");
        } else {

            setTitle("Team Mappings (" + model.getRowCount() + " new teams)");
        }
        //</editor-fold>
    }//GEN-LAST:event_buttonRemoveRowActionPerformed

    private void cbSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSportActionPerformed
        //<editor-fold defaultstate="collapsed" desc="...">
        String sport = (String) cbSport.getSelectedItem();
        if (evt.getActionCommand().equals("comboBoxEdited")) {
            sport = Utils.capitalizeFirstLetter(sport);
            SortedComboBoxModel cmbModel = (SortedComboBoxModel) cbSport.getModel();
            cmbModel.addElement(sport);
        }
        TeamMappingsTableModel model = (TeamMappingsTableModel) teamMappingTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Object sportInModel = model.getValueAt(i, 3);
            if (manual || Utils.isEmpty(sportInModel) || sportInModel.equals(NEW_MAPPING.getSport())) {
                model.setValueAt(sport, i, 3);
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_cbSportActionPerformed

    private void cbLeagueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLeagueActionPerformed
        //<editor-fold defaultstate="collapsed" desc="...">
        String league = (String) cbLeague.getSelectedItem();
        if (evt.getActionCommand().equals("comboBoxEdited")) {
            league = Utils.capitalizeFirstLetter(league);
            SortedComboBoxModel cmbModel = (SortedComboBoxModel) cbLeague.getModel();
            cmbModel.addElement(league);
        }
        TeamMappingsTableModel model = (TeamMappingsTableModel) teamMappingTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Object sportInModel = model.getValueAt(i, 4);
            if (manual || Utils.isEmpty(sportInModel) || sportInModel.equals(NEW_MAPPING.getSport())) {
                model.setValueAt(league, i, 4);
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_cbLeagueActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAccept;
    private javax.swing.JButton buttonAddRow;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonCopy;
    private javax.swing.JButton buttonRemoveRow;
    private javax.swing.JComboBox cbCountry;
    private javax.swing.JComboBox cbLeague;
    private javax.swing.JComboBox cbSport;
    private javax.swing.JLabel lblApplyForAll;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblLeague;
    private javax.swing.JLabel lblSport;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JScrollPane scrollPaneTeamMappingsTable;
    // End of variables declaration//GEN-END:variables

    private EditableTable teamMappingTable = new EditableTable(new TeamMappingsTableModel(true));
    private Set<TeamMapping> newMappings = new HashSet<TeamMapping>();
    private Set<TeamMapping> mappingsToReturn = new HashSet<TeamMapping>();
    private boolean accepted = false;
    private Component parent;
    private boolean manual;
    private final Logger LOG = Logger.getLogger(TeamMappingDialog.class);
    private static final TeamMapping NEW_MAPPING = new TeamMapping("<external name>", "<sport>", "<country>", "<internal name>", "<league>");

    public boolean wasAccepted() {
        return accepted;
    }

    public Set<TeamMapping> getNewMappings() {
        return mappingsToReturn;
    }

    private void additionalInit() {
        //<editor-fold defaultstate="collapsed" desc="...">
        Utils.centerOnParent(parent, this);
        String message = "Populating countries combobox";
        LOG.debug(message);
        cbSport.setEnabled(manual);
        cbCountry.setEnabled(manual);
        cbLeague.setEnabled(manual);
        if (manual) {
            List<String> countries = null;
            List<String> sports = null;
            List<String> leagues = null;
            countries = DAO.getAllCountriesFromTeams();
            sports = DAO.getAllSportsFromTeams();
            leagues = DAO.getAllLeaguesFromTeams();
            countries.add("");
            sports.add("");
            leagues.add("");
            cbSport.setModel(new SortedComboBoxModel(sports.toArray(new String[0])));
            cbCountry.setModel(new SortedComboBoxModel(countries.toArray(new String[0])));
            cbLeague.setModel(new SortedComboBoxModel(leagues.toArray(new String[0])));
        }
        teamMappingTable.addHighlighter(HighlighterFactory.createAlternateStriping());
        teamMappingTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        teamMappingTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    buttonRemoveRow.setEnabled(manual && teamMappingTable.getSelectedRowCount() > 0);
                }
            }
        });
        scrollPaneTeamMappingsTable.setViewportView(teamMappingTable);
        progressBar.setVisible(false);
        buttonRemoveRow.setEnabled(manual);
        buttonAddRow.setEnabled(manual);
        AsyncWorker.post(new PopulateDataTask());
        //</editor-fold>
    }

    //<editor-fold defaultstate="collapsed" desc="PopulateTableTask">
    private class PopulateDataTask extends AsyncTask {

        private final Logger LOG = Logger.getLogger(PopulateDataTask.class);

        @Override
        public Object run() {
            if (Utils.isEmpty(newMappings)) {
                return null;
            }
            String message = "Populating mappings table";
            LOG.debug(message);
            progressBar.setString(message);
            progressBar.setStringPainted(true);
            progressBar.setValue(0);
            progressBar.setMaximum(newMappings.size());
            progressBar.setVisible(true);
            buttonAccept.setEnabled(false);
            buttonCancel.setEnabled(false);
            TeamMappingsTableModel model = new TeamMappingsTableModel(manual);
            int i = 0;
            for (TeamMapping mapping : newMappings) {
                i++;
                model.addRow(mapping);
                progressBar.setValue(i);
            }
            teamMappingTable.setModel(model);
            return null;
        }

        @Override
        public void success(Object result) {
            progressBar.setIndeterminate(false);
            progressBar.setVisible(false);
            buttonAccept.setEnabled(true);
            buttonCancel.setEnabled(true);
        }

        @Override
        public void failure(Throwable ex) {
            progressBar.setIndeterminate(false);
            progressBar.setVisible(false);
            buttonAccept.setEnabled(true);
            buttonCancel.setEnabled(true);
            LOG.error(ex.getMessage(), ex);
            Utils.showError(TeamMappingDialog.this, ex);
        }
    }
    //</editor-fold>
}
