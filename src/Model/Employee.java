package Model;

public class Employee {
    protected int id;
    protected String name;
    protected int yearOfBirth;
    protected int experience;

    protected boolean higherEducation;

    public Employee(int id, String name, int yearOfBirth, int experience, boolean higherEducation) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.experience = experience;
        this.higherEducation = higherEducation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getExperience() {
        return experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", name = " + name +
                ", yearOfBirth = " + yearOfBirth +
                ", experience = " + experience +
                ", higher education = " + higherEducation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee emplyee = (Employee) o;

        return id == emplyee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
