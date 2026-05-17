import java.util.Objects;

public class Actor extends Person{
    private double height;

    public Actor(String name, String surname, Gender gender, double height) {
        super(name, surname, gender);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return   super.toString() + "(" + height + "см.)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Actor other = (Actor) obj;

        return this.getName().equals(other.getName()) &&
                this.getSurname().equals(other.getSurname()) &&
                Double.compare(height, other.height) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), height);
    }
}



