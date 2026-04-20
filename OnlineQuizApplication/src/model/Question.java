package model;

public class Question {
    int id;
    String question, o1, o2, o3, o4;
    int correct;

    public Question(int id, String q, String o1, String o2, String o3, String o4, int c) {
        this.id = id;
        this.question = q;
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.o4 = o4;
        this.correct = c;
    }

    public String getQuestion() { return question; }
    public String getO1() { return o1; }
    public String getO2() { return o2; }
    public String getO3() { return o3; }
    public String getO4() { return o4; }
    public int getCorrect() { return correct; }
}