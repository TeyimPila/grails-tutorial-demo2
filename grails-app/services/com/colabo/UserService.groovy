package com.colabo

class UserService {

    User get(Serializable id) {
        User.get(id)
    }

    /**
     * Returns a list - that fits the criteria in args- of users
     * @param args: E.g. [max: 10, offset: 0]
     * @return
     */
    List<User> list(Map args) {
        User.list(args)
    }

    Long count() {
        User.count()
    }

    void delete(Serializable id) {
        get(id).delete(flush: true)
    }

    User save(User user) {
        user.save(flush: true)
    }

}
