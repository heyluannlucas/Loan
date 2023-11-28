/**
 * A utility class for generating payment schedules for loans.
 *
 * This class provides a method to generate a payment schedule for a loan, based on the loan's interest, the number of installments, and a grace period in days.
 *
 * @author org.jala.university
 * @version 1.0
 * @since 2023-11-10
 */

package org.jala.university.utils;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PaymentScheduleGenerator {
    /**
     * Generates a payment schedule for a loan.
     *
     * @param interest        The loan's interest details.
     * @param numInstallments The number of installments in the payment schedule.
     * @param gracePeriodDays The grace period in days before each installment is due.
     * @return A list of strings representing the payment schedule for the loan.
     */
    public static List<String> generatePaymentSchedule(Interest interest, int numInstallments, int gracePeriodDays) {
        List<String> paymentSchedule = new ArrayList<>();
        BigDecimal totalAmountWithInterest = interest.getLoanAmount();

        BigDecimal installmentAmount = totalAmountWithInterest.divide(BigDecimal.valueOf(numInstallments), 2, RoundingMode.HALF_UP);
        Calendar dueDate = Calendar.getInstance();

        dueDate.add(Calendar.DAY_OF_MONTH, 30);

        for (int i = 0; i < numInstallments; i++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String installmentInfo = "Installment " + (i + 1) + " - Amount: " + installmentAmount + ", Due Date: " + dateFormat.format(dueDate.getTime());
            paymentSchedule.add(installmentInfo);
            dueDate.add(Calendar.DAY_OF_MONTH, gracePeriodDays);
        }

        return paymentSchedule;
    }

}
