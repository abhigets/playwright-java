package org.playwright.java.actions;

import com.microsoft.playwright.Page;

import static org.playwright.java.ui.FieldServicePage.fieldServiceTabLink;
import static org.playwright.java.ui.FieldServicePage.waitForFieldServicePage;

public class NavigateToFieldService {
    public static void navigateToFieldService(Page page) {
        fieldServiceTabLink(page).click();
        waitForFieldServicePage(page);
    }

}
