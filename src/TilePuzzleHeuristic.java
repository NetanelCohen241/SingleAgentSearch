import java.util.List;

public class TilePuzzleHeuristic implements IHeuristic
{

	private double manhattanDistance;

	public TilePuzzleHeuristic() {
		this.manhattanDistance = 0;
	}

	@Override
	public double getHeuristic(IProblemState problemState)
	{

		TilePuzzleState tilePuzzleState=null;
		if(problemState instanceof TilePuzzleState)
			tilePuzzleState=(TilePuzzleState) problemState;
		int row,col;
		int[][] tp=tilePuzzleState._tilePuzzle;
		for (int i = 0; i < tp.length ; i++) {
			for (int j = 0; j < tp.length; j++) {

				row=tp[i][j]/tp.length;
				col=tp[i][j]%tp.length;
				manhattanDistance+=tp[i][j]*(Math.abs(i-row)+Math.abs(j-col));
			}

		}

		return manhattanDistance;

	}
	
}
