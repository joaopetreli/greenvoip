#include <dao/UserDAO.h>

BEGIN_DAO_NAMESPACE

User UserDAO::getUser()
{
	return _user;
}

void UserDAO::setUser(const User &user)
{
	_user = user;
}

END_DAO_NAMESPACE
