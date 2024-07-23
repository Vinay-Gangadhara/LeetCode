class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        /**
        -------> Main Idea
        1. Create an map that stores least possible value of a word(Asc order) and values the words when sorted equals to the key.
        2. Once we pair them we know the Values are all grouped in there anagrams.
        3. just return the values as answer.
         */
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