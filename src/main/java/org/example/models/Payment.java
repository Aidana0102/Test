package org.example.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class Payment {


    @NotEmpty(message="Name should not be empty")
    String payersName;

    @NotEmpty(message="THe field  should not be empty")
    @Size(min = 16,max = 16,message = "Account should be 16 characters")
    Long payersAccount;

    @NotEmpty(message="The should not be empty")
    @Size(min = 14,max = 14,message = "BIK should be 16 characters")
    Long payersBIK;

    @NotEmpty(message="THe field should not be empty")
     Date  dateOfExecution;


    @NotEmpty(message="The field should not be empty")
    Date paymentDate;

    @NotEmpty(message="Name should not be empty")
    String  beneficiarysName;


    @NotEmpty(message="The field should not be empty")
    @Size(min = 16,max = 16,message = "Account should be 16 characters")
    Long beneficiarysAccount;



    @Size(min = 6,max = 6,message = "INN should be 16 characters")
    Long INN;


    @Size(min = 14,max = 14,message = "BIK should be 16 characters")
    Long  beneficiarysBIK;


    @NotEmpty(message="The field should not be empty")
    Long  amount ;
    private org.example.models.GKPO GKPO;
    @NotEmpty(message="The field should not be empty")
    String purposeOfPayment;




//
//    public static enum GKPO {
//        OPEN, IN_WORK, FINISHED
//    }




    public Payment(String payersName, Long payersAccount, Long payersBIK, Date dateOfExecution, Date paymentDate, String beneficiarysName, Long beneficiarysAccount, Long INN, Long beneficiarysBIK, Long amount, org.example.models.GKPO GKPO, String purposeOfPayment) {
        this.payersName = payersName;
        this.payersAccount = payersAccount;
        this.payersBIK = payersBIK;
        this.dateOfExecution = dateOfExecution;
        this.paymentDate = paymentDate;
        this.beneficiarysName = beneficiarysName;
        this.beneficiarysAccount = beneficiarysAccount;
        this.INN = INN;
        this.beneficiarysBIK = beneficiarysBIK;
        this.amount = amount;
        this.GKPO = GKPO;
        this.purposeOfPayment = purposeOfPayment;
    }

    public Payment() {
    }

    public String getPayersName() {
        return payersName;
    }

    public void setPayersName(String payersName) {
        this.payersName = payersName;
    }

    public Long getPayersAccount() {
        return payersAccount;
    }

    public void setPayersAccount(Long payersAccount) {
        this.payersAccount = payersAccount;
    }

    public Long getPayersBIK() {
        return payersBIK;
    }

    public void setPayersBIK(Long payersBIK) {
        this.payersBIK = payersBIK;
    }

    public Date getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(Date dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBeneficiarysName() {
        return beneficiarysName;
    }

    public void setBeneficiarysName(String beneficiarysName) {
        this.beneficiarysName = beneficiarysName;
    }

    public Long getBeneficiarysAccount() {
        return beneficiarysAccount;
    }

    public void setBeneficiarysAccount(Long beneficiarysAccount) {
        this.beneficiarysAccount = beneficiarysAccount;
    }

    public Long getINN() {
        return INN;
    }

    public void setINN(Long INN) {
        this.INN = INN;
    }

    public Long getBeneficiarysBIK() {
        return beneficiarysBIK;
    }

    public void setBeneficiarysBIK(Long beneficiarysBIK) {
        this.beneficiarysBIK = beneficiarysBIK;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public org.example.models.GKPO getGKPO() {
        return GKPO;
    }

    public void setGKPO(org.example.models.GKPO GKPO) {
        this.GKPO = GKPO;
    }

    public String getPurposeOfPayment() {
        return purposeOfPayment;
    }

    public void setPurposeOfPayment(String purposeOfPayment) {
        this.purposeOfPayment = purposeOfPayment;
    }
}
