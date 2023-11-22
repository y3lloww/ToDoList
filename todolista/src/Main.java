import java.util.ArrayList;
import java.util.Scanner;

class Zadanie {
    private String nazwa;
    private String opis;
    private boolean Wykonane;

    public Zadanie(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.Wykonane = false;
    }

    public String pobierzNazwa() {
        return nazwa;
    }

    public String pobierzOpis() {
        return opis;
    }

    public boolean Wykonane() {
        return Wykonane;
    }

    public void zaznaczWykonane() {
        Wykonane = true;
    }

    @Override
    public String toString() {
        return (Wykonane ? "[x] " : "[ ] ") + nazwa + ": " + opis;
    }
}

