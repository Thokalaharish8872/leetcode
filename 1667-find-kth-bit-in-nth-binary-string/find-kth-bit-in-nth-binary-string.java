class Solution {
    String[] arr;

    private String reverse_invert(StringBuilder str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1') str.setCharAt(i, '0');
            else str.setCharAt(i, '1');
        }

        return str.reverse().toString();
    }

    private void preCompute(){
        arr = new String[21];

        arr[1] = "0";

        for(int i = 2; i < 21; i++){
            arr[i] = arr[i - 1] + "1" + reverse_invert(new StringBuilder(arr[i - 1]));
        }
    }

    public char findKthBit(int n, int k){
        if(arr == null)  preCompute();

        return arr[n].charAt(k - 1);
    }
}