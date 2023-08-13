Feature: Order with different quantities

  Scenario Outline: Add HP Pen Drive to cart with different quantities

    Given User searches for HP Pen Drive
    When Add the first result on the page with quantity <qty>
    Then Cart should display <qty> pen drive

    Examples:
      | qty |
      | 1   |
      | 5   |
      | 10  |