package ru.geekbrains.interview.prep.lessons.lesson1.task1;

public class Person {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String country;
    private final String address;
    private final String phone;
    private final int age;
    private final String gender;

    private Person(PersonBuilder personBuilder){
        this.firstName = personBuilder.firstName;
        this.middleName = personBuilder.middleName;
        this.lastName = personBuilder.lastName;
        this.country = personBuilder.country;
        this.address = personBuilder.address;
        this.phone = personBuilder.phone;
        this.age = personBuilder.age;
        this.gender = personBuilder.gender;
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }

    public static class PersonBuilder{

        private String firstName;
        private String middleName;
        private String lastName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        private PersonBuilder(){}

        public PersonBuilder addFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder addMiddleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder addLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder addCountry(String country){
            this.country = country;
            return this;
        }

        public PersonBuilder addAddress(String address){
            this.address = address;
            return this;
        }

        public PersonBuilder addPhone(String phone){
            this.phone = phone;
            return this;
        }

        public PersonBuilder addAge(int age){
            this.age = age;
            return this;
        }

        public PersonBuilder addGender(String gender){
            this.gender = gender;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
