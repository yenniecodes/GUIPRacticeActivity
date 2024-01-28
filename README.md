# GUIPRacticeActivity Pseudocode
Class MilestoneCalculator:
    Initialize GUI components:
        milestone1Label, milestone2Label, terminalLabel, resultLabel: JLabel
        milestone1Field, milestone2Field, terminalField: JTextField
        calculateButton: JButton
    Implement constructor to set up the GUI:
        Set title, size, default close operation, and location of JFrame
        Create JPanel with GridLayout(4, 2)
        Add JLabels, JTextFields, JButton, and resultLabel to the panel
        Add panel to JFrame
        Set JFrame visible

    Implement actionPerformed method:
        If calculateButton is clicked:
            Try:
                Parse grades from milestone1Field, milestone2Field, and terminalField as doubles
                Create instance of GradeCalculator with parsed grades
                Calculate total grade using GradeCalculator
                If total grade exceeds 100:
                    Display error message
                Else:
                    Update resultLabel with total grade
            Catch NumberFormatException:
                Display error message for invalid input

Class GradeCalculator:
    Initialize private variables milestone1Grade, milestone2Grade, terminalGrade as doubles
    Implement constructor to initialize grades:
        Set milestone1Grade, milestone2Grade, and terminalGrade to provided values

    Implement calculateTotalGrade method:
        Calculate totalGrade as sum of milestone1Grade, milestone2Grade, and terminalGrade
        Return totalGrade

Main method:
    Create instance of MilestoneCalculator
