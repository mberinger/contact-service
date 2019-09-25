package uk.co.mikebelringer.contact.server;

import uk.co.mikebelringer.person.types.Person;

public class PersonContact {
    private Person person;
    private String telephone;

    public PersonContact(Person person, String telephone) {
        this.person = person;
        this.telephone = telephone;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
