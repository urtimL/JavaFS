package Model;

public class Worker extends Employee {
    double rate;
    int hours;

    public Worker(int id, String name, int yearOfBirth, int experience, boolean higherEducation, double rate, int hours) {
        super(id, name, yearOfBirth, experience, higherEducation);
        this.rate = rate;
        this.hours = hours;
    }

    public double getSalary(){
        return rate * hours;
    }

    @Override
    public String toString() {
        return "Worker{" +
                super.toString() +
                ", rate = " + rate +
                ", hours = " + hours + "};";
    }
}
