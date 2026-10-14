package com.coding.service;

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

import java.util.*;

public class ProblemService {
    public List<Customersummary_P1> customerTransactionAggregator(List<Transaction_P1> transactions) {
        Map<String, double[]> customerMap = new HashMap<>();
        for (Transaction_P1 transaction : transactions) {
            String customerId = transaction.getCustomerId();
            if (!customerMap.containsKey(customerId)) {
                customerMap.put(customerId, new double[]{0.0, 0.0});
            }
            double[] amounts = customerMap.get(customerId);

            if
            (transaction.getType().equalsIgnoreCase("CREDIT")) {
                amounts[0] = amounts[0] + transaction.getAmount();
            } else if
            (transaction.getType().equalsIgnoreCase("DEBIT")) {
                amounts[1] = amounts[1] + transaction.getAmount();
            }
        }
         List<Customersummary_P1> summaries = new ArrayList<>();
        for (Map.Entry<String, double[]> entry : customerMap.entrySet()) {
            String CustomerId = entry.getKey();
            double[] amounts = entry.getValue();
            double totalCredits = amounts[0];
            double totalDebits = amounts[1];
            double balance = totalCredits - totalDebits;
            Customersummary_P1 summary = new Customersummary_P1(CustomerId, totalCredits, totalDebits, balance);
            summaries.add(summary);
        }
        summaries.sort(new Comparator<Customersummary_P1>() {
            @Override
            public int
            compare(Customersummary_P1 c1, Customersummary_P1 c2) {
                return Double.compare(c2.getBalance(), c1.getBalance());
            }
        });
        return summaries;
    }

