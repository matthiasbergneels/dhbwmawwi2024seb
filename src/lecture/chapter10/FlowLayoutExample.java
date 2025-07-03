package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {

  public FlowLayoutExample() {
    this.setTitle("Flow Layout Example");


    JPanel flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    flowLayoutPanel.add(new JLabel("Hitzefrei?"));
    flowLayoutPanel.add(new JButton("Ja"));
    flowLayoutPanel.add(new JButton("Nein"));

    this.add(flowLayoutPanel);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
  }

  public static void main(String[] args) {
    // invokeLater für sichere parallel Verarbeitung
    SwingUtilities.invokeLater(() -> {
        JFrame flowLayoutExample = new FlowLayoutExample();
        flowLayoutExample.setVisible(true);
        System.out.println("Starting UI-Frame - " + Thread.currentThread());
      }
    );
    System.out.println("Added UI-Frame to starting queue - " + Thread.currentThread());
    System.out.println("Ende main()");
  }
}
