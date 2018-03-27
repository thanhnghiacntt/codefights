/*
A top secret message containing uppercase letters from 'A' to 'Z' has been encoded as numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent and you need to determine the total number of ways that the message can be decoded.

Since the answer could be very large, take it modulo 109 + 7.
*/
int mapDecoding(String message) {
    int result = 0;
    if(message.length() > 0){
        char[]arr = message.toCharArray();
        if(check(arr)){
            return count(arr);
        }
    }else{
        result = 1;
    }
    return result;
}

boolean check(char[]arr){
    for (int i = 0; i < arr.length; i++) {
        if(arr[i] == '0'){
            if(i == 0){
                return false;
            }
            if(arr[i-1] > '2' || arr[i-1] < '1'){
                return false;
            }
        }
    }
    return true;
}

int count(char[] arr) {
    int len = arr.length - 1;
    int[]f = new int[arr.length];

    switch (len) {
    case 0:
        f[0] = 1;
        break;
    case 1:
        f[0] = 1;
        f[1] = 1;
        if(arr[0] < '3' && arr[1] < '7' && arr[1] > '0'){
            f[1] = 2;
        }
        break;
    default:
        f[0] = 1;
        f[1] = 1;
        if(arr[0] < '3' && arr[1] < '7' && arr[1] > '0'){
            f[1] = 2;
        }
        for (int i = 2; i < f.length; i++) {
            char last = arr[i];
            char pre = arr[i-1];
            if(last == '0'){
                f[i] = f[i-2];
            }else{
                if(pre == '1' || (pre == '2' && last < '7')){
                    f[i] = f[i-1] + f[i-2];
                }else{
                    f[i] = f[i-1];
                }
            }
            f[i] = f[i]%1000000007;
        }
        break;
    }
    return f[len];
}