package com.example.aroundtheworld.bean;

import com.example.aroundtheworld.exception.PhoneFormatException;
import com.example.aroundtheworld.model.Animal;
import com.example.aroundtheworld.model.FamilyMember;
import com.example.aroundtheworld.model.FamilyPreferences;

import java.util.List;

public class NewFamilyBean {

    private String name;
    private String imgSrc;
    private String city;
    private String address;
    private List<Animal> animals;
    private List<FamilyMember> members;
    private String phone;
    private String email;

    private FamilyPreferences familyPreferences;

    public NewFamilyBean(String name, String city, String address, String phone, String email) throws PhoneFormatException {
        this.name = name;
        this.city = city;
        this.address = address;
        this.setPhoneNumber(phone);
        this.email = email;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void setMembers(List<FamilyMember> members) {
        this.members = members;
    }

    public void setFamilyPrefernces(FamilyPreferences familyPreferences) {
        this.familyPreferences = familyPreferences;
    }

    public String getName() {
        return name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<FamilyMember> getMembers() {
        return members;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public FamilyPreferences getFamilyPrefernces() {
        return familyPreferences;
    }

    public void setPhoneNumber(String phoneNumber) throws PhoneFormatException {
        if(!isNumeric(phoneNumber)){
            throw new PhoneFormatException(phoneNumber);
        }
        this.phone = phoneNumber;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
