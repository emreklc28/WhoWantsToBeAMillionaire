package com.emrekilic.whowantstobeamillionaire.model;

public class AnswerModel {

    private String question;
    private boolean isSelected;

    private boolean isCorrectAnswer;


    public AnswerModel(String question, boolean isSelected, boolean isCorrectAnswer) {
        this.question = question;
        this.isCorrectAnswer=isCorrectAnswer;
        this.isSelected = isSelected;
    }

    public String getQuestion() {
        return question == null ? "" : question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }
}
