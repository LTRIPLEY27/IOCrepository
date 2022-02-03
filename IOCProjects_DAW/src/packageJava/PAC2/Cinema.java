package packageJava.PAC2;

public class Cinema {
    private String movies;
    private double payMovie;
    private String date;
    private int cantity;
    private double totalCost;
    
    public Cinema(){
        this.movies = "";
        this.payMovie = 0.0;
        this.date = "";
        this.cantity = 0;
        this.totalCost = 0.0;
    }

    public Cinema(String movies, double payMovie, String date, int cantity) {
        this.movies = movies;
        this.payMovie = payMovie;
        this.date = date;
        this.cantity = cantity;
        this.totalCost = payMovie * cantity;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public double getPayMovie() {
        return payMovie;
    }

    public void setPayMovie(double payMovie) {
        this.payMovie = payMovie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCantity() {
        return cantity;
    }

    public void setCantity(int cantity) {
        this.cantity = cantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
 

    @Override
    public String toString() {
        return "Película = " + movies + "\nPrecio Entrada = " + payMovie + "\nHorario Pelicula = " + date + "\nCantidad entradas = " + cantity + "\nTotal a pagar = " + totalCost;
    }
    
    
}
