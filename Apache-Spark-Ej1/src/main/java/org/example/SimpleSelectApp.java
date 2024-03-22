package org.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class SimpleSelectApp {
    public static void main(String[] args) {
        SimpleSelectApp app = new SimpleSelectApp();
        app.start();
    }

    private void start() {
        SparkSession spark = SparkSession.builder()
                .appName("Simple SELECT using SQL")
                .master("local")
                .getOrCreate();

        Dataset<Row> df = spark.read().format("csv")
                .option("header", true)
                .load("data/populationbycountry19802010millions.csv");
        df.createOrReplaceTempView("geodata");
        df.printSchema();
        Dataset<Row> smallCountriesEvolution = spark.sql(
                "SELECT Country, `1980`, `2010`, evolution " +
                        "FROM (" +
                        "   SELECT Country, `1980`, `2010`, ((`2010` - `1980`) * 1000000) AS evolution " +
                        "   FROM geodata" +
                        ") AS temp_table " +
                        "WHERE evolution > 999999 " +
                        "ORDER BY evolution DESC"
        );

        Dataset<Row> smallCountriesNoEvolution = spark.sql(
                "SELECT Country, `1980`, `2010`, evolution " +
                        "FROM (" +
                        "   SELECT Country, `1980`, `2010`, ((`2010` - `1980`) * 1000000) AS evolution " +
                        "   FROM geodata" +
                        ") AS temp_table " +
                        "WHERE evolution < 0 " +
                        "ORDER BY evolution ASC"
        );

        smallCountriesEvolution.show();
        smallCountriesNoEvolution.show();
    }
}
