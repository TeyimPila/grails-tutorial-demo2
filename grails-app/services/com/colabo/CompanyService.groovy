package com.colabo

class CompanyService {

    Company get(Serializable id) {
        Company.get(id)
    }

    /**
     * Returns a list - that fits the criteria in args- of Companys
     * @param args: E.g. [max: 10, offset: 0]
     * @return
     */
    List<Company> list(Map args) {
        Company.list(args)
    }

    Long count() {
        Company.count()
    }

    void delete(Serializable id) {
        get(id).delete(flush: true)
    }

    Company save(Company Company) {
        Company.save(flush: true)
    }

}
