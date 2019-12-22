package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Hobby implements Serializable {
    protected String name;
    protected int experience;
    protected boolean isActive;

    public void tellAboutHobby() {
        System.out.println("Name is: " + name + ", experience: " + experience + ", activity is: " + isActive);
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    Hobby(String name, int experience, boolean isActive) {
        this.name = name;
        this.experience = experience;
        this.isActive = isActive;
    }

    Hobby(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public Hobby(String name) {
        this.name = name;
    }

    Hobby() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hobby)) return false;
        Hobby hobby = (Hobby) o;
        return getExperience() == hobby.getExperience() &&
                isActive() == hobby.isActive() &&
                Objects.equals(getName(), hobby.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExperience(), isActive());
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", isActive=" + isActive +
                '}';
    }
}