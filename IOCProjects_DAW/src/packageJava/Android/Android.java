package packageJava.Android;
public class Android {
    private boolean teclat;
    private String screen;
    private String model;
    private int year;

    public Android(boolean teclat, String screen, String model, int year) {
        this.teclat = teclat;
        this.screen = screen;
        this.model = model;
        this.year = year;
    }

    public boolean isTeclat() {
        return teclat;
    }

    public void setTeclat(boolean teclat) {
        this.teclat = teclat;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Android{" + "teclat=" + teclat + ", screen=" + screen + ", model=" + model + ", year=" + year + '}';
    }

}
