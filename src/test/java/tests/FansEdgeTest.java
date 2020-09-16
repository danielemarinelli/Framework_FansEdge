package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CollegeTeamsPage;
import pages.HomePage;
import pages.LogInPage;

import java.io.IOException;

public class FansEdgeTest extends TestBase{

    HomePage hp;
    LogInPage login;
    CollegeTeamsPage collegeTeams;

    @Test
    public void verifyWrongCredentials() throws Exception {

        hp = new HomePage(driver());
        //hp.searchTeamsCaps();
        hp.logInUser();
        login = new LogInPage(driver());
        login.insertCredentials();
        Assert.assertEquals(login.insertCredentials(),
                "Please provide a valid e-mail address.",
                "Wrong login Page!!");
        reporter().report(LogStatus.PASS,
                "Checking inserting wrong credentials",
                "Insert Invalid Credentials Test is Successfull");

    }

    @Test
    public void getTigerWoodsItems() throws Exception {

        hp = new HomePage(driver());
        int count = hp.searchTigerWoodsItems();

        Assert.assertEquals(count, 14,"Wrong number items");
        reporter().report(LogStatus.PASS,
                "Checking Tiger Woods Items in the page",
                "Tiger Woods Items Test is Successfull");

    }

    @Test
    public void getAllCollegeTeamsDisplayed() throws Exception {

        hp = new HomePage(driver());
        collegeTeams = hp.searchCollegeTeams();
        collegeTeams.getAllCollegeTeams();
        Assert.assertEquals(collegeTeams.getAllCollegeTeams(), 439,"Wrong number items");
        reporter().report(LogStatus.PASS,
                "Checking NCAA College teams in the page",
                "NCAA College Test is Successfull");

    }

    @Test
    public void getBillsCapsDisplayed() throws Exception {

        hp = new HomePage(driver());
        int countCaps = hp.searchTeamsCaps();

        Assert.assertEquals(countCaps, 5,"Wrong number items");
        reporter().report(LogStatus.PASS,
                "Checking Bills Caps with size 7 3/4 in the page",
                "Bills Caps Test is Successfull");

    }

}
