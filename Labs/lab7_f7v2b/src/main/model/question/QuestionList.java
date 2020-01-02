package model.question;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a list of quiz questions.
 */
public class QuestionList {
    private List<Question> questions;

    // EFFECTS: constructs empty list of questions
    public QuestionList() {
        questions = new LinkedList<Question>();
    }

    // MODIFIES: this
    // EFFECTS: adds q to list of questions
    public void addQuestion(Question q) {
        questions.add(q);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    // EFFECTS: returns number of questions in list
    public int length() {
        return questions.size();
    }

    // EFFECTS: returns the max total mark possible as a sum of the marks across all of
    // the questions.
    public int getMaxMark() {
        int maxMark = 0;

        for (Question q : questions) {
            maxMark += q.getMaxMark();
        }

        return maxMark;
    }
}
