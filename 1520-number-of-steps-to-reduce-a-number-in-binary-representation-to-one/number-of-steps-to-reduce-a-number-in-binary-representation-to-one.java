import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {

        BigInteger n = new BigInteger(s, 2);
        BigInteger ONE = BigInteger.ONE;
        BigInteger TWO = BigInteger.valueOf(2);

        int steps = 0;

        while (!n.equals(ONE)) {

            if (n.mod(TWO).equals(BigInteger.ZERO)) n = n.divide(TWO);
            else n = n.add(ONE);
            
            steps++;
        }

        return steps;
    }
}