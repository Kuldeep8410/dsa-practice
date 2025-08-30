import java.util.*;
public class kcars {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int dsq;    // sqaure of the distance from origin
        int idx;

        public Point(int x,int y, int dsq,int idx){
            this.x=x;
            this.y=y;
            this.dsq=dsq;
            this.idx =idx;
        }
        @Override
        public int compareTo(Point p2){
           return this.dsq - p2.dsq ;
        }
    }
    public static void main(String[] args){
        int[][] pts = {{3,3},{2,4},{0,3},{-1,2}};
        int k=2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int dsq = (pts[i][0]*pts[i][0]) + (pts[i][1]* pts[i][1]);
            pq.add(new Point(pts[i][0],pts[i][1],dsq,i));
        }
        // neareset k cars
        for(int i=0;i<k;i++){
            System.out.println("C"+ pq.remove().idx);
        }
    }
}
