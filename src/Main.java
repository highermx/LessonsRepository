public class Main {
    public static void main(String[] args) {
        int[][] worldMap = {
                {1,1,2,2,1},
                {2,1,2,1,2},
                {1,2,1,2,1}
        };

        Voyager island = new DfsVoyager();
        int result = island.lookupIslands(worldMap);

        System.out.println("Обнаружено островов: " + result);

    }
}
