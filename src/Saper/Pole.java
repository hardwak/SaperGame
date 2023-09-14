package Saper;

public class Pole {
    private boolean CzyBomba;
    private String stan; //1-zakryty, 2-odkryty 3-flaga
    private int IleBombGraniczy;

    public Pole(){
        this.CzyBomba = false;
        this.stan="zakryty";
        this.IleBombGraniczy=1;

    }

    public Pole(boolean CzyBomba, String stan, int ileBombGraniczy){
        this.CzyBomba = CzyBomba;
        this.stan = stan;
        this.IleBombGraniczy=ileBombGraniczy;

    }

    public boolean getCzyBomba() {
        return CzyBomba;
    }

    public String getStan() {
        return stan;
    }

    public void setCzyBomba(boolean czyBomba) {
        this.CzyBomba = czyBomba;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public int getIleBombGraniczy() {
        return IleBombGraniczy;
    }

    public void setIleBombGraniczy(int ileBombGraniczy) {
        this.IleBombGraniczy = ileBombGraniczy;
    }
}
