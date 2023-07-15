package sg.edu.rp.c346.id22011117.lesson9song;

public class ListView {

    private int id;
    private String title;
    private String singers;
    private String year;
    private String stars;

    public ListView(int id, String title, String singers, String year, String stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;

    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getSingers() { return singers;}

    public String getYear() { return year;}

    public String getStars() { return stars;}

    public String toString() {
        return id + "\n" + title + "\n" + singers + "\n" + year + "\n" + stars;
    }
}

