package excersises.chapter10.meldeamt;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class CitizenRegistrationUI extends JFrame {

    private static final String ACTION_ADD = "ADD";
    private static final String ACTION_SHOW = "SHOW";
    private static final String ACTION_SEARCH = "SEARCH";
    private static final String ACTION_DELETE = "DELETE";
    private static final String ACTION_SHOW_LIST = "SHOW_LIST";
    private static final String ACTION_CLOSE = "CLOSE";
    private static final String ACTION_LANGUAGE_DE = "ACTION_LANGUAGE_DE";
    private static final String ACTION_LANGUAGE_EN = "ACTION_LANGUAGE_EN";


    private final ButtonGroup maritalStatusOptions = new ButtonGroup();
    private JLabel notificationLabel;
    private JComboBox<Title> titleComboBox;
    private JTextField lastNameTextField;
    private JTextField firstNameTextField;
    private JTextField birthLastNameTextField;
    private JTextField emailTextField;
    private MaritalStatus currentMaritalStatus = MaritalStatus.MARRIED;

    public CitizenRegistrationUI(Locale locale) {
        super();

        // Internationalisierung
        if(locale != null){
            Locale.setDefault(locale);
        }

        ResourceBundle uiLabelBundle = ResourceBundle.getBundle(CitizenRegistrationUtilities.UI_LABELS_RESOURCE_IDENTIFIER);

        this.setTitle(uiLabelBundle.getString("frametitle"));
        this.setLayout(new BorderLayout());

        // ActionListener - Buttons
        ActionListener btnListener = (ActionEvent e) -> {

          String action = e.getActionCommand();

          switch(action) {
            case ACTION_ADD -> {
              boolean erg = CitizenListOperations
                .addNewCitizen(lastNameTextField.getText(), firstNameTextField.getText(),
                  birthLastNameTextField.getText(), emailTextField.getText(),
                  (Title) titleComboBox.getSelectedItem(),
                  currentMaritalStatus);
              if (erg) {
                notificationLabel.setText("Einwohner "
                  + lastNameTextField.getText()
                  + " erfolgreich hinzugefügt!");
              } else {
                notificationLabel.setText("Einwohner "
                  + lastNameTextField.getText()
                  + " NICHT erfolgreich hinzugefügt!");
              }
            }
                case ACTION_SHOW -> {
                    boolean erg = CitizenListOperations.showCitizen(lastNameTextField.getText(),
                            firstNameTextField.getText());
                    if (erg) {
                        notificationLabel.setText("Einwohner "
                                + lastNameTextField.getText() + " angezeigt!");
                    } else {
                        notificationLabel.setText("Einwohner "
                                + lastNameTextField.getText() + " NICHT angezeigt!");
                    }
            }
                case ACTION_SEARCH -> {
                  boolean erg = CitizenListOperations.searchCitizenByName(lastNameTextField.getText(),
                    firstNameTextField.getText());
                  if (erg) {
                    notificationLabel.setText("Einwohner "
                      + lastNameTextField.getText() + " gefunden!");
                  } else {
                    notificationLabel.setText("Einwohner "
                      + lastNameTextField.getText() + " NICHT gefunden!");
                  }
                }
               case ACTION_DELETE -> {
                 boolean erg = CitizenListOperations.deleteCitizenByName(lastNameTextField.getText(),
                   firstNameTextField.getText());
                 if (erg) {
                   notificationLabel.setText("Einwohner "
                     + lastNameTextField.getText() + " gelöscht!");
                 } else {
                   notificationLabel.setText("Einwohner "
                     + lastNameTextField.getText() + " NICHT gefunden!");
                 }
               }
                case ACTION_SHOW_LIST -> {
                    CitizenListOperations.printCitizenList();
                }
                case ACTION_CLOSE -> {
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
                case ACTION_LANGUAGE_DE -> {
                    CitizenListOperations.saveCitizenDataToFile();
                    this.dispose();
                    startUI(Locale.GERMANY);
                }
                case ACTION_LANGUAGE_EN -> {
                    CitizenListOperations.saveCitizenDataToFile();
                    this.dispose();
                    startUI(Locale.US);
                }
            }
        };

        ItemListener maritalStatusItemListener = (ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                MaritalStatusRadioButton currentMaritalStatusButton = (MaritalStatusRadioButton) e.getItem();
                currentMaritalStatus =currentMaritalStatusButton.getMaritalStatus();

                if (currentMaritalStatus == MaritalStatus.SINGLE) {
                    birthLastNameTextField.setText("");
                    birthLastNameTextField.setEditable(false);
                } else {
                    birthLastNameTextField.setEditable(true);
                }
            }
        };

        // Panels im BorderLayout
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // "Eingedrückter" Centerbereich
        Border loweredBevelBorder = BorderFactory
                .createBevelBorder(BevelBorder.LOWERED);
        centerPanel.setBorder(loweredBevelBorder);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);

        // North Panel - Leiste für Meldungen
        notificationLabel = new JLabel("");
        northPanel.add(notificationLabel);

        // Center Panel - Eingabebereich
        Border etchedBorder = BorderFactory.createEtchedBorder();

        // Kontaktdaten
        JPanel contactDataPanel = new JPanel(new GridLayout(0, 2));
        Border contactEtchedBorder = BorderFactory.createTitledBorder(
                etchedBorder, uiLabelBundle.getString("frametitle_adress"));
        contactDataPanel.setBorder(contactEtchedBorder);
        centerPanel.add(contactDataPanel);

        titleComboBox = new JComboBox<>(Title.values());
        lastNameTextField = new JTextField(20);
        lastNameTextField.setText("Mustermann");
        firstNameTextField = new JTextField(20);
        firstNameTextField.setText("Mimi");
        birthLastNameTextField = new JTextField(20);
        birthLastNameTextField.setText("Musterfrau");
        emailTextField = new JTextField(20);
        emailTextField.setText("mimi.mustermann@email.de");

        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_title")+":"));
        titleComboBox.setToolTipText("Anrede auswählen");
        contactDataPanel.add(titleComboBox);
        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_name")+":"));
        lastNameTextField.setToolTipText("Nachname eingeben - z.B. \"Mustermann\"");
        contactDataPanel.add(lastNameTextField);
        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_firstname")+":"));
        contactDataPanel.add(firstNameTextField);
        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_birthname")+":"));
        contactDataPanel.add(birthLastNameTextField);
        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_email")+":"));
        contactDataPanel.add(emailTextField);

        // Familienstand
        JPanel maritalStatusPanel = new JPanel(new GridLayout(0, 1));
        Border maritalEtchedBorder = BorderFactory.createTitledBorder(
                etchedBorder, uiLabelBundle.getString("frametitle_familystatus"));
        maritalStatusPanel.setBorder(maritalEtchedBorder);
        centerPanel.add(maritalStatusPanel);

        MaritalStatusRadioButton maritalStatusSingleRadioButton = new MaritalStatusRadioButton(MaritalStatus.SINGLE, maritalStatusItemListener);
        MaritalStatusRadioButton maritalStatusMarriedRadioButton = new MaritalStatusRadioButton(MaritalStatus.MARRIED, maritalStatusItemListener);
        MaritalStatusRadioButton maritalStatusWidowedRadioButton = new MaritalStatusRadioButton(MaritalStatus.WIDOWED, maritalStatusItemListener);
        MaritalStatusRadioButton maritalStatusDivorcedRadioButton = new MaritalStatusRadioButton(MaritalStatus.DIVORCED, maritalStatusItemListener);

        maritalStatusMarriedRadioButton.setSelected(true);

        maritalStatusOptions.add(maritalStatusSingleRadioButton);
        maritalStatusOptions.add(maritalStatusMarriedRadioButton);
        maritalStatusOptions.add(maritalStatusWidowedRadioButton);
        maritalStatusOptions.add(maritalStatusDivorcedRadioButton);

        maritalStatusPanel.add(maritalStatusSingleRadioButton);
        maritalStatusPanel.add(maritalStatusMarriedRadioButton);
        maritalStatusPanel.add(maritalStatusWidowedRadioButton);
        maritalStatusPanel.add(maritalStatusDivorcedRadioButton);

        // South Panel - Leiste für Buttons
        JButton btnAdd = new JButton(uiLabelBundle.getString("btn_add"));
        btnAdd.setActionCommand(ACTION_ADD);
        btnAdd.addActionListener(btnListener);

        JButton btnShow = new JButton(uiLabelBundle.getString("btn_show"));
        btnShow.setActionCommand(ACTION_SHOW);
        btnShow.addActionListener(btnListener);

        JButton btnSearch = new JButton(uiLabelBundle.getString("btn_search"));
        btnSearch.setActionCommand(ACTION_SEARCH);
        btnSearch.addActionListener(btnListener);

        JButton btnDelete = new JButton(uiLabelBundle.getString("btn_delete"));
        btnDelete.setActionCommand(ACTION_DELETE);
        btnDelete.addActionListener(btnListener);

        JButton btnShowList = new JButton(uiLabelBundle.getString("btn_showlist"));
        btnShowList.setActionCommand(ACTION_SHOW_LIST);
        btnShowList.addActionListener(btnListener);

        southPanel.add(btnAdd);
        southPanel.add(btnShow);
        southPanel.add(btnSearch);
        southPanel.add(btnDelete);
        southPanel.add(btnShowList);

        JMenuItem menuItemAdd = new JMenuItem(uiLabelBundle.getString("btn_add"));
        menuItemAdd.setActionCommand(ACTION_ADD);
        menuItemAdd.addActionListener(btnListener);

        JMenuItem menuItemDelete = new JMenuItem(uiLabelBundle.getString("btn_delete"));
        menuItemDelete.setActionCommand(ACTION_DELETE);
        menuItemDelete.addActionListener(btnListener);

        JMenuItem menuItemClose = new JMenuItem(uiLabelBundle.getString("btn_close"));
        menuItemClose.setActionCommand(ACTION_CLOSE);
        menuItemClose.addActionListener(btnListener);

        JMenu general = new JMenu(uiLabelBundle.getString("menu_common"));
        general.add(menuItemAdd);
        general.add(menuItemDelete);
        general.addSeparator();
        general.add(menuItemClose);


        JMenuItem menuItemSearch = new JMenuItem(uiLabelBundle.getString("btn_search"));
        menuItemSearch.setActionCommand(ACTION_SEARCH);
        menuItemSearch.addActionListener(btnListener);

        JMenuItem menuItemShowList = new JMenuItem(uiLabelBundle.getString("btn_showlist"));
        menuItemShowList.setActionCommand(ACTION_SHOW_LIST);
        menuItemShowList.addActionListener(btnListener);

        JMenu listFunctions = new JMenu(uiLabelBundle.getString("menu_listfunctions"));
        listFunctions.add(menuItemSearch);
        listFunctions.add(menuItemShowList);

        JMenuItem menuLanguageDe = new JMenuItem(uiLabelBundle.getString("btn_language_de"));
        menuLanguageDe.setActionCommand(ACTION_LANGUAGE_DE);
        menuLanguageDe.addActionListener(btnListener);

        JMenuItem menuLanguageEn = new JMenuItem(uiLabelBundle.getString("btn_language_en"));
        menuLanguageEn.setActionCommand(ACTION_LANGUAGE_EN);
        menuLanguageEn.addActionListener(btnListener);

        JMenu menuLanguage = new JMenu(uiLabelBundle.getString("menu_language"));
        menuLanguage.add(menuLanguageDe);
        menuLanguage.add(menuLanguageEn);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(general);
        menuBar.add(listFunctions);
        menuBar.add(menuLanguage);

        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                CitizenListOperations.loadCitizenDataFromFile();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                CitizenListOperations.saveCitizenDataToFile();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        startUI(null);
    }

    private static void startUI(Locale locale) {
      SwingUtilities.invokeLater(() -> {
        JFrame citizenRegistrationUI = new CitizenRegistrationUI(locale);
        citizenRegistrationUI.setVisible(true);
      });
    }

    private class MaritalStatusRadioButton extends JRadioButton {
        private final MaritalStatus maritalStatus;

        private MaritalStatusRadioButton(MaritalStatus maritalStatus, ItemListener itemListener) {
            super(maritalStatus.toString());
            this.maritalStatus = maritalStatus;
            this.addItemListener(itemListener);
        }

        public MaritalStatus getMaritalStatus() {
            return maritalStatus;
        }
    }
}

