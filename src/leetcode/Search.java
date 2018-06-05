package leetcode;

import java.awt.GraphicsDevice;
import java.util.LinkedList;
import java.util.Queue;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*广度遍历*/
	public int minPathLength(int[][] grids,int tr,int tc) {
		int [][] next = {{1,0},{-1,0},{0,1},{0,-1}};
		int m = grids.length,n = grids[0].length;
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(0, 0,1));
		while(!queue.isEmpty()) {
			Position pos = queue.poll();
			for(int i=0;i<4;i++) {
				Position nextPos = new Position(pos.r+next[i][0],
						pos.c+next[i][1], pos.length+1);
				if(nextPos.r<0||nextPos.r>m||nextPos.c<0||nextPos.c>n) continue;
				if(grids[nextPos.r][nextPos.c]!=1) continue;
				grids[nextPos.r][nextPos.c] = 0;
				if(nextPos.r == tr&&nextPos.c ==tc) return nextPos.length;
				queue.add(nextPos);
			}
		}
		return -1;
	}
	private class Position{
		int r,c,length;
		public Position(int r, int c, int length) {
			super();
			this.r = r;
			this.c = c;
			this.length = length;
		}
	}
	
	/*深度遍历*/
	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for(int i =0;i<grid.length;i++) {
			for(int j =0;j<grid[i].length;j++) {
				if(grid[i][j]==1) {
					max = Math.max(max, dfs(grid,i,j));
				}
			}
		}
		return max;
	}
	public int dfs(int[][] grid,int i,int j) {
		if(i<0||i>grid.length||j<0||j>grid[i].length||grid[i][j]==0) {
			return 0;
		}
		grid[i][j] = 0;
		return  dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
	}
}
