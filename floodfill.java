public class floodfill {
    public void floodx(int[][] image,int sr,int sc,int color,boolean[][] vis,int orgcol){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||vis[sr][sc]||image[sr][sc]!=orgcol){
            return;
        }
        vis[sr][sc]=true;
        image[sr][sc]=color;
        //left
        floodx(image,sr,sc-1,color,vis,orgcol);
        //right
        floodx(image,sr,sc+1,color,vis,orgcol);
        //up
        floodx(image,sr-1,sc,color,vis,orgcol);
        //down
        floodx(image,sr+1,sc,color,vis,orgcol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        int orgcol = image[sr][sc];
        if(orgcol==color) return image;

        floodx(image,sr,sc,color,vis,orgcol);
        return image;
    }

    public static void main(String[] args){
        floodfill f = new floodfill();
        int[][] image ={{1,0,1,1},{1,1,1,0},{1,0,1,1},{1,0,1,0}};
        int[][] result = f.floodFill(image, 1, 1, 3);
        for(int[] row : result) {
            for(int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
