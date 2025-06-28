package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {

  private BorderLayoutExample(){
    this.setTitle("BorderLayoutExample");

    JPanel borderLayoutPanel = new JPanel(new BorderLayout());

    borderLayoutPanel.add(new JButton("Westen"), BorderLayout.WEST);
    borderLayoutPanel.add(new JButton("Osten"), BorderLayout.EAST);
    borderLayoutPanel.add(new JButton("North"), BorderLayout.NORTH);
    borderLayoutPanel.add(new JButton("South"), BorderLayout.SOUTH);
    borderLayoutPanel.add(new JLabel("South Label"), BorderLayout.SOUTH);


    JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    centerPanel.add(new JLabel("Center Label"));
    centerPanel.add(new JButton("Center"));
    borderLayoutPanel.add(centerPanel);

    this.add(borderLayoutPanel);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    // invokeLater für sichere parallel Verarbeitung
    SwingUtilities.invokeLater(() -> {
        JFrame borderLayoutExample = new BorderLayoutExample();
        borderLayoutExample.setVisible(true);
        System.out.println("Starting UI-Frame - " + Thread.currentThread());
      }
    );
    System.out.println("Added UI-Frame to starting queue - " + Thread.currentThread());
  }

}