    public List<OrderSummary_P2>groupOrdersByCustomer(List<Order_P2>orders){
        Map<String,double[]>orderMap=new HashMap<>();
        for(Order_P2 order:orders){
            String customerId=order.getCustomerId();
            if(!orderMap.containsKey(customerId)){
                orderMap.put(customerId,new double[]{0,0.0});
            }
            double[]values=orderMap.get(customerId);
            values[0]=values[0]+1;
            values[1]=values[1]+order.getAmount();
        }
        List<OrderSummary_P2>orderSummaries=new ArrayList<>();
        for(Map.Entry<String, double[]> entry:orderMap.entrySet()){
            String customerId=entry.getKey();
            double[]values=entry.getValue();

            int totalOrders=(int)values[0];
            double totalAmount=values[1];

            OrderSummary_P2 summary=new OrderSummary_P2(customerId,totalOrders,totalAmount);
            orderSummaries.add(summary);
        }
        return orderSummaries;
    }
    public Map<String,Integer>
    logAnalytics(List<LogEntry_P3>logs){
        Map<String,Integer>logCountMap=new HashMap<>();
        for (LogEntry_P3 log : logs) {
            String level = log.getLevel();
           if (logCountMap.containsKey(level)){
               int count=logCountMap.get(level);
                logCountMap.put(level,count+1);
           } else {
                logCountMap.put(level, 1);
           }
        }
        return logCountMap;
    }
    public List<WordCount_P4>top3FrequentWords(String paragraph){
        Map<String,Integer>wordCountMap=new HashMap<>();
        String[]words=paragraph.split(" ");
        for (String word:words){
            if(wordCountMap.containsKey(word)){
                int count = wordCountMap.get(word);
                wordCountMap.put(word,count+1);
            } else {
                wordCountMap.put(word,1);
            }
        }
        List<WordCount_P4> wordCounts = new ArrayList<>();
        for(Map.Entry<String, Integer>entry:wordCountMap.entrySet()){
            String word=entry.getKey();
            int count=entry.getValue();

            WordCount_P4 wordCount = new WordCount_P4(word,count);
            wordCounts.add(wordCount);
        }
        wordCounts.sort(new Comparator<WordCount_P4>() {
            @Override
            public int compare(WordCount_P4 w1, WordCount_P4 w2) {
                return Integer.compare(w2.getCount(), w1.getCount());
            }
        });
        List<WordCount_P4>top3=new ArrayList<>();
        int limit=Math.min(3, wordCounts.size());
        for(int i=0;i<limit;i++){
            top3.add(wordCounts.get(i));
        }
        return top3;
    }
    public List<AnagramGroup_P5> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : words) {
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String key = new String(characters);
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(word);
        }
        List<AnagramGroup_P5>anagramGroups=new ArrayList<>();
        for(Map.Entry<String,List<String>>entry:anagramMap.entrySet()){
            List<String>groupWords=entry.getValue();
            AnagramGroup_P5 group=new AnagramGroup_P5(groupWords);
            anagramGroups.add(group);
        }
        return anagramGroups;
    }
    public List<InventoryMismatch_P6> reconcileinventory(List<Product_P6>warehouseProducts,List<Product_P6>storeProducts) {
        Map<String,Integer>warehouseMap=new HashMap<>();
        for(Product_P6 product:warehouseProducts){
        warehouseMap.put(product.getProductId(),product.getQuantity());
        }
        List<InventoryMismatch_P6> mismatches = new ArrayList<>();
        for(Product_P6 storeProduct:storeProducts){
            String productId=storeProduct.getProductId();
            if(warehouseMap.containsKey(productId)){
               int expectedQuantity=warehouseMap.get(productId);
                int actualQuantity=storeProduct.getQuantity();
                if(expectedQuantity !=actualQuantity){
                    InventoryMismatch_P6 mismatch=new InventoryMismatch_P6(productId,expectedQuantity,actualQuantity);
                    mismatches.add(mismatch);
                }
            }
        }
            return mismatches;
    }
    public SubstringResult_P7 longestSubstringWithKDistinct( String input, int k){
        Map<Character,Integer>charCountMap= new HashMap<>();
        int left = 0;
        int maxLength=0;
        int startIndex=0;
        int right=0;
        while(right<input.length()){
            char currentChar = input.charAt(right);
            if
            (charCountMap.containsKey(currentChar)){
                int count= charCountMap.get(currentChar);
                charCountMap.put(currentChar,count+1);
            }else{
                charCountMap.put(currentChar,1);
            }
            while (charCountMap.size()>k){
                char leftChar =input.charAt(left);
                int count = charCountMap.get(leftChar);
                charCountMap.put(leftChar,count-1);
                if(charCountMap.get(leftChar)==0){
                    charCountMap.remove(leftChar);
                }
                left++;
            }
            int currentLength = right-left+1;

            if (charCountMap.size()==k && currentLength>maxLength){
                maxLength=currentLength;
                startIndex=left;
            }
            right ++;
        }
        String longestSubstring = input.substring(startIndex,startIndex+maxLength);
        return new  SubstringResult_P7(longestSubstring,maxLength);
    }
    public void
    buildEmployeeHierarchy(List<Employee_P8>employees){
        Employee_P8 rootEmployee=null;
        for(Employee_P8 employee:employees){
            if(employee.getManagerId()==null){
                rootEmployee=employee;
                break;
            }
        }
        if (rootEmployee !=null){
            printEmployeeHierarchy(rootEmployee,employees,0);
        }
    }
    private void printEmployeeHierarchy(
            Employee_P8 employee,
            List<Employee_P8>employees,
            int level){
        for (int i=0;i<level;i++){
            System.out.println(" ");
        }
        System.out.println(employee.getName());
        for (Employee_P8 childEmployee:employees){
            if(childEmployee.getManagerId()!=null &&
            childEmployee.getManagerId().equals(employee.getId())){
                printEmployeeHierarchy(childEmployee,employees,level+1);
            }
        }
    }
    public List<Employee_P9>
    sortEmployees(List<Employee_P9>employees){
        employees.sort(new Comparator<Employee_P9>(){
            @Override
            public int compare(Employee_P9 e1,Employee_P9 e2){
                int departmentCompare=
                        e1.getDepartment().compareTo(e2.getDepartment());
                if(departmentCompare !=0){
                    return departmentCompare;
                }
                int experienceCompare= Integer.compare(e2.getExperience(),e1.getExperience());
                if(experienceCompare!=0){
                    return experienceCompare;
                }
                int ratingCompare=
                        Double.compare(e2.getRating(),e1.getRating());
                if (ratingCompare!=0){
                    return ratingCompare;
                }
                return
                        e1.getName().compareTo(e2.getName());
            }
        });
        return employees;
    }
    public List<AccountBalance_P10>
    processAccountBalances(
            List<AccountTransaction_P10>transactions){
        Map<String,Double>balanceMap=new HashMap<>();
        for(AccountTransaction_P10 transaction:transactions){
            String accountId=transaction.getAccountId();
            double currentBalance=0.0;
            if(balanceMap.containsKey(accountId))
            {
                currentBalance=balanceMap.get(accountId);
            }
            if
            (transaction.getType().equals("CREDIT")){
                currentBalance=currentBalance+transaction.getAmount();
            }
            if(transaction.getType().equals("DEBIT")){
                currentBalance=currentBalance-transaction.getAmount();
            }
            balanceMap.put(accountId,currentBalance);
        }
        List<AccountBalance_P10>accountBalances=new ArrayList<>();
        for(Map.Entry<String,Double>entry:balanceMap.entrySet()){
            String accountId= entry.getKey();
            double balance= entry.getValue();
            AccountBalance_P10 accountBalance=new AccountBalance_P10(accountId,balance);
            accountBalances.add(accountBalance);
        }
        return accountBalances;
    }
    public AccountBalance_P10
    findTopAccount(
            List<AccountBalance_P10> accountBalances){
        AccountBalance_P10 topAccount=null;
        for(AccountBalance_P10 accountBalance: accountBalances){
            if (topAccount == null ||
                    accountBalance.getBalance() > topAccount.getBalance()) {
                topAccount=accountBalance;
            }
        }
        return topAccount;
    }
    public boolean detectCircularDependency(
            List<Dependency_P11>dependencies){
        Map<String,List<String>> dependencyMap=new HashMap<>();
        for(Dependency_P11 dependency:dependencies){
            String from=dependency.getFrom();
            String to= dependency.getTo();

            if(!dependencyMap.containsKey(from)){
                dependencyMap.put(from,new ArrayList<>());
            }
            dependencyMap.get(from).add(to);
        }
        Set<String>visited=new HashSet<>();
        Set<String>recursionStack=new HashSet<>();
        for(String node: dependencyMap.keySet()){
            if (hasCycle(node,dependencyMap,visited,recursionStack)){
                return true;
            }
        }
        return false;
    }
    private boolean hasCycle(
            String node,
            Map<String,List<String>>
            dependencyMap,
            Set<String>visited,
            Set<String>recursionStack){
        if(recursionStack.contains(node)){
            return true;
        }
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        recursionStack.add(node);
        if(dependencyMap.containsKey(node)){
            for(String nextNode:dependencyMap.get(node)){
                if(hasCycle(nextNode,dependencyMap,visited,recursionStack)){
                    return true;
                }
            }
        }
        recursionStack.remove(node);
        return false;
    }
    public List<SessionSummary_P12>sessionAnalytics(
            List<SessionEvent_P12>sessionEvents){
        Map<String,Integer>loginTimeMap= new HashMap<>();
        List<SessionSummary_P12>sessionSummaries=new ArrayList<>();
        for(SessionEvent_P12 event:sessionEvents){
            String userId=event.getUserId();
            int eventTime=convertTimeToMinutes(event.getTime());
            if (event.getType().equals("LOGIN")) {
                loginTimeMap.put(userId,eventTime);
            }
            if(event.getType().equals("LOGOUT")&&
            loginTimeMap.containsKey(userId)){
                int loginTime=loginTimeMap.get(userId);
                int sessionMinutes=eventTime-loginTime;

                SessionSummary_P12 summary=new SessionSummary_P12(userId,sessionMinutes);
                sessionSummaries.add(summary);
                loginTimeMap.remove(userId);
            }
        }
        return sessionSummaries;
    }
    private int convertTimeToMinutes(String time){
        String[]parts=time.split(":");
        int hours=Integer.parseInt(parts[0]);
        int minutes=Integer.parseInt(parts[1]);
        return(hours*60)+minutes;
    }
    public double calculateAverageSession(
            List<SessionSummary_P12>sessionSummaries){
        int totalMinutes=0;
        for(SessionSummary_P12 summary:sessionSummaries){
            totalMinutes=totalMinutes+ summary.getSessionMinutes();
        }
        if(sessionSummaries.size()==0){
            return 0.0;
        }
        return (double) totalMinutes/sessionSummaries.size();
    }
}



