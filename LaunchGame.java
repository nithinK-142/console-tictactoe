import java.util.Random;
import java.util.Scanner;

class TicTacToe{
    static char[][] board;
    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }
    void initBoard(){
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                board[i][j] = ' ';
    }
    static void dispBoard(){
        System.out.println(" -------------");
        for(int i = 0; i < board.length; i++) {
            System.out.print(" | ");
            for(int j = 0; j < board[i].length; j++) 
                System.out.print(board[i][j] +" | ");
            System.out.println();
            System.out.println(" -------------");
        }
    }
    static void placeMark(int row, int col, char mark){
        if(row >=0 && row <= 2 && col  >= 0 && col <= 2)
            board[row][col] = mark;
        else
            System.out.println("Invalid Input");
    }
    static boolean checkColWin(){
        for(int j=0; j <=2; j++)
            if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j])
                return true;
        return false;
    }
    static boolean checkRowWin(){
        for(int i=0; i <=2; i++)
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return true;
        return false;
    }
    static boolean checkDiagWin(){
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] != ' ' &&  board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;
        return false;
    }
    static boolean checkDraw(){
        for(int i=0; i <=2; i++)
            for(int j=0; j <=2; j++)
                if(board[i][j] == ' ')
                    return false;
        return true;
    }
}

abstract class Player{
    String name;
    char mark;

    boolean isVlaidMove(int row, int col){
        if(row >=0 && row <= 2 && col  >= 0 && col <= 2)
            if(TicTacToe.board[row][col] == ' ' )
                return true;
            System.out.println("Already Placed...");
        return false;
    }
    abstract void makeMove();
}
class HumanPlayer extends Player{
    HumanPlayer(String name, char mark){
        this.name = name;
        this.mark = mark;
    }
    void makeMove(){
        Scanner scan = new Scanner(System.in);
        int row,col;
        do{
            System.out.print("Enter row and col : ");
            row = scan.nextInt();
            col = scan.nextInt();
            
        }while(!isVlaidMove(row, col));
        TicTacToe.placeMark(row,col,mark);
    }
}
class AIPlayer extends Player{
    public AIPlayer(String name, char mark){
        this.name = name;
        this.mark = mark;
    }
    void makeMove(){
        int row,col;
        do{
            Random r = new Random();
            row = r.nextInt(3);
            col = r.nextInt(3);
        }while(!isVlaidMove(row, col));
        TicTacToe.placeMark(row, col, mark);  
    }
}

public class LaunchGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose from these...\n1.P V AI\n2.P V P");
        int choice = scan.nextInt();
        TicTacToe toe = new TicTacToe();

        switch(choice) {
            case 1: HumanPlayer hp = new HumanPlayer("HumanPlayer", 'X');
                    AIPlayer ai = new AIPlayer("AIPlayer", 'O');
                    Player cp1 = hp;
    
                    while(true){
                    System.out.println(cp1.name + "'s turn...");
                    cp1.makeMove();
                    TicTacToe.dispBoard();
    
                    if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()){
                        System.out.println(cp1.name +" wins!");
                        break; 
                    }
                    else if(TicTacToe.checkDraw()){
                         System.out.println("Its a draw!");
                         break;
                    }
                    else
                        if(cp1 == hp)
                            cp1 = ai;
                        else
                            cp1 = hp;
                    }

            case 2: HumanPlayer p1 = new HumanPlayer("Player 1", 'X');
                    HumanPlayer p2 = new HumanPlayer("Player 2", 'O');
    
                    HumanPlayer cp2 = p1;
                    while(true){
                    System.out.println(cp2.name + "'s turn...");
                    cp2.makeMove();
                    TicTacToe.dispBoard();
    
                    if(TicTacToe.checkColWin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()){
                        System.out.println(cp2.name +" wins!");
                        break; 
                    }
                    else if(TicTacToe.checkDraw()){
                         System.out.println("Its a draw!");
                         break;
                    }
                    else
                        if(cp2 == p1)
                            cp2 = p2;
                        else
                            cp2 = p1;

                    }

            default : System.out.println("Invalid Choice");
        }
    }
}
