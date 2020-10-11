package com.kaikeba.homework.view;

import com.kaikeba.homework.bean.Express;

import java.util.Scanner;

public class Views {
    private Scanner input = new Scanner(System.in);

    public void welcome(){
        System.out.println("欢迎使用快递e站（code by 邵蔚）");
    }

    public void bye(){
        System.out.println("欢迎下次使用~");
    }

    public int identityMenu(){
        System.out.println("请输入您的身份：");
        System.out.println("1.管理员");
        System.out.println("2.普通用户");
        System.out.println("0.退出");
        String in = input.nextLine();
        int number = -1;
        try{
            number = Integer.parseInt(in);
        }catch(NumberFormatException e){

        }
        return number;
    }

    public int adminMenu(){
        System.out.println("请选择您要进行的操作：");
        System.out.println("1.快递录入");
        System.out.println("2.快递删除");
        System.out.println("3.修改快递");
        System.out.println("4.显示所有快递");
        System.out.println("0.退回上一层");
        String in = input.nextLine();
        int number = -1;
        try{
            number = Integer.parseInt(in);
        }catch(NumberFormatException e){

        }
        return number;
    }

    public Express add() {
        System.out.println("请输入快递单号: ");
        String number = input.nextLine();
        System.out.println("请输入快递公司: ");
        String company = input.nextLine();
        Express e = new Express();
        e.setNumber(number);
        e.setCompany(company);
        return e;
    }

    public Express delete(){
        System.out.println("请输入要删除的快递单号：");
        String number = input.nextLine();
        Express e = new Express();
        e.setNumber(number);
        return e;
    }

    public Express update(){
        System.out.println("请输入要更改的快递单号：");
        String number = input.nextLine();
        Express e = new Express();
        e.setNumber(number);
        return e;
    }

    public void showAll(Express[][] e){
        System.out.println("以下是所有快递的信息：");
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.println("快递位置在： " + i + "行 " + j + "列");
                printExpress(e[i][j]);
            }
        }
    }

    public void printExpress(Express e){
        System.out.println("快递单号：" + e.getNumber() + "  快递公司： " + e.getCompany() + "  取件码： " + e.getCode());
    }

    public int userMenu(){
        System.out.println("请输入取件码：");
        String in = input.nextLine();
        int code = -1;
        try{
            code = Integer.parseInt(in);
        }catch(NumberFormatException e){

        }
        return code;
    }

    public void printAll(Express[][] e){
        int count = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(e[i][j] != null){
                    count++;
                    printExpress(e[i][j]);
                }
            }
        }
        if(count == 0){
            System.out.println("暂无快递信息");
        }
    }

    public void printExist(){
        System.out.println("快递已经存在，请重新输入");
    }

    public void printNull(){
        System.out.println("快递不存在，请重新输入");
    }

    public void success(){
        System.out.println("操作成功");
    }

}
