package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

import java.util.List;

public class CollegeTeamsPage extends TestBase {

    @FindBy(xpath ="((.//div[@class='team-list-column'])[2])//following-sibling::a")
    private List<WebElement> listCollegeTeams1;

    @FindBy(xpath ="((.//div[@class='team-list-column'])[3])//following-sibling::a")
    private List<WebElement> listCollegeTeams2;

    @FindBy(xpath ="((.//div[@class='team-list-column'])[5])//following-sibling::a")
    private List<WebElement> listCollegeTeams3;

    @FindBy(xpath ="((.//div[@class='team-list-column'])[6])//following-sibling::a")
    private List<WebElement> listCollegeTeams4;

    private WebDriver driver;
    public CollegeTeamsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public int getAllCollegeTeams(){
        int teamInColumn1 = listCollegeTeams1.size();
        System.out.println("TOTAL DISPLAYED TEAMS NUMBER in FIRST COLUMN: " +teamInColumn1);
        for(WebElement collegeTeam1 : listCollegeTeams1){
            System.out.println(":::::::");
            System.out.println(collegeTeam1.getText());
        }
        System.out.println("===========");
        int teamInColumn2 = listCollegeTeams2.size();
        System.out.println("TOTAL DISPLAYED TEAMS NUMBER in SECOND COLUMN: " +teamInColumn2);
        for(WebElement collegeTeam2 : listCollegeTeams2){
            System.out.println(":::::::");
            System.out.println(collegeTeam2.getText());
        }
        System.out.println("===========");
        int teamInColumn3 = listCollegeTeams3.size();
        System.out.println("TOTAL DISPLAYED TEAMS NUMBER in THIRD COLUMN: " +teamInColumn3);
        for(WebElement collegeTeam3 : listCollegeTeams3){
            System.out.println(":::::::");
            System.out.println(collegeTeam3.getText());
        }
        System.out.println("===========");
        int teamInColumn4 = listCollegeTeams4.size();
        System.out.println("TOTAL DISPLAYED TEAMS NUMBER in FOURTH COLUMN: " +teamInColumn4);
        for(WebElement collegeTeam4 : listCollegeTeams4){
            System.out.println(":::::::");
            System.out.println(collegeTeam4.getText());
        }
        System.out.println("===========");
        System.out.println("===========");
        int totalTeams=teamInColumn4+teamInColumn3+teamInColumn2+teamInColumn1;
        System.out.println("TOTAL DISPLAYED TEAMS ARE: " +totalTeams);
        return totalTeams;
    }

}
