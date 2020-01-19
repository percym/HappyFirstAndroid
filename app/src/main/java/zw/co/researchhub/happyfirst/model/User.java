package zw.co.researchhub.happyfirst.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName="user" ,indices = {@Index(value = {"name"},
        unique = true)})
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int user_id;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="surname")
    private String surname ;

    @ColumnInfo(name="password")
    private String password ;

    @ColumnInfo(name ="role")
    private String role;

    @ColumnInfo(name ="gender")
    private String gender;

    @ColumnInfo(name="is_going")
    private boolean isGoing;

    @ColumnInfo(name ="first_login")
    private  boolean firstLogin;

    @ColumnInfo(name = "birth_day")
    private String birthDay;

    @ColumnInfo(name ="orphan")
    private  boolean orphan;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean getIsGoing() {
        return isGoing;
    }

    public void setIsGoing(boolean isGoing) {
        this.isGoing = isGoing;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isOrphan() {
        return orphan;
    }

    public void setOrphan(boolean orphan) {
        this.orphan = orphan;
    }
}

