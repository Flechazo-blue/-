package com.kaikeba.homework1;

import java.util.Scanner;

public class Main {
    public static ExpressCabinet ec = new ExpressCabinet();

    public static void main(String[] args) {

        int in;
        while(true){
            in = menu();
            if(in == 1){
                adminMenu();
            }else if(in == 2){
                userMenu();
            }else{
                System.out.println("请输入正确的值。");
            }
        }

    }

    public static int menu(){
        System.out.println("请输入您的身份: ");
        System.out.println("1.管理员  2.普通用户");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        return in;
    }

    public static void adminMenu(){
        Scanner input = new Scanner(System.in);

        System.out.println("请输入你要进行的操作：");
        System.out.println("1.快递录入  2.删除快递  3.修改快递  4.查看所有快递");
        int in = input.nextInt();
        input.nextLine();
        if(in == 1){
            System.out.println("请输入快递单号：");
            String trackingNum = input.nextLine();
            System.out.println("请输入公司名称：");
            String company = input.nextLine();

            ExpressDelivery ed = new ExpressDelivery(trackingNum, company);

            if(ec.add(ed)){
                System.out.println("添加成功!");
            }
        }else if(in == 2){
            System.out.println("请输入删除快递的单号： ");
            String trackingNum = input.nextLine();
            if(ec.removeByTrackingNum(trackingNum)){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        }else if(in == 3){
            System.out.println("请输入修改快递的单号： ");
            String trackingNum = input.nextLine();
            ExpressDelivery oldDelivery = ec.getByTrackingNum(trackingNum);

            if(oldDelivery == null){
                System.out.println("没有找到！");
                return;
            }
            System.out.println("请输入快递单号：");
            String newTrackingNum = input.nextLine();
            System.out.println("请输入公司名称：");
            String newCompany = input.nextLine();

            ExpressDelivery newDelivery = new ExpressDelivery(newTrackingNum, newCompany);
            newDelivery.setPickupCode(oldDelivery.getPickupCode());

            System.out.println(newDelivery.toString());

            if(ec.updateByTrackingNum(trackingNum, newDelivery)){
                System.out.println("更新成功！");
            }
        }else if(in == 4){
            System.out.println("以下是所有快递信息：");
            ec.showAll();
        }else{
            System.out.println("请输入正确的操作序号!");
        }
    }


    public static void userMenu(){
        System.out.println("请输入取件码：");
        Scanner input = new Scanner(System.in);
        String pickupCode = input.nextLine();
        int pos[] = ec.getIndexByPickupCode(pickupCode);
        if(pos[0] == -1 && pos[1] == -1){
            System.out.println("没有找到快递！");
            System.out.println("请重新输入");
            return;
        }
        System.out.println("快递位置在 ： ");
        System.out.println("行 ： " + pos[0]);
        System.out.println("列 ： " + pos[1]);
        System.out.println(ec.getByIndex(pos[0], pos[1]).toString());
        ec.removeByPickupCode(pickupCode);
        System.out.println("取件成功！");
    }
}
