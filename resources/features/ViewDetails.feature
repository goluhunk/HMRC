@Login
Feature: View Details

  Scenario Outline: I am successfully logged in to ChoCs Servise and view my details
    Given I launch Browser
    When I am logged in with Nino "<nino>" and on Chocs service page
    Then I should see the below details on "Your Details" page
      | Personal Details          | Value          |
      | Name                      | <name>         |
      | National Insurance number | <nino>         |
      | Main address              | <m_address>    |
      | Postal address            | <p_address>    |
      | Contact preferences       | <contact_pref> |
      | Trusted Helpers           | <trusted_help> |
    And I close the browser 


    Examples: 
      | nino          | name         | m_address                         | p_address               | contact_pref | trusted_help                |
      | ER 87 24 14 B | Robert Smith | 1 Flixton Road Manchester M13 9GU | TestInt1 TestInt2 Malta | By post      | Manage your Trusted Helpers |