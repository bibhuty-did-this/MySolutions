import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Code_771A_BearAndFriendshipCondition{
    public static void main(String args[]) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in=new StringTokenizer(reader.readLine());
        PrintWriter out=new PrintWriter(System.out);

        int vertices=Integer.parseInt(in.nextToken()),pairs=Integer.parseInt(in.nextToken());
        ArrayList<Integer>[] graph=new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<pairs;i++){
            in=new StringTokenizer(reader.readLine());
            int a=Integer.parseInt(in.nextToken())-1,b=Integer.parseInt(in.nextToken())-1;
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited=new boolean[vertices];
        for(int i=0;i<vertices;++i){
            long vertex=0,edges=0;
            if(!visited[i]){
                //out.println("Starting vertes is "+i);
                Stack<Integer> s=new Stack<>();
                s.push(i);
                visited[i]=true;
                while(!s.isEmpty()){
                    int v=s.pop();
                    edges+=graph[v].size();
                    ++vertex;
                    //out.print(v+" -> ");
                    for(int V:graph[v]){
                        if(!visited[V]){
                            visited[V]=true;
                            //out.print(V+" ");
                            s.push(V);
                        }
                    }
                    //out.println();
                }
                //out.println(edges+" "+vertex);
                if(edges!=vertex*(vertex-1)){
                    out.print("NO");
                    out.close();
                    return;
                }
            }
        }
        out.print("YES");


        out.close();
    }
}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Code_771A_BearAndFriendshipCondition{
    public static void main(String args[]) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in=new StringTokenizer(reader.readLine());
        PrintWriter out=new PrintWriter(System.out);

        int vertices=Integer.parseInt(in.nextToken()),pairs=Integer.parseInt(in.nextToken());
        ArrayList<Integer>[] graph=new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<pairs;i++){
            in=new StringTokenizer(reader.readLine());
            int a=Integer.parseInt(in.nextToken())-1,b=Integer.parseInt(in.nextToken())-1;
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited=new boolean[vertices];
        for(int i=0;i<vertices;++i){
            long vertex=0,edges=0;
            if(!visited[i]){
                //out.println("Starting vertes is "+i);
                Stack<Integer> s=new Stack<>();
                s.push(i);
                visited[i]=true;
                while(!s.isEmpty()){
                    int v=s.pop();
                    edges+=graph[v].size();
                    ++vertex;
                    //out.print(v+" -> ");
                    for(int V:graph[v]){
                        if(!visited[V]){
                            visited[V]=true;
                            //out.print(V+" ");
                            s.push(V);
                        }
                    }
                    //out.println();
                }
                //out.println(edges+" "+vertex);
                if(edges!=vertex*(vertex-1)){
                    out.print("NO");
                    out.close();
                    return;
                }
            }
        }
        out.print("YES");


        out.close();
    }
}
*/
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Code_771A_BearAndFriendshipCondition{
    public static void main(String args[]) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in=new StringTokenizer(reader.readLine());
        PrintWriter out=new PrintWriter(System.out);

        int vertices=Integer.parseInt(in.nextToken()),pairs=Integer.parseInt(in.nextToken());
        ArrayList<Integer>[] graph=new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<pairs;i++){
            in=new StringTokenizer(reader.readLine());
            int a=Integer.parseInt(in.nextToken())-1,b=Integer.parseInt(in.nextToken())-1;
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited=new boolean[vertices];
        for(int i=0;i<vertices;++i){
            long vertex=0,edges=0;
            if(!visited[i]){
                //out.println("Starting vertes is "+i);
                Stack<Integer> s=new Stack<>();
                s.push(i);
                while(!s.isEmpty()){
                    int v=s.pop();
                    if(visited[v])continue;
                    edges+=graph[v].size();
                    ++vertex;
                    visited[v]=true;
                    //out.print(v+" -> ");
                    for(int V:graph[v]){
                        s.push(V);
                    }
                    //out.println();
                }
                //out.println(edges+" "+vertex);
                if(edges!=vertex*(vertex-1)){
                    out.print("NO");
                    out.close();
                    return;
                }
            }
        }
        out.print("YES");


        out.close();
    }
}
 */