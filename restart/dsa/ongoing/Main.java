package restart.dsa.ongoing;

import java.util.*;

public class Main {
    public int minimumSemesters(int n, int[][] relations) {
        int[] prerequisite=new int[n+1];
        List<Integer>[] graph = new ArrayList[n+1]; // Create an array of lists
        //Arrays.fill(graph, new ArrayList<Integer>());
        for(int i=0;i<=n;++i) graph[i]=new ArrayList<>();
        for(int[] relation:relations){
            int prevCourse=relation[0],nextCourse=relation[1];
            prerequisite[nextCourse]++;
            graph[prevCourse].add(nextCourse);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=n;++i){
            if(prerequisite[i]==0){
                queue.add(i);
            }
        }
        int semesters=0,total=0;
        while(!queue.isEmpty()){
            int currentCourses=queue.size();
            ++semesters;
            while (!queue.isEmpty() && currentCourses-->0){
                int current=queue.poll();
                ++total;
                for(int child:graph[current]){
                    --prerequisite[child];
                    if(prerequisite[child]==0){
                        queue.add(child);
                    }
                }
            }
        }
        return total==n ? semesters : -1;
    }
    public static void main(String[] args) {
        var main=new Main();
        System.out.println(main.minimumSemesters(3, new int[][]{{1,3},{2,3}}));
        System.out.println(main.minimumSemesters(3, new int[][]{{1,2},{2,3},{3,1}}));
    }
}
