package main.com.yang.refactoring;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by yang on 2016. 9. 28..
 */
public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }
    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = getName() + "'s Movie Rental Records\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            frequentRenterPoints += each.getFrequntRenterPoints();

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

            totalAmount += each.getCharge();
        }
        result += "Total Amount : " + String.valueOf(totalAmount) + "\n";
        result += "Renter Points : " + String.valueOf(frequentRenterPoints);
        return result;
    }



}
