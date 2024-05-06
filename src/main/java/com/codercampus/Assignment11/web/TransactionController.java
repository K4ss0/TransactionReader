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
		List <Transaction> transactions = transactionService.getAllTransactions();
		model.addAttribute("transactions", transactions);
		return "transactions";
	}
	
	@GetMapping("/transaction/{id}")
	public String getTransactionByID(@PathVariable Long id, Model model) {
		Transaction transaction = transactionService.getTransactionById(id);
		model.addAttribute("transaction", transaction);
		return "transactionid";
	}

}
