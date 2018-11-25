import java.util.List;

public class TilePuzzleHeuristic implements IHeuristic
{

	/*
	private double manhattanDistance;

	public TilePuzzleHeuristic() {
		this.manhattanDistance = 0;
	}
*/


    @Override
    public double getHeuristic(IProblemState problemState)
    {
        int manhattanDistance = 0;
        int sizeOfTable = 0;
        if(problemState instanceof TilePuzzleState)
            sizeOfTable = ((TilePuzzleState)problemState)._tilePuzzle.length;
        else
            return 0;
        int row,col;
        for (int i = 0; i < sizeOfTable ; i++) {
            for (int j = 0; j < sizeOfTable; j++) {
                int currTile = ((TilePuzzleState)problemState)._tilePuzzle[i][j];
                if(currTile != 0) {
                    row = currTile / sizeOfTable;
                    col = currTile % sizeOfTable;
                    col = col - 1;
                    if (col == -1){
                        col = sizeOfTable - 1;
                        row = row - 1;
                    }


                    manhattanDistance += currTile * (Math.abs(i - row) + Math.abs(j - col));
                }
            }
        }

        return manhattanDistance;

    }

}
