import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTac {
    static String[] board;
    static String turn;
    static String CheckWinner(){
        for(int i=0;i<8;i++){
            String line=null;
            switch (i){
                case 0:
                    line =board[0]+board[1]+board[2];
                    break;
                case 1:
                    line=board[3]+board[4]+board[5];
                    break;
                case 2:
                    line=board[6]+board[7]+board[8];
                    break;
                case 3:
                    line=board[0]+board[3]+board[6];
                    break;
                case 4:
                    line=board[1]+board[4]+board[7];
                    break;
                case 5:
                    line=board[2]+board[5]+board[8];
                    break;
                case 6:
                    line=board[0]+board[4]+board[8];
                    break;
                case 7:
                    line=board[2]+board[4]+board[6];
                    break;
            }
            if(line.equals("XXX")){
                return "X";
            }else if(line.equals("000")){
                return "0";
            }
        }
        for(int i=0;i<9;i++){
            if(Arrays.asList(board).contains(String.valueOf(i+1))){
                break;
            }else if (i==8){
                return "Draw";
            }
        }
        System.out.println(turn+"'s turn; enter a slot number to place "+turn+" in:");
        return null;
    }
    static void printBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        board =new String[9];
        turn="X";
        String Wninner=null;
        for(int i=0;i<9;i++){
            board[i]=String.valueOf(i+1);
        }
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
        System.out.println("X will play first. Enter a slot number to place X in:");
        while (Wninner==null){
            int numInput;
            try{
                numInput=sc.nextInt();
                if(!(numInput>0 && numInput<=9)){
                    System.out.println("Invalid Input; re-enter slot number:");
                    continue;
                }
                if (board[numInput-1].equals(String.valueOf(numInput))){
                    board[numInput - 1] = turn;
                    turn=turn.equals("X")?"0":"X";
                    printBoard();
                    Wninner=CheckWinner();
                }else{
                    System.out.println("Slot is already taken; re-enter Slot number");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input; re-enter slot number:");
                sc.nextLine();
            }
        }
        if(Wninner.equalsIgnoreCase("Draw")){
            System.out.println("It's draw! Thanks for playing.");
        }else {
            System.out.println("Congratulations! " + Wninner + "'s have won! Thanks for playing.");
        }
        sc.close();
    }

}
