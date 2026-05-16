import java.util.ArrayList;

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

    public void addActor (Actor newActor){
        for (Actor existingActor : listOfActors){
            if(existingActor.equals(newActor)){
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
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor existingActor = listOfActors.get(i);
            if (existingActor.getSurname().equals(surname)) {
                listOfActors.set(i, newActor);
                System.out.println("Актер с фамилией " + surname + " заменен на " + newActor);
                return;
            }
        }
        System.out.println("Извините, актер с фамилией " + surname + " не найден в списке");
    }
}
