package org.playwright.java.ui;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    public static Locator belronLogo(Page page){
        return page.locator(".slds-global-header__logo");
    }
}
