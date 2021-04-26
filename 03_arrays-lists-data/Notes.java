
public String reverse(String s){
    String ret = "";
    for (int k=0; k < s.length(); k +=1){
        ret = s.charAt(k) + ret;
    }
    return ret;
}