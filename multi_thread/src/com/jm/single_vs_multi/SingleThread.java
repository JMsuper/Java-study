package com.jm.single_vs_multi;

public class SingleThread {
    void run(){
        long startTime = System.currentTimeMillis();
        long targetNum = 10000;
        long curNum = 0;
        while(curNum < targetNum){
            for(int i = 0; i < 10000000; i++){
                for(int j = 0; j < 10000; j++){

                }
            }
//            System.out.println("s : " + curNum);
            curNum++;
        }
        long finishTime = System.currentTimeMillis();
        long elapsedTime = finishTime - startTime;
        System.out.println("single elapsedTime(ms) : " + elapsedTime);
        System.out.println("single finished!");
    }
}
