package com.kish.xdoc.dbo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Created by ThejKishore on 1/3/2017.
 */
@JsonIgnoreProperties
public class Contact implements Serializable{
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object rhs) {
        return EqualsBuilder.reflectionEquals(this,rhs);
    }

    public Contact getDifferenceObject(Contact rhs){
        Contact differencecontact =new Contact();
        differencecontact.setAddress(stringDiff(this.getAddress(),rhs.getAddress()));
        differencecontact.setEmail(stringDiff(this.getEmail(),rhs.getEmail()));
        differencecontact.setTelephone(stringDiff(this.getTelephone(),rhs.getTelephone()));
        differencecontact.setName(stringDiff(this.getName(),rhs.getName()));
        return differencecontact;
    }



    private String stringDiff(String lhs,String rhs){
        if(StringUtils.isBlank(lhs)){
            return rhs;
        }
        if(StringUtils.isBlank(rhs)){
            return lhs;
        }
        if(!StringUtils.equals(lhs,rhs)){
            return rhs;
        }else{
            return lhs;
        }
    }
}
