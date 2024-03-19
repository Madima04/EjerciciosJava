package org.example;


import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.example.configuration.DbConfiguration;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class App
{
    public static void main( String[] args ) throws SQLException {
        DbConfiguration dbConfiguration = new DbConfiguration();
        Connection conn = dbConfiguration.getConnection();
        Properties connectionProperties = dbConfiguration.getProperties();
        Dataset<Row> df = dbConfiguration.getRowDataset();
        Dataset<Row> df2 = df.select("id", "marca", "modelo", "precio");
        Dataset<Row> df3 = df2.filter("precio > 10000");
        Dataset<Row> df4 = df3.withColumn("precio_dolares", df3.col("precio").multiply(1.17));
        String sql = "INSERT INTO public.car (id, marca, modelo, precio) VALUES (100, 'Toyota', 'Corolla', 15000)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            System.out.println("A new car has been inserted");
        }
        else {
            System.out.println("No car has been inserted");
        }

        df4.show();


    }
}
