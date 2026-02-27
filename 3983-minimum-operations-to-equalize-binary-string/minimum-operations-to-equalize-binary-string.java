class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();

        TreeSet<Integer>[] ts = new TreeSet[2];
        Arrays.setAll(ts, i -> new TreeSet<>());

        for (int i = 0; i <= n; i++) {
            ts[i & 1].add(i);
        }

        int cnt0 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt0++;
            }
        }

        ts[cnt0 & 1].remove(cnt0);

        Deque<Integer> q = new ArrayDeque<>();
        q.add(cnt0);

        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- != 0) {
                int cur = q.remove();
                if (cur == 0) return ans;

                int l = cur + k - 2 * Math.min(cur, k);
                int r = cur + k - 2 * Math.max(k - n + cur, 0);

                TreeSet<Integer> t = ts[l & 1];

                Integer next = t.ceiling(l);
                while (next != null && next <= r) {
                    q.add(next);
                    t.remove(next);

                    next = t.ceiling(l);
                }
            }
            ans++;
        }

        return -1;
    }
}