package Saper;
import Saper.Menu.Menu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;


public class GUI implements MouseListener{

    //deklarowanie zmiennych
    JFrame frame;
    JPanel textPanel;
    JPanel buttonPanel;
    JButton[][] buttons;
    JLabel textfield;
    JPanel resetAndMenuPanel;
    JButton resetButton;
    JButton menuButton;

    //deklarowanie ikon
    ImageIcon bomb = new ImageIcon("src/Saper/resources/mine.png");
    ImageIcon flag = new ImageIcon("src/Saper/resources/flag.png");

    Color tileColor = Color.lightGray;
    int XSize;
    int YSize;

    int WindowWidth = 540;
    int WindowHeight = 600;



    //tworzenie GUI(kolor poszczegolnych przyciskow, paneli tekstow)
    public GUI(int XSize, int YSize){

        this.XSize = XSize;
        this.YSize = YSize;

        frame=new JFrame();
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WindowWidth, WindowHeight);
        frame.revalidate();
        frame.setLocation(0,0);

        textPanel=new JPanel();
        textPanel.setVisible(true);
        textPanel.setBackground(new Color(64,64,64));

        buttonPanel=new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.setLayout(new GridLayout(YSize,XSize));
        buttonPanel.setBorder(new LineBorder(Color.black));
        //buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        resetAndMenuPanel = new JPanel();
        resetAndMenuPanel.setVisible(true);
        //resetAndMenuPanel.setBorder(new LineBorder(new Color(255, 255, 255))); // tworzenie niewidzalnego borderu

        textfield=new JLabel();
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setFont(new Font("MV Boli",Font.BOLD,20));
        textfield.setForeground(new Color(211,211,211));
        textfield.setText("Minesweeper");

        resetButton=new JButton();
        resetButton.setForeground(Color.black);
        resetButton.addMouseListener(this);
        resetButton.setText("Reset");
        //resetButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        resetButton.setBackground(Color.WHITE);
        resetButton.setFocusable(false);

        menuButton=new JButton();
        menuButton.setForeground(Color.black);
        menuButton.addMouseListener(this);
        menuButton.setText("Menu");
       // menuButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        menuButton.setBackground(Color.WHITE);
        menuButton.setFocusable(false);


        buttons=new JButton[YSize][XSize];

        for(int i=0; i<buttons.length; i++)
        {
            for(int j=0; j<buttons[0].length; j++)
            {
                buttons[i][j]=new JButton();
                buttons[i][j].setFocusable(false);
                //buttons[i][j].setFont(new Font("MV Boli",Font.BOLD,12));
                buttons[i][j].addMouseListener(this);
                buttons[i][j].setText("");
                buttons[i][j].setBorder( new LineBorder(Color.gray) ); //robienie z nich ostrych prostoaktow nwm czy to zostawic
                buttons[i][j].setBackground(tileColor);
                buttons[i][j].setOpaque(true);
                buttonPanel.add(buttons[i][j]);

            }
        }

        resetAndMenuPanel.add(menuButton);
        resetAndMenuPanel.add(resetButton);
        textPanel.add(textfield);

