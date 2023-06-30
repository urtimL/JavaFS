package Model;

import java.util.Objects;

public class Emplyee {
    protected int id;
    protected String name;
    protected int yearOfBirth;
    protected int experience;

    public Emplyee(int id, String name, int yearOfBirth, int experience) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.experience = experience;
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
        return "id=" + id +
                ", name=" + name +
                ", yearOfBirth=" + yearOfBirth +
                ", experience=" + experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emplyee)) return false;

        Emplyee emplyee = (Emplyee) o;

        return id == emplyee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
