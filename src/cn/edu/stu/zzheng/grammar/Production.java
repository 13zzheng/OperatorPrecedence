package cn.edu.stu.zzheng.grammar;

import java.util.HashSet;

/**
 * Created by neng-zheng on 2015/12/23.
 */
public class Production {

    private HashSet<String> production=null;


    public HashSet<String> getProduction() {
        return production;
    }

    public void add(String production) {
        this.production.add(production);
    }


    public Production(){
        production=new HashSet<String>();
    }
}
