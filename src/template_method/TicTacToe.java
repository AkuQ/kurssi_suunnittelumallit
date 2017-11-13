
package template_method;

import java.util.Scanner;

public class TicTacToe extends Game {
    private final Scanner scanner;
    private final char[] board;
    private int turn_count;
    
    public TicTacToe(){
        this.board = new char[9];
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    void initializeGame() {
        for(int i = 0; i < this.board.length; i++) {
            this.board[i] = ' ';
        }
        this.turn_count = 0;
        this.playersCount = 2;
    }

    @Override
    void makePlay(int player) {
        char p;
        switch (player) {
            case 0:
                p = 'X';
                break;
            case 1:
                p = 'O';
                break;
            default:
                System.out.println("This is a two player game!");
                return;
        }
        this.turn_count++;
        int placement = -1;
        while (placement < 0 || placement > 8) {
            System.out.println("Player " + p + ", select placement (0-8)");
            placement = this.scanner.nextInt();
            
            if(this.board[placement] != ' ') {
                System.out.println(placement + " already filled!");
                placement = -1;
            }
            else
                this.board[placement] = p;
        }
        
        System.out.println("Turn " + this.turn_count + ":");
        this.print();
    }

    @Override
    boolean endOfGame() {
        return this.getWinner() != ' ' || this.turn_count >= 9;
    }

    @Override
    void printWinner() {
        char winner = this.getWinner();
        switch (winner) {
            case  ' ':
                System.out.println("Draw");
                break;
            case 'X':
                System.out.println("Winner is X");
                break;
            default:
                System.out.println("Winner is O");
                break;
        }
    }
    
    private char getWinner(){
        char player;
        //Horizontals:
        for (int i = 0; i < 9; i +=3) {
            if(' ' != (player = this.board[i])) { 
                for (int j = i; j < i+3; j++) {
                    if(this.board[j] != player) {
                        player = ' ';
                        break;
                    }
                }
                if (player != ' ') {
                    return player;
                }
            }
        }
        
        //Vertical:
        for (int i = 0; i < 3; i++) {
            if(' ' != (player = this.board[i])) { 
                for (int j = i; j < 9; j+=3) {
                    if(this.board[j] != player) {
                        player = ' ';
                        break;
                    }
                }
                if (player != ' ') {
                    return player;
                }
            }
        }
        
        //Diagonals:
        player = this.board[4];
        if(player != ' ') {
            if(
                (player == this.board[0] && player == this.board[8]) 
                || 
                (player == this.board[2] && player == this.board[6])) 
            {
                System.out.println("D");
                return player;
            }
        }
        
        return ' ';
    }
    
    public void print() {
        String s = "" 
                + '|' + this.board[0] + '|' + this.board[1] + '|' + this.board[2] + "|\n"
                + '|' + this.board[3] + '|' + this.board[4] + '|' + this.board[5] + "|\n"
                + '|' + this.board[6] + '|' + this.board[7] + '|' + this.board[8] + "|";
        System.out.println(s);
    }
}
