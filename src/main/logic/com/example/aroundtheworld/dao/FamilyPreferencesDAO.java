package com.example.aroundtheworld.dao;

import com.example.aroundtheworld.connection.ConnectionDB;
import com.example.aroundtheworld.dao.queries.CRUDQueries;
import com.example.aroundtheworld.dao.queries.SimpleQueries;
import com.example.aroundtheworld.engineering.Printer;
import com.example.aroundtheworld.exception.NotFoundException;
import com.example.aroundtheworld.model.FamilyPreferences;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FamilyPreferencesDAO {
    private static final String HOUSE = "house";
    private static final String VEGETARIAN = "vegetarian";
    private static final String VEGAN = "vegan";
    private static final String TRAVELS = "travels";
    private static final String SPORT = "sport";
    private static final String BOOKS = "books";
    private static final String NATURE = "nature";
    private static final String FILM = "film";
    private static final String VIDEOGAMES = "videoGames";
    private static final String COOKING = "cooking";

    private FamilyPreferencesDAO(){}

    public static FamilyPreferences retrievePreferences(int familyId) {
        Connection connection;
        FamilyPreferences preferences = null;

        try{
            connection = ConnectionDB.getConnection();

            ResultSet resultSet = SimpleQueries.retrievePreferences(connection, familyId);

            if(!resultSet.first()) {
                throw new NotFoundException("No preferences found for family with id: " + familyId);
            }

            resultSet.first();
            do{
                preferences = getPreferences(resultSet);

            } while(resultSet.next());

            resultSet.close();

        }catch(SQLException | NotFoundException e){
            Printer.printError(e.getMessage());
        }
        return preferences;
    }

    public static void addPreferences(FamilyPreferences familyPreferences, int id) {
        Connection connection;

        try{
            connection = ConnectionDB.getConnection();

            CRUDQueries.insertPreferences(connection, id, familyPreferences);

        } catch(SQLException e) {
            Printer.printError(e.getMessage());
        }
    }

    public static FamilyPreferences retrievePreferencesRequest(int idRequest) {
        Connection connection;
        FamilyPreferences preferences = null;

        try{
            connection = ConnectionDB.getConnection();

            ResultSet resultSet = SimpleQueries.retrievePreferencesRequest(connection, idRequest);

            if(!resultSet.first()) {
                throw new NotFoundException("No preferences found for request with id: " + idRequest);
            }

            resultSet.first();
            do{
                preferences = getPreferences(resultSet);

            } while(resultSet.next());

            resultSet.close();

        }catch(SQLException | NotFoundException e){
            Printer.printError(e.getMessage());
        }
        return preferences;
    }

    public static void addPreferencesRequest(FamilyPreferences familyPreferences, int idRequest) {
        Connection connection;

        try{
            connection = ConnectionDB.getConnection();
            CRUDQueries.insertPreferencesRequest(connection, idRequest, familyPreferences);

        } catch(SQLException e) {
            Printer.printError(e.getMessage());
        }
    }

    private static FamilyPreferences getPreferences(ResultSet resultSet) throws SQLException {

        String house = resultSet.getString(HOUSE);
        int vegetarian = resultSet.getInt(VEGETARIAN);
        int vegan = resultSet.getInt(VEGAN);
        int travels = resultSet.getInt(TRAVELS);
        int books = resultSet.getInt(BOOKS);
        int film = resultSet.getInt(FILM);
        int nature = resultSet.getInt(NATURE);
        int videoGames = resultSet.getInt(VIDEOGAMES);
        int cooking = resultSet.getInt(COOKING);
        int sport = resultSet.getInt(SPORT);

        FamilyPreferences preferences = new FamilyPreferences();
        preferences.setFood(vegetarian, vegan);
        preferences.setHobbies(travels, sport, books, nature, film, videoGames, cooking);
        preferences.setHouse(house);

        return preferences;
    }
}
