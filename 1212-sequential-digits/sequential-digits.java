class Solution {
    public List<Integer> sequentialDigits(int l, int h) {
        List<Integer> list = new ArrayList<>();

        String digits = "123456789";

        String low = l + "";
        String high = h + "";

        int i = low.charAt(0) - '0' - 1;
        int j = low.length();

        int num = l;

        while(num <= h){

            if(i + j > 9){
                i = 0;
                j++;
            }

            if(i + j > 9)
                break;

            num = Integer.parseInt(digits.substring(i, i + j));
            if(num >= l && num <= h)
                list.add(num);

            i++;
        }

        return list;
    }
}