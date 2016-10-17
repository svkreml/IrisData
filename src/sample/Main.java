package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ooo");

        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        ScatterChart<Number,Number> NumberLineChart = new ScatterChart<Number, Number>(x,y);
        XYChart.Series series1= new XYChart.Series();
        XYChart.Series series2= new XYChart.Series();
        series1.setName("orange");
        series2.setName("yellow");
        ObservableList<XYChart.Data> data1 = FXCollections.observableArrayList();
        for (double X =1; X<10;X=X+1){

            data1.add(new XYChart.Data(    X,1/X     ));
        }
        ObservableList<XYChart.Data> data2 = FXCollections.observableArrayList();
        for (double X =1; X<10;X=X+1){

            data2.add(new XYChart.Data(    X,X     ));
        }
        series1.setData(data1);
        series2.setData(data2);

        Scene scene = new Scene(NumberLineChart ,600,600);
        NumberLineChart.getData().add(series1);
        NumberLineChart.getData().add(series2);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
