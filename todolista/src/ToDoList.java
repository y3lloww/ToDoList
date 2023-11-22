import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<Zadanie> zadanie = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Dodaj nowe zadanie");
            System.out.println("2. Oznacz zadanie jako zakończone");
            System.out.println("3. Usuń zadanie");
            System.out.println("4. Wyświetl listę zadań");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję (1|2|3|4|5): ");

            int wybierz = scanner.nextInt();
            scanner.nextLine();

            switch (wybierz) {
                case 1:
                    System.out.print("Podaj nazwę zadania: ");
                    String nazwaZadania = scanner.nextLine();
                    System.out.print("Podaj opis zadania: ");
                    String opisZadania = scanner.nextLine();
                    Zadanie noweZadanie = new Zadanie(nazwaZadania, opisZadania);
                    zadanie.add(noweZadanie);
                    System.out.println("Zadanie \"" + nazwaZadania + "\" zostało dodane do listy.");
                    break;
                case 2:
                    System.out.println("Lista zadań:");
                    displayTasks(zadanie);

                    System.out.print("Podaj numer zadania do oznaczenia jako zakończone: ");
                    int wykonaneZadanie = scanner.nextInt();
                    if (wykonaneZadanie >= 1 && wykonaneZadanie <= zadanie.size()) {
                        zadanie.get(wykonaneZadanie - 1).zaznaczWykonane();
                        System.out.println("Zadanie \"" + zadanie.get(wykonaneZadanie - 1).pobierzNazwa() + "\" zostało oznaczone jako zakończone.");
                    } else {
                        System.out.println("Nieprawidłowy numer zadania.");
                    }
                    break;
                case 3:
                    System.out.println("Lista zadań:");
                    displayTasks(zadanie);

                    System.out.print("Podaj numer zadania do usunięcia: ");
                    int usunZadanie = scanner.nextInt();
                    if (usunZadanie >= 1 && usunZadanie <= zadanie.size()) {
                        Zadanie removedZadanie = zadanie.remove(usunZadanie - 1);
                        System.out.println("Zadanie \"" + removedZadanie.pobierzNazwa() + "\" zostało usunięte z listy.");
                    } else {
                        System.out.println("Nieprawidłowy numer zadania.");
                    }
                    break;
                case 4:
                    System.out.println("Lista zadań:");
                    displayTasks(zadanie);
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja. Wybierz ponownie.");
            }
        }
    }

    private static void displayTasks(ArrayList<Zadanie> zadania) {
        if (zadania.isEmpty()) {
            System.out.println("(brak zadań)");
        } else {
            for (int i = 0; i < zadania.size(); i++) {
                System.out.println((i + 1) + ". " + zadania.get(i).toString());
            }
        }
    }
}
