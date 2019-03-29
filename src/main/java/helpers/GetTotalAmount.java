package helpers;

import model.Details;
import model.Expenses;
import model.User;

import java.util.HashMap;
import java.util.List;

public class GetTotalAmount {

    public static HashMap<String, Integer> getTotalAmountByCategory(final User user) {
        HashMap<String, Integer> result = new HashMap<>();
        List<Expenses> expenses = user.getExpenses();
        for (Expenses expense : expenses) {
            String category;
            List<Details> details = expense.getDetails();
            for (Details detail : details) {
                category = detail.getCategory();
                int amount = detail.getAmount();
                if (result.get(category) == null) {
                    result.put(category, amount);
                } else {
                    int localSum = result.get(category) + amount;
                    result.put(category, localSum);
                }
            }
        }
        return result;
    }
}
