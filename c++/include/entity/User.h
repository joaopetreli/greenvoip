#ifndef USER_H
#define USER_H

#include <string>

#include "Credit.h"
#include "Entity.h"

using std::string;

BEGIN_ENTITY_NAMESPACE

class User
{
 public:
	class Status
	{
	public:
		enum value {
			ACTIVE = 0,
			INACTIVE = 1,
		};

		static string toString(const value status);
	};

	unsigned long getId();
	void setId(const unsigned long id);

	string getName();
	void setName(const string &name);

	string getEmail();
	void setEmail(const string &email);

	string getPassword();
	void setPassword(const string &password);

	Status::value getStatus();
	void setStatus(const Status::value status);

	Credit getCredit();
	void setCredit(const Credit &credit);

 private:
	unsigned long _id;
	string _name;
	string _email;
	string _password;
	Status::value _status;
	Credit _credit;
};

END_ENTITY_NAMESPACE

#endif
