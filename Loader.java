package com.Muzafar.project;

public class Loader {
    Loader(char c){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    for (int i=0;i<10;i++){
                        System.out.print(c);
                        Thread.sleep(100);
                    }
                    System.out.println();
        System.out.print("        ");
                }
                catch (Exception e){
                    System.out.println(e.getMessage());

                }            }

        });
        t1.start();
    }
}