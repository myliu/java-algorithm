package array_2d;

public class WordSearch_DP {
	
	int[][][] map;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordSearch_DP ws = new WordSearch_DP();
		
		char[][] board = new char[][]{"ab".toCharArray(), "bc".toCharArray()};
		String s = "aba";		
		if (ws.exist(board, s))
			System.out.println("True");
		else
			System.out.println("False");
		
		ws.printMap(ws.map);
	}
	
    public boolean exist(char[][] board, String word) {
    	map = new int[board.length][board[0].length][word.length() + 1];
    	
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (exist(board, word, i, j))
        			return true;
        	}
        }
        return false;
    }
    
    private boolean exist(char[][] board, String word, int m, int n) {
    	if (word.equals("")) 
    		return true;
    	
    	if (map[m][n][word.length()] == 1)
    		return true;
    	
    	if (map[m][n][word.length()] == 2)
    		return false;
    	
    	
    	if (board[m][n] != word.charAt(0)) {
    		map[m][n][word.length()] = 2;
    		return false;
    	}
    	
    	String w = word.substring(1);
    	
    	if (m - 1 >= 0) {
    		if (exist(board, w, m - 1, n)) {
    			map[m][n][word.length()] = 1;
    			return true;
    		}
    	}
    	
    	if (m + 1 <= board.length - 1) {
    		if (exist(board, w, m + 1, n)) {
    			map[m][n][word.length()] = 1;
    			return true;
    		}
    	}
    	
    	if (n - 1 >= 0) {
    		if (exist(board, w, m, n - 1)) {
    			map[m][n][word.length()] = 1;
    			return true;
    		}
    	}
    	
    	if (n + 1 <= board[0].length - 1) {
    		if (exist(board, w, m, n + 1)) {
    			map[m][n][word.length()] = 1;
    			return true;
    		}
    	}
    	
    	map[m][n][word.length()] = 2;
    	return false;
    }
    
    private void printMap(int[][][] map) {
    	for (int i = 0; i < map.length; i++) {
    		for (int j = 0; j < map[0].length; j++) {
    			for (int k = 0; k < map[0][0].length; k++) {
    				System.out.print(map[i][j][k]);
    			}
    		}
    	}
    }

}
