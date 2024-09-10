package org.playwright.java.common;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class PlaywrightManager {
    // Shared between all tests in this class.
    public static Playwright playwright = playwright = Playwright.create();
    Browser browser;

    // New instance for each test method.
    BrowserContext context;

    public Page createContextAndPage() {
        context = browser.newContext(
                new Browser.NewContextOptions()
//                .setRecordVideoDir(Paths.get("video/"))
//                .setRecordVideoSize(640,480)
        );
        return context.newPage();
    }

    public void launchBrowser() {
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)
        );
    }

    public void closeBrowser() {
        playwright.close();
    }

    public void closeContext() {
        context.close();
    }
}
