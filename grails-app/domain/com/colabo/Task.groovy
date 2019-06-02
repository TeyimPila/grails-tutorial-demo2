package com.colabo

class Task {

    static belongsTo = ['owner': User]

    User owner
    String title
    String description
    Date dueDate
    String status = 'Pending'

    Date dateCreated
    Date lastUpdated


    static constraints = {
        status inList: ['Pending', 'In Progress', 'Completed']
        dueDate nullable: true
        description nullable: true, blank: true
        title validator: {value ->
            return value.length() > 10
        }
    }
}
