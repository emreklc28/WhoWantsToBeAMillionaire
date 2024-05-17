package com.emrekilic.whowantstobeamillionaire;

import com.google.gson.annotations.SerializedName;

public class Answer {
    @SerializedName("answer_a")
    private String answer_a;

    @SerializedName("answer_b")
    private String answer_b;

    @SerializedName("answer_c")
    private String answer_c;

    @SerializedName("answer_d")
    private String answer_d;

    @SerializedName("answer_e")
    private String answer_e;

    @SerializedName("answer_f")
    private String answer_f;

    public Answer() {
    }

    public Answer(String answer_a, String answer_b, String answer_c, String answer_d, String answer_e, String answer_f) {
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.answer_e = answer_e;
        this.answer_f = answer_f;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
    }

    public String getAnswer_e() {
        return answer_e;
    }

    public void setAnswer_e(String answer_e) {
        this.answer_e = answer_e;
    }

    public String getAnswer_f() {
        return answer_f;
    }

    public void setAnswer_f(String answer_f) {
        this.answer_f = answer_f;
    }
}
