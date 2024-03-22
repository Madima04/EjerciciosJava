package org.example;

import org.apache.logging.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DeleteApp {
    public static void main(String[] args) {
        DeleteApp app = new DeleteApp();
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

        df.createOrReplaceTempView("geodata");
        Dataset<Row> cleanedDf =
                spark.sql(
                        "select * from geodata where Country is not null "
                                + "and Country != 'Africa' "
                                + "and Country != 'North America' "
                                + "and Country != 'World' "
                                + "and Country != 'Asia & Oceania' "
                                + "and Country != 'Central & South America' "
                                + "and Country != 'Europe' "
                                + "and Country != 'Eurasia' "
                                + "and Country != 'Middle East' "
                                + "order by `2010` desc");
        cleanedDf.show(20, false);

    }
}
