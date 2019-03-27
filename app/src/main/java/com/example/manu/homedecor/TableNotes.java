package com.example.manu.homedecor;

public class TableNotes {
    public static final String TABLE_NAME = "UserTable";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_USER_PASSWORD = "userpassword";

    private int id;
    private String username;
    private String userpassword;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_USER_NAME + " TEXT,"
                    + COLUMN_USER_PASSWORD + " TEXT"
                    + ")";

    public TableNotes(){

    }
    public TableNotes(int id,String username,String userpassword){
        this.id = id;
        this.username = username;
        this.userpassword = userpassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}