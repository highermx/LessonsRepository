public class Employee {
    String name;
    String profession;
    String email;
    long phone;
    int age;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", age=" + age +
                '}';
    }

    public Employee(String name, String profession, String email, long phone, int age) {
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
