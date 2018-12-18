package net.ericlefevre;

import java.util.*;

public class Day6ChronalCoordinates {
    public static Coordinates coordinates(long x, long y) {
        Coordinates c = new Coordinates();
        c.x = x;
        c.y = y;
        return c;
    }

    static class Coordinates {
        private long x, y;

        public Coordinates left() {
            return coordinates(x - 1, y);
        }

        public Coordinates right() {
            return coordinates(x + 1, y);
        }

        public Coordinates up() {
            return coordinates(x, y - 1);
        }

        public Coordinates down() {
            return coordinates(x, y + 1);
        }

        @Override
        public String toString() {
            return "Coordinates{" + "x=" + x + ", y=" + y + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static Cell cell(Integer origin, int distance) {
        Cell cell = new Cell();
        cell.origin = origin;
        cell.distance = distance;
        return cell;
    }

    static Cell sameDistance = cell(-1, -1);

    static class Cell {
        private Integer origin;
        private int distance;
    }

    static class Grid {
        public List<Integer> enclosedOrigins;
        private Map<Coordinates, Cell> grid = new HashMap<>();
        private long minX = 0;
        private long maxX = 0;
        private long minY = 0;
        private long maxY = 0;


        public boolean isFree(Coordinates coordinates) {
            return !grid.containsKey(coordinates);
        }

        public boolean isAssigned(Coordinates coordinates) {
            if (isFree(coordinates)) {
                return false;
            }
            return grid.get(coordinates).distance >= 0;
        }

        public Character toCharacter(Coordinates coordinates) {
            if (isFree(coordinates)) {
                return '.';
            }
            Cell cell = grid.get(coordinates);
            if (cell.distance < 0) {
                return ' ';
            }

            int i = grid.get(coordinates).origin.intValue();
            return Character.valueOf((char) (i + 64));
        }

        public boolean assign(Coordinates coordinates, Integer territory, int distance) {
            if (coordinates.x < minX) {
                minX = coordinates.x;
            }
            if (coordinates.x > maxX) {
                maxX = coordinates.x;
            }
            if (coordinates.y < minY) {
                minY = coordinates.y;
            }
            if (coordinates.y > maxY) {
                maxY = coordinates.y;
            }
            if (isFree(coordinates)) {
                grid.put(coordinates, cell(territory, distance));
                return true;
            }
            Cell cell = grid.get(coordinates);
            if (cell.distance < distance) {
                return false;
            }
            if (cell.origin == territory) {
                return false;
            }

            grid.put(coordinates, sameDistance);
            return false;
        }
    }

    static class Iteration {
        private Map<Integer, List<Coordinates>> next = new HashMap<>();
        private int distance = 0;
        private boolean done = false;

        public Iteration(int distance) {
            this.distance = distance;
        }

        public void add(Integer origin, Coordinates coordinates) {
            if (!next.containsKey(origin)) {
                next.put(origin, new ArrayList<>());
            }
            next.get(origin).add(coordinates);
        }
    }

    private static List<Coordinates> origins = Arrays.asList(coordinates(69, 102), coordinates(118, 274), coordinates(150, 269), coordinates(331, 284), coordinates(128, 302), coordinates(307, 192), coordinates(238, 52), coordinates(240, 339), coordinates(111, 127), coordinates(180, 156), coordinates(248, 265), coordinates(160, 69), coordinates(58, 136), coordinates(43, 235), coordinates(154, 202), coordinates(262, 189), coordinates(309, 53), coordinates(292, 67), coordinates(335, 198), coordinates(99, 199), coordinates(224, 120), coordinates(206, 313), coordinates(359, 352), coordinates(101, 147), coordinates(301, 47), coordinates(255, 347), coordinates(121, 153), coordinates(264, 343), coordinates(252, 225), coordinates(48, 90), coordinates(312, 139), coordinates(90, 277), coordinates(203, 227), coordinates(315, 328), coordinates(330, 81), coordinates(190, 191), coordinates(89, 296), coordinates(312, 255), coordinates(218, 181), coordinates(299, 149), coordinates(151, 254), coordinates(209, 212), coordinates(42, 76), coordinates(348, 183), coordinates(333, 227), coordinates(44, 210), coordinates(293, 356), coordinates(44, 132), coordinates(175, 77), coordinates(215, 109));
    //private static List<Coordinates> origins = Arrays.asList(coordinates(3, 3), coordinates(5, 5), coordinates(4, 4));

    public static void main(String[] args) {
        List<Integer> enclosedOrigins = findEnclosedOrigins(origins);
        for (Integer origin : enclosedOrigins) {
            System.out.println(origin + " is enclosed");
        }

        Grid grid = new Grid();
        grid.enclosedOrigins = enclosedOrigins;
        Iteration iteration = new Iteration(0);

        for (int i = 0; i < origins.size(); i++) {
            grid.assign(origins.get(i), i, iteration.distance);
            iteration.add(i, origins.get(i));
        }
        printGrid(grid, iteration);

        while (!iteration.done) {
            iteration = computeIteration(grid, iteration);
            printGrid(grid, iteration);
        }


        Map<Integer, Integer> territorySizes = new HashMap<>();
        for (long y = grid.minY; y < grid.maxY + 1; y++) {
            for (long x = grid.minX; x < grid.maxX + 1; x++) {
                if (grid.isAssigned(coordinates(x, y))) {
                    Integer origin = grid.grid.get(coordinates(x, y)).origin;
                    if (!grid.enclosedOrigins.contains(origin)) {
                        continue;
                    }
                    if (!territorySizes.containsKey(origin)) {
                        territorySizes.put(origin, 0);
                    }
                    territorySizes.put(origin, territorySizes.get(origin) + 1);
                }
            }
        }
        for (Integer size : territorySizes.values()) {
            System.out.print(size + ", ");
        }
    }

    private static List<Integer> findEnclosedOrigins(List<Coordinates> origins) {
        long minX = Integer.MAX_VALUE;
        long maxX = 0;
        long minY = Integer.MAX_VALUE;
        long maxY = 0;

        for (Coordinates coordinates : origins) {
            if (coordinates.x < minX) minX = coordinates.x;
            if (coordinates.x > maxX) maxX = coordinates.x;
            if (coordinates.y < minY) minY = coordinates.y;
            if (coordinates.y > maxY) maxY = coordinates.y;
        }
        System.out.println("minX: " + minX + ", maxX: " + maxX + ", minY: " + minY + ", maxY: " + maxY);
        List<Integer> enclosed = new ArrayList<>();
        for (int i = 0; i < origins.size(); i++) {
            if (origins.get(i).x != minX && origins.get(i).x != maxX && origins.get(i).y != minY && origins.get(i).y != maxY) {
                enclosed.add(i);
            }
        }


        return enclosed;
    }

    private static Iteration computeIteration(Grid grid, Iteration iteration) {
        Iteration nextIteration = new Iteration(iteration.distance + 1);
        for (Integer origin : iteration.next.keySet()) {
            for (Coordinates coordinates : iteration.next.get(origin)) {
                if (grid.assign(coordinates.left(), origin, nextIteration.distance)) {
                    nextIteration.add(origin, coordinates.left());
                }
                if (grid.assign(coordinates.right(), origin, nextIteration.distance)) {
                    nextIteration.add(origin, coordinates.right());
                }
                if (grid.assign(coordinates.up(), origin, nextIteration.distance)) {
                    nextIteration.add(origin, coordinates.up());
                }
                if (grid.assign(coordinates.down(), origin, nextIteration.distance)) {
                    nextIteration.add(origin, coordinates.down());
                }
            }
        }
/*        for (Coordinates coordinates:nextIteration.next.get(0)) {
            System.out.print(coordinates+", ");
        }
        System.out.println();*/

        boolean done = true;
        for (Integer origin : grid.enclosedOrigins) {
            if (!nextIteration.next.get(origin).isEmpty()) {
                System.out.println(origin+" is still in progress");
                done = false;
                break;
            }
        }
        nextIteration.done = done;
        return nextIteration;
    }

    private static void printGrid(Grid grid, Iteration iteration) {
        System.out.println(iteration.distance + " " + (iteration.done ? "done" : "in progress"));
/*        for (long y = 80; y < 120 + 1; y++) {
            for (long x = 50; x < 90 + 1; x++) {
                System.out.print(grid.toCharacter(coordinates(x, y)));
            }
            System.out.println();
        }*/
    }

}
