package com.lafin.knowledge.exam;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 숫자 야구 게임
 * 1~n 사이의 중복없는 n개의 숫자를 임의로 생성한다
 * 사용자는 n개의 숫자를 입력하며 숫자는 존재하나 자릿수가 맞지않으면 볼, 자릿수와 숫자 둘다 동일하면 스트라이크를 출력
 * 스트라이크가 3개면 자릿수, 숫자 모두 동일한 것이므로 승리!
 * 플레이어에게 기회는 n번 준다
 * @author lafin
 */
public class BaseballGame {

    // 총 공의 갯수
    int total;

    // 던질 공의 갯수
    int ballCount;

    // 플레이어가 시도할 수 있는 횟수
    int chance;

    // 현재 시도 중인 기회
    int turnCount;
    
    // 임의로 생성 될 숫자 배열
    int[] throwBalls;

    // 플레이어가 입력한 숫자 배열
    int[] playerBalls;

    // 사용자 입력을 받을 스캐너 변수 (System.in은 프로그램에서 하나만 생성하기 때문에 같은 클래스에서 공유해야한다.)
    Scanner input = new Scanner(System.in);

    // 초기화
    private void init(int ballCount){
        // 전역 변수, 배열 초기화
        System.out.print("초기화...");
        this.ballCount = ballCount;
        this.chance = ballCount;
        this.turnCount = 1;
        this.total = ballCount * 2;        
        this.throwBalls = new int[ballCount];
        this.playerBalls = new int[ballCount];
        System.out.println("완료!");

        // 0 ~ n 사이의 랜덤한 숫자 생성
        System.out.print("숫자는 1 ~ " + total + " 범위로 생성합니다...");
        System.out.print(ballCount + "개의 랜덤한 공을 생성합니다...");        
        makeRandomArray();
        System.out.println("완료!");
    }

    // 중복되지 않는 랜덤한 숫자배열 생성
    private void makeRandomArray(){
        // 공 배열 크기 만큼 반복
        for(int i=0; i<ballCount; i++){

            // while문으로 중복값 없을 때까지 반복
            int tmpBall = getRandomInt();
            while(isExistBall(throwBalls, tmpBall)){
                tmpBall = getRandomInt();
            }

            // while문에서 나온경우 tmpBall은 중복값이 없는 상태
            throwBalls[i] = tmpBall;
        }
    }

    // 랜덤 숫자 1개 생성
    // 랜덤 숫자는 전체 숫자 범위에서 만들어냄
    private int getRandomInt(){
        return (int) (Math.random() * total + 1);
    }

