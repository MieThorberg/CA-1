/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Person;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.List;

/**
 *
 * @author tha
 */

public class PersonDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Set<PhoneDTO> phones;
    private AddressDTO address;
    private Set<HobbyDTO> hobbies;

    public PersonDTO(Person person) {
        if(person.getId() != null)
            this.id = person.getId();
        this.firstname = person.getFirstname();
        this.lastname = person.getLastname();
        this.email = person.getEmail();
        this.phones = PhoneDTO.getPhoneDTOs(person.getPhones());
        this.address = new AddressDTO(person.getAddress());
        this.hobbies = HobbyDTO.getHobbyDTOs(person.getHobbies());
    }

    public static Set<PersonDTO> getPersonDTOs(List<Person> person){
        Set<PersonDTO> personDTOS = new HashSet<>();
        person.forEach(p->personDTOS.add(new PersonDTO(p)));
        return personDTOS;
    }

    public static Set<PersonDTO> getPersonDTOs(Set<Person> person){
        Set<PersonDTO> personDTOS = new HashSet<>();
        person.forEach(p->personDTOS.add(new PersonDTO(p)));
        return personDTOS;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneDTO> phones) {
        this.phones = phones;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Set<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phones=" + phones +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(firstname, personDTO.firstname) && Objects.equals(lastname, personDTO.lastname) && Objects.equals(email, personDTO.email) && Objects.equals(phones, personDTO.phones) && Objects.equals(address, personDTO.address) && Objects.equals(hobbies, personDTO.hobbies);
    }



    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, email, phones, address, hobbies);
    }
}
