import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmRepositoryTest {
    FilmItem item1 = new FilmItem(1, "1");
    FilmItem item2 = new FilmItem(2, "2");
    FilmItem item3 = new FilmItem(3, "3");
    FilmItem item4 = new FilmItem(4, "4");

   FilmRepository repo = new FilmRepository();

    @Test
    public void removeById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item2.getId());

        FilmItem[] expected = {item1, item3};
        FilmItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        FilmItem[] expected = {item1, item2, item3};
        FilmItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void saveFilm() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        FilmItem[] expected = {item1, item2, item3, item4};
        FilmItem[] actual = repo.save(item4);
        Assertions.assertArrayEquals(expected, actual);

    }
    ////////////////////////////////
    @Test
    public void findById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.findById(item2.getId());

        FilmItem[] expected = {item1, item2, item3};
        FilmItem[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }
    //////////////////////
    @Test
    public void removeALL() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeAll(1);
        repo.removeAll(2);
        repo.removeAll(3);

        FilmItem[] expected = {null};
        FilmItem[] actual = {null};

        Assertions.assertArrayEquals(expected, actual);
    }




}
