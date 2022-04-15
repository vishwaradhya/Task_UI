@UI
Feature: This feature is to verify ‘did you mean’ functionality for wikipedia search 


@sceanrio1
Scenario: Verify ‘did you mean’ suggestion functionality for wikipedia search shown when user search with incorrect search criteria
	Given A visitor is on the wikipedia home page
	When The visitor searches for "furry rabbits"
	Then A "Did you mean" suggestion is displayed
	And The visitor can see 20 results
	
	
@sceanrio2
Scenario: Verify ‘did you mean’ suggestion functionality for wikipedia search
	Given A visitor is on the wikipedia home page
	And The visitor searches for "furry rabbits"
	And A visitor is on the search result page for "furry rabbits"
	When The visitor uses the "did you mean" feature to correct his search
	And select the first entry
	Then The visitor is on the article page of the first hit