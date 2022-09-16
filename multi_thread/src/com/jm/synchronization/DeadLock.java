package com.jm.synchronization;

public class DeadLock {
    static class Friend{
        private final String name;
        public Friend(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public synchronized void bow(Friend bower){
            System.out.format("%s: %s" + " has bowed to me!\n",this.name,bower.name);
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower){
            System.out.format("%s: %s" + " has bowed back to me!\n",this.name,bower.getName());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        Thread AThread = new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.bow(gaston);
            }
        });
        Thread GThread = new Thread(new Runnable() {
            @Override
            public void run() {
                gaston.bow(alphonse);
            }
        });
        AThread.start();
        GThread.start();
        Thread.sleep(1000);
        System.out.println(AThread.getState());
        System.out.println(GThread.getState());
    }
}
