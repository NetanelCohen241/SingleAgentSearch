import java.util.*;

public class AStarSearch   extends ASearch
{
	// Define lists here ...
	private Queue<HeuristicSearchNode> openList;
	private Dictionary<String,ASearchNode> closeList;
	@Override
	public String getSolverName()
	{
		return "AStar";
	}

	@Override
	public ASearchNode createSearchRoot(IProblemState problemState)
	{
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists()
	{
		openList= new PriorityQueue<HeuristicSearchNode>((o1, o2) -> (int)(o1.getF()-o2.getF()));
		closeList= new Hashtable<>();

	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
        for (HeuristicSearchNode s:openList) {
            if(s.equals(node))
                return node;

        }
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
        for (HeuristicSearchNode s:openList) {
            if(s.equals(node))
                return true;

        }
        return false;
	}

	@Override
	public boolean isClosed(ASearchNode node)
	{
	    String an=node._currentProblemState.toString();
	    ASearchNode a= closeList.get(an);
	    if(a==null)
	        return false;
	    return true;
//        for (HeuristicSearchNode s:closeList) {
//            if(s.equals(node))
//                return true;
//
//        }
//        return false;
	}

	@Override
	public void addToOpen(ASearchNode node)
	{
		openList.add((HeuristicSearchNode) node);
	}

	@Override
	public void addToClosed(ASearchNode node)
	{
//		closeList.add((HeuristicSearchNode) node);
       String a=node._currentProblemState.toString();
	   closeList.put(a,node);
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
