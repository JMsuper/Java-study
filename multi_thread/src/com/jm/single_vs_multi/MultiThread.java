package com.jm.single_vs_multi;

public class MultiThread extends Thread{
    static long curNum = 0;
    static long targetNum = 10000;
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while(curNum < targetNum){
            for(int i = 0; i < 10000000; i++){
                for(int j = 0; j < 10000; j++){

                }
            }
            curNum++;
//            System.out.println("m : " + curNum);
        }
        long finishTime = System.currentTimeMillis();
        long elapsedTime = finishTime - startTime;
        System.out.println("multi elapsedTime(ms) : " + elapsedTime);
        System.out.println("multi finished!");
    }
}
