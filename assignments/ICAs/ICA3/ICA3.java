import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ICA3 {
    public static void main(String[] args) {
        // Rule 1: Any live cell with fewer than two live neighbours dies, as if by underpopulation.
        // if (cell.neighbours < 2 && cell.alive) {
        //     cell.die;
        // }
        // Rule 2: Any live cell with two or three live neighbours lives on to the next generation.
        // if ((cell.neighbours == 2 || cell.neighbours == 3) && cell.alive) {
        //     cell.keeps-living;
        // }
        // Rule 3: Any live cell with more than three live neighbours dies, as if by overpopulation.
        // if (cell.neighbours >= 3 && cell.alive) {
        //     cell.die;
        // }
        // Rule 4: Any dead cell with exactly three live neighbours becomes a live cell, as if by reproudction.
        // if (cell.neighbours == 3 && cell.dead) {
        //     cell.alive;
        // }
        game();
    }

    public static class Cell {
        public STATUS status;
        public STATUS nextStatus;

        public Cell(STATUS status) {
            this.status = status;
        }

        public boolean isAlive() {
            return status == STATUS.ALIVE;
        }
    }

    public enum STATUS {
        ALIVE,
        DEAD
    }

    public static class Grid {
        private static final int CELL_SIZE = 3;
        private static final int CELL_WIDTH = CELL_SIZE * 2 + 1;
        public int rows;
        public int cols;
        private final Cell[][] cells;

        public Grid(int rows, int cols) {
            this.rows = rows + 1;
            this.cols = cols + 1;
            this.cells = new Cell[this.rows][this.cols];
            for (int r = 0; r < this.rows; r++) {
                for (int c = 0; c < this.cols; c++) {
                    cells[r][c] = new Cell(STATUS.DEAD);
                }
            }
        }

        public void placeCell(int row, int col) {
            cells[row][col].status = STATUS.ALIVE;
        }

        public void printGrid() {
            String filled ="[]".repeat(CELL_SIZE) + " ";
            String empty =" ".repeat(CELL_WIDTH);

            System.out.print("   ");
            for(int c = 0; c < cols; c++) {
                System.out.printf("%-" + CELL_WIDTH + "d", c);
            }
            System.out.println();

            for(int r = 0; r < rows; r++) {
                for(int line = 0; line < CELL_SIZE; line++) {
                    if(line == 0) {
                        System.out.printf("%-3d", r);
                    } else {
                        System.out.print("   ");
                    }
                    for(int c = 0; c < cols; c++) {
                        System.out.print(cells[r][c].isAlive() ? filled : empty);
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

        public int countLiveNeighbours(int row, int col) {
            int count = 0;
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    int r = row + dr;
                    int c = col + dc;
                    if (r >= 0 && r < rows && c >= 0 && c < cols && cells[r][c].isAlive()) {
                        count++;
                    }
                }
            }
            return count;
        }

        public void step() {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int n = countLiveNeighbours(r, c);
                    Cell cell = cells[r][c];
                    boolean alive = n == 3 || (cell.isAlive() && n == 2);
                    cell.nextStatus = alive ? STATUS.ALIVE : STATUS.DEAD;
                }
            }
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    cells[r][c].status = cells[r][c].nextStatus;
                }
            }
        }
    }

    public static void game() {
        Grid grid = new Grid(9, 9);
        // Starting Configuration 1 (dies out after 127 generations)
        // grid.placeCell(4, 2);
        // grid.placeCell(5, 4);
        // grid.placeCell(6, 1);
        // grid.placeCell(6, 2);
        // grid.placeCell(6, 5);
        // grid.placeCell(6, 6);
        // grid.placeCell(6, 7);

        // Starting Configuration 2 (41 generations, ends as a block)
        // grid.placeCell(4, 5);
        // grid.placeCell(4, 6);
        // grid.placeCell(5, 4);
        // grid.placeCell(5, 5);
        // grid.placeCell(6, 5);

        // Starting Configuration 3 (28 generations, ends as a block in the corner)
        grid.placeCell(1, 2);
        grid.placeCell(2, 3);
        grid.placeCell(3, 1);
        grid.placeCell(3, 2);
        grid.placeCell(3, 3);

        while (true) {
            grid.printGrid();
            grid.step();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
