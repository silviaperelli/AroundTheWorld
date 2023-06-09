package com.example.aroundtheworld.bean;

import com.example.aroundtheworld.engineering.observer.Subject;

public class FamilyRequestBean extends Subject {
    private int id;
    private String city;
    private String arrival;
    private String departure;
    private int siblings;
    private int animals;
    private int idStudent;
    private String studentName;
    private String familyName;
    private int idFamily;
    private float compatibility;
    private int status;

    //preferences
    private int film;
    private int vegetarian;
    private int videoGames;
    private int books;
    private int nature;
    private int travels;
    private int vegan;
    private int sport;
    private int cooking;
    private String house;
    private String imgFamily;

    public FamilyRequestBean(String city, String arrival, String departure, int siblings, int animals, int idStudent){
        this.city = city;
        this.arrival = arrival;
        this.departure = departure;
        this.siblings = siblings;
        this.animals = animals;
        this.idStudent = idStudent;
    }

    public String getImgFamily() {
        return imgFamily;
    }

    public void setImgFamily(String imgFamily) {
        this.imgFamily = imgFamily;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public FamilyRequestBean(String city, String arrival, String departure, int status, int idFamily){
        this.city = city;
        this.arrival = arrival;
        this.departure = departure;
        this.status = status;
        this.idFamily = idFamily;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String name) {
        this.studentName = name;
    }

    public void setCompatibility(float compatibility) {
        this.compatibility = compatibility;
    }

    public void setIdFamily(int idFamily) {
        this.idFamily = idFamily;
    }

    public String getCity() {
        return city;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public int getSiblings() {
        return siblings;
    }

    public int getAnimals() {
        return animals;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public int getIdFamily() {
        return idFamily;
    }

    public float getCompatibility() {
        return compatibility;
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
    public int getBooks() {
        return books;
    }
    public int getTravels() {
        return travels;
    }
    public int getSport() {
        return sport;
    }
    public int getVideoGames() {
        return videoGames;
    }
    public int getVegetarian() {
        return vegetarian;
    }
    public int getFilm() {
        return film;
    }
    public int getVegan() {
        return vegan;
    }
    public int getCooking() {
        return cooking;
    }
    public int getNature() {
        return nature;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
