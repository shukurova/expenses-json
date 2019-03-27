package helpers;

import model.Details;
import model.Expenses;
import model.User;

import java.util.HashMap;
import java.util.List;

public class GetTotalAmount {

    public static HashMap<String, Integer> getTotalAmountByCategory(final User user,
                                                                    final List<String> neededCategory) {
        HashMap<String, Integer> result = new HashMap<>();
        List<Expenses> expenses = user.getExpenses();
        for (String c : neededCategory) {
            int sum = 0;
            for (Expenses expense : expenses) {
                List<Details> details = expense.getDetails();
                for (Details detail : details) {
                    String category = detail.getCategory();
                    int amount = detail.getAmount();
                    if (category.equalsIgnoreCase(c)) {
                        sum += amount;
                    }
                }
                result.put(c, sum);
            }
        }
        return result;
    }
}
