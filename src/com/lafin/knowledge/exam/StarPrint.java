package com.lafin.knowledge.exam;

class StarPrint{


    public void basic(){
        for(int i=0; i<7; i++){
            for(int j=0; j<10; j++){
                System.out.print("*");
            }
            System.out.println("");
        }

    }

    public void incre(){

        for(int i=0; i<5; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void decre(){
        for(int i=5; i>0; i--){
            for(int j=i; j>0; j--){
                System.out.print("*");
            }

            System.out.println();
        }
    }



    public static void main(String[] args) {
        
        StarPrint sp = new StarPrint();
        System.out.println("Incre");
        sp.incre();
        System.out.println("Decre");
        sp.decre();
        
    }
}