package grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Grid
{
    int gridWidth = 75, gridHeight = 75;
    float minGraphDensity = 0.95f;
    float maxGraphDensity = 0.8f;
    HashMap<String, Stick> sticks = new HashMap<>();
    //the key of a stick is composed of the unique nodeA - nodeB concatenation
    HashMap<String, Node> allNodes = new HashMap<>();
    //the key of a node is composed of the unique iIndex - jIndex concatenation
    HashMap<String,Node> availableNodes = new HashMap<>();
    int activePlayer = 1;

    void generateSticks()
    {
        Random rand = new Random();

        int maxSticks = (gridHeight - 1) * gridWidth + (gridWidth - 1) * gridHeight;

        int numberOfSticks = (int) (maxSticks * (rand.nextFloat() * (maxGraphDensity - minGraphDensity) + minGraphDensity) );

        for (int stickCounter = 0; stickCounter < numberOfSticks; stickCounter++)
        {
            int iA, jA, iB, jB;

            String potentialStickId;
            String invertedPotentialStickId;

            do
            {
                iA = rand.nextInt(gridHeight);
                jA = rand.nextInt(gridWidth);

                int isVertical = rand.nextInt(2);

                if (isVertical == 0)
                {
                    iB = iA;
                    jB = -1;

                    while (jB < 0 || jB >= gridWidth)
                    {
                        jB = jA + ( rand.nextInt(3)  - 1 );
                    }
                }
                else
                {
                    jB = jA;

                    iB = -1;

                    while (iB < 0 || iB >= gridWidth)
                    {
                        iB = iA + ( rand.nextInt(3)  - 1 );
                    }
                }


                potentialStickId = Stick.generatePotentialStickId(iA, jA, iB, jB);
                invertedPotentialStickId = Stick.generatePotentialStickId(iB, jB, iA, jA);
            } while ( sticks.containsKey( potentialStickId ) || sticks.containsKey( invertedPotentialStickId ) || !Stick.nodesAreDifferent(iA, jA, iB, jB) );

            Stick newStick = new Stick(iA, jA, iB, jB);

            sticks.put(newStick.getStickIdentifier(), newStick);
        }
    }

    void generateNodes()
    {
        for (String key: sticks.keySet())
        {
            Stick stick = sticks.get(key);

            Node nodeA = stick.getNodeA();

            Node nodeB = stick.getNodeB();

            if (!allNodes.containsKey(nodeA.getNodeIdentifier()))
            {
                allNodes.put(nodeA.getNodeIdentifier(), nodeA);
                availableNodes.put(nodeA.getNodeIdentifier(), nodeA);
            }
            else
                nodeA = allNodes.get(nodeA.getNodeIdentifier());

            if (!allNodes.containsKey(nodeB.getNodeIdentifier()))
            {
                allNodes.put(nodeB.getNodeIdentifier(), nodeB);
                availableNodes.put(nodeB.getNodeIdentifier(), nodeB);
            }
            else
                nodeB = allNodes.get(nodeB.getNodeIdentifier());

            nodeA.addAdjacency(nodeB);
            nodeA.addAdjacency(nodeA);
        }
    }

    public void runGame()
    {
        generateSticks();
        generateNodes();

        for (String key : sticks.keySet())
            System.out.println( sticks.get(key) );

        System.out.println("Number of sticks: " + sticks.size());

        while (availableNodes.size() != 0)
        {
            String activePlayerName = "Player 1";

            if (activePlayer != 1)
                activePlayerName = "Player 2";

            System.out.println("\n" + activePlayerName + " please input a move (I, J)" );

            System.out.println("\nAvailable positions are: \n");

            for ( String key : availableNodes.keySet() )
                System.out.print( "[" + availableNodes.get(key).getNodeIdentifier() + "], ");

            System.out.print("\n");

            int playerInputI, playerInputJ;

            String nodeIdentifier;

            while (true)
            {
                Scanner inputScanner = new Scanner(System.in);

                playerInputI = inputScanner.nextInt();

                playerInputJ = inputScanner.nextInt();

                nodeIdentifier = Node.generatePotentialNodeId(playerInputI, playerInputJ);

                if ( availableNodes.containsKey(nodeIdentifier) )
                {
                    System.out.println("Input was valid! Making the move..");
                    break;
                }

                System.out.println("INVALID INPUT!");
            }

            allNodes.get(nodeIdentifier).setOwner( activePlayer );

            availableNodes = allNodes.get(nodeIdentifier).getAvailableNodes();

            activePlayer *= -1;
        }

        activePlayer *= -1;

        String activePlayerName = "Player 1";

        if (activePlayer != 1)
            activePlayerName = "Player 2";

        System.out.println("The game has ended!");
        System.out.println( activePlayerName +  " has won!" );
    }
}
