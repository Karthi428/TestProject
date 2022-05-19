Feature: Verify searched page functionality
	@smoketest
  Scenario: Verify list of waterbottle is present
    Given Browser is opened
    And navigate amazon webpage
    When entering waterbottle
    And click search button
    Then List of waterbottle is displayed
	