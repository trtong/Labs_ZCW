package rocks.zipcode.atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author ZipCodeWilmington
 */

// Eventually 2 display fields : 1 for account info, 2: account transactions/alerts/status
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());

    //Login -> profile, new stages for each, change stages.
    //

    private Stage mainAccount(int id) {

        Stage account = new Stage();


        account.setTitle("Account Details");


        VBox vbox = new VBox(10);
        vbox.setBackground(new Background(
                new BackgroundFill(
                        Color.color(0.4, 0.6, 0.9), null, null)));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // New text areas that cannot be interacted with
        TextArea areaInfo = new TextArea();
        areaInfo.setEditable(false);
        areaInfo.setMouseTransparent(true);
        areaInfo.setFocusTraversable(false);

        TextArea transactions = new TextArea();
        transactions.setEditable(false);
        transactions.setMouseTransparent(true);
        transactions.setFocusTraversable(false);

        field.clear();

        grid.add(areaInfo, 0, 0);
        grid.add(field, 0, 1);


        Button btnDeposit = new Button("Deposit");
        btnDeposit.setOnAction(e -> {
            int amount = Integer.parseInt(field.getText());
            cashMachine.deposit(amount);

            areaInfo.setText(cashMachine.toString());
            transactions.setText(cashMachine.transactionString());
        });


        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            int amount = Integer.parseInt(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
            transactions.setText(cashMachine.transactionString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cashMachine.exit();
                areaInfo.setText(cashMachine.toString());

                Alert exitAlert = new Alert(Alert.AlertType.INFORMATION);
                exitAlert.setContentText("Now Exiting Application.");
                exitAlert.showAndWait();

                Stage stage = (Stage) btnExit.getScene().getWindow();
                stage.close();
            }
        });

        Button clearTrans = new Button("Clear Transactions");
        clearTrans.setOnAction(e -> {
            transactions.clear();
        });

        //

        Scene accountScene = new Scene(vbox, 450, 500);


        cashMachine.login(id);

        areaInfo.setText(cashMachine.toString());

        vbox.getChildren().addAll(grid, btnDeposit, btnWithdraw, transactions, clearTrans);

        account.setScene(accountScene);

        return account;
    }


    private Stage loginStage() {

        Stage login = new Stage();
        login.setTitle("Account Login");


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        VBox vbox = new VBox(10);
        vbox.setSpacing(10);

        vbox.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(vbox, 375, 350);

        vbox.setBackground(new Background(
                new BackgroundFill(
                        Color.color(0.4, 0.6, 0.9), null, null)));

        // Title
        Text title = new Text("ZipCloudBank");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFont(Font.font("Verdana", 25));
        title.setFill(Color.WHITE);

        grid.add(title, 0,0);

        // Desc
        Text desc = new Text(" ");
        desc.setFont(Font.font("Verdana", 10));
        grid.add(desc, 0, 1);


        // Enter username
        Label userName = new Label ("Enter Account Number");
        userName.setFont(Font.font("Verdana", 10));
        userName.setLabelFor(field);
        userName.setTextFill(Color.WHITESMOKE);

        grid.add(userName, 0, 2);
        grid.add(field, 0, 3);

        // Enter PW
        PasswordField pw = new PasswordField();
        Label pwLabel = new Label("Enter Password");
        pwLabel.setFont(Font.font("Verdana", 10));
        pwLabel.setTextFill(Color.WHITESMOKE);

        grid.add(pwLabel, 0, 4);
        grid.add(pw, 0, 5);

        // Login Button
        Button btn = new Button("Log in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);

        grid.add(btn, 0, 6);

//        // new user text
//        Text newUser = new Text("\nNew user?");
//        newUser.setFont(Font.font("Verdana", 10));
//        newUser.setFill(Color.WHITESMOKE);
//
//        grid.add(newUser, 0, 8);
//
//        // New user button
//        Button newbtn = new Button("Create Account");
//        HBox newHBox = new HBox(10);
//        newHBox.setAlignment(Pos.CENTER);
//        newHBox.getChildren().add(newbtn);
//
//        grid.add(newHBox, 0,9);


        vbox.getChildren().addAll(grid);

        // -------- Button actions --------- //

        // Login button action
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Integer id = Integer.parseInt(field.getText());

                if (cashMachine.checkUserId(id) && cashMachine.comparePassword(id, pw.getText())) {
//                    if (pw.getText().equals("1234")) {
//
//                    }
                    login.hide();
                    mainAccount(id).show();
                } else if (!cashMachine.checkUserId(id)) {
                    Alert invalidID = new Alert(Alert.AlertType.INFORMATION);
                    invalidID.setContentText("Invalid ID number.");
                    invalidID.showAndWait();
                    field.clear();
                    pw.clear();
                } else if (!cashMachine.comparePassword(id, pw.getText())) {
                    Alert invalidID = new Alert(Alert.AlertType.INFORMATION);
                    invalidID.setContentText("Wrong password.");
                    invalidID.showAndWait();
                    field.clear();
                    pw.clear();
                }
            }
        });


        login.setScene(scene);

        return login;

    }

//    private Stage changePW(int id) {
//        Stage changePW = new Stage();
//        changePW.setTitle("New Password");
//
//
//        VBox vbox = new VBox(10);
//        vbox.setBackground(new Background(
//                new BackgroundFill(
//                        Color.color(0.4, 0.6, 0.9), null, null)));
//
//
//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//
//        Scene scene = new Scene(grid, 300, 300);
//
//        Label newPass = new Label ("New Password: ");
//        newPass.setFont(Font.font("Verdana", 10));
//        newPass.setLabelFor(field);
//        newPass.setTextFill(Color.WHITESMOKE);
//
//        grid.add(newPass, 0, 2);
//        TextField newPw = new TextField();
//        grid.add(newPw, 0, 3);
//
//        Label newPass2 = new Label ("Re-enter password: ");
//        newPass2.setFont(Font.font("Verdana", 10));
//        newPass2.setLabelFor(field);
//        newPass2.setTextFill(Color.WHITESMOKE);
//        grid.add(newPass2, 0, 4);
//
//        TextField newPwRetype = new TextField();
//        grid.add(newPwRetype, 0, 5);
//
//        Button newbtn = new Button("Set Password");
//        HBox newHBox = new HBox(10);
//        newHBox.setAlignment(Pos.CENTER);
//        newHBox.getChildren().add(newbtn);
//
//        grid.add(newHBox, 0, 5);
//
//        newbtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (newPw.getText().equals(newPwRetype)) {
//                    cashMachine.setPassword(id);
//                }
//
//
//            }
//        });
//
//
//
//        vbox.getChildren().addAll(grid);
//
//        changePW.setScene(scene);
//
//        return changePW;
//    }

    @Override
    public void start(Stage stage) throws Exception {

        Stage login = loginStage();

        login.alwaysOnTopProperty();

        login.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}

