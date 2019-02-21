import java.util.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Search {


    public int breadFirstSearch(Grid startOfTHePuzzle, Grid goalOfThePuzzle){

        int numberOfnodesExpanded = 0;
        Grid nodeToExplore = startOfTHePuzzle;
        Queue<Grid> remainingGrids = new LinkedList<Grid>();

        remainingGrids.add(nodeToExplore);
        nodeToExplore.setDepth(0);
        int max = 0;

        while(!remainingGrids.isEmpty()){

            nodeToExplore = remainingGrids.poll();
            numberOfnodesExpanded++;



            if(remainingGrids.size() > max)
                max = remainingGrids.size();

              System.out.println();
              System.out.println("Number of nodes in the data structure : "  + remainingGrids.size());
              System.out.println("Number of nodes checked: " + numberOfnodesExpanded);
              System.out.println("Depth of : " + nodeToExplore.getDepth());
              System.out.println("******************************");
              System.out.println("Popped grid");
              nodeToExplore.showGrid();

            if(nodeToExplore.checkGoal(goalOfThePuzzle)){
                System.out.println("I have found a solution!");
                nodeToExplore.showGrid();
                return numberOfnodesExpanded;

            }

            if(nodeToExplore.getAgentPositon().getX() > 0){
                Grid moveLeft = moveLeft(nodeToExplore);
                moveLeft.setDepth( nodeToExplore.getDepth() + 1);
                remainingGrids.add(moveLeft);
            }

            if(nodeToExplore.getAgentPositon().getX() < nodeToExplore.getSize()-1){
                Grid moveRight = moveRight(nodeToExplore);
                moveRight.setDepth( nodeToExplore.getDepth() + 1);
                remainingGrids.add(moveRight);
            }

            if(nodeToExplore.getAgentPositon().getY() < nodeToExplore.getSize()-1){
                Grid moveDown = moveDown(nodeToExplore);
                moveDown.setDepth( nodeToExplore.getDepth() + 1);
                remainingGrids.add(moveDown);
            }

            if(nodeToExplore.getAgentPositon().getY() > 0 ){
                Grid moveUP = moveUp(nodeToExplore);
                moveUP.setDepth( nodeToExplore.getDepth() + 1);
                remainingGrids.add(moveUP);
            }

        }

        return  numberOfnodesExpanded;
    }

    public int depthFirstSearch( Grid startOfThePuzzle, Grid goalOfThePuzzle){

        Grid nodeToExplore = startOfThePuzzle;
        int numberOfNodesExpanded = 0;
        boolean aChildHasBeenProduced ;
        Stack<Grid> remainingGrids = new Stack<Grid>();
        Random random = new Random();
        int max = 0;

        remainingGrids.add(nodeToExplore);
        nodeToExplore.setDepth(0);

        while(!remainingGrids.empty()){

            aChildHasBeenProduced = false;
            if(remainingGrids.size() > max)
                max = remainingGrids.size();
            nodeToExplore = remainingGrids.pop();
            numberOfNodesExpanded++;


          //  System.out.println("Number of nodes in the data structure : "  + max);
            System.out.println();
            System.out.println("Number of nodes checked: " + numberOfNodesExpanded);
            System.out.println("Depth of : " + nodeToExplore.getDepth());
               System.out.println("******************************");
               System.out.println("Popped grid");
               nodeToExplore.showGrid();

            if(nodeToExplore.checkGoal(goalOfThePuzzle)) {
               System.out.println("Found a soloution");
               System.out.println("The final grid is the following: ");
                nodeToExplore.showGrid();
                return numberOfNodesExpanded;

            }

            while(!aChildHasBeenProduced){

                int move = random.nextInt(4);

                switch (move){

                    case 0 :
                        if(nodeToExplore.getAgentPositon().getX() > 0){


                           if(nodeToExplore.getAgentPositon().getX() < nodeToExplore.getSize()-1)
                                remainingGrids.add(moveRight(nodeToExplore));
                            if(nodeToExplore.getAgentPositon().getY() < nodeToExplore.getSize()-1)
                                remainingGrids.add(moveDown(nodeToExplore));
                            if(nodeToExplore.getAgentPositon().getY() > 0 )
                                remainingGrids.add(moveUp(nodeToExplore));


                            Grid moveLeft = moveLeft(nodeToExplore);
                            moveLeft.setDepth( nodeToExplore.getDepth() + 1);
                            remainingGrids.add(moveLeft);
                            aChildHasBeenProduced = true;
                        }
                        break;
                    case 1 :
                        if(nodeToExplore.getAgentPositon().getX() < nodeToExplore.getSize()-1){


                            if(nodeToExplore.getAgentPositon().getX() > 0)
                                remainingGrids.add(moveLeft(nodeToExplore));
                            if(nodeToExplore.getAgentPositon().getY() < nodeToExplore.getSize()-1)
                                remainingGrids.add(moveDown(nodeToExplore));
                            if(nodeToExplore.getAgentPositon().getY() > 0 )
                                remainingGrids.add(moveUp(nodeToExplore));


                            Grid moveRight = moveRight(nodeToExplore);
                            moveRight.setDepth( nodeToExplore.getDepth() + 1);
                            remainingGrids.add(moveRight);
                            aChildHasBeenProduced = true;
                        }
                        break;
                    case 2 :
                        if(nodeToExplore.getAgentPositon().getY() < nodeToExplore.getSize()-1){


                            if(nodeToExplore.getAgentPositon().getX() > 0)
                                remainingGrids.add(moveLeft(nodeToExplore));
                            if(nodeToExplore.getAgentPositon().getX() < nodeToExplore.getSize()-1)
                                remainingGrids.add(moveRight(nodeToExplore));
                            if(nodeToExplore.getAgentPositon().getY() > 0 )
                                remainingGrids.add(moveUp(nodeToExplore));

                            Grid moveDown = moveDown(nodeToExplore);
                            moveDown.setDepth( nodeToExplore.getDepth() + 1);
                            remainingGrids.add(moveDown);
                            aChildHasBeenProduced = true;
                        }
                        break;
                    case 3 :
                        if(nodeToExplore.getAgentPositon().getY() > 0 ){


                            if(nodeToExplore.getAgentPositon().getX() > 0)
                                remainingGrids.add(moveLeft(nodeToExplore));
                            if(nodeToExplore.getAgentPositon().getX() < nodeToExplore.getSize()-1)
                                remainingGrids.add(moveRight(nodeToExplore));
                            if(nodeToExplore.getAgentPositon().getY() < nodeToExplore.getSize()-1)
                                remainingGrids.add(moveDown(nodeToExplore));

                            Grid moveUP = moveUp(nodeToExplore);
                            moveUP.setDepth( nodeToExplore.getDepth() + 1);
                            remainingGrids.add(moveUP);
                            aChildHasBeenProduced = true;
                        }
                        break;
                }

            }

        }

        return numberOfNodesExpanded;
    }

    private int nodesSearchedByIterativeDeepening = 0;
    private int depthOfIterativeDeepening = 0;

    public int iterativeDeepening(Grid startOfThePuzzle, Grid endOfThePuzzle){

        int depth = 1;
        depthOfIterativeDeepening = 1;
        nodesSearchedByIterativeDeepening = 0;
        boolean solutionFound = false;

        while(!solutionFound){

            Grid puzzle = new Grid(startOfThePuzzle.getSize());
            puzzle.setPuzzleGrid(startOfThePuzzle.getPuzzleGrid());
            puzzle.setAgentPosition(startOfThePuzzle.getAgentPositon());

            solutionFound = depthLimitedSearch(puzzle, endOfThePuzzle , depth);
            depth++;
            depthOfIterativeDeepening++;
        }

        return  nodesSearchedByIterativeDeepening;
    }

    public boolean depthLimitedSearch(Grid nodeToExplore, Grid endOfThePuzzle, int depth){

        boolean foundSoulution = false;

        nodesSearchedByIterativeDeepening++;

        System.out.println("***************************");
        System.out.println("Number of nodes checked : " + nodesSearchedByIterativeDeepening);
        System.out.println("Limited Depth of: " + depthOfIterativeDeepening);
         nodeToExplore.showGrid();

        if(nodeToExplore.checkGoal(endOfThePuzzle)){
            return true;
        }

        if(depth <=0 ) {
            return false;
        }

        boolean foundSolution = false;


        if( nodeToExplore.getAgentPositon().getX() > 0 ){

            foundSolution = depthLimitedSearch(moveLeft(nodeToExplore) ,endOfThePuzzle, depth - 1);
            if(foundSolution)
                return true;
        }
        if( nodeToExplore.getAgentPositon().getX() < nodeToExplore.getSize() - 1 ){

            foundSolution = depthLimitedSearch(moveRight(nodeToExplore ), endOfThePuzzle, depth - 1);
            if(foundSolution)
                return true;
        }
        if( nodeToExplore.getAgentPositon().getY() < nodeToExplore.getSize() - 1 ){

            foundSolution = depthLimitedSearch(moveDown(nodeToExplore), endOfThePuzzle, depth - 1);
            if(foundSolution)
                return true;
        }
        if( nodeToExplore.getAgentPositon().getY() > 0){


            foundSolution = depthLimitedSearch(moveUp(nodeToExplore), endOfThePuzzle, depth - 1);
            if(foundSolution)
                return true;
        }
        return false;
    }


    public int aStar(Grid startOfThePuzzle, Grid goalOfThePuzzle){

        int numberOfNodesExpanded = 0;
        Grid nodeToExplore = startOfThePuzzle;
        PriorityQueue<Grid> remainingGrids = new PriorityQueue<Grid>();
        int max = 0;

        calculateHeuristic( nodeToExplore, goalOfThePuzzle, -1);

        nodeToExplore.setDepth(0);
        remainingGrids.add(nodeToExplore);

        while (!remainingGrids.isEmpty()){

            nodeToExplore = remainingGrids.poll();
            numberOfNodesExpanded++;

             System.out.println("***************************");
             System.out.println("The function f has the value : " + nodeToExplore.getHeuristic());
             System.out.println("The function g has the value : " + nodeToExplore.getDistanceFromRoot());
            System.out.println("The function h has the value : " + nodeToExplore.getDistanceToGoal());
            System.out.println("Number of nodes checked : " + numberOfNodesExpanded);
            System.out.println("Depth of : " + nodeToExplore.getDepth());
            System.out.println("Popped node");
            nodeToExplore.showGrid();

            if(remainingGrids.size() > max)
                max = remainingGrids.size();

            if(nodeToExplore.checkGoal( goalOfThePuzzle)){
                  System.out.println("Found a soloution");
                 System.out.println("The final grid is the following: ");
                nodeToExplore.showGrid();
                return numberOfNodesExpanded;
            }

            int xq = nodeToExplore.getAgentPositon().getX();
            int yq = nodeToExplore.getAgentPositon().getY();
            if( nodeToExplore.getAgentPositon().getX() > 0 &&
                    nodeToExplore.getTile( new TilePosition(xq - 1, yq) ) != '*' ){

                Grid moveLeft = moveLeft(nodeToExplore);
                calculateHeuristic(moveLeft, goalOfThePuzzle, nodeToExplore.getDistanceFromRoot());
                moveLeft.setDepth( nodeToExplore.getDepth() + 1);
                remainingGrids.add(moveLeft);

                System.out.println("Enqueued  node");
                moveLeft.showGrid();

            }
            if( nodeToExplore.getAgentPositon().getX() < nodeToExplore.getSize() - 1 &&
                    nodeToExplore.getTile( new TilePosition(xq + 1, yq) ) != '*'){

                Grid moveRight = moveRight(nodeToExplore);
                calculateHeuristic(moveRight, goalOfThePuzzle, nodeToExplore.getDistanceFromRoot());
                moveRight.setDepth( nodeToExplore.getDepth() + 1);
                remainingGrids.add(moveRight);

                 System.out.println("Enqueued  node");
                moveRight.showGrid();
            }
            if( nodeToExplore.getAgentPositon().getY() < nodeToExplore.getSize() - 1 &&
                    nodeToExplore.getTile( new TilePosition(xq , yq + 1) ) != '*' ){


                Grid moveDown = moveDown(nodeToExplore);
                calculateHeuristic(moveDown, goalOfThePuzzle, nodeToExplore.getDistanceFromRoot());
                moveDown.setDepth( nodeToExplore.getDepth() + 1);
                remainingGrids.add(moveDown);

               System.out.println("Enqueued  node");
                moveDown.showGrid();
            }
            if( nodeToExplore.getAgentPositon().getY() > 0 &&
                    nodeToExplore.getTile( new TilePosition(xq , yq - 1) ) != '*'){


                Grid moveUp = moveUp(nodeToExplore);
                calculateHeuristic(moveUp, goalOfThePuzzle, nodeToExplore.getDistanceFromRoot());
                moveUp.setDepth( nodeToExplore.getDepth() + 1);
                remainingGrids.add(moveUp);

                System.out.println("Enqueued  node");
                moveUp.showGrid();
            }

        }


        return numberOfNodesExpanded;
    }


    public int numberOfMovesTillGoal(Grid node, Grid goal){

        int numberOfMoves = 0;

        char [][] grid = new char[node.getSize()][node.getSize()];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                grid[j][i] = node.getPuzzleGrid()[j][i];
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j] != '@' && grid[i][j] != '0'){

                    for(int k=0; k<goal.getPuzzleGrid().length; k++) {
                        for (int m = 0; m < goal.getPuzzleGrid()[0].length; m++) {

                            if(grid[i][j] == goal.getPuzzleGrid()[k][m]){
                                numberOfMoves += Math.abs(( k - i ) + Math.abs( m - j )) ;
                            }
                        }
                    }

                }
            }
        }

        return numberOfMoves;
    }

    public void calculateHeuristic(Grid node, Grid goal ,int g){

        int distanceFromRoot = g + 1;

        int distanceToGoal = numberOfMovesTillGoal( node,goal );
        int f = distanceFromRoot + distanceToGoal;

        node.setDistanceFromRoot(distanceFromRoot);
        node.setDistanceToGoal(distanceToGoal);
        node.setHeuristic(f);

    }


    public Grid moveLeft( Grid node){

        Grid childNode = new Grid(node.getSize());
        childNode.setPuzzleGrid( node.getPuzzleGrid());

        int x = node.getAgentPositon().getX();
        int y = node.getAgentPositon().getY();

        TilePosition agentPosition = new TilePosition( x - 1,  y );

        char val = childNode.getTile( agentPosition );
        childNode.setAgentPosition( agentPosition );

        childNode.setTile( agentPosition, '@' );
        childNode.setTile( node.getAgentPositon(), val );
        System.out.println("Node added to the data structure");
        childNode.showGrid();

        return childNode;
    }

    public Grid moveRight( Grid node){

        Grid childNode = new Grid(node.getSize());
        childNode.setPuzzleGrid( node.getPuzzleGrid());

        int x = node.getAgentPositon().getX();
        int y = node.getAgentPositon().getY();

        TilePosition agentPosition = new TilePosition( x+ 1,  y );
        char val = childNode.getTile( agentPosition );
        childNode.setAgentPosition( agentPosition );

        childNode.setTile( agentPosition, '@' );
        childNode.setTile( node.getAgentPositon(), val );

        System.out.println("Node added to the data structure");
        childNode.showGrid();
        return childNode;
    }

    public Grid moveUp( Grid node){

        Grid childNode = new Grid(node.getSize());
        childNode.setPuzzleGrid( node.getPuzzleGrid());

        int x = node.getAgentPositon().getX();
        int y = node.getAgentPositon().getY();

        TilePosition agentPosition = new TilePosition( x,  y - 1 );

        char val = childNode.getTile( agentPosition );
        childNode.setAgentPosition( agentPosition );

        childNode.setTile( agentPosition, '@' );
        childNode.setTile( node.getAgentPositon(), val );

        System.out.println("Node added to the data structure");
        childNode.showGrid();

        return childNode;
    }

    public Grid moveDown( Grid node){

        Grid childNode = new Grid(node.getSize());
        childNode.setPuzzleGrid( node.getPuzzleGrid());

        int x = node.getAgentPositon().getX();
        int y = node.getAgentPositon().getY();

        TilePosition agentPosition = new TilePosition( x ,  y + 1 );
        char val = childNode.getTile( agentPosition );

        childNode.setAgentPosition( agentPosition );

        childNode.setTile( agentPosition, '@' );
        childNode.setTile( node.getAgentPositon(), val );

        System.out.println("Node added to the data structure");
        childNode.showGrid();

        return childNode;
    }

}
