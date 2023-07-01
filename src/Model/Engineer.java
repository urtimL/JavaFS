package Model;

public class Engineer extends Employee {
    double rate;
    int hours;

    public Engineer(int id, String name, int yearOfBirth, int experience, boolean higherEducation, double rate, int hours) {
        super(id, name, yearOfBirth, experience, higherEducation);
        this.rate = rate;
        this.hours = hours;
    }

    public double salary(){
        return rate * hours;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                super.toString() +
                ", rate = " + rate +
                ", hours = " + hours + ";";
    }
}
