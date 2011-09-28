#ifndef USERDAO_H
#define USERDAO_H

#include <string>

#include <entity/User.h>
#include "DAO.h"

using std::string;

using entity::User;

BEGIN_DAO_NAMESPACE

class UserDAO
{
 public:
	User getUser();
	void setUser(const User &user);

	bool save(const User &user);

 private:
	User _user;
};

END_DAO_NAMESPACE

#endif
