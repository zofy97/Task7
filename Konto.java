package task7_2;

class Konto {
    double kontostand;
    
    Konto(double k) {
        kontostand = k;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }
    
    public double einzahlen(double summe){
        return kontostand += summe;
    }
}