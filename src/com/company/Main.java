package com.company;

import cn.edu.stu.zzheng.grammar.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("算符优先算法分析程序，编制人：");
        System.out.println("郑卓 2013101059 13计算机");
        System.out.println("张水源 2013101053 13计算机");
        System.out.println("张国全 2013101059 13计算机");
        System.out.println("王伟韩 2013101040 13计算机");
//        System.out.println("例题文法如下：");
//        System.out.println("S=>a|^|(T)");
//        System.out.println("T=>T,S|S");
//        System.out.print("请输入以#结尾的符号串:");
//        Scanner scanner=new Scanner(System.in);
//        String input =scanner.nextLine();
//        Main mian=new Main();
//        mian.test(input);

        Main main=new Main();
        main.input();

    }

    public void test(String input){
        Grammar grammar=new Grammar();
        grammar.addNter("S'");
        grammar.addNter("S");
        grammar.addNter("T");

        grammar.addTer("#");
        grammar.addTer("a");
        grammar.addTer("^");
        grammar.addTer("(");
        grammar.addTer(")");
        grammar.addTer(",");

        grammar.addProduction("S'","#S#");
        grammar.addProduction("S","a");
        grammar.addProduction("S","^");
        grammar.addProduction("S","(T)");
        grammar.addProduction("T","T,S");
        grammar.addProduction("T","S");

        grammar.sort();
        grammar.caculate();
        grammar.analy(input);

    }
    public void input(){
        Grammar grammar=new Grammar();
        Scanner scanner=new Scanner(System.in);
        String pro;
        HashSet<String> nTer=new HashSet<String>();
        HashSet<String> ter=new HashSet<String>();
        HashSet<String> prod=new HashSet<String>();
        String input="";
        String[] s;
        String[] s1;
        System.out.println("请输入文法产生式，输入‘end’结束 例：S→SaT|T   （每条产生式占一行）");
        System.out.println("产生式：");
        pro =scanner.nextLine();
        s=pro.split("→");
        if (s.length != 2) {
            System.out.println("输入出错");

        }
        if (!pro.equals("end")) {
            nTer.add(s[0] + "'");
            nTer.add(s[0]);
            ter.add("#");
            prod.add(s[0] + "'→#" + s[0] + "#");
            if (s[1].contains("|")) {
                s1 = s[1].split("\\|");
                s[1]=s[1].replace("|", "");
                for (int i = 0; i < s1.length; i++) {
                    prod.add(s[0] + "→" + s1[i]);
                }
            } else {
                prod.add(s[0] + "→" + s[1]);
            }

            for (int i = 0; i < s[1].length(); i++) {
                if (!Character.isUpperCase(s[1].charAt(i))) {
                    ter.add(String.valueOf(s[1].charAt(i)));
                }
            }
        }
        while (true) {
            pro = scanner.nextLine();
            if (!pro.equals("end")) {
                s = pro.split("→");
                if (s.length != 2) {
                    System.out.println("输入出错");
                    break;
                }
                nTer.add(s[0]);
                if (s[1].contains("|")) {
                    s1 = s[1].split("\\|");
                    s[1]=s[1].replace("|", "");
                    for (int i = 0; i < s1.length; i++) {
                        prod.add(s[0] + "→" + s1[i]);
                    }
                } else {
                    prod.add(s[0] + "→" + s[1]);
                }
                for (int i = 0; i < s[1].length(); i++) {
                    if (!Character.isUpperCase(s[1].charAt(i))) {
                        ter.add(String.valueOf(s[1].charAt(i)));
                    }
                }

            }else{
                break;
            }
        }
        System.out.println("输入字符串：");
        input=scanner.nextLine();
        if (input.charAt(input.length()-1) !='#'){
            System.out.println("输入字符串出错");
        }
        scanner.close();

        System.out.print("非终结符集：");
        Iterator<String> iterator1=nTer.iterator();
        while (iterator1.hasNext()){
            String a=iterator1.next();
            System.out.print(a+" ");
            grammar.addNter(a);
        }
        System.out.println();
        System.out.print("终结符集：");
        Iterator<String> iterator2=ter.iterator();
        while (iterator2.hasNext()){
            String b=iterator2.next();
            System.out.print(b+" ");
            grammar.addTer(b);
        }
        System.out.println();
        Iterator<String> iterator3=prod.iterator();
        String[] ps;
        while (iterator3.hasNext()){
            String c=iterator3.next();
            ps=c.split("→");
            grammar.addProduction(ps[0],ps[1]);
        }
        System.out.println();
        grammar.sort();
        grammar.caculate();
        grammar.printO();
        grammar.analy(input);
    }
}
