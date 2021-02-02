public class Point {
	private int x;
	private int y;
	
	Point(){
		x = 0;
		y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	static void init(int[][] Board, Point p) {
		for(int[] i : Board) {
			for(int j : i) {
				j = 0;
			}
		}
		
	}//init
	
	static int sum(int[][] Board) {
		int total = 0;
		for(int[] i : Board) {
			for(int j : i) {
				total += j;
			}
		}
		return total;
	}//Board
	
	boolean North(int[][] board, Point p) {
		try {
				p.setY(p.getY()-1);
			if(board[p.getX()][p.getY()] == 0) {
				board[p.getX()][p.getY()] = 1;
			} else {
				board[p.getX()][p.getY()] *= 2;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}//North
	
	boolean South(int[][] board, Point p) {
		try {
				p.setY(p.getY()+1);
			if(board[p.getX()][p.getY()] == 0) {
				board[p.getX()][p.getY()] = 1;
			} else {
				board[p.getX()][p.getY()] *= 2;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}//South
	
	boolean East(int[][] board, Point p) {
		try {
				p.setX(p.getX()+1);
			if(board[p.getX()][p.getY()] == 0) {
				board[p.getX()][p.getY()] = 1;
			} else {
				board[p.getX()][p.getY()] *= 2;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}//West
	
	boolean West(int[][] board, Point p) {
		try {
				p.setX(p.getX()-1);
			if(board[p.getX()][p.getY()] == 0) {
				board[p.getX()][p.getY()] = 1;
			} else {
				board[p.getX()][p.getY()] *= 2;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}//East
	
}//Point
