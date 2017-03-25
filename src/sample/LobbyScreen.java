package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by teo on 14.03.2017.
 */
public class LobbyScreen extends Application {



    public int index = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{


        //Basic Pane

        primaryStage.setTitle("JavaFX 2 Login");
        GridPane bp = new GridPane();
        bp.setPadding(new Insets(30,150,100,150));
        bp.setPrefSize(1600,870);
        bp.setHgap(10);
        bp.setVgap(5);


        //Adding HBox

        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(7);


        Text text = new Text("Blackjack");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 38));
        text.setEffect(dropShadow);

        hb.getChildren().add(text);


        HBox hb1 = new HBox();
        hb1.setPadding(new Insets(20,20,20,30));

        Text text1 = new Text("Life's a gamble, Let's play");
        text1.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
        text1.setEffect(dropShadow);

        hb1.getChildren().add(text1);

        //Adding Panes


        GridPane chatPane = ininializationChat();
        BorderPane tutorialPane = ininializationTutorial();
        VBox menuPane = ininializationMenu();
        VBox ratingPane = ininializationRating();

        GridPane gridPane4 = new GridPane();
        gridPane4.setPrefSize(750,170);
        gridPane4.setHgap(10);
        gridPane4.setVgap(5);
        VBox profilePane = ininializationProfile();
        gridPane4.add(profilePane,27,0);


        GridPane gridPaneLeft = new GridPane();
        gridPaneLeft.setPrefSize(750,1450);
        gridPaneLeft.setHgap(10);
        gridPaneLeft.setVgap(5);
        gridPaneLeft.add(text,0,0);
        gridPaneLeft.add(text1,0,1);
        gridPaneLeft.add(tutorialPane,0,4);
        gridPaneLeft.add(chatPane,0,9);

        GridPane gridPaneRight = new GridPane();
        gridPaneRight.setPrefSize(800,1450);
        gridPaneRight.setHgap(10);
        gridPaneRight.setVgap(5);

        gridPaneRight.add(menuPane,0,18);
        gridPaneRight.add(ratingPane,0,23);

        gridPaneRight.add(gridPane4,0,29);

        bp.add(gridPaneLeft,0,0);
        bp.add(gridPaneRight,6,0);


        //Add ID's to Nodes
        bp.setId("bp");
        tutorialPane.setId("root");
        menuPane.setId("root");
        ratingPane.setId("root");
        profilePane.setId("root");
        text.setId("text");
        text1.setId("text");

        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(bp);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("resources/lobby.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blackjack");
        primaryStage.titleProperty().bind(
                scene.widthProperty().asString().
                        concat(" : ").
                        concat(scene.heightProperty().asString()));

        primaryStage.setResizable(false);
        primaryStage.show();



    }





    GridPane ininializationChat(){

            GridPane chatPane = new GridPane();
            chatPane.setPrefSize(520,370);
            chatPane.setHgap(10);
            chatPane.setVgap(10);



            VBox discution = new VBox();
            discution.setSpacing(10);
            discution.setPadding(new Insets(10));
            ScrollPane sp = new ScrollPane();
            sp.setPrefSize(520,270);
            sp.setContent(discution);
            sp.setPannable(true);
            sp.setVvalue(1.0);


            GridPane sentMessagePane = new GridPane();
            sentMessagePane.setPrefSize(550,80);
            sentMessagePane.setHgap(10);
            sentMessagePane.setVgap(5);




            GridPane myMessagePane = new GridPane();
            myMessagePane.setPrefSize(477,90);
            myMessagePane.setHgap(3);
            myMessagePane.setVgap(5);



            final TextField sendMessage = new TextField();
            sendMessage.setFocusTraversable(false);
            sendMessage.setPrefSize(420,90);

            Button sendButtonMessage = new Button("Send");



            myMessagePane.add(sendMessage,0,0);
            myMessagePane.add(sendButtonMessage,1,0);


            ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/resources/profile_picture.jpg"),100,100,true,true));
            image.setFitHeight(40);
            image.setFitWidth(40);






            sentMessagePane.add(myMessagePane,0,0);
            sentMessagePane.add(image,1,0);
            chatPane.add(sp,0,0);
            chatPane.add(sentMessagePane,0,1);

            /////////////////////////////////////////////////////////////////////////

            GridPane messagePane = new GridPane();
            messagePane.setPrefWidth(485);
            // messagePane.setPrefSize(250,50);
            messagePane.setHgap(10);
            messagePane.setVgap(5);

            GridPane textMessagePane = new GridPane();
            textMessagePane.setPrefWidth(485);
            textMessagePane.setHgap(10);
            textMessagePane.setVgap(1);




            GridPane dataPane = new GridPane();
            dataPane.setHgap(10);
            dataPane.setVgap(10);

            final Label name = new Label("Shakira");
            name.setFocusTraversable(false);
            name.setStyle("-fx-text-fill:  #ffffff;");
            name.setFont(Font.font("Courier New", FontWeight.BOLD, 14));

            final Label time = new Label("02:53");
            time.setFocusTraversable(false);
            time.setStyle("-fx-text-fill:  #ffffff;");
            time.setFont(Font.font("Courier New", FontWeight.BOLD, 14));


            dataPane.add(name,0,0);
            dataPane.add(time,1,0);

            final Label message = new Label();
            message.setFocusTraversable(false);
            message.setWrapText(true);
            message.setText("Hi, Adam");
            message.setStyle("-fx-text-fill:  #ffffff;");
            message.setFont(Font.font("Courier New", FontWeight.BOLD, 16));


            textMessagePane.add(dataPane,0,0);
            textMessagePane.add(message,0,1);

            ImageView imageProfileChat = new ImageView(new Image(getClass().getResourceAsStream("/resources/shakira.jpg"),100,100,true,true));
            imageProfileChat.setFitHeight(40);
            imageProfileChat.setFitWidth(40);

            messagePane.add(textMessagePane,1,0);
            messagePane.add(imageProfileChat,0,0);

            discution.getChildren().add(messagePane);



            ////////////////////////////////////////////////////////////////////////////




            sendButtonMessage.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                    GridPane messagePane = new GridPane();
                    messagePane.setPrefWidth(485);
                    messagePane.setHgap(10);
                    messagePane.setVgap(5);

                    GridPane textMessagePane = new GridPane();
                    textMessagePane.setPrefWidth(485);
                    textMessagePane.setHgap(10);
                    textMessagePane.setVgap(1);


                    GridPane dataPane = new GridPane();
                    dataPane.setHgap(10);
                    dataPane.setVgap(10);

                    final Label name = new Label("Adam Levine");
                    name.setFocusTraversable(false);
                    name.setStyle("-fx-text-fill:  #ffffff;");
                    name.setFont(Font.font("Courier New", FontWeight.BOLD, 14));

                    final Label time = new Label("02:55");
                    time.setFocusTraversable(false);
                    name.setStyle("-fx-text-fill:  #ffffff;");
                    time.setStyle("-fx-text-fill:  #ffffff;");
                    time.setFont(Font.font("Courier New", FontWeight.BOLD, 14));

                    dataPane.add(name,0,0);
                    dataPane.add(time,1,0);

                    final Label message = new Label();
                    message.setFocusTraversable(false);
                    message.setWrapText(true);
                    message.setText(sendMessage.getText());
                    message.setStyle("-fx-text-fill:  #ffffff;");
                    message.setFont(Font.font("Courier New", FontWeight.BOLD, 16));


                    textMessagePane.add(dataPane,0,0);
                    textMessagePane.add(message,0,1);
                    textMessagePane.setId("myMessage");

                    ImageView imageProfileChat = new ImageView(new Image(getClass().getResourceAsStream("/resources/profile_picture.jpg"),100,100,true,true));
                    imageProfileChat.setFitHeight(40);
                    imageProfileChat.setFitWidth(40);

                    messagePane.add(textMessagePane,0,0);
                    messagePane.add(imageProfileChat,1,0);


                    discution.getChildren().add(messagePane);
                    sendMessage.setText("");
                    sp.setVvalue(1.0d);


                }

            });

            textMessagePane.setId("yourMessage");
            sp.setId("scroll-pane");
            chatPane.setId("chat");
            sendMessage.setId("sendMessage");
            sendMessage.setId("myMessagePane");
            myMessagePane.setId("myMessagePane");
            sendButtonMessage.setId("btnSendMessage");

            return chatPane;
    }

    BorderPane ininializationTutorial(){
            BorderPane tutorialPane = new BorderPane();
            tutorialPane.setPrefSize(550,420);




            ImageView imageTutorial = new ImageView(new Image(getClass().getResourceAsStream("/resources/tutorial1.png"),450,0,true,true));



            RulesBlackjack rulesBlackjack = new RulesBlackjack();

            Label textTutorial = new Label(rulesBlackjack.getRule(0));
            textTutorial.setFocusTraversable(false);
            textTutorial.setWrapText(true);
            textTutorial.setPadding(new Insets(25,10,10,10));
            textTutorial.setFont(Font.font("Script MT Bold", FontWeight.BOLD, 20));

            Button previousButton = new Button("<");
            previousButton.setFont(Font.font("Courier New", FontWeight.BOLD, 15));
            previousButton.setVisible(false);
            Button nextButton = new Button(">");
            nextButton.setFont(Font.font("Courier New", FontWeight.BOLD, 15));


            Label pageNumber = new Label("1/10");
            pageNumber.setStyle("-fx-text-fill:  #663F15;");
            pageNumber.setFont(Font.font("Courier New", FontWeight.BOLD, 15));


            tutorialPane.setTop(imageTutorial);
            tutorialPane.setCenter(textTutorial);
            tutorialPane.setLeft(previousButton);
            tutorialPane.setRight(nextButton);
            tutorialPane.setBottom(pageNumber);



            tutorialPane.setAlignment(imageTutorial, Pos.TOP_CENTER);
            tutorialPane.setAlignment(pageNumber, Pos.TOP_CENTER);
            tutorialPane.setAlignment(previousButton,Pos.CENTER);
            tutorialPane.setAlignment(nextButton,Pos.CENTER);
            tutorialPane.setAlignment(textTutorial,Pos.TOP_LEFT);

            nextButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    rulesBlackjack.increment();
                    textTutorial.setText(rulesBlackjack.getRule(rulesBlackjack.getCount()));
                    previousButton.setVisible(true);
                    pageNumber.setText(rulesBlackjack.getCount() + 1 +"/10");

                    if(rulesBlackjack.getCount() == 9){
                        nextButton.setVisible(false);
                    }

                }


            });

            previousButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    rulesBlackjack.decrement();
                    textTutorial.setText(rulesBlackjack.getRule(rulesBlackjack.getCount()));
                    nextButton.setVisible(true);
                    pageNumber.setText(rulesBlackjack.getCount() + 1 +"/10");

                    if(rulesBlackjack.getCount() == 0){
                        previousButton.setVisible(false);
                    }
                }

            });

            textTutorial.setId("textTutorial");
            nextButton.setId("tutorialButton");
            previousButton.setId("tutorialButton");

            return tutorialPane;
    }

    VBox ininializationMenu(){
        VBox menuPane = new VBox();
        menuPane.setPrefSize(10,370);












        HBox buttonsMenu = new HBox();
        buttonsMenu.setPrefSize(650,45);


        GridPane buttonsMenuTable = new GridPane();
        buttonsMenuTable.setPrefSize(350,40);
        buttonsMenuTable.setPadding(new Insets(18,0,0,0));
        buttonsMenuTable.setHgap(1);
        buttonsMenuTable.setVgap(0);

        Button buttonTables = new Button("Tables");
        buttonTables.setPrefSize(150,20);


        Button buttonRanking = new Button("Ranking");
        buttonRanking.setPrefSize(150,20);

        buttonsMenuTable.add(buttonTables,30,0);
        buttonsMenuTable.add(buttonRanking,31,0);


        HBox menuCreateTablePane = new HBox();
        menuCreateTablePane.setPrefSize(300,40);

        Button buttonCreateTable = new Button("START NEW GAME");
        buttonCreateTable.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
        buttonCreateTable.setPrefSize(250,20);

        menuCreateTablePane.setAlignment(Pos.TOP_CENTER);
        menuCreateTablePane.getChildren().add(buttonCreateTable);

        buttonsMenu.getChildren().add(buttonsMenuTable);
        buttonsMenu.getChildren().add(menuCreateTablePane);



        VBox menu = new VBox();
        menu.setSpacing(5);
        ScrollPane menusp = new ScrollPane();
        menu.setPadding(new Insets(5,5,5,5));
        menusp.setPrefSize(20,300);
        menusp.setContent(menu);
        menusp.setPannable(true);
        menusp.setPadding(new Insets(100,200,0,200));



        tableInitialization(menu,"#E3BE7F");
        tableInitialization(menu,"#E7B663");
        tableInitialization(menu,"#E3BE7F");
        tableInitialization(menu,"#E7B663");
        tableInitialization(menu,"#E3BE7F");











        menuPane.getChildren().add(buttonsMenu);
        menuPane.getChildren().add(menusp);

        buttonTables.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                buttonRanking.setId("btnRanking");
                buttonTables.setId("btnTables");

            }
        });

        buttonRanking.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                buttonRanking.setId("btnTables");
                buttonTables.setId("btnRanking");

            }
        });

        buttonTables.setId("btnTables");
        buttonRanking.setId("btnRanking");
        menusp.setId("scroll-pane");
        buttonCreateTable.setId("btnCreateTable");

        return menuPane;






    }

    VBox ininializationRating(){
        VBox ratingPane = new VBox();
        ratingPane.setPrefSize(750,60);

        HBox ratingTopPane = new HBox();
        ratingTopPane.setPrefSize(750,60);
        ratingTopPane.setPadding(new Insets(7,0,0,0));

        Label textRatingOne = new Label("Rating Legend");
        textRatingOne.setFont(Font.font("Script MT Bold", FontWeight.BOLD, 24));
        textRatingOne.setPadding(new Insets(-18,25,-10,30));
        textRatingOne.setPrefWidth(140);
        textRatingOne.setWrapText(true);


        ImageView imageRanking1 = new ImageView(new Image(getClass().getResourceAsStream("/resources/brown1.png"),25,25,true,true));

        Label ratingOne = new Label("0-49");
        ratingOne.setFont(Font.font("Lucida Calligraphy", FontWeight.NORMAL, 16));
        ratingOne.setPadding(new Insets(-3,27,0,27));
        ImageView imageRanking2 = new ImageView(new Image(getClass().getResourceAsStream("/resources/brown2.png"),25,25,true,true));
        Label ratingTwo = new Label("50-99");
        ratingTwo.setPadding(new Insets(-3,27,0,27));
        ratingTwo.setFont(Font.font("Lucida Calligraphy", FontWeight.NORMAL, 16));
        ImageView imageRanking3 = new ImageView(new Image(getClass().getResourceAsStream("/resources/orange2.png"),25,25,true,true));
        Label ratingThree = new Label("100-199");
        ratingThree.setPadding(new Insets(-3,22,0,22));
        ratingThree.setFont(Font.font("Lucida Calligraphy", FontWeight.NORMAL, 16));
        ImageView imageRanking4 = new ImageView(new Image(getClass().getResourceAsStream("/resources/brown.png"),25,25,true,true));
        Label ratingFour = new Label("200+");
        ratingFour.setPadding(new Insets(-3,0,0,25));
        ratingFour.setFont(Font.font("Lucida Calligraphy", FontWeight.NORMAL, 16));






        ratingTopPane.getChildren().add(textRatingOne);
        ratingTopPane.getChildren().add(imageRanking1);
        ratingTopPane.getChildren().add(ratingOne);
        ratingTopPane.getChildren().add(imageRanking2);
        ratingTopPane.getChildren().add(ratingTwo);
        ratingTopPane.getChildren().add(imageRanking3);
        ratingTopPane.getChildren().add(ratingThree);
        ratingTopPane.getChildren().add(imageRanking4);
        ratingTopPane.getChildren().add(ratingFour);



        ratingPane.getChildren().add(ratingTopPane);

        textRatingOne.setId("textTutorial");
        ratingOne.setId("textTutorial");
        ratingTwo.setId("textTutorial");
        ratingThree.setId("textTutorial");
        ratingFour.setId("textTutorial");

        return ratingPane;
    }

    VBox ininializationProfile(){
        VBox profilePane = new VBox();
        profilePane.setPrefSize(380,170);

        HBox profileTopPane = new HBox();
        profileTopPane.setPrefSize(380,120);
        profileTopPane.setPadding(new Insets(10,10,10,10));


        HBox imagePane = new HBox();
        imagePane.setPrefSize(120,120);
        imagePane.setPadding(new Insets(10,10,10,10));



        ImageView imageProfile = new ImageView(new Image(getClass().getResourceAsStream("/resources/profile_picture.jpg"),90,0,true,true));

        GridPane profileInformation = new GridPane();
        profileInformation.setPadding(new Insets(10,0 ,0 ,10 ));
        profileInformation.setPrefSize(240,40);
        profileInformation.setHgap(10);
        profileInformation.setVgap(5);

        Label profileName = new Label("Adam Levine");
        profileName.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        profileName.setTextFill(Color.web("663F15"));

        Label profileUsername = new Label("adam.levine");
        profileUsername.setFont(Font.font("Courier New", FontWeight.NORMAL, 14));
        profileUsername.setTextFill(Color.web("663F15"));

        Label profileHome = new Label("Los Angeles, USA");
        profileHome.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        profileHome.setTextFill(Color.web("663F15"));

        HBox profileRating = new HBox();


        Label profileTextRating = new Label("Rating: 82");
        profileTextRating.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
        profileTextRating.setTextFill(Color.web("663F15"));
        profileTextRating.setPadding(new Insets(0,10,0,0));

        ImageView profileImageRating = new ImageView(new Image(getClass().getResourceAsStream("/resources/brown2.png"),20,0,true,true));

        profileRating.getChildren().add(profileTextRating);
        profileRating.getChildren().add(profileImageRating);

        profileInformation.add(profileName,0,0);
        profileInformation.add(profileUsername,0,1);
        profileInformation.add(profileHome,0,2);
        profileInformation.add(profileRating,0,3);




        imagePane.getChildren().add(imageProfile);
        profileTopPane.getChildren().add(imagePane);
        profileTopPane.getChildren().add(profileInformation);



        GridPane profileBottomPane = new GridPane();
        profileBottomPane.setPadding(new Insets(10,0 ,0 ,0 ));
        profileBottomPane.setPrefSize(350,40);
        profileBottomPane.setHgap(7);
        profileBottomPane.setVgap(5);

        Button editButton = new Button("Edit Profile");
        editButton.setPrefSize(80,10);

        Button logoutButton = new Button("Log Out");
        logoutButton.setPrefSize(80,10);


        profileBottomPane.add(editButton,3,0);
        profileBottomPane.add(logoutButton,26,0);


        profilePane.getChildren().add(profileTopPane);
        profilePane.getChildren().add(profileBottomPane);

        editButton.setId("btnEditProfile");
        logoutButton.setId("btnLogout");
        profileTopPane.setId("profileTopPane");
        return profilePane;
    }


    public static void main(String[] args) {
        launch(args);
    }



    void tableInitialization(VBox discution, String color){
        GridPane messagePane = new GridPane();
        messagePane.setPrefWidth(595);
        // messagePane.setPrefSize(250,50);
        messagePane.setHgap(10);
        messagePane.setVgap(5);

        GridPane tablesPane = new GridPane();
        tablesPane.setPrefWidth(595);
        tablesPane.setHgap(10);
        tablesPane.setVgap(1);
        tablesPane.setStyle("-fx-background-color:" + color + " ;-fx-border-radius: 10;-fx-padding: 5 5 5 5;-fx-background-radius: 10;");

        GridPane textMessagePane = new GridPane();
        textMessagePane.setPrefWidth(535);
        textMessagePane.setHgap(10);
        textMessagePane.setVgap(1);

        textMessagePane.setStyle("-fx-background-color: " + color + ";-fx-border-radius: 10;-fx-padding: 5 5 5 5;-fx-background-radius: 10;");



        GridPane dataPane = new GridPane();
        //dataPane.setPrefSize(350,20);
        dataPane.setHgap(10);
        dataPane.setVgap(10);

        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/resources/lock2.png"),100,100,true,true));
        image.setFitHeight(10);
        image.setFitWidth(10);


        final Label name = new Label("Table 1");
        name.setFocusTraversable(false);
        name.setStyle("-fx-text-fill:  #663F15;");
        name.setFont(Font.font("Courier New", FontWeight.BOLD, 16));



        dataPane.add(image,2,0);
        dataPane.add(name,3,0);


        GridPane playersPane = new GridPane();
        playersPane.setPrefSize(350,19);
        playersPane.setHgap(10);
        playersPane.setVgap(10);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/resources/orange2.png"),100,100,true,true));
        image1.setFitHeight(10);
        image1.setFitWidth(10);

        final Label name1 = new Label("Kevin");
        name1.setFocusTraversable(false);
        name1.setStyle("-fx-text-fill:  #663F15;");
        name1.setFont(Font.font("Courier New", FontWeight.BOLD, 13));

        ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/resources/brown1.png"),100,100,true,true));
        image2.setFitHeight(10);
        image2.setFitWidth(10);

        final Label name2 = new Label("Blake");
        name2.setFocusTraversable(false);
        name2.setStyle("-fx-text-fill:  #663F15;");
        name2.setFont(Font.font("Courier New", FontWeight.BOLD, 13));

        ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/resources/brown1.png"),100,100,true,true));
        image3.setFitHeight(10);
        image3.setFitWidth(10);

        final Label name3 = new Label("Christina");
        name3.setFocusTraversable(false);
        name3.setStyle("-fx-text-fill:  #663F15;");
        name3.setFont(Font.font("Courier New", FontWeight.BOLD, 13));

        ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/resources/brown2.png"),100,100,true,true));
        image4.setFitHeight(10);
        image4.setFitWidth(10);

        final Label name4 = new Label("Andrew");
        name4.setFocusTraversable(false);
        name4.setStyle("-fx-text-fill:  #663F15;");
        name4.setFont(Font.font("Courier New", FontWeight.BOLD, 13));


        playersPane.add(image1,2,0);
        playersPane.add(name1,3,0);
        playersPane.add(image2,4,0);
        playersPane.add(name2,5,0);
        playersPane.add(image3,6,0);
        playersPane.add(name3,7,0);
        playersPane.add(image4,8,0);
        playersPane.add(name4,9,0);

        HBox buttonPane = new HBox();
        buttonPane.setPrefSize(300,50);

        Button buttonJoin = new Button("Join");
        buttonJoin.setFont(Font.font("Courier New", FontWeight.BOLD, 12));
        buttonJoin.setStyle("-fx-background-color: linear-gradient(#C16E37  , #BA4A00 );-fx-text-fill:  #ffffff;");
        buttonJoin.setPrefSize(50,15);




        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        textMessagePane.add(dataPane,0,0);
        textMessagePane.add(playersPane,0,1);
        tablesPane.add(textMessagePane,0,0);
        tablesPane.add(buttonJoin,1,0);



        messagePane.add(tablesPane,0,0);



        discution.getChildren().add(messagePane);

    }


}
