package org.example.configuration;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.example.DbFuntions;

import java.sql.Connection;
import java.util.Properties;

public class DbConfiguration {
    public Dataset<Row> getRowDataset() {
        DbFuntions db = new DbFuntions();
        db.connect_to_db();

        SparkSession spark = SparkSession.builder()
                .appName("Concesionario SQL")
                .master("local")
                .getOrCreate();

        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "Mario");
        connectionProperties.put("password", "1234");

        Dataset<Row> df = spark.read()
                .option("header", true)
                .jdbc("jdbc:postgresql://localhost:5432/concesionario", "public.car", connectionProperties);
        df.createOrReplaceTempView("vehiculos");
        return df;
    }
    public Properties getProperties() {
        DbFuntions db = new DbFuntions();
        db.connect_to_db();

        SparkSession spark = SparkSession.builder()
                .appName("Concesionario SQL")
                .master("local")
                .getOrCreate();

        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "Mario");
        connectionProperties.put("password", "1234");
        return connectionProperties;
    }

    public Connection getConnection() {
        DbFuntions db = new DbFuntions();
        return db.connect_to_db();
    }
}
