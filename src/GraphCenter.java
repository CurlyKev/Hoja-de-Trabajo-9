public class GraphCenter {

    public static String getCenter(FloydWarshall fw) {

        int[][] dist = fw.getDistMatrix();
        String[] cities = fw.getCities();

        int minEccentricity = Integer.MAX_VALUE;
        String center = "";

        for (int i = 0; i < dist.length; i++) {

            int eccentricity = 0;

            for (int j = 0; j < dist.length; j++) {
                eccentricity = Math.max(eccentricity, dist[i][j]);
            }

            if (eccentricity < minEccentricity) {
                minEccentricity = eccentricity;
                center = cities[i];
            }
        }

        return center;
    }
}
