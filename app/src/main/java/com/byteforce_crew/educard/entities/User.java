package com.byteforce_crew.educard.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.byteforce_crew.educard.enums.Country;
import com.byteforce_crew.educard.enums.Gender;
import com.byteforce_crew.educard.enums.User_Type;


public class User implements Parcelable {

    // -- User Properties --
    protected String username; /* Document ID: username [Cannot change] */
    protected String email; /* Can be changed */
    protected String password;
    protected String firstname;
    protected String lastname;
    protected User_Type usertype; /* `Teacher` or `Student` */
    protected Gender gender;    /* Male or Female */
    protected Country nationality; /* From a list of pre-defined enum constants */


    // -- Default Constructor --
    public User() {}

    // -- Other Constructors (Overloading) --
    public User(String username, String email, String password, String firstname, String lastname,
                User_Type type, Gender gender, Country nationality){
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.usertype = type;
        this.gender = gender;
        this.nationality = nationality;
    }

    public User(User user){
        this(user.username, user.email, user.password, user.firstname, user.lastname,
                user.usertype, user.gender, user.nationality);
    }

    // -- Constructor without `password` --
    public User(String username, String email, String firstname, String lastname, User_Type usertype, Gender gender,
                Country nationality){
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.usertype = usertype;
        this.gender = gender;
        this.nationality = nationality;
    }

    // -- Getters --
    public String getUsername(){
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public User_Type getUsertype(){
        return usertype;
    }

    public Gender getGender(){
        return gender;
    }

    public Country getNationality(){
        return nationality;
    }

    // -- Setters --
    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){

        // -- Include some validation before storing the values --
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setUsertype(User_Type usertype){
        this.usertype = usertype;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public void setNationality(Country nationality){
        this.nationality = nationality;
    }

    // -- Parcelable Methods --
    @Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.username);
        out.writeString(this.email);
        out.writeString(this.firstname);
        out.writeString(this.lastname);
        out.writeString(this.usertype.name());
        out.writeString(this.gender.name());
        out.writeString(this.nationality.name());

    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in){
        this.username = in.readString();
        this.email = in.readString();
        this.firstname = in.readString();
        this.lastname = in.readString();
        this.usertype = User_Type.valueOf(in.readString());
        this.gender = Gender.valueOf(in.readString());
        this.nationality = Country.valueOf(in.readString());
    }


    // -- ToString Method --
    @NonNull
    public String toString(){
        return String.format("\nUsername: %s\nEmail: %s\nFirstname: %s\nLastname: %s\nUser Type: " +
                        "%s\nGender: %s\nNationality: %s\n",
                username, email, firstname, lastname, usertype, gender, nationality);
    }
}
