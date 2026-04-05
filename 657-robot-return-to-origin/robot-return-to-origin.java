class Solution {
    public boolean judgeCircle(String moves) {
        int[] freq = new int[26];

        for(char move : moves.toCharArray())
            freq[move - 'A']++;

        return freq['L' - 'A'] == freq['R' - 'A'] && freq['U' - 'A'] == freq['D' - 'A'];
    }
}