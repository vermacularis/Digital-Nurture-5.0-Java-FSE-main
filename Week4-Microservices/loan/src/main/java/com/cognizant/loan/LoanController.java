package com.cognizant.loan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * GET /loans/{number} -> dummy loan details.
 * Sample: { "number":"H00987987972342", "type":"car", "loan":400000, "emi":3258, "tenure":18 }
 */
@RestController
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable String number) {
        LOGGER.info("START getLoan({})", number);
        Loan loan = new Loan(number, "car", 400000, 3258, 18);
        LOGGER.info("END getLoan()");
        return loan;
    }
}
