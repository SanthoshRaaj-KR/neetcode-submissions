class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        for(int i =0;i<9;i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){

                char current = board[i][j];
                int b = (i/3)*3 + (j/3);

                if(current == '.'){
                    continue;
                }
                if(row[i].contains(current) || col[j].contains(current) || box[b].contains(current)){
                    return false;
                }

                box[b].add(current);
                col[j].add(current);
                row[i].add(current);
            }
        }

        return true;
    }
}
