
class MazeMap{
	public char[][] curr_map;
	
	MazeMap(int x, int y){
		curr_map = new char[x][y];
	}
	public void initializeMap(String line, int line_times){
	    for(int i = 0; i < 10; i++){
	     	curr_map[line_times][i] = line.charAt(i);
	    }
	}

	public void printMap(){
		for (int c = 0; c < 10 ;c++ ) {
			for (int r = 0; r < 10 ;r++ ) {
				System.out.print(curr_map[c][r]);
			}
			System.out.println();
		}
	}


}