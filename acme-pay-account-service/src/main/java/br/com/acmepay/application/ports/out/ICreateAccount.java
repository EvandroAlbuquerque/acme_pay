package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.model.AccountDomain;

public interface ICreateAccount {

    void execute(AccountDomain accountDomain);
}