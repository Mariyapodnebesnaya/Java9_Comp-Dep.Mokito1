import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class FilmManagerTest {
    FilmRepository repo = Mockito.mock(FilmRepository.class);
    Manager manager = new Manager(repo);

    FilmItem item1 = new FilmItem(1, "1");
    FilmItem item2 = new FilmItem(2, "2");
    FilmItem item3 = new FilmItem(3, "3");
    FilmItem item4 = new FilmItem(4, "4");

    @Test
    public void findAllFilm() {
       FilmItem[] items = {item1,item2,item3,item4};
       doReturn(items).when(repo).findAll();

        FilmItem[] expected = {item1, item2, item3, item4};
        FilmItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeById() {
        FilmItem[] items = {item1,item2,item4};
        doReturn(items).when(repo).removeById(item3.getId());

        FilmItem[] expected = {item1,item2,item4};
        FilmItem[] actual = repo.removeById(3);

        Assertions.assertArrayEquals(expected, actual);
    }


}