        frame.add(textPanel,BorderLayout.NORTH);
        frame.add(buttonPanel,BorderLayout.CENTER);
        frame.add(resetAndMenuPanel,BorderLayout.AFTER_LAST_LINE);


        }



    int klikniecia = 0;

    Plansza board = new Plansza(0,0);
    Pole[][] plansza = board.getPlansza();


    @Override
    public void mouseClicked(MouseEvent e) {
        for (int y = 0; y < YSize; y++) {
            for (int x = 0; x < XSize; x++) {
                if (e.getSource() == buttons[y][x] && SwingUtilities.isLeftMouseButton(e) && board.isCzyGramy()) {
                    klikniecia++;
                    if (klikniecia == 1) {
                        board = new Plansza(YSize,XSize);       //ustawiamy nowa plansze i pola o danej dlugosci
                        plansza = board.getPlansza();

                        board.WybierzIRozpocznij(y, x);     // pierwsze klikniecie, by nie kliknac w bombe
                        SettingTiles();
                    } else {
                        if (!board.whatStan(y + 1, x + 1).equals("flaga")) {  //sprawdzamy czy jest flaga, by nie odslonic tego pola
                            if (board.isBomb(y + 1, x + 1)) {
                                buttons[y][x].setIcon(bomb);                //klikniecie w bombe
                                board.setCzyGramy(false);
                                RevealingBombs();
                                textfield.setText("PRZEGRALES");  // wyswietlanie napisu przegrana i pop up message
                                JOptionPane.showMessageDialog(frame, "PRZEGRALES");
                            } else {
                                board.Odkryj(y + 1, x + 1);
                            }
                        }
                        //ustawiamy pola,
                        SettingTiles();

                    }
                        if (board.isGameFinished()){ textfield.setText("WYGRALES");
                            JOptionPane.showMessageDialog(frame, "WYGRALES");       //wygrana
                            board.setCzyGramy(false);}
                }

                if (e.getSource() == buttons[y][x] && SwingUtilities.isRightMouseButton(e) && board.isCzyGramy()) {
                    if (plansza[y + 1][x + 1].getStan().equals("flaga")) {
                        buttons[y][x].setIcon(null);                                        //ustawianie flagi
                        plansza[y+1][x+1].setStan("zakryty");
                    }
                    else if (!plansza[y + 1][x + 1].getStan().equals("odkryty")){
                        buttons[y][x].setIcon(flag);
                        plansza[y+1][x+1].setStan("flaga");
                    }
                }
            }
        }
        if (e.getSource() == resetButton) {
            Reset();
        }

        else if (e.getSource() == menuButton){
            frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            new Menu();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //mouseClicked(e);
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

    public void Reset(){  //resetuje klikniecia, plansze, setCzyGramy true i zakrywa wszystkie pola na nowo
        klikniecia = 0;
        board = new Plansza(YSize, XSize);
        plansza = board.getPlansza();
        board.setCzyGramy(true);
        textfield.setText("Minesweeper");

        for (int y = 0; y < YSize; y++) {
            for (int x = 0; x < XSize; x++) {
                plansza[y+1][x+1].setStan("zakryty");
                buttons[y][x].setIcon(null);
                buttons[y][x].setBackground(tileColor);
                buttons[y][x].setText("");
            }
        }
    }
    public void SettingTiles(){
        for (int y1 = 0; y1 < YSize; y1++) {             //przechodzimy przez wszystkie pola i jest ustawiamy
            for (int x1 = 0; x1 < XSize; x1++){
                if(plansza[y1+1][x1+1].getStan().equals("odkryty")){

                    if(plansza[y1+1][x1+1].getIleBombGraniczy() == 0){
                        buttons[y1][x1].setText("");            //pola bez sasiadujacych bomb
                    }
                    else {
                        buttons[y1][x1].setText(String.valueOf(plansza[y1 + 1][x1 + 1].getIleBombGraniczy()));
                        int ileSasiadow = plansza[y1 + 1][x1 + 1].getIleBombGraniczy();
                        buttons[y1][x1].setForeground(ColorOfNumbers(ileSasiadow));
                    }
                    buttons[y1][x1].setIcon(null);
                    buttons[y1][x1].setBackground(null);
                }
            }
        }
    }

    public void RevealingBombs(){
        for (int y1 = 0; y1 < YSize; y1++) {
            for (int x1 = 0; x1 < XSize; x1++){
                if(plansza[y1+1][x1+1].getCzyBomba()){
                    buttons[y1][x1].setBackground(null); //odkrywanie bomb
                    buttons[y1][x1].setIcon(bomb);
                }
            }
        }
    }

    public Color ColorOfNumbers(int ileSasiadow){
        return switch (ileSasiadow) {
            case 1 -> new Color(2, 2, 245, 255);
            case 2 -> new Color(35, 129, 42, 255);
            case 3 -> new Color(245, 11, 9, 255);
            case 4 -> new Color(7, 12, 129, 255);
            case 5 -> new Color(125, 4, 7, 255);
            case 6 -> new Color(5, 130, 123, 25);
            case 7 -> new Color(3, 3, 3, 255);
            case 8 -> new Color(130, 130, 130, 255);
            default -> null;
        };
    }

}

