package br.com.greenvoip.dao;

import br.com.greenvoip.entity.Credit;
import br.com.greenvoip.entity.User;
import br.com.greenvoip.entity.User.Status;

public class UserDAO {

	public User findUserByNumber(long number) {
		User user = new User();
		Credit credit = new Credit();
		
		credit.setCredit(10.50);
		
		user.setId(1);
		user.setName("João");
		user.setEmail("joao@registro.br");
		user.setPassword("AE013321FCD");
		user.setStatus(Status.ACTIVE);
		user.setCredit(credit);
		user.setNumber(number);
		return user;
	}
}
