package com.colabo

class User {

    static hasMany = ['tasks': Task, 'assignments': TaskUser]
    static belongsTo = [company: Company]

    String firstName
    String lastName
    String profilePicture
    String phoneNumber
    String username
    String password

    Date dateCreated
    Date lastUpdated

    static constraints = {
        firstName nullable: true
        lastName nullable: true
        profilePicture nullable: true
        phoneNumber nullable: true
    }
}
