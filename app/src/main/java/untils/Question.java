package untils;

import java.util.List;

/**
 * Created by 祝文 on 2018/3/2.
 */

public class Question {
    String question;
    List<Answer> mAnswer;
    int num;
    public String getQuestion() {
        return question;
    }
    public int getNum() {
        return num;
    }
    public List<Answer> getAnswer() {
        return mAnswer;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(List<Answer> answer) {
        mAnswer = answer;
    }
    public static  class Answer{
        String answerCode;
        String answerMessage;
        public Answer() {
        }
        public Answer(String answerCode, String answerMessage) {
            this.answerCode = answerCode;
            this.answerMessage = answerMessage;
        }
        public String getAnswerCode() {
            return answerCode;
        }
        public void setAnswerCode(String answerCode) {
            this.answerCode = answerCode;
        }
        public String getAnswerMessage() {
            return answerMessage;
        }
        public void setAnswerMessage(String answerMessage) {
            this.answerMessage = answerMessage;
        }
    }
}
