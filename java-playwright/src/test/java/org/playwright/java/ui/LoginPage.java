package org.playwright.java.ui;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    public static Locator userName(Page page){
        return page.locator("#username");
    }

    public static Locator password(Page page){
        return page.locator("#password");
    }

    public static Locator login(Page page){
        return page.locator("#Login");
    }
}
