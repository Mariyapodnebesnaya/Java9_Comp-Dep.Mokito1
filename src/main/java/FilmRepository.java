public class FilmRepository {
    private FilmItem[] items = new FilmItem[0];

    public FilmItem[] save(FilmItem item) {
        FilmItem[] tmp = new FilmItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
        return tmp;
    }

    public FilmItem[] removeById(int id) {
        FilmItem[] tmp = new FilmItem[items.length - 1];
        int copyToIndex = 0;
        for (FilmItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
        return tmp;
    }

    public void removeAll(int id) {
        items = null;
    }

    public void findById(int id) {
        for (FilmItem item : items) {
            if (item.getId() == id) {
                return;
            }
        }
    }

    public FilmItem[] getItems() {
        return items;
    }

    public FilmItem[] findAll() {
        return items;
    }
}
