package com.emrekilic.whowantstobeamillionaire;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataMain {


    @SerializedName("id")
    private int id;

    @SerializedName("question")
    private String question;

    @SerializedName("multiple_correct_answers")
    private String multiple_correct_answers;

    @SerializedName("correct_answer")
    private String correct_answer;

    @SerializedName("difficulty")
    private String difficulty;

    @SerializedName("answers")
    Answer answersList;

    CorrectAnswer correctAnswerList;

    public DataMain() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getMultiple_correct_answers() {
        return multiple_correct_answers;
    }

    public void setMultiple_correct_answers(String multiple_correct_answers) {
        this.multiple_correct_answers = multiple_correct_answers;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Answer getAnswersList() {
        return answersList;
    }

    public void setAnswersList(Answer answersList) {
        this.answersList = answersList;
    }

    public CorrectAnswer getCorrectAnswerList() {
        return correctAnswerList;
    }

    public void setCorrectAnswerList(CorrectAnswer correctAnswerList) {
        this.correctAnswerList = correctAnswerList;
    }
}
