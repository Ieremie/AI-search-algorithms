import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("Please input the size of the puzzle: ");
        Scanner scanner = new Scanner(System.in);


        int size = scanner.nextInt();
        System.out.println("Size inputted" );
        System.out.println("Creating puzzle of size " + size + "...");
        Grid startGrid = new Grid(size);
        Grid goalGrid = new Grid(size);

        TilePosition a;
        TilePosition b;
        TilePosition c;
        TilePosition agent;

        TilePosition ga;
        TilePosition gb;
        TilePosition gc;

        System.out.println("Input position of block a (x and y): " );
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        a = new TilePosition(x,y);

        System.out.println("Input position of block b (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        b = new TilePosition(x,y);

        System.out.println("Input position of block c (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        c = new TilePosition(x,y);

        System.out.println("Input position of the agent (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        agent = new TilePosition(x,y);

        System.out.println("Initializing puzzle...");
        startGrid.setGrid(a,b,c,agent);
        startGrid.setAgentPosition(agent);

        //This part is used to run the new puzzle for A*

      /*  System.out.println("Input fixed position of block alpha (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        TilePosition alpha = new TilePosition(x,y);

        System.out.println("Input fixed position of block beta (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        TilePosition beta = new TilePosition(x,y);

        System.out.println("Input fixed position of block theta (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        TilePosition theta = new TilePosition(x,y);

        startGrid.setTile(alpha, '*');
        startGrid.setTile(beta, '*');
        startGrid.setTile(theta, '*');

        */

        System.out.println("Input positions of goal states:");
        System.out.println("Input goal position of block a (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        ga = new TilePosition(x,y);

        System.out.println("Input goal position of block b (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        gb = new TilePosition(x,y);

        System.out.println("Input goal position of block c (x and y): " );
        x = scanner.nextInt();
        y = scanner.nextInt();
        gc = new TilePosition(x,y);

        System.out.println("Initializing goal puzzle...");
        goalGrid.setGrid(ga,gb,gc,new TilePosition(-1,-1));



        System.out.println("Start state of the puzzle is: ");
        startGrid.showGrid();

       System.out.println("Goal state of the puzzle is: ");
        goalGrid.showGrid();


      Search search = new Search();


      System.out.println("Breadth first search in action ...");
      System.out.println("The average number of nodes stored is: " );
      System.out.print(search.breadFirstSearch(startGrid,goalGrid));


    /*  System.out.println("Dfs in action ... ");

      int sum = 0;
        for(int i = 0; i< 20; i++){

            int k = search.depthFirstSearch(startGrid,goalGrid);
            sum += k ;

        }

        //System.out.println(search.depthFirstSearch(startGrid,goalGrid));
        System.out.println("The average number of nodes stored is: " + (double)sum/20);
        */



       // System.out.println("Iterative deepening in action ...");
       // System.out.println(search.iterativeDeepening(startGrid,goalGrid));
       // System.out.println();


        //test for A*
     //  System.out.println("A* in action ... ");
      //  System.out.println("The average number of nodes stored is: " );
       // System.out.print(search.aStar(startGrid,goalGrid));


    }
}
