import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Grid implements Comparable<Grid>{


    private char [][] puzzleGrid;
    private TilePosition agentPositon;

    public void setDistanceToGoal(Integer distanceToGoal) {
        this.distanceToGoal = distanceToGoal;
    }

    private Integer distanceToGoal;
    private Integer distanceFromRoot;
    private Integer heuristic;
    private int size;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    private int depth;

    public void setAgentPositon(TilePosition agentPositon) {
        this.agentPositon = agentPositon;
    }

    public Integer getDistanceToGoal() {
        return distanceToGoal;
    }

    public Integer getDistanceFromRoot() {
        return distanceFromRoot;
    }

    public void setDistanceFromRoot(Integer distanceFromRoot) {
        this.distanceFromRoot = distanceFromRoot;
    }

    public Integer getHeuristic() {
        return heuristic;
    }
    public void setHeuristic(Integer heuristic) {
        this.heuristic = heuristic;
    }


    public void setPuzzleGrid(char[][] puzzleGrid1) {
        char[][]  newPuzzleGrid  = new char[puzzleGrid1.length][puzzleGrid1.length];

        for(int i=0; i<puzzleGrid1.length; i++){
            for(int j=0; j<puzzleGrid1[0].length; j++){
                newPuzzleGrid[j][i] = puzzleGrid1[j][i];
            }
        }

        for(int i=0; i<newPuzzleGrid.length; i++){
            for(int j=0; j<newPuzzleGrid[0].length; j++){
                this.puzzleGrid[j][i] = newPuzzleGrid[j][i];
            }
        }
    }

    public char[][] getPuzzleGrid() {
        return puzzleGrid;
    }

    public int getSize() {
        return size;
    }

     protected Grid(int size){

         this.size = size;
         puzzleGrid = new char[size][size];

         for(int i = 0 ;i< this.puzzleGrid.length; i++){
             for(int j = 0; j<this.puzzleGrid[0].length; j++){
                 this.puzzleGrid[i][j] = '0';
             }
         }

     }

     public void setTile( TilePosition tilePosition, char tileName){
             this.puzzleGrid[tilePosition.getY()][tilePosition.getX()] = tileName;
     }

    public char getTile( TilePosition tilePosition){

        return this.puzzleGrid[tilePosition.getY()][tilePosition.getX()];
    }



    public void setAgentPosition( TilePosition agentPosition){

         this.agentPositon = agentPosition;
     }

     public TilePosition getAgentPositon(){

         return this.agentPositon;
     }


     public void setGrid(TilePosition a, TilePosition b, TilePosition c, TilePosition agent){


         setTile(a, 'a');
         setTile(b, 'b');
         setTile(c, 'c');
         if(agent.getX() != -1 && agent.getY()!= -1){

             this.setTile(agent, '@');
             this.setAgentPosition(agent);
         }
     }

    public boolean checkGoal( Grid puzzleGridGoalState) {


        boolean ok = true;
        for (int i = 0; i < this.puzzleGrid.length; i++) {

            for (int j = 0; j < this.puzzleGrid[0].length; j++) {

                if(this.puzzleGrid[i][j] == '@'  && ok){
                    this.puzzleGrid[i][j] = '0';
                    ok = false;
                }

                if (this.puzzleGrid[i][j] != puzzleGridGoalState.getPuzzleGrid()[i][j] && this.puzzleGrid[i][j] != '*')
                    return false;
            }
        }
        return true;

     }


     public void showGrid(){


         for(int i = 0; i<this.puzzleGrid.length; i++){

             for(int j = 0; j< this.puzzleGrid[0].length; j++){

                 System.out.print(this.puzzleGrid[i][j] + "  ");
             }
             System.out.println();
         }

         System.out.println();

     }




    @Override
    public int compareTo(Grid gridToCompare) {

        if(this.getHeuristic() > gridToCompare.getHeuristic())
            return 1;
        if(this.getHeuristic() < gridToCompare.getHeuristic())
            return -1;
        return 0;
    }
}
