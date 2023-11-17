package APCSUnit8;
import java.util.*;
public class APCS8A {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = 1;
        String currentPlayer = " X ";
        String[][] grid = new String[3][3];
            for(int i=0; i<grid.length; i++) {
                for(int q=0; q<grid[i].length; q++) {
                    grid[i][q] = "[ ]";
                }
            }

        while(true) {
            System.out.println("Round: "+round);
            System.out.println("Make your move(row,column)");
            print(grid);
            String input = sc.nextLine();
            int row = Integer.parseInt(input.substring(0,1));
            int column = Integer.parseInt(input.substring(2,3));
            if(moveCheck(row, column, grid)) {
                if(round%2==0) {
                    currentPlayer = " X ";
                    grid[row][column] = " X ";
                } else {
                    currentPlayer = " O ";
                    grid[row][column] = " O ";
                }
                if(gameCheck(grid, round)) {
                    print(grid);
                    System.out.println("Gameover");
                    if(currentPlayer.equals(" X ")) System.out.println("X wins");
                    else System.out.println("O wins");
                    break;
                }
                if(fullBoard(grid)) {
                    print(grid);
                    System.out.println("It's a draw!");
                    break;
                }
                round++;
            } else {
                System.out.println("Invalid move, try again");
            }
        }
        sc.close();
    }
    public static void print(String[][] x) {
        for(int i=0; i<x.length; i++) {
            for(int q=0; q<x[0].length; q++) {
                System.out.print(x[i][q]);
            }
            System.out.println();
        }
    }

    public static boolean moveCheck(int row, int column, String[][] x) {
        return row >= 0 && row < 3 && column >= 0 && column < 3 && x[row][column].equals("[ ]");
    }
    
    public static boolean gameCheck(String[][] x, int round) {
        if(round%2==0) {
            for(int i=0; i<x.length; i++) {
                if(x[i][0] == " X ") {
                    if(x[i][0].equals(x[i][1]) && x[i][1].equals(x[i][2])) {
                        return true;
                    }
                } else if(x[0][i] == " X ") {
                    if(x[0][i].equals(x[1][i]) && x[1][i].equals(x[2][i])) {
                        return true;
                    }
                } else if(x[1][1].equals(" X ")) {
                    if(x[0][0].equals(" X ")&& x[2][2].equals(" X ")) {
                        return true;
                    } else if(x[0][2].equals(" X ") && x[2][0].equals(" X ")) {
                        return true;
                    }
                }
            }
        } else {
            for(int i=0; i<x.length; i++) {
                if(x[i][0] == " O ") {
                    if(x[i][0].equals(x[i][1]) && x[i][1].equals(x[i][2])) {
                        return true;
                    }
                } else if(x[0][i] == " O ") {
                    if(x[0][i].equals(x[1][i]) && x[1][i].equals(x[2][i])) {
                        return true;
                    }
                } else if(x[1][1].equals(" O ")) {
                    if(x[0][0].equals(" O ")&& x[2][2].equals(" O ")) {
                        return true;
                    } else if(x[0][2].equals(" O ") && x[2][0].equals(" O ")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean fullBoard(String[][] x) {
        for(int i=0; i<x.length; i++) {
            for(int q=0; q<x[i].length; q++) {
                if(x[i][q].equals("[ ]")) return false;
            }
        }
        return true;
    }
}


