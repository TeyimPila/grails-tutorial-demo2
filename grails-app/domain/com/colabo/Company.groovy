package com.colabo

class Company {

    static hasMany = ['users': User]

    String name
    User admin

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
