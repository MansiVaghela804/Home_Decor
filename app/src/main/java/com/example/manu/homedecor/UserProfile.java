package com.example.manu.homedecor;


public class UserProfile{

    public String userfirstname;
    public String userlastname;
    public String userEmail;
    public String usercontactno;
    public String userpsw;
    public String userconfirmpsw;

    public UserProfile(String userfirstname, String userlastname, String userEmail, String usercontactno, String userpsw, String userconfirmpsw) {
        this.userfirstname = userfirstname;
        this.userlastname = userlastname;
        this.userEmail = userEmail;
        this.usercontactno = usercontactno;
        this.userpsw = userpsw;
        this.userconfirmpsw = userconfirmpsw;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUsercontactno() {
        return usercontactno;
    }

    public void setUsercontactno(String usercontactno) {
        this.usercontactno = usercontactno;
    }

    public String getUserpsw() {
        return userpsw;
    }

    public void setUserpsw(String userpsw) {
        this.userpsw = userpsw;
    }

    public String getUserconfirmpsw() {
        return userconfirmpsw;
    }

    public void setUserconfirmpsw(String userconfirmpsw) {
        this.userconfirmpsw = userconfirmpsw;
    }
}

