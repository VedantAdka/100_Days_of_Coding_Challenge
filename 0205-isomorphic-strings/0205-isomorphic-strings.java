class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mpp=new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        else{
            for(int i=0;i<s.length();i++){
                if(mpp.containsKey(s.charAt(i))){
                    if(!(mpp.get(s.charAt(i)).equals(t.charAt(i)))){
                        return false;
                    }
                }
                else{
                    if(mpp.containsValue(t.charAt(i))){
                        return false;
                    }
                    mpp.put(s.charAt(i),t.charAt(i));
                }
            }
            return true;
        }
    }
}