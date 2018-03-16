package bean;

/**
 * Created by 祝文 on 2018/3/3.
 */

public class AnswerBean {

    /**
     * id : 249
     * peType : MBTI_E
     * peId : 0.1
     * peTitle :
     * peBody : 注意事项：
     1．请在心态平和及时间充足的情况下才开始答题。
     2．每道题目均有两个答案：A和B。请仔细阅读题目，按照与你性格相符的程度选择相应选项。
     3．请注意，题目的答案无对错之分，你不需要考虑哪个答案“应该”更好，而且不要在任何问题上思考太久，而是应该凭你心里的第一反应做出选择。
     4．如果你觉得在不同的情境里，两个答案或许都能反映你的倾向，请选择一个对于你的行为方式来说最自然、最顺畅和最从容的答案。
     温馨提示：本测试共69题，预计花费您15分钟。

     * answerA :
     * answerB :
     * answerC : null
     * answerD : null
     * answerE : null
     * answerF : null
     * remarks : null
     */

    private int id;
    private String peType;
    private String peId;
    private String peTitle;
    private String peBody;
    private String answerA;
    private String answerB;
    private Object answerC;
    private Object answerD;
    private Object answerE;
    private Object answerF;
    private Object remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeType() {
        return peType;
    }

    public void setPeType(String peType) {
        this.peType = peType;
    }

    public String getPeId() {
        return peId;
    }

    public void setPeId(String peId) {
        this.peId = peId;
    }

    public String getPeTitle() {
        return peTitle;
    }

    public void setPeTitle(String peTitle) {
        this.peTitle = peTitle;
    }

    public String getPeBody() {
        return peBody;
    }

    public void setPeBody(String peBody) {
        this.peBody = peBody;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public Object getAnswerC() {
        return answerC;
    }

    public void setAnswerC(Object answerC) {
        this.answerC = answerC;
    }

    public Object getAnswerD() {
        return answerD;
    }

    public void setAnswerD(Object answerD) {
        this.answerD = answerD;
    }

    public Object getAnswerE() {
        return answerE;
    }

    public void setAnswerE(Object answerE) {
        this.answerE = answerE;
    }

    public Object getAnswerF() {
        return answerF;
    }

    public void setAnswerF(Object answerF) {
        this.answerF = answerF;
    }

    public Object getRemarks() {
        return remarks;
    }

    public void setRemarks(Object remarks) {
        this.remarks = remarks;
    }
}
