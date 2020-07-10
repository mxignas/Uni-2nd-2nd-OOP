
import javafx.scene.image.Image;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import static javafx.geometry.Orientation.VERTICAL;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApplicationRunner extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws FileNotFoundException {
        // Create a border pane
        BorderPane pane = new BorderPane();

        // Place nodes in the pane
        VBox left = new VBox(getVBox(), getVBox2());
        pane.setLeft(left);
        pane.setCenter(getVBox3());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowHBoxVBox"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    // creating slider method
    private Slider getSlider() {
        Slider slider = new Slider(0, 255, 0);
        slider.setPadding(new Insets(15, 5, 5, 5));
        slider.setMaxWidth(200);
        slider.setBlockIncrement(200);
        return slider;
    }

    // creating circle method
    private Circle getCircle() {
        Circle circle = new Circle();
        circle.setRadius(10.0f);
        return circle;
    }

    private VBox getVBox() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        Text t = new Text();
        t.setText("Lightining");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        vBox.getChildren().add(t);

        // array of text's to be used in for each loop
        Text[] rooms = {new Text("Hall: "), new Text("Kitchen: "),
            new Text("Dining room: "), new Text("Living room: "), new Text("Landing: "), new Text("Bedroom 1:"), new Text("Bedroom 2: ")};

        // for each text do the following
        for (Text room : rooms) {
            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER_RIGHT);
            vBox.getChildren().add(hbox);
            hbox.getChildren().addAll(room, getSlider(), getCircle());
        }

        // vBox style parameters
        vBox.setStyle("-fx-padding: 5;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: grey;");
        vBox.setPrefSize(300, 200);

        return vBox;
    }

    private VBox getVBox2() {
        VBox vBox2 = new VBox(15);
        vBox2.setPadding(new Insets(15, 5, 5, 5));

        Text t = new Text("Central Heating");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        vBox2.getChildren().add(t);

        HBox hbox = new HBox();
        vBox2.getChildren().add(hbox);
        VBox RadioBox = new VBox(10);
        RadioBox.setPadding(new Insets(5, 30, 5, 15));

        VBox SliderBox = new VBox(10);
        SliderBox.setPadding(new Insets(5, 30, 5, 30));

        VBox SquareBox = new VBox();
        // textfield parameters
        TextField textfield = new TextField();
        SquareBox.getChildren().add(textfield);
        textfield.setPrefWidth(50);
        textfield.setPrefHeight(50);
        textfield.setText(new Double(20.0).toString());
        
        SquareBox.setAlignment(Pos.CENTER_RIGHT);

        // slider parameters
        Slider slider = new Slider();
        slider.setOrientation(VERTICAL);
        slider.setMin(0);
        slider.setMax(30);
        slider.setValue(20);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(5);
        slider.setBlockIncrement(2.5);
       
        // bidirectional binding of properties
        textfield.textProperty().bindBidirectional(slider.valueProperty(), NumberFormat.getNumberInstance());

        // creating togglegroup to allow only one button pressed at once
        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Off");
        rb1.setToggleGroup(group);
        RadioButton rb2 = new RadioButton("Auto");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("Once");
        rb3.setToggleGroup(group);
        RadioButton rb4 = new RadioButton("Cont");
        rb4.setToggleGroup(group);
        
        RadioBox.getChildren().addAll(rb1, rb2, rb3, rb4);
        hbox.getChildren().addAll(RadioBox, SliderBox, SquareBox);
        SliderBox.getChildren().add(slider);
        
        // vbox2 style parameters
        vBox2.setStyle("-fx-padding: 5;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: grey;");
        vBox2.setPrefSize(300, 220);

        return vBox2;
    }

    private VBox getVBox3() throws FileNotFoundException {
        // inserting images and setting parameters for them
        Image back = new Image("images/back.jpg");
        ImageView back1 = new ImageView(back);
        back1.setFitWidth(200);
        back1.setFitHeight(200);

        Image drive = new Image("images/drive.jpg");
        ImageView drive1 = new ImageView(drive);
        drive1.setFitWidth(200);
        drive1.setFitHeight(200);

        Image front = new Image("images/front.jpg");
        ImageView front1 = new ImageView(front);
        front1.setFitWidth(200);
        front1.setFitHeight(200);

        Image side = new Image("images/side.jpg");
        ImageView side1 = new ImageView(side);
        side1.setFitWidth(200);
        side1.setFitHeight(200);

        Image mute = new Image("images/mute-screen.gif");
        ImageView mute1 = new ImageView(mute);
        mute1.setFitWidth(200);
        mute1.setFitHeight(200);

        ToggleButton Front = new ToggleButton("Front");
        ToggleButton Rear = new ToggleButton("Rear");
        ToggleButton Drive = new ToggleButton("Drive");
        ToggleButton Side = new ToggleButton("Side");

        // functions for toggle buttons
        Front.setOnAction(event -> {
            if (Front.isSelected()) {
                front1.setImage(mute);
            } else {
                front1.setImage(front);
            }
        });
        Rear.setOnAction(event -> {
            if (Rear.isSelected()) {
                back1.setImage(mute);
            } else {
                back1.setImage(back);
            }
        });
        Side.setOnAction(event -> {
            if (Side.isSelected()) {
                side1.setImage(mute);
            } else {
                side1.setImage(side);
            }
        });
        Drive.setOnAction(event -> {
            if (Drive.isSelected()) {
                drive1.setImage(mute);
            } else {
                drive1.setImage(drive);
            }
        });

        VBox vBox3 = new VBox(15);
        vBox3.setPadding(new Insets(15, 5, 5, 5));
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox5 = new HBox();
        Text t = new Text();
        t.setText("CCTV");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        vBox3.getChildren().add(t);
        vBox3.getChildren().addAll(hbox1, hbox2);
        hbox1.getChildren().addAll(front1, side1);
        hbox2.getChildren().addAll(back1, drive1);
        vBox3.getChildren().add(hbox5);
        hbox5.getChildren().addAll(Front, Rear, Drive, Side);

        //style parameters
        hbox1.setSpacing(10);
        hbox2.setSpacing(10);
        vBox3.setStyle("-fx-padding: 5;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: grey;");
        hbox5.setAlignment(Pos.BOTTOM_CENTER);
        hbox5.setSpacing(10);
        vBox3.setPrefSize(450, 370);

        return vBox3;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
