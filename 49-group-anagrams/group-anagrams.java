class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(String str : strs)
        {
            char word[] = str.toCharArray();
            Arrays.sort(word);
            String newWord = new String(word);

            if(!mp.containsKey(newWord))
            {
                ArrayList<String> lst= new ArrayList<>();
                lst.add(str);
                mp.put(newWord, lst);
            }
            else
            {
                mp.get(newWord).add(str);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entries: mp.entrySet())
        {
            result.add(entries.getValue());
        }
        return result;
    }
}