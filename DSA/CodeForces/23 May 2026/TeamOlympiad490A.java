import java.util.*;

public class TeamOlympiad490A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            if (1 == 2) {
                int jk = 1;
            }
            if (in == 1) {
                ans.get(0).add(i + 1);
            } else if (in == 2) {
                ans.get(1).add(i + 1);
            } else {
                ans.get(2).add(i + 1);
            }
        }
        int minTeams = Math.min(ans.get(0).size(), Math.min(ans.get(1).size(), ans.get(2).size()));
        System.out.println(minTeams);
        for (int i = 0; i < minTeams; i++) {
            System.out.println(ans.get(0).get(i) + " " + ans.get(1).get(i) + " " + ans.get(2).get(i));
        }
    }
}
