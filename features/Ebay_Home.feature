#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#First crear archivo de features y correlo como un proyecto cucumber
#Second Crear los step definitions con la definicion de las pruebas
#Third crear el runner
Feature: Ebay Home Page Scenarios

  @Homepage @taggedHook @afterTaggedHook
  Scenario: Advanced Search Link
    Given I am on Ebay Page
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  @Homepage1
  Scenario: Search item count
    #Sin parametros
    #Given I am on Ebay Page
    #When I search for iphone 11
    #Then I validate at least 1000 items are present
    #Con parametros
    Given I am on Ebay Page
    When I search for 'iphone 11'
    Then I validate at least 1000 items are present

  @Homepage1
  Scenario: Search item huawei
    Given I am on Ebay Page
    When I search for 'Huawei'
    Then I validate at least 5000 items are present

  @Homepage1
  Scenario: Search item watch
    Given I am on Ebay Page
    When I search for 'watch'
    Then I validate at least 100 items are present

  @Homepage2 @taggedHook
  Scenario: Search item in category
    Given I am on Ebay Page
    When I search for 'pintura' in 'Arte' category

  @HomePageLinks @taggedHook @afterTaggedHook
  Scenario Outline: Home page links
    Given I am on Ebay Page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples: 
      | link       | url                                                         | title                   |
      | Tecnología | https://mx.ebay.com/b/Electronics/bn_7000259124             | Electronics             |
      | Moda       | https://mx.ebay.com/b/Fashion/bn_7000259856                 | Moda                    |
      | Vehículos  | https://mx.ebay.com/b/Auto-Parts-Accessories/6028/bn_569479 | Auto PARTS & Accessorie |
      | Deportes   | https://mx.ebay.com/b/Sporting-Goods/888/bn_1865031dddd     | Deportes                |
