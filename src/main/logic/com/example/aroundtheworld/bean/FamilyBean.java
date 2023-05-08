package com.example.aroundtheworld.bean;

import com.example.aroundtheworld.exception.PhoneFormatException;
import java.util.ArrayList;
import java.util.List;

public class FamilyBean {
    private final String name;
    private String imgSrc;
    private final String city;
    private String address;
    private List<AnimalBean> animals = new ArrayList<>();
    private List<FamilyMemberBean> members = new ArrayList<>();
    private String phone;
    private String email;
    private int id;

    //preferences
    private int vegetarian;
    private int vegan;
    private int travels;
    private int sport;
    private int books;
    private int nature;
    private int film;
    private int videoGames;
    private int cooking;
    private String house;

    public FamilyBean(String name, String city, String address, int id, String phone, String email) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.id = id;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public FamilyBean(String name, String city, String address, String phone, String email) throws PhoneFormatException {
        this.name = name;
        this.city = city;
        this.address = address;
        this.setPhoneNumber(phone);
        this.email = email;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void addAnimal(AnimalBean animalBean) {
        this.animals.add(animalBean);
    }

    public void addMember(FamilyMemberBean memberBean) {
        this.members.add(memberBean);
    }

    public String getNameBean() {
        return name;
    }

    public String getImgSrcBean() {
        return imgSrc;
    }

    public String getCityBean() {
        return city;
    }

    public String getAddressBean() {
        return address;
    }

    public List<AnimalBean> getAnimalsBean() {
        return animals;
    }

    public List<FamilyMemberBean> getMembersBean() {
        return members;
    }

    public String getPhoneBean() {
        return phone;
    }

    public String getEmailBean() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) throws PhoneFormatException {
        if(!isNumeric(phoneNumber)){
            throw new PhoneFormatException(phoneNumber);
        }
        this.phone = phoneNumber;
    }

    private static boolean isNumeric(String strNum) {
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

    public void setFood(int vegetarian, int vegan) {
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }

    public void setHobbies(int travels, int sport, int books, int nature, int film, int videoGames, int cooking) {
        this.travels = travels;
        this.sport = sport;
        this.books = books;
        this.nature = nature;
        this.film = film;
        this.videoGames = videoGames;
        this.cooking = cooking;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getVegetarian() {
        return vegetarian;
    }

    public int getVegan() {
        return vegan;
    }

    public int getTravels() {
        return travels;
    }

    public int getSport() {
        return sport;
    }

    public int getBooks() {
        return books;
    }

    public int getNature() {
        return nature;
    }

    public int getFilm() {
        return film;
    }

    public int getVideoGames() {
        return videoGames;
    }

    public int getCooking() {
        return cooking;
    }

    public void setAnimals(List<AnimalBean> animals) {
        this.animals = animals;
    }

    public void setMembers(List<FamilyMemberBean> members) {
        this.members = members;
    }
}
