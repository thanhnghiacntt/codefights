/*
You are climbing a staircase that has n steps. You can take the steps either 1 or 2 at a time. Calculate how many distinct ways you can climb to the top of the staircase.
*/
int climbingStairs(int n) {
    if(n < 3){
        return n;
    }
    int[] f = new int[n];
    f[0] = 1;
    f[1] = 2;
    for(int i = 2; i < n; i++){
        f[i] = f[i-1] + f[i-2];
    }
    return f[n-1];
}
