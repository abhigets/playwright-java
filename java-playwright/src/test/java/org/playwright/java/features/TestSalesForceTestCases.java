package org.playwright.java.features;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.playwright.java.common.PlaywrightManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.playwright.java.actions.NavigateToUATEnv.navigateToUATEnv;
import static org.playwright.java.actions.ServiceAppointment.*;
import static org.playwright.java.actions.NavigateToFieldService.navigateToFieldService;
import static org.playwright.java.questions.IamOnFrontOfficeHomePage.amIOnHomePage;
import static org.playwright.java.ui.FieldServicePage.ServiceAppointmentType.Arrived;
import static org.playwright.java.ui.FieldServicePage.ServiceAppointmentType.FailedOnArrival;

public class TestSalesForceTestCases {

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


    //FOUK-127 Flag Failed Jobs on Arrival
    @Test
    void shouldBeAbleToSetFailedOnArriveState()  {
        navigateToUATEnv(page);
        assertTrue(amIOnHomePage(page));
        navigateToFieldService(page);
        viewServiceAppointmentThat(Arrived,page);
        ChangeStatusAsFailedAfterArrival(page);
        viewServiceAppointmentThat(FailedOnArrival,page);
    }

    //FOUK-145 Appointment Tooltip
    @Test
    void shouldBeAbleToSeeAppointmentTooltip()  {
        navigateToUATEnv(page);
        assertTrue(amIOnHomePage(page));
        navigateToFieldService(page);
        //Account ID:  M SMITH
        assertTrue(appointmentToolTipValueGreaterThan("Account ID:", page));
        //Remedy Job Id:  000001024673696
        assertTrue(appointmentToolTipValueGreaterThan("Remedy Job Id:", page));
        // Work Type ID:  Stock Collect
        assertTrue(appointmentToolTipValueGreaterThan("Work Type ID:", page));
        // Zip/Postal Code:  MK44 3US
        assertTrue(appointmentToolTipValueGreaterThan("Zip/Postal Code:", page));
        // Is Branch Appointment?:
        assertTrue(appointmentToolTipCheckBoxIsChecked("Is Branch Appointment?:", page));
        // Make Of Vehicle:  MERCEDES CARS
        assertTrue(appointmentToolTipValueGreaterThan("Make Of Vehicle:", page));
        // Model Of Vehicle:  GLA
        assertTrue(appointmentToolTipValueGreaterThan("Model Of Vehicle:", page));
        // Gantt Label:  M SMITH / FP67FSD
        assertTrue(appointmentToolTipValueGreaterThan("Gantt Label:", page));
        // Work Order Number:  00003862
        assertTrue(appointmentToolTipValueGreaterThan("Work Order Number:", page));
        // Status:  Dispatched
        assertTrue(appointmentToolTipValueGreaterThan("Status:", page));
        // Earliest Start Permitted:  Tue, 30 Apr 2024 07:00
        assertTrue(appointmentToolTipValueGreaterThan("Earliest Start Permitted:", page));
        // Due Date:  Fri, 3 May 2024 10:30
        assertTrue(appointmentToolTipValueGreaterThan("Due Date:", page));
        // Start Fri, 3 May 2024 08:00
        assertTrue(appointmentToolTipValueGreaterThan("Start", page));
        // Finish Fri, 3 May 2024 08:05
        assertTrue(appointmentToolTipValueGreaterThan("Finish", page));
    }

}