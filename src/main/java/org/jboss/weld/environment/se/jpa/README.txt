
Got inspired by
http://www.laliluna.de/articles/2011/01/12/jboss-weld-jpa-hibernate.html


This implementation will cause a separate entity manager for every transactional method. If you are aware of EJB3 or Spring transactions, then you will probably know the transaction type requires_new.
It is the same approach. If you want to achieve context propagation as in a EJB3, we need to improve our implementation. I leave the task to you but will outline the required steps.

    * Add an attribute to the @Transactional annotation which defines if the method should reuse an existing transaction.
    * Improve the interceptor
          o Check if the @Transactional annotation defines the reuse of an existing transaction
          o If an existing TX should be reused, it could check if the store has already a current entity manager. We could add a service method to the store like boolean hasEntitymanager()
          o If an existing TX should be reused and an entity manager exists already, do nothing else handle the transaction and create an entity manager.


Other way would be to implement doInJpa() like in Spring 2.5.