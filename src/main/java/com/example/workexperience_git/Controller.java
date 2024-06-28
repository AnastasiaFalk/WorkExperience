package com.example.workexperience_git;

import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ToggleGroup answers;

    @FXML
    private Text questionText;

    @FXML
    private RadioButton radioBtn_1;

    @FXML
    private RadioButton radioBtn_2;

    @FXML
    private RadioButton radioBtn_3;

    @FXML
    private RadioButton radioBtn_4;

    @FXML
    private Button answerBtn;

    @FXML
    private AnchorPane scenePane;

    Stage stage;

    public void exit() {
        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("Program has closed successfully");
        stage.close();
    }

    private final Questions[] questions = new Questions[] {
            new Questions("Which of the following is a classic ingredient in a traditional Margarita?", new String[] {
                    "Gin",
                    "Rum",
                    "Vodka",
                    "Tequila"
            }),
            new Questions("What is the main difference between a Martini and a Dirty Martini?", new String[] {
                    "The type of gin used",
                    "The garnish",
                    "The amount of vermouth",
                    "The addition of olive brine"
            }),
            new Questions("Which of the following cocktails is traditionally garnished with a maraschino cherry?", new String[] {
                    "Mojito",
                    "Cosmopolitan",
                    "Margarita",
                    "Old Fashioned"
            }),
            new Questions("Which spirit is the primary ingredient in a Mojito?", new String[] {
                    "Vodka",
                    "Tequila",
                    "Gin",
                    "Rum"
            }),
            new Questions("What does the term 'neat' mean when ordering a drink?", new String[] {
                    "With ice",
                    "Chilled",
                    "Shaken",
                    "Without ice or mixers"
            }),
            new Questions("Which of these cocktails typically contains tomato juice?", new String[] {
                    "Piña Colada",
                    "Mai Tai",
                    "Long Island Iced Tea",
                    "Bloody Mary"
            }),
            new Questions("What is a \"float\" in bartending?", new String[] {
                    "A drink served with ice cream",
                    "A cocktail that includes soda",
                    "Mixing ingredients by tossing them back and forth between two cups",
                    "Layering a small amount of liquid on top of a drink"
            })
    };

    private int nowQuestion = 0, correctAnswer;

    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        answerBtn.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            if(selectedRadioButton != null) {
                String toogleGroupValue = selectedRadioButton.getText();

                if(toogleGroupValue.equals(nowCorrectAnswer)) {

                    System.out.println("Correct answer.");
                    correctAnswer++;
                } else
                    System.out.println("Incorrect answer.");

                if(nowQuestion + 1 == questions.length) {
                    radioBtn_1.setVisible(false);
                    radioBtn_2.setVisible(false);
                    radioBtn_3.setVisible(false);
                    radioBtn_4.setVisible(false);
                    answerBtn.setVisible(false);


                    questionText.setText("You have answered " + correctAnswer + " out of " + questions.length + " questions correctly!");
                } else {
                    nowQuestion++;
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    questionText.setText(questions[nowQuestion].getQuestion());
                    String[] answers = questions[nowQuestion].getAnswers();

                    List<String> intList = Arrays.asList(answers);

                    Collections.shuffle(intList);

                    radioBtn_1.setText(intList.get(0));
                    radioBtn_2.setText(intList.get(1));
                    radioBtn_3.setText(intList.get(2));
                    radioBtn_4.setText(intList.get(3));

                    selectedRadioButton.setSelected(false);
                }
            }
        });
    }
}