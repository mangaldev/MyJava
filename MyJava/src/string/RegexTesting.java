package string;

/**
 * Created by mdev on 3/8/16.
 */

import java.util.ArrayList;
import java.util.List;

class RegexTesting {
    public static void main(String[] args) {
//        String title = "Redneck Island Ep. 405";
//        String title = "Skrillex: First of the Year (Equinox)";
        String title = "Madeline: 1234 Episodio 1 123";
//        String title = "Movies: PARENT TRAP (1998)";
//        String title = "Movies: PARENT TRAP (#abc) HD hd Hd";
        System.out.println("old title     = " + title);
        cleanTitle(title);
    }

    private static String cleanTitle(String title) {
        for (String regex : getRegexRulesForTitleCleanUp()) {
            title = title.replaceAll(regex, "");
        }
        System.out.println("cleaned title = " + title);
        return title;
    }

    public static List<String> getRegexRulesForTitleCleanUp() {
        List<String> regexRules = new ArrayList<String>();
        regexRules.add("#");
        regexRules.add("Unedited");
        regexRules.add("Widescreen Format");
        regexRules.add(" Unrated Version");
        regexRules.add(": Director's Cut");
        regexRules.add("(HD)?(hd)?");
        regexRules.add(" HD Version");
        regexRules.add(" Collector's Edition");
        regexRules.add(" L[i,I][v,V][e,E]");
        regexRules.add(" 3D");
//        given the string	afddadfa Episode:19 anc sdsf	assert that	matched result	equals	Episode:19	n/a
//        given the string	afddadfa epi:19 anc sdsf	assert that	matched result	equals	epi:19	n/a
//        given the string	afddadfa e:19 anc sdsf	assert that	matched result	equals	e:19	n/a
//        given the string	afddadfa E19 anc sdsf	assert that	matched result	equals	E19	n/a
//        given the string	fddadfa E  p :  112   19 anc sdsf	assert that	regex	does not match	n/a
//        given the string	fddadfa e  :  112   19 anc sdsf	assert that	matched result	equals	e  :  112	n/a
//        given the string	afddadfa e    112   19 anc sdsf	assert that	matched result	equals	e    112	n/a
//        given the string	afddadfa ep    112   19 anc sdsf	assert that	matched result	equals	ep    112	n/a
//        given the string	afddadfa E:19 anc sdsf	assert that	matched result	equals	E:19	n/a
//        given the string	afddadfa Ep:19 anc sdsf	assert that	matched result	equals	Ep:19	n/a
//        given the string	afddadfa Ep 19 anc sdsf	assert that	matched result	equals	Ep 19	n/a
//        given the string	afddadfa E    112   19 anc sdsf	assert that	matched result	equals	E    112	n/a
        regexRules.add(" [E,e][P,p]?\\.?i?(sode)?(sodio)?\\s*#?:?\\s*\\d+");
//        given the string	Sesame S45:02 HD	assert that	matched result	equals	 S45:02
//        given the string	Hunted S1   : 05	assert that	matched result	equals	 S1   : 05
        regexRules.add(" [S,s](eason)?\\s*#?:?\\s*\\d+\\s*:?\\s*[E,e]?\\s*(\\d+)?");
//        Remove  1/1 string from title
        regexRules.add(" \\d+\\/\\d+");
//        Remove  1-1 string from title
        regexRules.add(" \\d+-\\d+");
//        Remove (23) string from title
        regexRules.add(" \\(\\d*\\)");
//        (LIVE) (Equinox)
        regexRules.add(" \\(\\w*\\)");
//        Remove a combination if 3 digits .. like -> Horror 509 HD
        regexRules.add(" \\d{3,4}");
        regexRules.add(" - ");
        return regexRules;
    }



}