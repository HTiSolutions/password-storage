package com.htisolutions.viewModels;

public class UserEntryViewModel {

    private String forename;
    private String surname;
    private String nickname;
    private String hashedPassword;

    public UserEntryViewModel(String forename, String surname, String nickname, String hashedPassword) {
        this.forename = forename;
        this.surname = surname;
        this.nickname = nickname;
        this.hashedPassword = hashedPassword;
    }

    public String getForename() { return this.forename; }

    public String getSurname() { return this.surname; }

    public String getNickname() {
        return this.nickname;
    }

    public String getHashedPassword() { return this.hashedPassword; }

}
