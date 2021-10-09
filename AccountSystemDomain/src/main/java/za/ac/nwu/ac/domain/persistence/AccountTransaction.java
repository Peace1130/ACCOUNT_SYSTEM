package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TYPE_Tx",schema = "VITRSA_SANDBOX")


public class AccountTransaction implements Serializable {

    private final long serialVersionUID = 5320578342102714156L;
    private long TransactionId;
    private AccountType accountType;
    private long memberId;
    private long amount;
    private LocalDate transactionDate;

    public AccountTransaction(){

    }

    public AccountTransaction(Long transactionId,AccountType accountType,Long memberId ,Long amount, LocalDate transactionDate){
        this.transactionDate = transactionDate;
        this.TransactionId = transactionId;
        this.amount = amount;
        this.accountType = accountType;
        this.memberId = memberId;
    }
    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")


    @Column(name = "TX_ID")
    public long getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(long transactionId) {
        TransactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    @Column(name = "MEMBER_Id")
    public long getMemberId() {
        return memberId;
    }

    @Column(name = "AMOUNT")
    public long getAmount() {
        return amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return TransactionId == that.TransactionId && memberId == that.memberId && amount == that.amount && Objects.equals(accountType, that.accountType) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TransactionId, accountType, memberId, amount, transactionDate);
    }

    public String  toString() {
        AccountTransaction accountTransaction = new AccountTransaction();
        return "AccountTransaction{" +
                "transactionId=" + TransactionId +
                ", accountType='" + accountType +
                ", memberId='" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }

}
