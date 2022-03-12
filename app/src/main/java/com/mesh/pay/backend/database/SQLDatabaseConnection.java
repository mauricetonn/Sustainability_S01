package com.mesh.pay.backend.database;

import com.mesh.pay.backend.model.FundRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static List<FundRequest>abfrage() {
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
        List<FundRequest> ListeFundRequest = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

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

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return ListeFundRequest;
    }
}