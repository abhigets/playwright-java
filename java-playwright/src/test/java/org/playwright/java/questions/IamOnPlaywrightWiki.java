package org.playwright.java.questions;

import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IamOnPlaywrightWiki {
    public static void iAmOnPlaywrightWiki(Page page) {
        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
    }
}
