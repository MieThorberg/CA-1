package entities;

import dtos.AddressDTO;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "Address.deleteAllRows", query = "DELETE from Address")
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String additionalInfo;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY, orphanRemoval = true)
    @CascadeOnDelete
    private Set<Person> persons = new HashSet<>();

    @ManyToOne (fetch = FetchType.LAZY)
    private CityInfo cityInfo;

    public Address() {
    }

    public Address(String street, String additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
    }

    public Address(Long id, String street, String additionalInfo, Set<Person> persons, CityInfo cityInfo) {
        this.id = id;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.persons = persons;
        this.cityInfo = cityInfo;
    }

    public Address(String street, String additionalInfo, CityInfo cityInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.cityInfo = cityInfo;
    }

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.getStreet();
        this.additionalInfo = addressDTO.getAdditionalInfo();
        this.cityInfo = new CityInfo(addressDTO.getZipcode(), addressDTO.getCity());
    }

    public void addPerson(Person person) {
        if(person.getAddress() != this) {
            this.persons.add(person);
            person.setAddress(this);
        }
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
        cityInfo.addAddress(this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalinfo) {
        this.additionalInfo = additionalinfo;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", persons=" + persons +
                ", cityInfo=" + cityInfo +
                '}';
    }
}
