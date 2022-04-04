package grid;

public class Stick
{
    Node nodeA, nodeB;

    public Stick (int iA, int jA, int iB, int jB)
    {
        nodeA = new Node(iA, jA);
        nodeB = new Node(iB, jB);
    }

    public Node getNodeA() {
        return nodeA;
    }

    public Node getNodeB() {
        return nodeB;
    }

    public static boolean nodesAreDifferent(int iA, int jA, int iB, int jB)
    {
        if (iA == iB && jA == jB )
            return false;

        return true;
    }

    public static String generatePotentialStickId(int iA, int jA, int iB, int jB)
    {
        String id = "[("+ Node.generatePotentialNodeId(iA, jA) +"),(" + Node.generatePotentialNodeId(iB, jB) + ")]";
        return id;
    }

    public String getStickIdentifier()
    {
        String id = "[("+ nodeA.getNodeIdentifier() +"),(" + nodeB.getNodeIdentifier() + ")]";
        return id;
    }

    @Override
    public String toString()
    {
        return "Stick -> " + getStickIdentifier();
    }
}
