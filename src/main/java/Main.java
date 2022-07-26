import zadanie1.ObjectContainer;
import zadanie1.Person;
import zadanie2.MinMax;
import zadanie2.MinMaxService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {


        /*
        Zadanie 01: Bez uzycia struktur danych typu kolekcje, tablice, mapy czy zapisywania do pliku, nalezy stworzyc klase ObjectContainer w taki sposob aby wykonal
sie ponizszy kod: (przyklad dla klasy Person (name, city, age) - ale ma dzialac dla dowolnej klasy)

ObjectContainer<Person> peopleFromWarsaw = new ObjectContainer(p -> p.getCity().equals("Warsaw"));//tu w konstruktorze podajemy warunek do dodawania osoby do kontenera.
peopleFromWarsaw.add(new Person("Jan", "Warsaw", 30)); // powinno byc ok, Jan jest z warszawy
peopleFromWarsaw.add(new Person("Weronika","Warsaw", 20)); // powinno byc tez okej, Weronika jest z warszawy
peopleFroWarsaw.add(new Person("Waldek", "Monaco", 34));// no waldka niedoda, jest z Monaco, wiec tu powinno albo rzucic wyjatkiem, albo metoda add powinna zwrocic po prostu false - co wybierzesz to twoja decyzja.

//do tego ponizej mozesz juz stosowac liste, no bo masz zwrocic liste:)

List<Person> females = peopleFromWarsaw.getWithFilter(p -> p.getName().endsWith("a")); // zwraca nam wszystkie osoby spelniajace dany warunek.
peopleFromWarsaw.removeIf(p -> p.getAge() > 50); // powinno nam usuwac ludzi spelniajacy dany warunek w nawiasie.

//tu naturalnie mozesz stosowac zapis do pliku bo wymaga tego polecenie

peopleFromWarsaw.storeToFile("youngPeopleFromWarsaw.txt", p -> p.getAge() < 30, p -> p.getName()+";"+p.getAge()+";"+p.getCity());

//metoda powinna zapisac obiekty do pliku z pierwszego argumenty metody, tylko te co spelniaja drugi warunek metody, w formacie z trzeciego warunku metody.


Zadanie 02: Stworz klase MinMax<T extends Comparable> ktora jako pola klasy pobiera instancje T max oraz T min
Nastepnie stworz klase MinMaxService ktora bedzie miala statyczna metode MinMax<cos tutaj> getMinAndMax(List<cos tutaj> elements) zadaniem tej metody jest zwracanie mina i maxa z listy w tym jednym obiekcie wg naturalnego porządku jaki gwarantuje komparator, klasa MinMax powinna byc generyczna i metody getMin oraz getMax powinny zwraca instancje tego co bedzie na liscie elements, czyli jak przekazemy liste stringow to getMax ma zwraca String, getMin tez stringa a jak damy liste osob to ma getMax zwraca osobe, itp itd.

         */


        ObjectContainer<Person> peopleFromWarsaw = new ObjectContainer<>(p -> p.getCity().equals("Warsaw"));
        peopleFromWarsaw.add(new Person("Robert", "Warsaw", 30));
        peopleFromWarsaw.add(new Person("Janusz", "Warsaw", 40));
        //peopleFromWarsaw.add(null);
        peopleFromWarsaw.add(new Person("Jan", "Warsaw", 30)); // powinno byc ok, Jan jest z warszawy
        peopleFromWarsaw.add(new Person("Weronika", "Warsaw", 20)); // powinno byc tez okej, Weronika jest z warszawy
        //peopleFromWarsaw.add(new Person("Waldek", "Monaco", 34));// no waldka niedoda, jest z Monaco, wiec tu powinno albo rzucic wyjatkiem, albo metoda add powinna zwrocic po prostu false - co wybierzesz to twoja decyzja.

        List<Person> females = peopleFromWarsaw.getWithFilter(p -> p.getName().endsWith("a"));
        for (Person f : females) {
            System.out.println(f.getName());
        }


        peopleFromWarsaw.removeIf(p -> p.getAge() > 50);

        List<Person> all = peopleFromWarsaw.getWithFilter(Objects::nonNull);
        for (Person f : all) {
            System.out.println(f.getName());
        }

        System.out.println();


        peopleFromWarsaw.storeToFile("youngPeopleFromWarsaw.txt", p -> p.getAge() < 60, p -> p.getName() + ";" + p.getAge() + ";" + p.getCity());


        List<Person> all2 = peopleFromWarsaw.getWithFilter(Objects::nonNull);
        for (Person f : all2) {
            System.out.println(f.getName());
        }

        //MinMax<?> mm = MinMaxService.getMinAndMax(Arrays.asList("kot", "piesel", "czlowiek"));
        MinMax<?> mm = MinMaxService.getMinAndMax(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
        //MinMax<?> mm = MinMaxService.getMinAndMax(null);
        System.out.println(mm.getMin());
        System.out.println(mm.getMax());
    }
}
