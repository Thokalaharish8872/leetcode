class Solution {
    Set<Integer> b1 = new HashSet<>(List.of(2, 3, 4, 5));
    Set<Integer> b2 = new HashSet<>(List.of(4, 5, 6, 7));
    Set<Integer> b3 = new HashSet<>(List.of(6, 7, 8, 9));

    boolean f1, f2, f3;

    private void check(int num){
        if(b1.contains(num))
            f1 = false;
        if(b2.contains(num))
            f2 = false;
        if(b3.contains(num))
            f3 = false;
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int m = reservedSeats.length;

        List<int[]> res = Arrays.stream(reservedSeats)
                        .collect(Collectors.toList());

        res.sort((a, b) -> {
            int row = Integer.compare(a[0], b[0]);

            if (row != 0)
                return row;

            return Integer.compare(a[1], b[1]);
        });

        int count = 0;

        int i = 0;
        int rows = 0;

        while(i < m){
            int j = i;

            f1 = true;
            f2 = true;
            f3 = true;

            while(j < m && res.get(i)[0] == res.get(j)[0])
                check(res.get(j++)[1]);

            if(f1 && f3)
                count += 2;
            else if(f1 || f2 || f3)
                count++;

            rows++;
            i = j;
        }

        return count + (n - rows) * 2;
    }
}