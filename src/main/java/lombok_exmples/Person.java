package lombok_exmples;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class Person {
    private String name;
    private int age;
    private int salary;

    public Person() {
    }


    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getAge() != other.getAge()) return false;
        if (this.getSalary() != other.getSalary()) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getAge();
        result = result * PRIME + this.getSalary();
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Person;
    }

    public String toString() {
        return "lombok_exmples.Person(name=" + this.getName() + ", age=" + this.getAge() + ", salary=" + this.getSalary() + ")";
    }
}
