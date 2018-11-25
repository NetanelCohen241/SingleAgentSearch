import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	private List<BlindSearchNode> openList;
	private List<BlindSearchNode> closeList;

	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState)
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
	    openList= new ArrayList<>();
	    closeList= new ArrayList<>();

	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
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
		openList.add((BlindSearchNode) node);
	}

	@Override
	public void addToClosed(ASearchNode node)
	{
        closeList.add((BlindSearchNode) node);
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
	    return openList.get(0);
	}

	

}
