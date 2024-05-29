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
        return answer_a == null ? "" : answer_a;
    }

    public String getAnswer_b() {
        return answer_b == null ? "" : answer_b;
    }

    public String getAnswer_c() {
        return answer_c == null ? "" : answer_c;
    }

    public String getAnswer_d() {
        return answer_d == null ? "" : answer_d;
    }


}
