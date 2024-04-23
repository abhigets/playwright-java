package org.playwright.java.actions;

import com.microsoft.playwright.Page;

public class NavigateToWiki {
    public static void navigateToWiki(Page page){
        page.navigate("https://www.wikipedia.org/");
    }
}
