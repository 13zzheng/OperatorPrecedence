package cn.edu.stu.zzheng.grammar;

/**
 * Created by neng-zheng on 2015/12/23.
 */
public class Terminator {

    private String termiannator;
    private int id=-1;

    public String getTermiannator() {
        return termiannator;
    }

    public void setTermiannator(String termiannator) {
        this.termiannator = termiannator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Terminator (String  s){
        this.termiannator=s;
    }
}
