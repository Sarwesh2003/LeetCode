class Solution {
    public double myPow(double x, int n) {
        return pow(x, n);
    }
    public double pow(double x, int y){
        double power = y;
        double res = 1.0;
        if(power < 0){
            power*=-1;
        }
        while(power > 0){
            if(power % 2 == 0){
                x*=x;
                power/=2;
            }else{
                res *= x;
                power -= 1;
            }
        }
        res = (y<0)?(1/res):res;
        return res;
    }
}