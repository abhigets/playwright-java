package org.playwright.java.ui;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FieldServicePage {
    public static Locator fieldServiceTabLink(Page page) {
        page.waitForSelector("a[title=\"Field Service\"]");
        return page.locator("a[title=\"Field Service\"]");
    }

    public static void waitForFieldServicePage(Page page) {
        page.waitForSelector("iframe[title=\"Field Service\"]").contentFrame();
    }

    public static FrameLocator getFieldServiceFrame(Page page) {
        return page.frameLocator("iframe[title=\"Field Service\"]");
    }
}
