import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Jesse_and_Cookies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        
        int operations = 0;
        while (pq.size() > 1 && pq.peek() < k) {
            int least = pq.poll();
            int secondLeast = pq.poll();
            int combined = least + 2 * secondLeast;
            pq.add(combined);
            operations++;
        }
        
        if (!pq.isEmpty() && pq.peek() >= k) {
            System.out.println(operations);
        } else {
            System.out.println(-1);
        }
    }
}