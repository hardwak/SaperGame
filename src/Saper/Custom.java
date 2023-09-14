package Saper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

public class Custom implements MouseListener{

    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JLabel HeightLabel = new JLabel();
    JLabel WidthLabel = new JLabel();
    JTextField HeighText = new JTextField(3);
    JTextField WidthText = new JTextField(3);
    JButton SubmitButton = new JButton();


    public Custom(){

        frame.setSize(200,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        panel.add(WidthLabel);
        panel.add(WidthText);
        panel.add(HeightLabel);
        panel.add(HeighText);
        panel.add(SubmitButton);

        WidthLabel.setText("X");

        HeightLabel.setText("Y");

        SubmitButton.setText("Submit");
        SubmitButton.addMouseListener(this);


        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    int x;
    int y;
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == SubmitButton){
            x = Integer.valueOf(WidthText.getText());
            y = Integer.valueOf(HeighText.getText());
            frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            new GUI(x, y);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

