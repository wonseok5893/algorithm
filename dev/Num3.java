package dev;

import java.util.HashMap;
import java.util.Map;

public class Num3 {
    public static void main(String[] args) {
        new Num3().solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
                , new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
                , new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10});
    }
    static Map<String, Integer> getProfit = new HashMap<>();
    static Map<String, String> parentMap = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (String name : enroll) {
            getProfit.put(name, 0);
        }
        getProfit.put("CENTER", 0);
        //Parent가 누구인지 ->
        for (int i = 0; i < referral.length; i++) {
            String parent = referral[i];
            if(parent.equals("-")) parentMap.put(enroll[i], "CENTER");
            else parentMap.put(enroll[i], parent);
        }
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int profit = amount[i] * 100;
            addProfitToParentAndMe(sellerName, profit);
        }

        int[] ans = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            ans[i] = getProfit.get(enroll[i]);
        }
        return ans;
    }

    private void addProfitToParentAndMe(String sellerName, int profit) {
        if (parentMap.get(sellerName)==null||profit / 10 < 1) {
            getProfit.put(sellerName,getProfit.get(sellerName)+profit);
            return;
        }else{
            getProfit.put(sellerName, getProfit.get(sellerName) + profit - (profit / 10));
            addProfitToParentAndMe(parentMap.get(sellerName),profit / 10);
        }
    }
}
