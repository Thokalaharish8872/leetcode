class Solution {

    boolean[] isPrime;

    private void sieve(int N) {

        isPrime = new boolean[N + 1];

        Arrays.fill(isPrime, true);

        if (N >= 0) isPrime[0] = false;
        if (N >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        int maxVal = 0;

        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        sieve(maxVal);

        int[] dis = new int[n];

        Arrays.fill(dis, (int) 1e9);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        Set<Integer> usedPrime = new HashSet<>();

        Queue<Integer> q = new ArrayDeque<>();

        q.add(0);

        dis[0] = 0;

        while (!q.isEmpty()) {

            int idx = q.remove();

            if (idx == n - 1) {
                return dis[idx];
            }

            if (idx + 1 < n &&
                    dis[idx] + 1 < dis[idx + 1]) {

                dis[idx + 1] = dis[idx] + 1;

                q.add(idx + 1);
            }

            if (idx - 1 >= 0 &&
                    dis[idx] + 1 < dis[idx - 1]) {

                dis[idx - 1] = dis[idx] + 1;

                q.add(idx - 1);
            }

            int p = nums[idx];

            if (isPrime[p] && !usedPrime.contains(p)) {

                usedPrime.add(p);

                for (int multiple = p;
                     multiple <= maxVal;
                     multiple += p) {

                    List<Integer> list = map.get(multiple);

                    if (list == null)
                        continue;

                    for (int next : list) {

                        if (dis[idx] + 1 < dis[next]) {

                            dis[next] = dis[idx] + 1;

                            q.add(next);
                        }
                    }
                }
            }
        }

        return -1;
    }
}