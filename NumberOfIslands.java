/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] visited = new int[rows][cols];
        Queue<Coordinate> q = new LinkedList<Coordinate>();
        int islands = 0;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(visited[i][j] == 0) {
                    visited[i][j]++;
                    
                    if(grid[i][j] == '1') {
                        q.offer(new Coordinate(i, j));
                        
                        while(q.peek() != null) {
                            Coordinate curr = q.poll();
                    
                            if(curr.i+1 < rows && visited[curr.i+1][curr.j] == 0){
                                if(grid[curr.i+1][curr.j] == '1') {
                                    q.offer(new Coordinate(curr.i+1, curr.j));
                                } 
                                visited[curr.i+1][curr.j]++;
                            }
                    
                            if(curr.j+1 < cols && visited[curr.i][curr.j+1] == 0) {
                                if(grid[curr.i][curr.j+1] == '1') {
                                    q.offer(new Coordinate(curr.i, curr.j+1));
                                }
                                visited[curr.i][curr.j+1]++;
                            }
                            
                            if(curr.i > 0 && visited[curr.i-1][curr.j] == 0){
                                if(grid[curr.i-1][curr.j] == '1') {
                                    q.offer(new Coordinate(curr.i-1, curr.j));
                                } 
                                visited[curr.i-1][curr.j]++;
                            }
                    
                            if(curr.j > 0 && visited[curr.i][curr.j-1] == 0) {
                                if(grid[curr.i][curr.j-1] == '1') {
                                    q.offer(new Coordinate(curr.i, curr.j-1));
                                }
                                visited[curr.i][curr.j-1]++;
                            }
                    
                        }
                        
                        islands++;
                    }
                }
            }
        }
        
        return islands;
    }
}

class Coordinate {
    int i;
    int j;
    
    public Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
