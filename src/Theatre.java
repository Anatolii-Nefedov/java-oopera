import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {
        System.out.println("Поехали!\n");

        Actor actor1 = new Actor("Джонни", "Депп", Gender.MALE, 185);
        Actor actor2 = new Actor("Марго", "Робби", Gender.FEMALE, 165.0);
        Actor actor3 = new Actor("Том", "Харди", Gender.MALE, 175.0);

        Director director1 = new Director("Кристофер", "Нолан", Gender.MALE, 30);
        Director director2 = new Director("Грета", "Гервиг", Gender.FEMALE, 12);

        String musicAuthor = "Джакомо Пуччини";
        String choreographer = "Джордж Баланчин";

        Show regularShow = new Show("Довод", 145.0, director1, new ArrayList<>());
        Opera opera = new Opera("Богема", 180.0, director2, new ArrayList<>(), musicAuthor,
                "Либретто оперы Богема", 40);
        Ballet ballet = new Ballet("Лебединое озеро", 130.0, director1, new ArrayList<>(),
                "Чайковский", "Либретто балета Лебединое озеро", choreographer);

        regularShow.addActor(actor1);
        regularShow.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        ballet.addActor(actor1);
        ballet.addActor(actor3);

        System.out.println("Список актеров!");
        regularShow.printShowActors();
        System.out.println();
        opera.printShowActors();
        System.out.println();
        ballet.printShowActors();
        System.out.println();

        Actor newActor = new Actor("Брэд", "Питт", Gender.MALE, 185.0);
        regularShow.replaceActor("Депп", newActor);
        System.out.println("Актуализирую список.");
        regularShow.printShowActors();
        System.out.println();

        opera.replaceActor("Форд", newActor);
        System.out.println();

        System.out.println("Опера: " + opera.getLibrettoText());
        System.out.println("Балет: " + ballet.getLibrettoText());
    }
}
