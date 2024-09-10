package org.playwright.java.actions;

import com.microsoft.playwright.Page;

import static org.playwright.java.ui.LoginPage.*;


public class NavigateToUATEnv {
    public static void navigateToUATEnv(Page page) {

        page.navigate("https://belronint--uktrg1.sandbox.lightning.force.com/");
        userName(page).fill("abhijeet.patil@belron.com.uktrg1");
        password(page).fill("Belron12");
        login(page).click();
        page.waitForURL("**/lightning*");
    }
}
