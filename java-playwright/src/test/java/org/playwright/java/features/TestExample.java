package org.playwright.java.features;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.playwright.java.actions.NavigateToWiki;
import org.playwright.java.actions.SearchPlaywright;
import org.playwright.java.actions.UploadAFile;
import org.playwright.java.common.PlaywrightManager;
import org.playwright.java.actions.NavigateToVirusTotalDotCom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.playwright.java.actions.NavigateToVirusTotalDotCom.navigateToVirusTotalDotCom;
import static org.playwright.java.actions.NavigateToWiki.navigateToWiki;
import static org.playwright.java.actions.SearchPlaywright.searchPlaywright;
import static org.playwright.java.actions.UploadAFile.uploadAFile;
import static org.playwright.java.questions.IamOnPlaywrightWiki.iAmOnPlaywrightWiki;

public class TestExample {

    static PlaywrightManager playwrightManager;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwrightManager = new PlaywrightManager();
        playwrightManager.launchBrowser();
    }

    @AfterAll
    static void closeBrowser() {
        playwrightManager.closeBrowser();
    }

    @BeforeEach
    void createPage() {
        page= playwrightManager.createContextAndPage();
    }

    @AfterEach
    void closeContext() {
        playwrightManager.closeContext();
    }

    @Test
    void shouldClickButton() {
        page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
        page.locator("button").click();
        assertEquals("Clicked", page.evaluate("result"));
    }

    @Test
    void shouldCheckTheBox() {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.locator("input").check();
        assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
    }

    @Test
    void shouldSearchWiki() {
        navigateToWiki(page);
        searchPlaywright(page);
        iAmOnPlaywrightWiki(page);
    }


    @Test
    void shouldInteractWithShadowDom() {
        navigateToVirusTotalDotCom(page);
        uploadAFile(page);
    }
}