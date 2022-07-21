package com.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionControl {

    public static ConnectionControl connectionControl;

    public static Connection connection;

    //no args constructor
    private ConnectionControl(){
    }
    //getters
    private ConnectionControl getConnectionControl(){
        if(connectionControl == null){
            connectionControl = new ConnectionControl();
        }
        return connectionControl;
    }

    public static Connection getConnection(){
        if(connection == null){
            connection = connect();
        }
        return connection;
    }

    //actual connection method
    public static Connection connect(){

        try{

            FileReader reader = new FileReader("/Users/Chris/IdeaProjects/ProjectOneDay/OneDay" + "/src/main/resources/jdbc.properties");

            Properties p = new Properties();

            p.load(reader);

            StringBuilder sb = new StringBuilder();

//for Postgres the url we are creating consists of
            //----jdbc:postgresql://hostname:port/databaseName
            sb.append("jdbc:postgresql://");
            sb.append(p.get("hostname"));
            sb.append(":");
            sb.append(p.get("port"));
            sb.append("/");
            sb.append(p.get("database"));

            String connectionUrl = sb.toString();

            String user = String.valueOf(p.get("user"));

            String password = String.valueOf(p.get("password"));
            //DriverManager connects an application to a datasource- in our case this application is being connected to our AWS database.
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl,user,password);

            System.out.println(connection.toString());






        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return connection;

    }


}
