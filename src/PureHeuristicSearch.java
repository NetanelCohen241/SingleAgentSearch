import java.util.ArrayList;
import java.util.List;

public class PureHeuristicSearch  extends ASearch
{
	// Define lists here ...
	private List<HeuristicSearchNode> openList;
	private List<HeuristicSearchNode> closeList;
	@Override
	public String getSolverName() 
	{
		return "PHS";
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
		openList= new ArrayList<>();
		closeList= new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		ASearchNode ans;
		for (BlindSearchNode openNode : openList) {
			ans = openNode;
			if (ans.equals(node))
				return ans;
		}
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
		openList.remove(node);
	}

	@Override
	public int openSize()
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest()
	{
		ASearchNode min=openList.get(0);
		for (int i = 1; i <openList.size() ; i++) {
			if(min.getH()>openList.get(i).getH())
				min=openList.get(i);

		}
		return min;
	}

}