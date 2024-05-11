package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transactions")
	public String getTransactions(Model model) {
		List<Transaction> transactions = transactionService.getAllTransactionsSortedByDate();
		model.addAttribute("transactions", transactions);
//		System.out.println(transactions);
		return "transactions";
	}
	@GetMapping("/transaction/{id}")
    public String getTransactionDetails(@PathVariable Long id, Model model) {
        Transaction transaction = transactionService.getTransactionById(id);
        model.addAttribute("transactionDetails", transaction);
        return "transactions";
	}
}
