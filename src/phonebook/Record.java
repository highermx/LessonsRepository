package phonebook;

public class Record {
    private String name;
    private int phone;

    public Record(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

    public int getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