    // 현재 배열에 중복 값이 있는지 확인
    private boolean isExistBall(int[] arr, int ball){
        boolean isExist = false;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == ball){
                isExist = true;
                break;
            }
        }

        return isExist;
    }

    // 게임을 세팅하는 메소드 
    public void setGame(){

        // 입력을 제대로 받을 때까지 반복
        while(true){
            try{
                System.out.print("플레이 할 공의 갯수를 입력하세요 : ");

                int tmpBall = input.nextInt();
                

                if(tmpBall <= 0){
                    System.err.println("플레이 할 공의 수는 0보다 커야 합니다.");
                    input.nextLine();
                }else{
                    init(tmpBall);
                    System.out.println();
                    input.nextLine();
                    break;
                }
                
            }catch(InputMismatchException e){
                System.err.println("공의 갯수는 숫자만 입력가능합니다.");
                input.nextLine();
            }catch(NoSuchElementException ne){
                System.err.println("공의 갯수는 숫자만 입력가능합니다.");
                input.nextLine();
            }catch(Exception e){
                e.printStackTrace();
                input.nextLine();
            }
        }
    }

    // 게임 시작
    public void start() throws InterruptedException{

        // 게임 시작 대기 시간
        int waitTime = 3;
        
        // 게임 시작 
        System.out.println(waitTime + "초 후에 게임을 시작합니다.");
        System.out.println(ballCount + "개의 공의 순서와 숫자를 맞춰주세요~");
        
        // 3초 후에 시작 그냥 넣어봄 간지나게
        for(int i=waitTime; i>0; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }

        System.out.println("시작!");

        // 턴 수를 체크한다
        while(turnCount <= chance){
            System.out.println("[############### " + turnCount + "번째 시도! ###############]");
            turn();
            turnCount++;
        }

        System.out.println("시도 횟수를 초과했어요! 아쉽지만 다음에 다시 도전해주세요 ㅠ_ ㅠ");
    }

    // 게임 종료
    public void finish(){
        System.out.println("게임을 종료합니다! Good bye~");
        System.exit(0);
    }

    // 플레이어 공 초기화
    public void initPlayerBalls(){
        for(int i=0; i<playerBalls.length; i++){
            playerBalls[i] = 0;
        }
    }

    // 플레이어 입력 받기
    public void turn(){

        try{  
            while(true){
                // 플레이어 입력 공 초기화
                initPlayerBalls();
                for(int i=1; i<=ballCount; i++){
                    System.out.print(i + "번째 공을 입력해주세요 : ");
                    int answer = input.nextInt();                    

                    if(answer > 0){
                        if(answer > total){
                            System.err.println("제일 큰 수인 " + total + "을 넘을 수 없습니다!");
                            --i;
                            continue;
                        }

                        // 중복 체크
                        if(isExistBall(playerBalls, answer)){
                            System.out.println("이미 입력한 공이에요! 다시 입력해주세요 ㅎㅎ");
                            --i;
                        }else{
                            playerBalls[i-1] = answer;
                        }
                    }else{
                        System.err.println("공은 0보다 큰 수를 입력해야 합니다!");
                        --i;
                    }

                    input.nextLine();
                }

                int result = checkBalls();
                
                if(result == 3){
                    System.out.println("아쉬워요 ㅠ_ ㅠ 다시 ㄱㄱ~!");
                }else{
                    System.out.println("아예 없는 수를 입력했으니 이번 기회는 무효!");
                    turnCount--;
                }

                break;
            }
        }catch(InputMismatchException e){
            System.err.println("공은 숫자만 입력가능합니다.");
            input.nextLine();
        }catch(NoSuchElementException ne){
            System.err.println("공은 숫자만 입력가능합니다.");
            input.nextLine();
        }catch(Exception e){
            e.printStackTrace();
            input.nextLine();
        }
    }
    

    // 정답확인
    public int checkBalls(){
        int strikeCount = 0;
        int failCount = 0;
        
        // 설정된 숫자와 입력받은 숫자가 같은지 비교
        for(int i=0; i<throwBalls.length; i++){

            for(int j=0; j<playerBalls.length; j++){

                // 값이 있는지 검사
                if(throwBalls[i] == playerBalls[j]){
                    
                    // 일단 값이 있으면 순서가 맞는지 검사
                    if(i == j){
                        strikeCount++;                        
                    }else{
                        failCount++;
                    }
                    break;
                }
            }
        }

        System.out.println();
        System.out.println("[########## 채점결과 ##########]");
        System.out.println("스트라이크 : " + strikeCount);
        System.out.println("볼 : " + failCount);
        System.out.println("##############################");
        System.out.println();

        if(strikeCount == ballCount){
            System.out.println("축하합니다!! 당신이 이겼어요~~! \\^0 ^/");
            finish();
        }

        return strikeCount + failCount;
    }

    // 공 출력
    public void print(){
        
        System.out.println("[Ball print]");
        for(int i=0; i<throwBalls.length; i++){
            System.out.print(throwBalls[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // 야구게임 클래스 생성
        BaseballGame game = new BaseballGame();

        try{
            // 게임 초기화 
            game.setGame();

            // 게임 시작
            game.start();
            
        }catch(Exception e){
            System.err.println("게임 중 오류가 발생하였습니다. 개발자를 욕해주세요..");
        }
    }
}
