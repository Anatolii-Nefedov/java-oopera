import java.util.ArrayList;
import java.util.Scanner;

public class Show {
    String title;
    double duration;
    Director director;
    ArrayList<Actor> listOfActors;

    public Show(String title, double duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }

    public void printDirectorInfo() {
        System.out.println("Режиссёр: " + director);
    }

    public void addActor(Actor newActor) {
        for (Actor existingActor : listOfActors) {
            if (existingActor.equals(newActor)) {
                System.out.println("Извините, такой актёр " + newActor + " уже есть в списке!");
                return;
            }
        }
        listOfActors.add(newActor);
        System.out.println("Актер " + newActor + " успешно добавлен!");
    }

    public void printShowActors() {
        System.out.println("Актеры в спектакле " + title + ":");
        if (listOfActors.isEmpty()) {
            System.out.println("  Список актеров пуст");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println("  - " + actor);
            }
        }
    }

    public void replaceActor(String surname, Actor newActor) {
        ArrayList<Actor> found = new ArrayList<>();
        ArrayList<Integer> sameSurname = new ArrayList<>();
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor existingActor = listOfActors.get(i);
            if (existingActor.getSurname().equals(surname)) {
                found.add(existingActor);
                sameSurname.add(i);
            }
        }
        if (found.isEmpty()){
            System.out.printf("Актёр с фамилией " + surname + " не найден.");
            return;
        } if (found.size() == 1) {
            int index = sameSurname.get(0);
            System.out.println("Найден один актёр: " + found.get(0));
            System.out.print("Заменить его на " + newActor + "?");
            System.out.println("Напечатайте << ЗАМЕНИТЬ >> для замены");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("ЗАМЕНИТЬ")) {
                listOfActors.set(index, newActor);
                System.out.println("Замена выполнена.");
            } else {
                System.out.println("Введена неизвестная компандал.");
            }
            return;
        }
        System.out.println("Найдено несколько актёров с фамилией " + surname + ":");
        for (int i = 0; i < found.size(); i++) {
            System.out.println((i + 1) + ". " + found.get(i));
        }
        System.out.print("Выберите номер актёра для замены (1-" + found.size() + "): ");

        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод.");
            return;
        }

        if (choice < 1 || choice > found.size()) {
            System.out.println("Номер вне диапазона.");
            return;
        }

        int indexToReplace = sameSurname.get(choice - 1);
        listOfActors.set(indexToReplace, newActor);
        System.out.println("Актёр " + found.get(choice - 1) + " заменён на " + newActor);
    }
    }
