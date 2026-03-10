
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML private TextField number1Field;
    @FXML private TextField number2Field;
    @FXML private Label resultLabel;

    @FXML
    private void onCalculateClick() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());

            double sum        = num1 + num2;
            double difference = num1 - num2;
            double product    = num1 * num2;
            double quotient;

            if (num2 == 0) {
                resultLabel.setText("Division by zero is not allowed!");
                return;
            }
            quotient = num1 / num2;

            resultLabel.setText(
                "Sum: " + sum +
                ", Subtract: " + difference +
                ", Product: " + product +
                ", Division: " + quotient
            );

            // Save to DB
            ResultService.saveResult(num1, num2, sum, difference, product, quotient);

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }
}
