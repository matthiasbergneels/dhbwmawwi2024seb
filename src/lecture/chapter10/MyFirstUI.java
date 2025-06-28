package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class MyFirstUI {

  public static void main(String[] args) {
    System.out.println("Start Ui...");
    JFrame myFrame = new JFrame();
    myFrame.setTitle("MyFirstUI");


    JPanel myPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));


    JButton myButton = new JButton("Juhu!");
    JLabel myLabel = new JLabel("Bitte nicht den Button drücken!");

    myFrame.add(myPanel);
    myPanel.add(myButton);
    myPanel.add(myLabel);
    myPanel.add(new JLabel("Hallo1"));
    myPanel.add(new JLabel("Hallo2"));
    myPanel.add(new JLabel("Hallo3"));
    myPanel.add(new JLabel("Hallo4"));



    myFrame.pack();
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setVisible(true);

    System.out.println("Ende main()");

  }

}
