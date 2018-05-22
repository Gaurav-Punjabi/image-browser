/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flickr.demonstation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gauravpunjabi
 */
public class FlickrDemonstation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String linkPatternString = "<link.*href=\"([\\w\\-\\d.:/_]*)\"/>";
        String imagePatternString = "<img.*src=\"//([\\w\\-\\d./_]*).*>";
        String s = "<img width=\"866\" height=\"519\" src=\"//c1.staticflickr.com/5/4790/39850977415_c4ede85fc9_n.jpg\" class=\"low-res-photo\" alt=\"IMG_20180301_144128804_BURST000_COVER_TOP | by EadaoinFlynn\">";
    }
    
}
