package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // write your code here
        int length = 0;
        while(true) {
            try {
                System.out.println("enter length of list:");
                length = Integer.parseInt(UserInput());
                if(length>0) {
                    break;
                }
                else{
                    System.out.println("number need to be greater then 0");
                }
            }
            catch(Exception e){
                System.out.println("invalid input"+e);
            }
        }
        String[] board= new String[length];
        board= makeBoard(length,board);
        System.out.println("enter name");
        String name = UserInput();

        board=game(length,name,board);
        checkWinner(board,name);



    }
    public static String[] game(int length,String name,String[] board){
        int goes = 0;
        int userInt=0;
        while(goes*2< length){
            while(true) {
                try {
                    System.out.println("type a number between 0 and " + (length - 1));
                    userInt = Integer.parseInt(UserInput());
                    if ((userInt >= 0) && (userInt <= (length - 1))) {
                        break;
                    } else {
                        System.out.println("number out of range");
                    }
                }
                catch(Exception e){
                    System.out.println("invalid input"+e);
                }
            }
            if (board[userInt].equals("[ ]")){
                board[userInt]=name;
            }
            int RandNum=RandNum(0,length-1);
            if (board[RandNum].equals("[ ]")) {
                board[RandNum] = "comp";
            }
            goes=goes+1;

        }
        return board;
    }
    public static String UserInput() {
        Scanner input = new Scanner(System.in);
        String userin;
        while (true) {
            try {
                userin = input.next();
                break;
            } catch (Exception e) {
                System.out.println("not a valid input " + e);
                input.next();
            }
        }
        return userin;
    }
    public static String[] makeBoard(int length,String[] board){
        for (int i = 0; i < length; i++) {
            board[i]= "[ ]";
        }
        return board;
    }
    public static int RandNum(int min,int max){
        Random random = new Random();
        return random.nextInt(max-min)+min;
    }
    public static void checkWinner(String[] board,String name){
        int playerScore = 0;
        int computerScore = 0;
        for (int i = 0; i < board.length; i++) {
            if(board[i].equals(name)){
                playerScore=playerScore+1;
            }
            if(board[i].equals("comp")){
                computerScore=computerScore+1;
            }
        }
        System.out.println(name+" scored "+playerScore);
        System.out.println("computer scored "+computerScore);

        if(playerScore>=computerScore){
            System.out.println("player wins");
        }
        else{
            System.out.println("computer wins");
        }
    }

}