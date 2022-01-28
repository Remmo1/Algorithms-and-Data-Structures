package Za1;

public class Osoba {
    private String name;
    private String surN;
    private String dateOfBirth;

    public Osoba(String name, String surN, String dateOfBirth) {
        this.name = name;
        this.surN = surN;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() { return name; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getSurN() { return surN; }

    public void setName(String name) { this.name = name; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setSurN(String surN) { this.surN = surN; }

    @Override
    public String toString() {
        return name + " " + surN + " " + dateOfBirth;
    }
}

