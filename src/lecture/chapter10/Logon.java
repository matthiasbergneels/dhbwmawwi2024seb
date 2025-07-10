package lecture.chapter10;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Logon extends JFrame {

  // ACTION Constants
  private static final String ACTON_LOGIN = "ACTON_LOGIN";
  private static final String ACTION_BEENDEN = "ACTION_BEENDEN";
  private static final String ACTION_PRINT = "ACTION_PRINT";

  // Component Name Constants
  private static final String COMPONENT_NAME_PORT_INPUTFIELD = "PORT_INPUTFIELD";

  // Instanzattribute
  private final JFormattedTextField portField;

  private Logon() throws ParseException {
    super();
    this.setTitle("Logon");
    this.setAlwaysOnTop(true);
    this.setName("Logon");
    this.setResizable(false);

    JComboBox<String> myComboBox = new JComboBox<>(new String[]{"SSH", "FTP", "HTTP", "HTTPS"});

    portField = new JFormattedTextField(new MaskFormatter("#####"));
    portField.setName(COMPONENT_NAME_PORT_INPUTFIELD);
    portField.setColumns(3);

    myComboBox.addItemListener((itemEvent)-> {
      System.out.println("Item Event ausgelöst: " + itemEvent.getItem());
      System.out.println("State change: " + itemEvent.getStateChange());
      System.out.println("Parameter String: " + itemEvent.paramString());

      JTextField portField = (JTextField) findComponentByName(this, COMPONENT_NAME_PORT_INPUTFIELD);

      if(portField == null) {
        System.out.println("Port Input Field not found!");
        return;
      }
      if(itemEvent.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("Protokoll " + itemEvent.getItem() + " ausgewählt.");
        if(itemEvent.getItem().equals("SSH")) {
          System.out.println("SSH ausgewählt - Port 22");
          portField.setText("22");
        } else if(itemEvent.getItem().equals("FTP")) {
          portField.setText("21");
        } else if(itemEvent.getItem().equals("HTTP")) {
          portField.setText("80");
        } else if(itemEvent.getItem().equals("HTTPS")) {
          portField.setText("443");
        } else {
          portField.setText("");
        }
      }

    });



    // initialize Panels
    JPanel mainPanel = new JPanel(new BorderLayout());

    JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel southPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new FlowLayout());


    JPanel connectionPanel = new JPanel(new GridLayout(0, 2));
    JPanel filePanel = new JPanel(new GridLayout(0, 2));

    FlowLayout cellFlowLayout = new FlowLayout(FlowLayout.LEFT);

    // Message Area
    JLabel messageTextLabel = new JLabel("");
    northPanel.add(messageTextLabel);

    //create and assign elements for connection area
    JPanel flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("User:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    JTextField userNameField = new JTextField(3);
    flowLayoutForCell.add(userNameField);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Passwort:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    JPasswordField userPasswordField = new JPasswordField(3);
    flowLayoutForCell.add(userPasswordField);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Art:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(myComboBox);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Host:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    JTextField host = new JTextField(5);
    flowLayoutForCell.add(host);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Port:"));
    connectionPanel.add(flowLayoutForCell);
    connectionPanel.add(portField);

    // create and add Fields for File Area
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Quelle:"));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(10));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Ziel:"));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(10));
    filePanel.add(flowLayoutForCell);

    // create & assign Buttons
    JButton okButton = new JButton("Login");
    okButton.setActionCommand(ACTON_LOGIN);
    JButton cancelButton = new JButton("Beenden");
    cancelButton.setActionCommand(ACTION_BEENDEN);
    JButton printButton = new JButton("Ausgabe");
    printButton.setActionCommand(ACTION_PRINT);

    ActionListener buttonListener = e -> {
      System.out.println("Action Event Command: " + e.getActionCommand());
      System.out.println("Parameter String: " + e.paramString());
      System.out.println("Timestamp (when): " + e.getWhen());
      System.out.println("Modifiers: " + e.getModifiers());
      System.out.println("Modifiers (binär): " + Integer.toBinaryString(e.getModifiers()));


      if(e.getActionCommand().equals(ACTON_LOGIN)) {
        System.out.println("OK Button gedrückt");
        messageTextLabel.setText("Login erfolgreich!");

        if((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK){
          System.out.println("CTRL gedrückt - Login wird nicht durchgeführt.");
        }
      } else if(e.getActionCommand().equals(ACTION_PRINT)) {
        System.out.println("Print Button gedrückt");
        messageTextLabel.setText("Ausgabe der Daten:");
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("User", userNameField.getText());
        dataMap.put("Passwort", new String(userPasswordField.getPassword()));
        dataMap.put("Art", (String) myComboBox.getSelectedItem());
        dataMap.put("Host", host.getText());
        dataMap.put("Port", portField.getText());
        System.out.println(dataMap);
      } else if(e.getActionCommand().equals(ACTION_BEENDEN)) {
        System.out.println("Cancel Button gedrückt - Programm wird beendet.");
        messageTextLabel.setText("Programm wird beendet.");
        System.exit(0);
      }
    };

    okButton.addActionListener(buttonListener);
    printButton.addActionListener(buttonListener);
    cancelButton.addActionListener(buttonListener);

    okButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setEnabled(false);
        button.setText("Geh weg!");
      }

      @Override
      public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        button.setEnabled(true);
        button.setText("Login");
      }
    });

    southPanel.add(okButton);
    southPanel.add(cancelButton);
    southPanel.add(printButton);

    // create and assign Borders
    Border etchedBorder = BorderFactory.createEtchedBorder();
    Border connectionBorder = BorderFactory.createTitledBorder(etchedBorder, "Verbindung");
    Border fileBorder = BorderFactory.createTitledBorder(etchedBorder, "Datei");
    Border centerBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

    connectionPanel.setBorder(connectionBorder);
    filePanel.setBorder(fileBorder);
    centerPanel.setBorder(centerBorder);

    // combine Panels
    centerPanel.add(connectionPanel);
    centerPanel.add(filePanel);

    mainPanel.add(northPanel, BorderLayout.NORTH);
    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);

    this.add(mainPanel);

    // Menüleiste hinzufügen
    JMenuBar swingMenuBar = new JMenuBar();
    JMenu swingMenu = new JMenu("Files");

    JMenuItem swingLoginMenuItem = new JMenuItem("Login");
    swingLoginMenuItem.setActionCommand(ACTON_LOGIN);
    swingLoginMenuItem.addActionListener(buttonListener);

    JMenuItem swingPrintMenuItem = new JMenuItem("Ausgabe");
    swingPrintMenuItem.setActionCommand(ACTION_PRINT);
    swingPrintMenuItem.addActionListener(buttonListener);

    JMenuItem swingCancelMenuItem = new JMenuItem("Beenden");
    swingCancelMenuItem.setActionCommand(ACTION_BEENDEN);
    swingCancelMenuItem.addActionListener(buttonListener);

    swingMenu.add(swingLoginMenuItem);
    swingMenu.add(swingPrintMenuItem);
    swingMenu.addSeparator();
    swingMenu.add(swingCancelMenuItem);
    swingMenuBar.add(swingMenu);
    this.setJMenuBar(swingMenuBar);

    MenuBar awtMenuBar = new MenuBar();
    Menu fileMenu = new Menu("File");
    MenuItem loginMenuItem = new MenuItem("Login");
    loginMenuItem.setActionCommand(ACTON_LOGIN);
    loginMenuItem.addActionListener(buttonListener);
    MenuItem printMenuItem = new MenuItem("Ausgabe");
    printMenuItem.setActionCommand(ACTION_PRINT);
    printMenuItem.addActionListener(buttonListener);
    MenuItem cancelMenuItem = new MenuItem("Beenden");
    cancelMenuItem.setActionCommand(ACTION_BEENDEN);
    cancelMenuItem.addActionListener(buttonListener);
    fileMenu.add(loginMenuItem);
    fileMenu.add(printMenuItem);
    fileMenu.addSeparator();
    fileMenu.add(cancelMenuItem);
    awtMenuBar.add(fileMenu);
    this.setMenuBar(awtMenuBar);

    // set JFrame behavior
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) throws ParseException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    // Set cross-platform Java L&F (also called "Metal")
    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    System.out.println(UIManager.getLookAndFeel());

    GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    System.out.println(String.format("Screen Dimension: %.0f x %.0f",
      defaultScreenDevice.getDefaultConfiguration().getBounds().getWidth(),
      defaultScreenDevice.getDefaultConfiguration().getBounds().getHeight()));

    GraphicsEnvironment virtualGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] screens = virtualGraphicsEnvironment.getScreenDevices();

    // using invokeLater for safe parallel processing
    SwingUtilities.invokeLater(() -> {
      JFrame logonUI = null;
      try {
        logonUI = new Logon();
        logonUI.setVisible(true);
      } catch (ParseException e) {
        throw new RuntimeException(e);
      }

        System.out.println("Starting UI-Frame - " + Thread.currentThread());
      }
    );
    System.out.println("Added UI-Frame to starting queue - " + Thread.currentThread());
  }

  private JComponent findComponentByName(Container currentContainer, String name){
    System.out.println(currentContainer);
    for (Component component : currentContainer.getComponents()) {
      if (name.equals(component.getName())) {
        return (JComponent) component;
      }
      if (component instanceof Container) {
        JComponent found = findComponentByName((Container) component, name);
        if (found != null) {
          return found;
        }
      }
    }
    return null;
  }

}