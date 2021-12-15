Feature: Associate Service

  @AddAssociate
  Scenario Outline: Add associate
    Given the add associate payload is given with "<associateType>" "<memberIdentifier>"
    When for "AddAssociateAPI" "POST" method is used
    Then associate is added with status code 201
    And verify "<memberIdentifier>" using "RetrieveAssociateAPI"  and "GET" method

    Examples:
      | associateType | memberIdentifier |
      | GUARDIAN      | 45172371         |

  @DeleteAssociate
  Scenario: Delete Associate
    Given the delete associate payload is given
    When for "DeleteAssociateAPI" "POST" method is used
    Then associate is added with status code 200
    And verify "<memberIdentifier>" using "RetrieveAssociateAPI"  and "GET" method

