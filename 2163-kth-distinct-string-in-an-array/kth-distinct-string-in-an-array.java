class Solution {
    public String kthDistinct(String[] arr, int k) {
        ArrayList<String> al = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();

        for(String s : arr)
        {
            hm.put(s,hm.getOrDefault(s,0)+1);
        }

        for(int i=0;i<arr.length;i++)
        {
            if(hm.get(arr[i]) == 1)
            {
                al.add(arr[i]);
            }
        }

        if(al.size() >= k)
        {
            return al.get(k-1);
        }
        else
        {
            return "";
        }
    }
}