package student_class;

public class Student {
    private String name;
    private String address;
    private float average;

    protected Student() {

    }

    public Student( String name, String address, float average) {
        this.name = name;
        this.address = address;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", average=" + average +
                '}';
    }
}
