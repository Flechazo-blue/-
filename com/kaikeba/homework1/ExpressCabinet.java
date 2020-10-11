package com.kaikeba.homework1;

public class ExpressCabinet {
    private ExpressDelivery[][] ed = new ExpressDelivery[20][40];
    private boolean[][] isOccupy = new boolean[20][40];
    public static final int MAX_X = 20;
    private static final int MAX_Y = 20;

    private int[] generatePosition(){
        while(true){
            int x = (int)Math.floor(Math.random() * 20);
            int y = (int)Math.floor(Math.random() * 20);
            if(isOccupy[x][y] == false){
                int[] result = {x, y};
                isOccupy[x][y] = true;
                return result;
            }
        }
    }

    private String generatePickupCode(){
        while(true){
            String code = "";
            for(int i = 1; i <= 6; i++){
                code += Integer.toString((int)Math.floor(Math.random()*10));
            }
            if(getByPickupCode(code) == null){
                return code;
            }
        }
    }

    public int[] getIndex(ExpressDelivery delivery){
        int[] pos = new int[2];

        if(delivery == null){
            pos[0] = -1;
            pos[1] = -1;
            return pos;
        }

        for(int i = 0; i < MAX_X; i++){
            for(int j = 0; j < MAX_Y; j++){
                if(ed[i][j] == null){
                    continue;
                }
                if(delivery.equals(ed[i][j])){
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }

        pos[0] = -1;
        pos[1] = -1;
        return pos;
    }

    public int[] getIndexByPickupCode(String pickupCode){
        ExpressDelivery delivery = new ExpressDelivery();
        delivery.setPickupCode(pickupCode);
        return getIndex(delivery);
    }

    public int[] getIndexByTrackingNum(String trackingNum){
        ExpressDelivery delivery = new ExpressDelivery();
        delivery.setTrackingNum(trackingNum);
        return getIndex(delivery);
    }

    public ExpressDelivery getByIndex(int x, int y){
        return ed[x][y];
    }

    public ExpressDelivery get(ExpressDelivery delivery){
        int[] pos = getIndex(delivery);
        if(pos[0] == -1 && pos[1] == -1){
            return null;
        }else {
            System.out.println(ed[pos[0]][pos[1]].toString());
            return ed[pos[0]][pos[1]];
        }
    }

    public ExpressDelivery getByTrackingNum(String trackingNum){
        ExpressDelivery delivery = new ExpressDelivery();
        delivery.setTrackingNum(trackingNum);
        return get(delivery);
    }

    public ExpressDelivery getByPickupCode(String pickupCode){
        ExpressDelivery delivery = new ExpressDelivery();
        delivery.setPickupCode(pickupCode);
        return get(delivery);
    }

    public boolean  add(ExpressDelivery delivery){
        int[] pos = getIndex(delivery);
        if(pos[0] != -1 && pos[1] != -1){
            System.out.println("快递信息重复，请重新输入。");
            return false;
        }

        pos = generatePosition();
        ed[pos[0]][pos[1]] = delivery;
        delivery.setPickupCode(generatePickupCode());
        return true;
    }

    public boolean removeByPickupCode(String pickupCode){
        int pos[] = getIndexByPickupCode(pickupCode);
        isOccupy[pos[0]][pos[1]] = false;
        return updateByPickupCode(pickupCode, null);
    }

    public boolean removeByTrackingNum(String trackingNum){
        int pos[] = getIndexByTrackingNum(trackingNum);
        isOccupy[pos[0]][pos[1]] = false;
        return updateByTrackingNum(trackingNum, null);
    }

    public boolean updateByTrackingNum(String trackingNum, ExpressDelivery newDelivery){
        int pos[] = getIndexByTrackingNum(trackingNum);
        if(pos[0] == -1 && pos[1] == -1){
            System.out.println("找不到快递，请重新输入。");
            return false;
        }

        ed[pos[0]][pos[1]] = newDelivery;

        return true;
    }

    public boolean updateByPickupCode(String pickupCode, ExpressDelivery newDelivery){
        int pos[] = getIndexByPickupCode(pickupCode);
        if(pos[0] == -1 && pos[1] == -1){
            System.out.println("找不到快递，请重新输入。");
            return false;
        }

        ed[pos[0]][pos[1]] = newDelivery;

        return true;
    }

    public void showAll(){
        for(int i = 0; i < MAX_X; i++){
            for(int j = 0; j < MAX_Y; j++){
                if(ed[i][j] == null){
                    continue;
                }
                System.out.println("快递位置：");
                System.out.println("行： " + i);
                System.out.println("列： " + j);
                System.out.println(ed[i][j].toString());
            }
        }
    }

}
