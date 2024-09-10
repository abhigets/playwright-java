package org.playwright.java.questions;

import com.microsoft.playwright.Page;
import org.playwright.java.ui.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IamOnFrontOfficeHomePage {
    public static boolean amIOnHomePage(Page page) {
        return HomePage.belronLogo(page).first().isVisible();
    }
}
