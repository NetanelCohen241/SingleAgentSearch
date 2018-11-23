import java.util.List;

public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		List<IProblemState> states=problemState.getNeighborStates();

		return 0;

	}
	
}
