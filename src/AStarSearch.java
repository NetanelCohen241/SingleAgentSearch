import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearch   extends ASearch
{
	// Define lists here ...
	private Queue<HeuristicSearchNode> openList;
	private List<HeuristicSearchNode> closeList;
	@Override
	public String getSolverName() 
	{
		return "AStar";
	}
	
	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{	
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists()
	{
		openList= new PriorityQueue<HeuristicSearchNode>((o1, o2) -> (int)(o1.getF()-o2.getF()));
		closeList= new ArrayList<>();

	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{

		if(isOpen(node))
			return node;
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		return openList.contains(node);
	}

	@Override
	public boolean isClosed(ASearchNode node)
	{
		return closeList.contains(node);
	}

	@Override
	public void addToOpen(ASearchNode node)
	{
		openList.add((HeuristicSearchNode) node);
	}

	@Override
	public void addToClosed(ASearchNode node)
	{
		closeList.add((HeuristicSearchNode) node);
//		openList.remove(node);
	}

	@Override
	public int openSize()
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest(){

		return openList.poll();
	}

}
