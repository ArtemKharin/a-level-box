package ua.kharin.jadv.practice10.classes;

public class Person {

    Account account;
    private String name;

    Person(String name, String password) {
        this.name = name;
        account = new Account(password);
    }

    public void displayPerson() {
        System.out.printf("Person \t Name: %s \t Password: %s \n", name, account.password);
    }

    public class Account {
        private String password;

        Account(String pass) {
            this.password = pass;
        }

        void displayAccount() {
            System.out.printf("Account Login: %s \t Password: %s \n", Person.this.name, password);
        }
    }

    public static void main(String[] args) {
        Person tom = new Person("Tom", "qwerty");
        tom.displayPerson();
        tom.account.displayAccount();
    }
}