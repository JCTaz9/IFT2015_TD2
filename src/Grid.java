public class Grid {
    public class Cell {
        int value;
        Cell left;
        Cell right;
        Cell top;
        Cell bottom;
        public Cell(){
            this.value = -1;
            this.left = null;
            this.right = null;
            this.top = null;
            this.bottom = null;
        }
        public Cell(int value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.top = null;
            this.bottom = null;

        }
    }

    private Cell[] grid;

    public Grid(){
        grid = new Cell[12];
        grid[0] = new Cell(1);
        grid[1] = new Cell(1);
        grid[2] = new Cell(1);
        grid[3] = new Cell(1);
        grid[4] = new Cell(5);
        grid[5] = new Cell(5);
        grid[6] = new Cell(10);
        grid[7] = new Cell(10);
        grid[8] = new Cell(10);
        grid[9] = new Cell(10);
        grid[10] = new Cell(25);
        grid[11] = new Cell();
        grid[0].right = grid[1];
        grid[0].bottom = grid[4];
        grid[1].left = grid[0];
        grid[1].bottom = grid[5];
        grid[1].right = grid[2];
        grid[2].left = grid[1];
        grid[2].bottom = grid[6];
        grid[2].right = grid[3];
        grid[3].left = grid[2];
        grid[3].bottom = grid[7];
        grid[4].top = grid[0];
        grid[4].right = grid[5];
        grid[4].bottom = grid[8];
        grid[5].top = grid[1];
        grid[5].left = grid[4];
        grid[5].bottom = grid[9];
        grid[5].right = grid[6];
        grid[6].top = grid[2];
        grid[6].left = grid[5];
        grid[6].bottom = grid[10];
        grid[6].right = grid[7];
        grid[7].top = grid[3];
        grid[7].left = grid[6];
        grid[7].bottom = grid[11];
        grid[8].top = grid[4];
        grid[8].right = grid[9];
        grid[9].top = grid[5];
        grid[9].left = grid[8];
        grid[9].right = grid[10];
        grid[10].top = grid[6];
        grid[10].left = grid[9];
        grid[11].top = grid[7];
        grid[11].left = grid[10];

    }

    public boolean move(Cell box){
        if (box.value == -1) {
            return false;
        }
        if (box.left != null && box.left.value == -1) {
            box.left.value = box.value;
            box.value = -1;
            return true;
        } else if (box.right != null && box.right.value == -1) {
            box.right.value = box.value;
            box.value = -1;
            return true;
        } else if (box.top != null && box.top.value == -1) {
            box.top.value = box.value;
            box.value = -1;
            return true;
        } else if (box.bottom != null && box.bottom.value == -1) {
            box.bottom.value = box.value;
            box.value = -1;
            return true;
        }
        return false;
    }

    public boolean check_complete(){

        
        Cell[] grid = this.grid;

        if(grid[0].value == grid[8].value){
            if(grid[1].value == grid[9].value){
                if(grid[2].value == grid[10].value){
                    if(grid[3].value == grid[11].value){
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public void solve_game(){
        // TODO
    }
}
