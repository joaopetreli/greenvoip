#ifndef CREDIT_H
#define CREDIT_H

#include "Entity.h"

BEGIN_ENTITY_NAMESPACE

class Credit
{
public:
	unsigned long getId();
	void setId(const unsigned long id);

	double getCredit();
	void setCredit(const double credit);
private:
	unsigned long _id;
	double _credit;
};

END_ENTITY_NAMESPACE

#endif
