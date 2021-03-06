package dtos;

import entities.CityInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
public class CityInfoDTO {
    private Long id;
    private String zipcode;
    private String city;

    public CityInfoDTO(CityInfo cityInfo) {
        if(cityInfo.getId() != null)
            this.id = cityInfo.getId();
        this.zipcode = cityInfo.getZipcode();
        this.city = cityInfo.getCity();
    }

    public static Set<CityInfoDTO> getCityInfoDTOs(List<CityInfo> cityInfos){
        Set<CityInfoDTO> cityInfoDTOs = new HashSet<>();
        cityInfos.forEach(c->cityInfoDTOs.add(new CityInfoDTO(c)));
        return cityInfoDTOs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CityInfoDTO{" +
                "id=" + id +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityInfoDTO that = (CityInfoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(zipcode, that.zipcode) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zipcode, city);
    }
}
