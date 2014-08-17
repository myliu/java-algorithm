package array_2d;

public class WordSearch_DP1 {
	int[][][] map;
	boolean[][] visited;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordSearch_DP1 ws = new WordSearch_DP1();
		ws.run();
	}
	
	void run() {
		char[][] board = new char[][]{"ABCE".toCharArray(), "FSCS".toCharArray(), "ADEE".toCharArray()};
//		String word = "ABCCED";
//		String word = "SEE";
		String word = "ABCB";
		printBoard(board);
		map = new int[board.length][board[0].length][word.length()+1];
		visited = new boolean[board.length][board[0].length];
		if (exist(board, word))
			System.out.println("Exist");
		else
			System.out.println("Not Exist");
	}
	
    public boolean exist(char[][] board, String word) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (exist(board, word, i, j))
    				return true;
    		}
    	}
    	return false;
    }
    
    private boolean exist(char[][] board, String word, int m, int n) {
    	visited[m][n] = true;
    	
    	if (word.length() == 0)
    		return true;
    	if (map[m][n][word.length()] == 1)
    		return true;
    	if (map[m][n][word.length()] == 2) {
    		visited[m][n] = false;
    		return false;
    	}
    	
    	if (word.charAt(0) != board[m][n]) {
    		visited[m][n] = false;
    		return false;
    	}
    	String next = word.substring(1);
    	if (m-1 >= 0 && !visited[m-1][n] && exist(board, next, m-1, n)) {
    		map[m][n][word.length()] = 1;
    		return true;
    	}
    	if (m+1 <= board.length-1 && !visited[m+1][n] && exist(board, next, m+1, n)) {
    		map[m][n][word.length()] = 1;
    		return true;
    	}
    	if (n-1 >= 0 && !visited[m][n-1] && exist(board, next, m, n-1)) {
    		map[m][n][word.length()] = 1;
    		return true;
    	}
    	if (n+1 <= board[0].length-1 && !visited[m][n+1] && exist(board, next, m, n+1)) {
    		map[m][n][word.length()] = 1;
    		return true;
    	}
		map[m][n][word.length()] = 2;
		visited[m][n] = false;
    	return false;
    }
    
    private void printBoard(char[][] board) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (j != board[0].length - 1)
    				System.out.print(board[i][j] + " ");
    			else
    				System.out.print(board[i][j] + "\n");
    		}
    	}
    }


}
