package com.lafin.knowledge.exam;

/**
 * 입문 기초 별 찍기 클래스
 * 아주 간단한 기초 문법과 사고력 기르기 시작에 좋은 방법
 * @author laifn
 */
class StarPrint{

    // 기본 가로, 세로 크기
    final int DEFAULT_WIDTH = 5;
    final int DEFAULT_HEIGHT = 5;
    
    // 출력을 위한 상수값
    final String LINE = "=========================";

    int width;  // 가로 길이
    int height; // 세로 길이

    // 생성자
    public StarPrint(){
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
    }

    // 초기화 메소드
    public void reset(){
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
    }

    // 가로, 세로 크기 세팅
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    // 기본 5x5 출력
    /**
        출력형태
        *****
        *****
        *****
        *****
        *****
    */
    public void basic(){        
        System.out.println("[기본 삼각형 출력]");
        System.out.println(LINE);       

        // 사이즈 초기화
        reset(); 

        // 1번째 for문 당 한줄을 개행하므로 세로 길이만큼
        for(int i = 0; i < height; i++){

            // 2번째 for문 당 한줄 내 별을 출력하므로 가로 길이 만큼
            for(int j = 0; j < width; j++){
                System.out.print("*");
            }

            // 개행
            System.out.println();
        }

        System.out.println(LINE);
    }

    // 증가 삼각 형태
    /**
        출력
        *
        **
        ***
        ****
        *****
    */
    public void increseTriangle(){
        System.out.println("[증가 삼각형 출력]");
        System.out.println(LINE);
        
        // 사이즈 초기화
        reset();
        
        // 5줄이 출력되므로 세로길이 그대로 사용
        for(int i = 0; i < height; i++){

            // n번째 행에 n개가 출력되므로 변수 i를 이용한다
            // 조건식은 i == j 인경우 실행되지 않으므로 <= 작거나 같을때까지 반복 
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println(LINE);
    }

    // 감소 삼각 형태
    /**
        출력
        *****
        ****
        ***
        **
        *
    */
    public void decreseTriangle(){
        System.out.println("[감소 삼각형 출력]");
        System.out.println(LINE);
        
        // 사이즈 초기화
        reset();
        
        // 5줄이 출력되므로 세로길이 그대로 사용
        for(int i = 0; i < height; i++){

            // n번째 행에 (가로길이 - n) 개가 출력되므로 변수 i를 이용한다
            // 첫 행은 0부터 시작해야 가로길이 전체가 출력되므로 < 작을때까지만 반복
            for(int j = i; j < width; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println(LINE);
    }

    // 피라미드 형태
    // 모양을 맞추기 위해 행은 5개로 동일하나 가로길이만 4를 더해 9로 사용한다.
    /**
           출력
            *
           ***
          *****
         *******
        *********
    */
    public void pyramid(){
        System.out.println("[피라미드 형태 출력]");
        System.out.println(LINE);
        
        // 크기를 9*5로 리사이징
        setSize(9, 5);
        
        // 5줄이 출력되므로 세로길이 그대로 사용
        for(int i = 0; i < height; i++){

            // 양쪽에 (세로길이 - i) 개수만큼 빈칸이 있다
            // 별이 출력되는 위치는 i번째 행에 (세로길이 - (i + 1)) 부터 시작해서 (세로길이 - i) + (i * 1 + i) 까지 출력한다
            for(int j = 0; j < width; j++){
                int start = height - (i + 1);    // 별 출력이 시작할 위치
                int end = start + (i * 1 + i);   // 별 출력이 끝날 위치
                
                // start <= j <= end 형태로 출력하게 됨
                if(j >= start && j <= end){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }

            System.out.println();
        }

        System.out.println(LINE);
    }

    // 역피라미드 형태
    // 모양을 맞추기 위해 행은 5개로 동일하나 가로길이만 4를 더해 9로 사용한다.
    /**
           출력
        *********
         ******* 
          *****  
           ***   
            *
    */
    public void unpyramid(){
        System.out.println("[역피라미드 형태 출력]");
        System.out.println(LINE);
        
        // 크기를 9*5로 리사이징
        setSize(9, 5);
        
        // 5줄이 출력되므로 세로길이 그대로 사용
        for(int i = 0; i < height; i++){
            
            // 아래 수식은 width=9 인 것을 이용하고 index는 0~8 까지 인것을 감안하고 수식을 만듬
            // (가로길이 - (가로길이 - i)) 가 시작 값이 된다.
            // (가로길이 - (i + 1) 가 끝 값이 된다.
            for(int j = 0; j < width; j++){
                int start = width - (width - i);  // 별 출력이 시작할 위치
                int end = width - (i + 1);        // 별 출력이 끝날 위치

                if(j >= start && j <= end){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        System.out.println(LINE);
    }

    // 모래시계 형태
    /**
        출력
        *****
         *** 
          *
          *
         ***
        *****
    */
    public void hourglass(){
        System.out.println("[모래시계 형태 출력]");
        System.out.println(LINE);
        
        // 크기를 5*6 으로 리사이징
        setSize(5, 6);
        
        // 6줄이 출력되므로 세로길이 그대로 사용
        for(int i = 0; i < height; i++){
            
            // 피라미드, 역피라미드 수식을 활용하여 세로길이의 반까지는 역피라미드, 반 이상부터는 피라미드 수식을 사용한다.
            for(int j = 0; j < width; j++){
                boolean afterHalf = (height / 2) <= i; // 현재 행이 반 이상 지났는지 검사하는 변수

                // 반 이상이면 피라미드 이하면 역피라미드 수식 사용
                // 피라미드 수식은 0부터 시작하는 것을 전제로 하기 때문에 시작값을 임시로 0으로 설정
                int start = afterHalf ? height - (i + 1) : width - (width - i); // 별 출력이 시작할 위치
                int end = afterHalf ? start + ((i - (height / 2)) * 1 + (i - (height / 2))) : width - (i + 1);    // 별 출력이 끝날 위치

                if(j >= start && j <= end){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        System.out.println(LINE);
    }

    // 달팽이 형태
    // n * n 형태로 출력 인자값을 받아서 처리한다
    /**
        출력
        ********************
                           *
        ****************** *
        *                * *
        * ************** * *
        * *            * * *
        * * ********** * * *
        * * *        * * * *
        * * * ****** * * * *
        * * * *    * * * * *
        * * * * *  * * * * *
        * * * * **** * * * *
        * * * *      * * * *
        * * * ******** * * *
        * * *          * * *
        * * ************ * *
        * *              * *
        * **************** *
        *                  *
        ********************
    */
    public void snail(int size){
        System.out.println("[달팽이 형태 출력]");
        System.out.println(LINE);
        
        // 크기를 size*size 으로 리사이징
        setSize(size, size);
        
        // 
        for(int i = 0; i < height; i++){
            
            // 
            for(int j = 0; j < width; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println(LINE);
    }
    

    public static void main(String[] args) {
        
        System.out.println("별 찍기 시작");
        StarPrint sp = new StarPrint();

        // 기본 별찍기
        sp.basic();

        // 증가삼각형
        sp.increseTriangle();

        // 감소삼각형
        sp.decreseTriangle();

        // 피라미드
        sp.pyramid();

        // 역피라미드
        sp.unpyramid();

        // 모래시계
        sp.hourglass();

        // 달팽이
        sp.snail(15);

    }
}