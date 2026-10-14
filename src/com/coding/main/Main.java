package com.coding.main;

import com.coding.dto.SessionEvent_P12;
import com.coding.dto.SessionSummary_P12;
import com.coding.dto.Dependency_P11;
import com.coding.dto.AccountTransaction_P10;
import com.coding.dto.AccountBalance_P10;
import com.coding.dto.Employee_P9;
import com.coding.dto.Employee_P8;
import com.coding.dto.SubstringResult_P7;
import com.coding.dto.Product_P6;
import com.coding.dto.InventoryMismatch_P6;
import com.coding.dto.AnagramGroup_P5;
import com.coding.dto.WordCount_P4;
import com.coding.dto.LogEntry_P3;
import com.coding.dto.Order_P2;
import com.coding.dto.OrderSummary_P2;
import com.coding.dto.Transaction_P1;
import com.coding.dto.Customersummary_P1;
import com.coding.service.ProblemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ProblemService service = new ProblemService();
        List<Transaction_P1> transactions = new ArrayList<>();
        transactions.add(new Transaction_P1("C1", "CREDIT", 1000));
        transactions.add(new Transaction_P1("C1", "DEBIT", 200));
        transactions.add(new Transaction_P1("C2", "CREDIT", 500));
        transactions.add(new Transaction_P1("C1", "CREDIT", 300));
        List<Customersummary_P1> summaries = service.customerTransactionAggregator(transactions);
        System.out.println("Problem 1- Customer Transaction Aggregator");
        for (Customersummary_P1 summary : summaries) {
            System.out.println(summary);
        }
        System.out.println();
        List<Order_P2> orders=new ArrayList<>();
        orders.add(new Order_P2("O1","C1",100));
        orders.add(new Order_P2("O2","C1",200));
        orders.add(new Order_P2("O3","C2",150));
        List<OrderSummary_P2>orderSummaries=service.groupOrdersByCustomer(orders);
        System.out.println("Problem 2- Group Orders by Customer");
        for(OrderSummary_P2 Summary:orderSummaries){
            System.out.println(Summary);
        }
        System.out.println();
        List<LogEntry_P3> logs=new ArrayList<>();
        logs.add(new LogEntry_P3("ERROR","DB Failed"));
        logs.add(new LogEntry_P3("INFO","Login Success"));
        logs.add(new LogEntry_P3("ERROR","Timeout"));
        logs.add(new LogEntry_P3("WARN","Disk High"));
        Map<String,Integer> logResults=service.logAnalytics(logs);
        System.out.println("Problem 3- Log Analytics");
        for(Map.Entry<String,Integer>entry:logResults.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        System.out.println();
        String paragraph="java spring java kafka spring java redis";
        List<WordCount_P4> topWords=service.top3FrequentWords(paragraph);
        System.out.println("Problem 4- Top 3 Frequent Words");
        for(WordCount_P4 wordCount:topWords){
            System.out.println(wordCount);
        }
        System.out.println();
        List<String>anagramWords=new ArrayList<>();
        anagramWords.add("eat");
        anagramWords.add("tea");
        anagramWords.add("ate");
        anagramWords.add("tan");
        anagramWords.add("nat");
        anagramWords.add("bat");
        List<AnagramGroup_P5>anagramGroups=service.groupAnagrams(anagramWords);
        System.out.println("Problem 5- Group Anagrams");
        for(AnagramGroup_P5 group:anagramGroups){
            System.out.println(group);
        }
        List<Product_P6>warehouseProducts= new ArrayList<>();
        warehouseProducts.add(new Product_P6("P1",100));
        warehouseProducts.add(new Product_P6("P2",200));
        List<Product_P6>storeProducts=new ArrayList<>();
        storeProducts.add(new Product_P6("P1",90));
        storeProducts.add(new Product_P6("P2",200));
        List<InventoryMismatch_P6>mismatches= service.reconcileinventory(warehouseProducts,storeProducts);
        for(InventoryMismatch_P6 mismatch:mismatches){
            System.out.println(mismatch);
        }
        String input="aabacbebebe";
        int k=3;
        SubstringResult_P7 substringResult= service.longestSubstringWithKDistinct(input,k);
        System.out.println(substringResult);

        List<Employee_P8>employees=new ArrayList<>();
        employees.add(new Employee_P8(1,"CEO",null));
        employees.add(new Employee_P8(2,"Manager",1));
        employees.add(new Employee_P8(3,"Dev1",2));
        employees.add(new Employee_P8(4,"Dev2",2));
        service.buildEmployeeHierarchy(employees);

        List<Employee_P9>employeesP9=new ArrayList<>();
        employeesP9.add(new Employee_P9("John","IT",10,4.5));
        employeesP9.add(new Employee_P9("Alice","IT",10,4.8));
        employeesP9.add(new Employee_P9("Bob","HR",12,4.7));
        List<Employee_P9>sortedEmployeesP9=service.sortEmployees(employeesP9);
        for(Employee_P9 employee:sortedEmployeesP9){
            System.out.println(employee);
        }
        List<AccountTransaction_P10>transactionP10=new ArrayList<>();
        transactionP10.add(new AccountTransaction_P10("A1","CREDIT",1000));
        transactionP10.add(new AccountTransaction_P10("A1","DEBIT",400));
        transactionP10.add(new AccountTransaction_P10("A2","CREDIT",700));
        List<AccountBalance_P10>accountBalancesP10=
                service.processAccountBalances(transactionP10);
        for(AccountBalance_P10 accountBalance:accountBalancesP10){
            System.out.println(accountBalance);
        }
        AccountBalance_P10 topAccountp10=
                service.findTopAccount(accountBalancesP10);
        System.out.println("Top Account="+ topAccountp10.getAccountId());

        List<Dependency_P11>dependenciesP11=new ArrayList<>();
        dependenciesP11.add(new Dependency_P11("A","B"));
        dependenciesP11.add(new Dependency_P11("B","C"));
        dependenciesP11.add(new Dependency_P11("C","A"));
        boolean cycleDetectedP11=
                service.detectCircularDependency(dependenciesP11);
        System.out.println("Cycle Detected="+(cycleDetectedP11 ? "TRUE":"FALSE"));

        List<SessionEvent_P12> sessionEventP12 =new ArrayList<>();
        sessionEventP12.add(new SessionEvent_P12("U1","LOGIN","10:00"));
        sessionEventP12.add(new SessionEvent_P12("U1","LOGOUT","10:45"));
        sessionEventP12.add(new SessionEvent_P12("U2","LOGIN","11:00"));
        sessionEventP12.add(new SessionEvent_P12("U2","LOGOUT","12:30"));
        List<SessionSummary_P12>sessionSummariesP12=
                service.sessionAnalytics(sessionEventP12);
        for(SessionSummary_P12 summary: sessionSummariesP12){
            System.out.println(summary);
        }
        double averageSessionP12=
                service.calculateAverageSession(sessionSummariesP12);
        System.out.println("Average Session="+averageSessionP12+"mins");

    }
}
