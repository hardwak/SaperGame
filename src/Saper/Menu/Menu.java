package Saper.Menu;

import Saper.Custom;
import Saper.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

public class Menu implements MouseListener {
    private JButton EasyModeButton;
    private JButton HardModeButton;
    private JButton ExtremeModeButton;
    private JPanel menuPanel;

    private JPanel textPanel;

    private JLabel textfield;

    ImageIcon EasyModeIcon = new ImageIcon("src/Saper/resources/8x8.png");
    ImageIcon HardModeIcon = new ImageIcon("src/Saper/resources/16x16.png");

    JFrame frame;

    public Menu(){
        frame=new JFrame();
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,280);
        frame.add(menuPanel);

        textPanel=new JPanel();
        textPanel.setVisible(true);
        textPanel.setBackground(new Color(64,64,64));

        textfield=new JLabel();
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setFont(new Font("MV Boli",Font.BOLD,20));
        textfield.setForeground(new Color(211,211,211));
        textfield.setText("MENU");

        textPanel.add(textfield);
        frame.add(textPanel,BorderLayout.NORTH);


        EasyModeButton.addMouseListener(this);
        HardModeButton.addMouseListener(this);
        ExtremeModeButton.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == EasyModeButton) {
            frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            new GUI(12, 12);
        }

        else if (e.getSource() == HardModeButton) {
            frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            new GUI(20, 20);
        }

        else if (e.getSource() == ExtremeModeButton) {
            frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            new GUI(40,40);
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
