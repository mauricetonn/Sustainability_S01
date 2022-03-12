package com.mesh.pay.backend.database;

import android.os.StrictMode;

import com.mesh.pay.backend.model.FundRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SQLDatabaseConnection {
    // Connect to your database.

    // Replace server name, username, and password with your credentials
    public static List<FundRequest>abfrage() {
        ExecutorService execute = Executors.newFixedThreadPool(2);
        System.out.println("TESSSSSSSST");
        List<FundRequest> ListeFundRequest = new ArrayList<>();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        execute.submit(()-> {


                System.out.println("vor driver laden");
                //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                System.out.println("DriverGeladen");
                String connectionUrl =
                        "jdbc:sqlserver://sustainableserver.database.windows.net:1433;"
                                + "database=database;"
                                + "user=adminsus@sustainableserver;"
                                + "password=38976#abB;"
                                + "encrypt=true;"
                                + "trustServerCertificate=false;"
                                + "hostNameInCertificate=*.database.windows.net;"
                                + "loginTimeout=30;";

                ResultSet resultSet = null;
                System.out.println("nächsterTest2");

                try (Connection connection = DriverManager.getConnection(connectionUrl);
                     Statement statement = connection.createStatement();
                     ) {

                    System.out.println("nächsterTest3");

                    // Create and execute a SELECT SQL statement.
                    String selectSql = "SELECT * FROM [dbo].[rechnungen]";
                    resultSet = statement.executeQuery(selectSql);
                    // System.out.println(resultSet.getString(0));
                    // Print results from select statement


                    while (resultSet.next()) {
                        //FundRequest fundRequest = new FundRequest("", "","",
                        //        "", "", "", "", "","","");

                        FundRequest fundRequest = new FundRequest(resultSet.getString(8), resultSet.getString(9), resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5), resultSet.getInt(6), resultSet.getString(7));
                        ListeFundRequest.add(fundRequest);
                        System.out.println("DatenErhalten");
                        System.out.println(fundRequest);
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("exception");
                }

        });
        return ListeFundRequest;
    }
}