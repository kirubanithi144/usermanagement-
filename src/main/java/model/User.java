package model;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Long mobile;
    @Column(unique = true)
    private String email;
    private String password;
    private String app;
    private Long sum;

    private String perStreet;
    private String perVillageOrCity;
    private String perState;
    private String perCountry;

    private String curStreet;
    private String curVillageOrCity;
    private String curState;
    private String curCountry;


    public User() {

    }

    public User(String name, Long mobile, String email, String password, String app, Long sum,
                String permanentStreet, String permanentVillageOrCity, String permanentState, String permanentCountry,
                String currentStreet, String currentVillageOrCity, String currentState, String currentCountry) {
        {
            this.name = name;
            this.mobile = mobile;
            this.email = email;
            this.password = password;
            this.app = app;
            this.sum = sum;
        }


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
    public String getCurCountry() {
        return curCountry;
    }

    public void setCurCountry(String curCountry) {
        this.curCountry = curCountry;
    }

    public String getCurState() {
        return curState;
    }

    public void setCurState(String curState) {
        this.curState = curState;
    }

    public String getCurVillageOrCity() {
        return curVillageOrCity;
    }

    public void setCurVillageOrCity(String curVillageOrCity) {
        this.curVillageOrCity = curVillageOrCity;
    }

    public String getCurStreet() {
        return curStreet;
    }

    public void setCurStreet(String curStreet) {
        this.curStreet = curStreet;
    }

    public String getPerCountry() {
        return perCountry;
    }

    public void setPerCountry(String perCountry) {
        this.perCountry = perCountry;
    }

    public String getPerState() {
        return perState;
    }

    public void setPerState(String perState) {
        this.perState = perState;
    }

    public String getPerVillageOrCity() {
        return perVillageOrCity;
    }

    public void setPerVillageOrCity(String perVillageOrCity) {
        this.perVillageOrCity = perVillageOrCity;
    }

    public String getPerStreet() {
        return perStreet;
    }

    public void setPerStreet(String perStreet) {
        this.perStreet = perStreet;
    }
}
