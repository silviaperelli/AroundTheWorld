package com.example.aroundtheworld.model;

public class FamilyRequest extends Request {
    private int siblings;
    private int animals;
    private FamilyPreferences familyPreferences;
    private int idFamily;
    private float compatibility;
    private int rate;

    public FamilyRequest(String city, String arrival, String departure, int siblings, int animals, int idStudent, int status) {
        super(city, arrival, departure, idStudent, status);
        this.siblings = siblings;
        this.animals = animals;
    }

    public FamilyRequest(String city, String arrival, String departure, int idStudent, int idFamily, int status) {
        super(city, arrival, departure, idStudent, status);
        this.idFamily = idFamily;
    }

    public void setIdFamily(int idFamily) {
        this.idFamily = idFamily;
    }

    public void setCompatibility(float compatibility) {
        this.compatibility = compatibility;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    //per la relazione di composizione l'istanza passata di FamilyPrefrences deve essere clonata
    public void setFamilyPreferences(FamilyPreferences familyPreferences) {
        this.familyPreferences = new FamilyPreferences();
        this.familyPreferences.setHouse(familyPreferences.getHouse());
        this.familyPreferences.setHobbies(familyPreferences.getTravels(),familyPreferences.getSport(),familyPreferences.getBooks(),familyPreferences.getNature(),familyPreferences.getFilm(),familyPreferences.getVideoGames(),familyPreferences.getCooking());
        this.familyPreferences.setFood(familyPreferences.getVegetarian(),familyPreferences.getVegan());
    }

    public int getSiblings() {
        return siblings;
    }

    public int getAnimals() {
        return animals;
    }

    public FamilyPreferences getFamilyPreferences() {
        return familyPreferences;
    }

    public int getIdFamily() {
        return idFamily;
    }

    public float getCompatibility() {
        return compatibility;
    }

}
