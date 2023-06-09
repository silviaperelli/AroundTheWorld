package com.example.aroundtheworld.engineering.observer;

import com.example.aroundtheworld.bean.FamilyRequestBean;
import com.example.aroundtheworld.bean.ResidenceRequestBean;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Vector;

    /*definisco la classe astratta anche se tutti i metodi che
     fornisce sono concreti per impedire l'istanziazione di essa
     */

public abstract class Subject {
    private final List<Observer> observersList;

    protected Subject() {
        this((Observer) null);
    }

    protected Subject(Observer observer) {
        this(new Vector<>());
        if (observer != null) {
            this.register(observer);
        }
    }

    protected Subject(List<Observer> observersList) {
        this.observersList = observersList;
    }

    public void register(Observer observer) {
        observersList.add(observer);
    }

    public void unregister(Observer observer) {
        observersList.remove(observer);
    }

    public void notifyObserversFamily(FamilyRequestBean familyRequestBean, Pane pane) {
        for (Observer observer : observersList) {
            observer.update();
            observer.updateFamilyPage(familyRequestBean, pane);
        }
    }

    public void notifyObserversResidence(ResidenceRequestBean residenceRequestBean, Pane pane) {
        for (Observer observer : observersList) {
            observer.update();
            observer.updateResidencePage(residenceRequestBean, pane);
        }
    }

}
