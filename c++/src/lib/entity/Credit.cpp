#include <entity/Credit.h>

BEGIN_ENTITY_NAMESPACE

unsigned long Credit::getId()
{
	return _id;
}

void Credit::setId(const unsigned long id)
{
	_id = id;
}

double Credit::getCredit()
{
	return _credit;
}

void Credit::setCredit(const double credit)
{
	_credit = credit;
}

END_ENTITY_NAMESPACE
