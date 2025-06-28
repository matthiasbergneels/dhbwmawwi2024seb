package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

  private GridLayoutExample() {
    this.setTitle("GridLayoutExample");

    JPanel gridLayoutPanel = new JPanel(new GridLayout(0,3));

    JPanel cellOnePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    cellOnePanel.add(new JButton("Cell 1"));

    gridLayoutPanel.add(cellOnePanel);
    gridLayoutPanel.add(new JButton("Cell 2"));
    gridLayoutPanel.add(new JLabel("Cell 3"));
    gridLayoutPanel.add(new JLabel("Cell 4"));
    gridLayoutPanel.add(new JLabel("Cell 5"));
    gridLayoutPanel.add(new JLabel("Cell 6"));
    gridLayoutPanel.add(new JLabel("Cell 7"));
    gridLayoutPanel.add(new JLabel("Cell 8"));
    gridLayoutPanel.add(new JLabel("Cell 9"));
    gridLayoutPanel.add(new JLabel("Cell 10"));

    this.add(gridLayoutPanel);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    // invokeLater für sichere parallel Verarbeitung
    SwingUtilities.invokeLater(() -> {
        JFrame gridLayoutExample = new GridLayoutExample();
        gridLayoutExample.setVisible(true);
        System.out.println("Starting UI-Frame - " + Thread.currentThread());
      }
    );
    System.out.println("Added UI-Frame to starting queue - " + Thread.currentThread());
  }
}
