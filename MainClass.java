class Solution {
    public boolean isValid(String s)
    {
     HashMap<Character,Character> obj= new HashMap<Character,Character>();
        obj.put(')','(');
        obj.put('}','{');
        obj.put(']','[');
         
        Stack<Character> obj1 = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            char a1 = s.charAt(i);
            char b;            
            if(obj.containsValue(a1))
                obj1.push(a1);
            else if(obj.containsKey(a1))
                {
                b = obj.get(a1);
                if(obj1.empty())
                {
                   return false; 
                }
                else
                {
                   if(obj1.pop()!= b)
                        return false; 
                }
                }
            
        }
      return obj1.isEmpty();  
    }
}

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            boolean ret = new Solution().isValid(s);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}