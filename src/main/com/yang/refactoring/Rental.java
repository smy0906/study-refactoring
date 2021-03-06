package main.com.yang.refactoring;

/**
 * Created by yang on 2016. 9. 28..
 */
public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    public int getFrequntRenterPoints() {
        return _movie.getFrequntRenterPoints(_daysRented);
    }
}
