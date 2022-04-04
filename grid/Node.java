package grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Node
{
    int iIndex, jIndex;
    int owner = 0;
    HashMap<String,Node> adjacentNodes = new HashMap<>();

    public Node (int iIndex, int jIndex)
    {
        this.iIndex = iIndex;
        this.jIndex = jIndex;
    }

    public static String generatePotentialNodeId(int targetI, int targetJ)
    {
        String id = targetI + " - " + targetJ;
        return id;
    }

    public String getNodeIdentifier()
    {
        String id = iIndex + " - " + jIndex;
        return id;
    }

    public void addAdjacency(Node newNode)
    {
        if (adjacentNodes.containsKey( newNode.getNodeIdentifier()))
            return;

        adjacentNodes.put( newNode.getNodeIdentifier(), newNode );
    }

    public void setOwner(int playerIndex)
    {
        owner = playerIndex;
    }

    public HashMap<String, Node> getAvailableNodes()
    {
        HashMap<String, Node> available = new HashMap<>();

        for (String key : adjacentNodes.keySet())
        {
            if ( adjacentNodes.get(key).owner == 0 )
                available.put( key, adjacentNodes.get(key) );
        }

        return available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return iIndex == node.iIndex && jIndex == node.jIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNodeIdentifier());
    }
}
