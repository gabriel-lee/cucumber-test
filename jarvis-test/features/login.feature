Feature: Login feature

	Background:
		Given I have opened the browser

	Scenario: As a valid user I can log into Liferay
		Given I navigate to "http://localhost:8080"
		And I click on link having text "Sign In"
		Then I wait for modal with id "signinmodal"
		And I clear input field having id "_com_liferay_login_web_portlet_LoginPortlet_login"
		Then I enter "test@liferay.com" into input field having id "_com_liferay_login_web_portlet_LoginPortlet_login"
		And I enter "asdf" into input field having id "_com_liferay_login_web_portlet_LoginPortlet_password"
		Then I click on element having class "btn" and text "Sign In"
		And I close driver
