#include <entity/User.h>

BEGIN_ENTITY_NAMESPACE

string User::Status::toString(const value status)
{
	switch (status) {
	case ACTIVE:
		return "Active";
	case INACTIVE:
		return "Inactive";
	default:
		return "";
	}
}

unsigned long User::getId()
{
	return _id;
}

void User::setId(const unsigned long id)
{
	_id = id;
}

string User::getName()
{
	return _name;
}

void User::setName(const string &name)
{
	_name = name;
}

string User::getEmail()
{
	return _email;
}

void User::setEmail(const string &email)
{
	_email = email;
}

string User::getPassword()
{
	return _password;
}

void User::setPassword(const string &password)
{
	_password = password;
}

User::Status::value User::getStatus()
{
	return _status;
}

void User::setStatus(const User::Status::value status)
{
	_status = status;
}

Credit User::getCredit()
{
	return _credit;
}

void User::setCredit(const Credit &credit)
{
	_credit = credit;
}

END_ENTITY_NAMESPACE
