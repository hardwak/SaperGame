package Saper;


import Saper.Menu.Menu;

public class Game {
    public static void main(String[] args) {
        //GUI GUI1 = new GUI(16 ,16);
        //new Menu();
        new Menu();
        /*
        int dlugosc = 10;
        int szerokosc = 10;
        Plansza board = new Plansza(dlugosc,szerokosc);
        System.out.println("Wpisz współrzędne (x, y) pierwszego kroku");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        board.WybierzIRozpocznij(x,y);
        board.WyprintujPlansze();

        while (board.isCzyGramy()){

            System.out.println("Wybierz co chcesz zrobić:");
            System.out.println("1 - Zrobić następny krok");
            System.out.println("2 - Zaznaczyć albo usunąć flagę");

            int krok = scanner.nextInt();

            System.out.println("Wpisz współrzędne (rzad, kolumna)");

            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();


            if (x0 < szerokosc && y0 < dlugosc) {
                if (krok == 1) {
                    if (board.whatStan(x0 + 1, y0 + 1) != "flaga") {
                        if (board.isBomb(x0 + 1, y0 + 1)) {
                            System.out.println("Bomba wybuchła");
                            board.bombExploded();
                            board.setCzyGramy(false);
                        } else {
                            board.Odkryj(x0 + 1, y0 + 1);
                            board.WyprintujPlansze();
                        }
                    } else
                        System.out.println("Zaznaczyłeś tam flagę");

                }
                if (krok == 2) {
                    board.zaznaczFlagę(x0 + 1, y0 + 1);
                    board.WyprintujPlansze();
                }



                if (board.isGameFinished()) {
                    System.out.println("Wygrałeś!");
                    board.setCzyGramy(false);
                }
            }
            else
                System.out.println("Wpisz prawidlowe wspolrzedne");
        }
        */

    }
}

