public class TriangleAnalyzer {

    public static Statistics computeTypeStatistics(double[][] data) {
        if (data == null) {
            throw new NullPointerException("Input data is null");
        }

        Statistics stats = new Statistics();

        for (double[] triangle : data) {
            if (triangle.length != 6) {
                throw new IllegalArgumentException("Each entry must contain exactly 6 elements");
            }

            double x1 = triangle[0], y1 = triangle[1];
            double x2 = triangle[2], y2 = triangle[3];
            double x3 = triangle[4], y3 = triangle[5];

            double a = distance(x1, y1, x2, y2);
            double b = distance(x2, y2, x3, y3);
            double c = distance(x3, y3, x1, y1);

            if (!formsTriangle(a, b, c)) {
                stats.nonTriangle++;
            } else if (a == b && b == c) {
                stats.equilateral++;
            } else if (a == b || b == c || a == c) {
                stats.isosceles++;
            } else {
                stats.scalene++;
            }
        }

        return stats;
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static boolean formsTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static class Statistics {
        public int nonTriangle = 0;
        public int equilateral = 0;
        public int isosceles = 0;
        public int scalene = 0;
    }
}