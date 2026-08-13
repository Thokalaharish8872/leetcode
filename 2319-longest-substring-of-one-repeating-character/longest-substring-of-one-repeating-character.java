class Solution {

    // segement tree find min in range

class SGTree{
        int[][] seg;
        char[] arr;
        
        SGTree(int n, String s){
            seg = new int[4 * n + 1][5];
            arr = s.toCharArray();
        }

        void updateChar(int idx, char ch){
            arr[idx] = ch;
        }
        
        void merge(int left, int right, int mid, int low, int high, int idx){

            int n1 = seg[low][0], n2 = seg[high][0];
            int lfSt = seg[low][1], rfSt = seg[high][1];
            int lfEn = seg[low][2], rfEn = seg[high][2];
            int lsSt = seg[low][3], rsSt = seg[high][3];
            int lsEn = seg[low][4], rsEn = seg[high][4];

            char leftRight = arr[lsEn];
            char rightLeft = arr[rfSt];

            seg[idx][0] = Math.max(n1, n2);
            seg[idx][1] = lfSt;
            seg[idx][2] = lfEn;
            seg[idx][3] = rsSt;
            seg[idx][4] = rsEn;

            if(leftRight == rightLeft){
                int leftPrefixLen = lfEn - lfSt + 1;
                int leftSuffixLen = lsEn - lsSt + 1;

                int rightPrefixLen = rfEn - rfSt + 1;
                int rightSuffixLen = rsEn - rsSt + 1;

                int crossing = leftSuffixLen + rightPrefixLen;
                seg[idx][0] = Math.max(seg[idx][0], crossing);

                if(leftPrefixLen == mid - left + 1){
                    seg[idx][1] = lfSt;
                    seg[idx][2] = rfEn;
                }

                if(rightSuffixLen == right - mid){
                    seg[idx][3] = lsSt;
                    seg[idx][4] = rsEn;
                }
            }
        }
        
        void build(int left, int right, int idx){
            if(left == right){
                seg[idx][0] = 1;
                seg[idx][1] = seg[idx][2] = seg[idx][3] = seg[idx][4] = left;
                return;
            }
            
            int mid = (left + right) / 2;
            int low = idx * 2 + 1, high = idx * 2 + 2;

            build(left, mid, low);
            build(mid + 1, right, high);

            merge(left, right, mid, low, high, idx);
        }
        
        void update(int i, char v, int left, int right, int idx){
            if(left == right){
                seg[idx][0] = 1;
                seg[idx][1] = seg[idx][2] = seg[idx][3] = seg[idx][4] = left;
                return;
            }
               
            int mid = (left + right) / 2;
            int low = idx * 2 + 1, high = idx * 2 + 2;

            if(i <= mid)
                update(i, v, left, mid, idx * 2 + 1);
            else
                update(i, v, mid + 1, right, idx * 2 + 2);

            merge(left, right, mid, low, high, idx);
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;

        SGTree sgTree = new SGTree(n, s);
        sgTree.build(0, n - 1, 0);

        for(int i = 0; i < 4 * n; i++){
            System.out.print(sgTree.seg[i][0] + " ");
        }

        int[] ans = new int[k];

        for(int i = 0; i < k; i++){

            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            sgTree.updateChar(idx, ch);

            sgTree.update(idx, ch, 0, n - 1, 0);

            ans[i] = sgTree.seg[0][0];
        }

        return ans;
    }
}