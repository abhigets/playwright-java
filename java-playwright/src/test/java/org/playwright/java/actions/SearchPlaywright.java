package org.playwright.java.actions;

import com.microsoft.playwright.Page;

public class SearchPlaywright {
    public static void searchPlaywright(Page page) {
        page.locator("input[name=\"search\"]").click();
        page.locator("input[name=\"search\"]").fill("playwright");
        page.locator("input[name=\"search\"]").press("Enter");
    }
}
