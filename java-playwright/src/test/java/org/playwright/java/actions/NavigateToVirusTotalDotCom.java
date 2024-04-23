package org.playwright.java.actions;

import com.microsoft.playwright.*;

public class NavigateToVirusTotalDotCom {
    static String url = "https://www.virustotal.com/gui/home/upload";
    public static void navigateToVirusTotalDotCom(Page page){
        page.navigate(url);
    }
}
