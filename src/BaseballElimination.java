import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.List;

public class BaseballElimination {
    int[] w;
    int[] l;
    int[] r;
    int[][]g;
    int n;
    HashMap<String,Integer> teamMap;
    public BaseballElimination(String filename){
        In in = new In(filename);
        n = Integer.valueOf(in.readLine());
        String[] lines = in.readAllLines();
        w = new int[n];
        l = new int[n];
        r = new int[n];
        g = new int[n][n];
        teamMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            String[] info = (lines[i].replaceAll("\\s+"," ")).split(" ");
            teamMap.put(info[0],i);
            w[i] = Integer.valueOf(info[1]);
            l[i] = Integer.valueOf(info[2]);
            r[i] = Integer.valueOf(info[3]);
            for(int j = 0; j < info.length-4; j++){
                g[i][j] = Integer.valueOf(info[j+4]);
            }
        }
        System.out.println("dfsg");


    }

    public              int numberOfTeams(){return n;}
    public Iterable<String> teams(){return teamMap.keySet();}
    public              int wins(String team){return w[teamMap.get(team)];}
    public              int losses(String team){return l[teamMap.get(team)];}
    public              int remaining(String team){return r[teamMap.get(team)];}
    public              int against(String team1, String team2){return g[teamMap.get(team1)][teamMap.get(team2)];}

    public          boolean isEliminated(String team){return false;}              // is given team eliminated?
    public Iterable<String> certificateOfElimination(String team){return null;}  // subset R of teams that eliminates given team; null if not eliminated

    public static void main(String[] args) {
        BaseballElimination b = new BaseballElimination("files/teams4.txt");
    }
}
