package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.PageObjects;

public class TestSteps {

	public WebDriver driver;
	PageObjects object = new PageObjects(driver);
	
	
	@Before
	public void startBrowser() {
		object.chromeDriver();
	}
	
	@After
	public void closeBrowser() {
		object.closeBrowser();
	}

	@Given("^User is on Google home page$")
	public void user_is_on_google_home_page() {
		object.getGoogle();
	}

	@Given("^User is on TruNarrative home$")
	public void user_is_on_TruNarrative_home() {
		object.getTruNarrative();
	}

	@Given("^User has navigated to Team Page$")
	public void user_has_navigated_to_team_page() throws Exception {
		object.goToTeamPage();
	}

	@When("^TruNarrative is searched for$")
	public void trunarrative_is_searched_for() {
		object.searchTruNarrative();
	}

	@When("^TruNarrative home page is displayed$")
	public void trunarrative_home_page_is_displayed() throws Exception {
		object.checkHomeTitle();
	}
	
	@When("^Team members are counted$")
	public void team_members_are_counted() {
		object.findTeamMembers();
	}

	@When("^John Lords info is viewed$")
	public void john_lords_info_is_viewed() {
		object.findJohnLord();
	}

	@When("^David Eastaughs info is viewed$")
	public void david_eastaughs_info_is_viewed() {
		object.findDavidEastaugh();
	}

	@When("^Nicola Janneys info is viewed$")
	public void nicola_janneys_info_is_viewed() {
		object.findNicolaJanney();
	}

	@Then("^TruNarrative is the first result$")
	public void trunarrative_is_the_first_result() {
		object.waitForFirstLink();
	}

	@Then("^Strap line is present$")
	public void strap_line_is_present() {
		object.findStrapline();
	}

	@Then("^There are eight team members in total$")
	public void there_are_eight_team_members_in_total() {
		object.countTeamMembers();
	}

	@Then("^he has role Founder and CEO$")
	public void he_has_role_founder_and_ceo() throws Exception {		
		object.hasRoleFounder();
	}

	@Then("^he has role CTO$")
	public void he_has_role_cto() throws Exception {
		object.hasRoleCto();
	}

	@Then("^she has role Human Resources Manager$")
	public void she_has_role_human_resources_manager() throws Exception {
		object.hasRoleHr();
	}

	@And("^it points to TruNarrative home$")
	public void it_points_to_trunarrative_home() {
		object.pointsToTnHome();
	}
}