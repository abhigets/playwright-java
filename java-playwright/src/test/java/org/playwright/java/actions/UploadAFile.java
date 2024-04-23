package org.playwright.java.actions;

import com.microsoft.playwright.Page;

import static org.playwright.java.ui.UploadPage.uploadButtonLocator;

public class UploadAFile {
    public static void uploadAFile(Page page) {
        page.locator(uploadButtonLocator).click();
    }
}
