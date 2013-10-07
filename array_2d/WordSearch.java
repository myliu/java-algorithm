package array_2d;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = new char[][]{{'a', 'b'}, {'b', 'c'}};
		String s = "aba";
		if (ws.exist(board, s))
			System.out.println("True");
		else
			System.out.println("False");
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
    	if (word.equals(""))
    		return true;
    	
    	if (board[m][n] != word.charAt(0))
    		return false;
    	
    	String w = word.substring(1);
    	
    	if (m - 1 >= 0) {
    		if (exist(board, w, m - 1, n))
    			return true;
    	}
    	
    	if (m + 1 <= board.length - 1) {
    		if (exist(board, w, m + 1, n))
    			return true;
    	}
    	
    	if (n - 1 >= 0) {
    		if (exist(board, w, m, n - 1))
    			return true;
    	}
    	
    	if (n + 1 <= board[0].length - 1) {
    		if (exist(board, w, m, n + 1))
    			return true;
    	}
    		
    	return false;
    }

}
