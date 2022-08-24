package com.payeshgaran.dto.account;

import com.payeshgaran.entity.Account;
import com.payeshgaran.entity.Locked;
import com.payeshgaran.entity.TypeOfAccount;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class AccountInDto {
    @ApiModelProperty(required = true)
    private String accountNumber;

    @ApiModelProperty(required = true)
    private String pin;

    @ApiModelProperty(required = true)
    private BigDecimal balance;

    @ApiModelProperty(required = true)
    @Enumerated(EnumType.STRING)
    private TypeOfAccount type;

    @ApiModelProperty(required = true)
    @Enumerated(EnumType.STRING)
    private Locked locked;

    @ApiModelProperty(required = true)
    private int incorrectAttempts;

    public Account converterDtoToEntity(AccountInDto accountInDto){
        Account account = new Account();
        account.setAccountNumber(accountInDto.getAccountNumber());
        account.setBalance(accountInDto.getBalance());
        account.setLocked(accountInDto.getLocked());
        account.setPin(accountInDto.getPin());
        account.setIncorrectAttempts(accountInDto.getIncorrectAttempts());
        account.setType(accountInDto.getType());
        return account;
    }
}
