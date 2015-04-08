package client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


class ChefOfyear {
    public ChefOfyear() {
        super();
    }
    private static Map<String, Integer> mapCountryChefNum = null;
    private static Map<String, String> mapChefCountryName = null;
    private static Map<String, Integer> mapChefVoteNum = null;

    public static void main(String[] args) {
        String strChef;
        String strCountryName;
        mapCountryChefNum = new HashMap<String, Integer>();


        InputReader ir = new InputReader(System.in);
        int numberOfChefs = ir.nextInt();
        mapChefCountryName = new HashMap<String, String>(numberOfChefs);
        mapChefVoteNum = new HashMap<String, Integer>(numberOfChefs);
        String countryWithMaxChef = null;
        String chefWithMaxVote = null;
        int maxVoteCount = 0;
        int maxChefInACountry = 0;
        int numOfMails = ir.nextInt();
        int temp = numberOfChefs;
        while (temp > 0) {
            temp--;
            strChef = ir.next();
            strCountryName = ir.next();
            mapChefCountryName.put(strChef, strCountryName);
            mapCountryChefNum.put(strCountryName, 0);
            mapChefVoteNum.put(strChef, 0);
        }
        temp = numOfMails;

        while (temp > 0) {
            temp--;
            strChef = ir.next();
            int lastVoteCount = mapChefVoteNum.get(strChef) + 1;
            if (maxVoteCount == 0 || maxVoteCount < lastVoteCount) {
                maxVoteCount = lastVoteCount;
                chefWithMaxVote = strChef;
            }
            if (maxVoteCount == lastVoteCount) {
                if (strChef.compareTo(chefWithMaxVote) < 0) {
                    chefWithMaxVote = strChef;
                }
            }
            mapChefVoteNum.put(strChef, lastVoteCount);
            String chefCountry = mapChefCountryName.get(strChef);
            int lastCountryChefCount = mapCountryChefNum.get(chefCountry) + 1;
            if (maxChefInACountry == 0 ||
                maxChefInACountry < lastCountryChefCount) {
                maxChefInACountry = lastCountryChefCount;
                countryWithMaxChef = chefCountry;
            }
            if (maxChefInACountry == lastCountryChefCount) {
                if (chefCountry.compareTo(countryWithMaxChef) < 0) {
                    countryWithMaxChef = chefCountry;
                }
            }
            mapCountryChefNum.put(chefCountry, lastCountryChefCount);
        }

        System.out.println(countryWithMaxChef);
        System.out.println(chefWithMaxVote);
        mapCountryChefNum.clear();
        mapChefCountryName.clear();
        mapChefVoteNum.clear();
    }
}