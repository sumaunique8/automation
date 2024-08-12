@PocScenario
Feature: feature to test Cv Functionality and Client Filter

  @Scenario1_Creating_Automatic_Number_&_Deleting
  Scenario Outline: Scenario1_Creating_Automatic_Number_&_Deleting
    Given Browser is opened
    When User search for Application URL
    Then Switch to Frame<frame>
    When User select Branch<branchID>
    Then Click on main menu<MainMenu>
    Then Click on sub menu<submenu>
    Then Click on Crea Numero Automatico button
    Then Enter UserName<name>
    Then Enter SurName<surname>
    Then Select Gender
    Then Enter DOB
    Then Enter Address_Town
    Then Enter AddressStreet
    Then Enter Contact Number
    Then Enter E-mail
    Then Enter profession
    Then Switch to Frame<ChildFrame1>
    Then Select Area Proffession
    Then Select Sotto-Area Professionale
    Then Click on Confirm button on ChildFrame
    Then Switch to Default frame
    Then Select Fonte di reclutamento
    Then Switch to Frame<ChildFrame2>
    Then Upload CV on Curriculum Vitae in allegato
    Then Switch to Default frame
    Then Select Option Presa visione on Dichiarazione di Consenso
    Then Select Option Consenso concesso on Dichiarazione di Consenso
    Then Select Data firma modulo privacy in filiale
    Then Switch to Frame<ChildFrame3>
    Then Upload CV on Curriculum Vitae in Documenti Allegati Privacy Firmata
    Then Switch to Default frame
    Then Click on Save button
    Then Switch to Frame<ChildFrame4>
    Then Click on Confirm on ChildFrame4
    Then Switch to Default frame
    Then Switch to Frame<ChildFrame4>
    Then Click on Confirm on ChildFrame4
    Then Switch to Default frame
    Then Click on Delete button
    Then Switch to Frame<ChildFrame4>
    Then Click Confirm button on ChildFrame4

    Examples: 
     |name    |surname|MainMenu |submenu       |frame     |ChildFrame1     |ChildFrame2   |ChildFrame3        |ChildFrame4     |branchID|
     |Test001 |Test   |Candidati|Inserisci CV  |iFrameMain|TB_iframeContent|iFrameInsertCV|iFrameInsertPrivacy|TB_iframeContent|0594     |


 @Scenario_2:ClientFilter_&_getting_History_of_orders
  Scenario Outline: ClientFilter_&_getting_History_of_orders
    Given Browser is opened
    When User search for Application URL
    Then Switch to Frame<frame>
    When User select Branch<branchID>
    Then Select Option Ricerca e selezione
    Then Click on main menu<MainMenu>
    Then Click on sub menu<submenu>
    #Then Accept Alert
    Then Switch to Frame<ChildFrame5>
    Then Switch to Frame<ChildFrame6>
    Then Select Client
    Then Click on Applica Filtro button
    Then Click on Mostra altre info button
    Then Switch to Default frame
    Then Click on Close button
    #Then Accept Alert
    Then Switch to Default frame
    Then Click on main menu<MainMenu>
    Then Click on sub menu<submenu>
    #Then Accept Alert
    Then Switch to Frame<ChildFrame5>
    Then Switch to Frame<ChildFrame6>
    Then Select Client
    Then Click on Applica Filtro button
    Then Switch to Default frame
    Then Click on Storico stati dellordine button
    
Examples: 
      |MainMenu |submenu       |frame     |ChildFrame5            |ChildFrame6                 |branchID|
      |Ordine   |Copri Ordine  |iFrameMain|IFrameWorkOrderCovering|IFrameWorkOrderCoveringStep1|0736    |
  